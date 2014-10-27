package cn.jiuling.comparesystem.utils;

import java.util.Map;

import org.apache.log4j.Logger;

public class ParamUtils {

	private static final Logger log = Logger.getLogger(ParamUtils.class);

	public static Integer getInteger(Map params, String key, Integer defaultValue) {
		Object obj = params.get(key);
		Integer value = defaultValue;
		if (null != value) {
			try {
				value = Integer.valueOf(obj.toString());
			} catch (Exception e) {
				log.warn("参数转换错误,参数是:" + key + ",值是:" + obj + ",取默认值:" + defaultValue);
			}
		}
		return value;
	}

	public static String getString(Map params, String key, String defaultValue) {
		Object obj = params.get(key);
		String value = defaultValue;
		if (null != value) {
			try {
				value = "" + obj;
			} catch (Exception e) {
				log.warn("参数转换错误,参数是:" + key + ",值是:" + obj + ",取默认值:" + defaultValue);
			}
		}
		return value;
	}
}
