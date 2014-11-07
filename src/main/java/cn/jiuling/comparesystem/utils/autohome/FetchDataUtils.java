package cn.jiuling.comparesystem.utils.autohome;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

public class FetchDataUtils {
	public static List dataList = new ArrayList();

	private static String get(String url) throws Exception {
		String ret = "";
		URL u = new URL(url);
		ret = IOUtils.toString(u, "gbk");
		return ret;
	}

	private static String get(Integer seriesId) {
		String url = "http://car.autohome.com.cn/duibi/ashx/SpecCompareHandler.ashx?type=2&seriesid=" + seriesId + "&isie6=0";
		try {
			return get(url);
		} catch (Exception e) {
			System.out.println("失败了:" + seriesId);
			e.printStackTrace();
		}
		return "";
	}

	public static void main(String[] args) {
		final File f = getOutputFile();

		List<CarType> brandList = null;
		try {
			String brandsHtml = get("http://car.autohome.com.cn/javascript/NewSpecCompare.js");
			brandsHtml = trimBrandHtml(brandsHtml);
			System.out.println(brandsHtml);
			brandList = getBrandList(brandsHtml);
		} catch (Exception e1) {
			System.out.println("获取品牌错误,停止程序");
			System.exit(0);
		}
		// 这个map用于存放系列id-->品牌id的映射关系
		final Map<Integer, Integer> seriesMap = new HashMap<Integer, Integer>();
		// 系列列表,用于存放所有系列id
		List<CarType> sList = new ArrayList<CarType>();

		StringBuilder brandSql = new StringBuilder("insert into carcomparesystem.brand(id,name,shortName) values\n");
		StringBuilder seriesSql = new StringBuilder("insert into carcomparesystem.series(id,name,brandId,brandName) values\n");
		for (int i = 0; i < brandList.size(); i++) {// 遍历品牌
			CarType brand = brandList.get(i);
			List<CarType> factoryList = brand.getList();
			int bid = i + 1;
			brandSql.append(String.format("(%d,'%s','%s'),\n", bid, brand.getN(), brand.getL()));

			for (CarType factory : factoryList) {// 遍历厂家
				List<CarType> sereisList = factory.getList();
				for (CarType series : sereisList) {// 遍历系列
					seriesMap.put(series.getI(), brand.getI());
					sList.add(series);
					seriesSql.append(String.format("(%d,'%s',%d,'%s'),\n", sList.size(), series.getN(), bid, brand.getN()));
				}
			}
		}

		int lastComma4Brand = brandSql.lastIndexOf(",");
		brandSql.replace(lastComma4Brand, lastComma4Brand + 1, ";");
		brandSql.append(seriesSql);
		brandSql.insert(0, "delete from car;delete from series;delete from brand;\n");

		lastComma4Brand = brandSql.lastIndexOf(",");
		brandSql.replace(lastComma4Brand, lastComma4Brand + 1, ";");

		InputStream input = new ByteArrayInputStream(brandSql.toString().getBytes());
		OutputStream output;
		try {
			output = new FileOutputStream(f);
			IOUtils.copy(input, output);
			input.close();
			output.close();
		} catch (Exception e) {
		}

		int size = sList.size();

		final List result = new ArrayList();
		final int threadCount = 30;// 分threadCount个线程执行任务
		int step = size / threadCount + 1;
		System.out.println("task size:" + size + ",threadCount:" + threadCount + ",step:" + step);
		for (int k = 0; k < threadCount; k++) {
			int fromIndex = k * step;
			int toIndex = fromIndex + step;
			if (fromIndex >= size) {
				break;
			}
			new Thread(new MyRunnable(fromIndex, sList.subList(fromIndex, Math.min(toIndex, size))) {
				@Override
				public void run() {
					ObjectMapper mapper = new ObjectMapper();
					StringBuilder sb = new StringBuilder();
					for (int i = 0, size = list.size(); i < size; i++) {
						Integer sid = ((CarType) list.get(i)).getI();
						try {
							String seriesJson = get(sid);
							CarType c = mapper.readValue(seriesJson, CarType.class);
							List<CarType> zt = c.getList();
							for (CarType zai_ting_shou : zt) {
								List<CarType> nianfen = zai_ting_shou.getList();
								for (CarType c2 : nianfen) {
									List<CarType> kuanList = c2.getList();
									for (CarType kuan : kuanList) {
										sb.append(String.format("(%d,%d,'%s',%d,%d,%d),#bid:%d,sid:%d,tid:%d\n",
														fromIndex + i + 1, c2.getI(), kuan.getN(), kuan.getP(), kuan.getI(), sid, seriesMap.get(sid), kuan
																.getI(), sid));
									}
								}
							}
						} catch (Exception e) {
							System.exit(0);
							e.printStackTrace();
						}
					}
					synchronized (result) {
						result.add(sb);
						int resultSize = result.size();
						System.out.println(resultSize * 100 / threadCount + "%");
						if (resultSize == threadCount) {
							String sql = buildCarTypeSql(result);
							writeToFile(sql, f);
						}
					}
				}

				private String buildCarTypeSql(final List result) {
					String typeInsertsql = "\ninsert into carcomparesystem.car(seriesId,year,name,price,autohomeId,autohomeSeriesId) values\n";
					StringBuilder s = new StringBuilder(typeInsertsql);
					for (int i = 0, len = result.size(); i < len; i++) {
						Object object = result.get(i);
						if (i > 0 && i % 2 == 0) {
							int lastComma = s.lastIndexOf("),");
							s.replace(lastComma, lastComma + 2, ");");
							s.append(typeInsertsql);
						}
						s.append(object);
					}
					int lastComma = s.lastIndexOf("),");
					s.replace(lastComma, lastComma + 2, ");");
					return s.toString();
				}

				private void writeToFile(String s, final File f) {
					InputStream input = new ByteArrayInputStream(s.getBytes());
					OutputStream output;
					try {
						output = new FileOutputStream(f, true);
						IOUtils.copy(input, output);
						input.close();
						output.close();
					} catch (Exception e) {
					}
				}
			}).start();

		}
	}

	private static List<CarType> getBrandList(String brandsHtml) throws IOException, JsonParseException, JsonMappingException {
		List<CarType> brandList;
		ObjectMapper mapper = new ObjectMapper();
		JavaType Mytype = mapper.getTypeFactory().constructParametricType(ArrayList.class, CarType.class);
		brandList = mapper.readValue(brandsHtml, Mytype);
		return brandList;
	}

	private static String trimBrandHtml(String brands) {
		brands = brands.substring(brands.indexOf("["), brands.lastIndexOf(";"));
		return brands;
	}

	private static File getOutputFile() {
		final File f = new File("all.sql");
		if (f.exists()) {
			f.delete();
		}
		return f;
	}
}