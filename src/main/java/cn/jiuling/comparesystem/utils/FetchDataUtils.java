package cn.jiuling.comparesystem.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

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
		}
		return "";
	}

	public static void main(String[] args) {
		String series = "179,400,401,923,385,822,266,386,2275,2846,582,3170,692,18,2951,812,19,509,2730,650,370,471,538,2734,472,2736,740,2738,146,2739,2264,593,2841,412,148,2740,511,2735,2994,2447,2444,2575,2446,155,3343,2236,3412,66,65,2561,2388,373,317,2963,2968,202,2847,270,153,271,3053,159,587,3230,2387,161,675,2196,3189,2726,2727,2728,2729,2725,703,2838,172,168,415,162,2073,2252,623,3284,3361,3533,965,3035,2126,622,852,966,588,197,2562,2084,2034,52,398,2966,56,450,365,59,57,60,467,469,300,267,237,192,683,595,2005,235,2842,2967,2717,2719,2197,2722,2723,2833,2721,2720,914,2718,632,466,2310,3000,3104,135,859,314,2565,3460,694,81,3085,2168,78,880,449,900,723,897,231,233,579,407,927,3283,2085,2761,2806,2091,2944,2088,3059,831,798,997,417,940,540,489,3068,99,877,987,2299,3234,2619,437,688,640,689,2472,2047,185,724,184,277,186,875,982,164,834,2896,3554,166,525,344,592,901,3014,305,306,390,76,3217,2045,2119,2788,2567,3033,2429,1008,2785,2778,3204,705,484,2046,590,520,2954,2122,2001,2090,2120,2304,2200,491,493,624,492,535,6,552,536,3309,2952,3324,898,2078,2314,545,145,2922,3103,614,3197,528,874,333,144,826,149,207,16,633,871,442,496,905,15,360,210,372,539,224,557,82,86,631,3416,669,430,368,700,574,602,2198,576,575,560,561,951,562,3341,1006,790,2556,3493,554,3301,3414,3128,2990,2540,2742,606,2769,2776,126,676,889,2682,2261,3016,459,361,308,367,359,3267,2767,465,89,90,91,601,2262,543,542,544,3126,3462,110,771,2237,505,111,109,526,371,375,882,770,45,46,170,513,762,334,964,2107,107,983,2574,2244,2354,963,206,549,550,3633,2454,2455,2453,659,364,117,3175,2871,2863,498,577,713,704,684,2024,2025,2302,102,2353,97,378,661,955,980,2355,2974,2093,2095,2094,3069,3524,2141,2560,3574,3272,2306,2774,3134,2114,969,865,1015,968,967,864,67,392,68,481,3481,2615,2027,2123,2124,395,824,470,3303,2941,2766,3214,3075,823,844,47,527,696,2318,855,379,38,3108,2771,556,428,570,461,507,194,460,856,862,2133,2108,2144,477,290,2212,673,2160,2211,291,23,504,777,121,3062,521,263,503,3048,608,2840,447,409,3556,2051,2155,799,841,474,801,989,2964,3467,2111,2156,2192,133,609,132,421,138,611,828,3407,3408,2956,3395,616,3080,2752,816,2543,660,617,567,572,2674,2228,589,178,2903,456,328,258,2325,2402,3320,911,2611,2610,3511,517,3207,2949,488,970,311,49,462,2629,238,426,2068,731,732,566,487,227,342,2207,380,222,3277,2277,354,174,727,2102,2103,265,836,3015,3559,3442,2063,201,403,261,341,351,112,352,3238,697,332,908,196,188,2184,2765,686,199,257,2248,3220,597,3082,2957,443,596,3083,2312,2134,928,2125,583,691,706,3124,961,962,569,3150,815,568,793,869,2991,758,794,95,103,75,3216,2049,432,3112,3528,872,362,94,529,2242,3185,2176,892,508,500,3436,3439,3438,2883,501,833,635,468,571,77,754,802,850,69,256,3177,72,272,681,891,3547,2147,532,835,531,555,533,209,930,749,750,2241,904,3178,3179,3181,3182,3180,433,3294,2418,2987,641,363,22,3154,655,3066,2118,658,1005,578,672,584,3096,2391,304,295,3060,289,551,903,322,191,389,2902,3382,2293,3491,3153,2835,3152,2836,3151,2988,3293,2295,3040,2296,2642,479,464,2748,888,524,806,348,653,670,2021,381,182,2563,2989,87,612,996,837,2953,2178,2980,2324,83,2331,3397,3195,518,530,2180,854,396,478,85,84,434,451,3475,2955,2341,2867,3226,454,2319,876,413,813,3385,2886,3286,2246,565,2137,142,298,284,890,1010,281,591,453,502,1016,452,275,2086,522,425,448,64,634,564,656,2381,355,63,475,53,2113,264,438,702,436,208,958,205,376,204,316,2779,2062,537,482,2743,2297,2972,2970,804,853,2109,797,791,620,2958,343,211,25,24,3131,458,873,483,668,128,2768,3008,377,369,486,2332,580,1018,325,651,3064,2791,3427,2787,599,345,506,13,141,2214,455,139,3132,485,516,2751,283,287,2417,285,286,414,2557,382,519,3290,2962,3171,3013,772,3269,858,357,3393,3392,3389,3390,3391,2357,2805,613,909,725,959,693,463,3158,3420,2678,404,2190,585,177,175,406,494,981,714,718,2105,2115,3415,586,2764,3073,50,3292,358,1007,2927,431,814,51,690,866,2649,429,2256,1017,446,3453,594,255,2984,3164,2117,756,975,127,131,510,457,252,3090,163,2348,657,397,2313,3335,2583,420,439,678,808,682,546,2945,639,98,792,232,476,293,388,230,2473,473,329,480,212,440,2378,2445,2440,939,3081,444,879,2716,104,101,878,2781,106,2131,913,2992,3097,3535,3098,3043,3099,3100,3201,3202,2400,383,581,605,122,416,3306,3087,424,3497,3289,2999,2770,2857,2998,2323,523,825,411,130,2294,860,490,2658,2850,627,2081,2143,2230,3575,3002,2161,2171,2337,558,663,2336,2334,708";

		String arr[] = series.split(",");
		Integer seriesId;
		int length = arr.length;

		final List result = new ArrayList();

		for (int k = 0; k < 50; k++) {
			new Thread(new MyRunnable(k, arr) {
				@Override
				public void run() {
					ObjectMapper mapper = new ObjectMapper();
					Integer sid;
					StringBuilder sb = new StringBuilder();
					int start = this.k * 20;
					for (int i = start; i < start + 20; i++) {
						if (i < arr.length) {
							sid = Integer.valueOf(arr[i]);
							String d = "init";
							try {
								d = get(sid);
								CarType c = mapper.readValue(d, CarType.class);
								List<CarType> zt = c.getList();
								for (int j = 0; j < zt.size(); j++) {
									CarType zai_ting_shou = zt.get(j);
									List<CarType> nianfen = zai_ting_shou.getList();
									for (int k2 = 0; k2 < nianfen.size(); k2++) {
										CarType c2 = nianfen.get(k2);
										List<CarType> kuanList = c2.getList();
										for (CarType kuan : kuanList) {
											sb.append("(" + (i + 1) + "," + c2.getI() + ",'" + kuan.getN() + "'," + kuan.getP() + "),\n");
										}
									}
								}
							} catch (Exception e) {
								System.err.println(d);
								System.exit(0);
								e.printStackTrace();
							}
						}
					}
					synchronized (result) {
						result.add(sb);
					}
					System.out.println(result.size());
					if (result.size() == 50) {
						StringBuilder s = new StringBuilder();
						for (Iterator iterator = result.iterator(); iterator.hasNext();) {
							Object object = (Object) iterator.next();
							s.append(object);
						}
						s.deleteCharAt(s.length() - 2).append(";");
						InputStream input = new ByteArrayInputStream(s.toString().getBytes());
						OutputStream output;
						try {
							File f = new File("all.txt");
							if (f.exists()) {
								f.delete();
							}
							output = new FileOutputStream(f);
							IOUtils.copy(input, output);
							input.close();
							output.close();
						} catch (Exception e) {
						}
					}
				}
			}).start();

		}
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class CarType {
	private Integer I;
	private String N;
	private Integer P;
	private List<CarType> List;

	@JsonProperty("I")
	public Integer getI() {
		return I;
	}

	@JsonProperty("P")
	public Integer getP() {
		return P;
	}

	public void setP(Integer p) {
		P = p;
	}

	public void setI(Integer i) {
		I = i;
	}

	@JsonProperty("N")
	public String getN() {
		return N;
	}

	public void setN(String n) {
		N = n;
	}

	@JsonProperty("List")
	public List<CarType> getList() {
		return List;
	}

	public void setList(List<CarType> list) {
		List = list;
	}

}

class MyRunnable implements Runnable {
	public Integer k;
	public String[] arr;
	public String sb;

	@Override
	public void run() {

	}

	public MyRunnable(Integer i) {
		super();
		this.k = i;
	}

	public MyRunnable(Integer i, String[] arr) {
		super();
		this.k = i;
		this.arr = arr;
	}
}
