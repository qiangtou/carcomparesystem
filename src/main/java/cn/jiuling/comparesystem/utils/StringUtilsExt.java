package cn.jiuling.comparesystem.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtilsExt {
	public static List<Short> fromStringToArray(String strV, String delimiter) {

		List<Short> shortList = new ArrayList<Short>();
		String[] shortStrs = null;

		if (strV != null && delimiter != null) {
			shortStrs = strV.split(delimiter);

			if (shortStrs != null && shortStrs.length > 0) {
				for (int i = 0; i < shortStrs.length; i++) {
					try {
						// int cur = Integer.parseInt(shortStrs[i]);
						short cur = Short.parseShort(shortStrs[i]);
						shortList.add(cur);
					} catch (NumberFormatException e) {
						System.out.println("StringUtils:fromStringToArray：not Number");
						e.printStackTrace();
						if (shortList.size() < 1) {
							// shortList.add(Short.valueOf("0"));
							shortList.add(null);
						}
						return shortList;
					}
				}
			}
		}

		if (shortList.size() < 1) {
			shortList.add(null);
		}
		return shortList;
	}
}
