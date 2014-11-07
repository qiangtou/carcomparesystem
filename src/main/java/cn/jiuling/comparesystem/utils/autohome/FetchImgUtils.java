package cn.jiuling.comparesystem.utils.autohome;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FetchImgUtils {

	public static List<String> getPics(Integer seriesId, Integer carTypeId) {

		String url = "http://car.autohome.com.cn/pic/series-s" + seriesId + "/" + carTypeId + ".html";
		Document doc;
		List<String> list = new ArrayList<String>();
		try {
			doc = Jsoup.connect(url).get();
			Elements es = doc.select(".uibox-con img");
			String prefix = "autoimg.cn/";
			for (Element e : es) {
				String src = e.attr("src");
				src = src.substring(src.indexOf(prefix) + prefix.length());
				list.add(src);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) throws Exception {
		List<String> list = getPics(1001802, 2523);
		StringBuilder sb = new StringBuilder();
		for (String src : list) {
			sb.append(src + "\n");
		}
		System.out.println(sb.toString());
	}
}
