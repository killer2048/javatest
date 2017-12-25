package com.killer2048.usermanger;

public class Tools {
	// 工具类
	public static void horizontalLine() {
		// 显示分割线
		System.out.println("==============================");// length=30
	}

	public static void wrongInput() {
		horizontalLine();
		System.out.println("您的输入有误");
		horizontalLine();
	}

	// 输入检查
	public static boolean checkName(String name) {
		return name != null;
	}

	public static boolean checkPW(String pw) {
		return pw != null;
	}

	//输入的字符串是否为数字
	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkMail(String mail) {
		// 检查邮箱格式
		/*
		 * 合法邮箱地址：必须有@；必须有.；只能有一个@；
		 * 
		 * @的下标不能大于.的；@不能是第一个字符 .不能是最后一个字符
		 */
		if (mail == null) {
			return false;
		}
		String[] m = mail.split("@");
		if (m.length != 2 || m[0].length() == 0) {
			return false;
		}
		if ((m[0].indexOf('.') >= 0) || (m[1].lastIndexOf('.') == (m[1].length() - 1))) {
			return false;
		}
		return true;
	}

	public static void inputCheckFalse() {
		// 输入的格式错误
		System.out.println("您的输入格式有误");

	}
}
