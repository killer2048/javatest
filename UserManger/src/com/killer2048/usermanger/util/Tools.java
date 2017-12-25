package com.killer2048.usermanger.util;

public class Tools {
	// 工具类
	public static void horizontalLine() {
		// 显示分割线
		System.out.println("==============================");// length=30
	}

	//字符串是否为数字
		public static boolean isNumeric(String str) {
			for (int i = 0; i < str.length(); i++) {
				System.out.println(str.charAt(i));
				if (!Character.isDigit(str.charAt(i))) {
					return false;
				}
			}
			return true;
		}
}
