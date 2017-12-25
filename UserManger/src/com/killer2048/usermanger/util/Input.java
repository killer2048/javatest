package com.killer2048.usermanger.util;

import java.util.Scanner;

public class Input {
    public static String getName(Scanner sc) {
    	System.out.println("请输入用户名");
		String name = sc.next();
		if(Input.checkName(name)) {
			return name;
		}
		return null;
    }
    
    public static String getPw(Scanner sc) {
    	System.out.println("请输入密码");
		String pw = sc.next();
		if(Input.checkPW(pw)) {
			return pw;
		}
		return null;
    }
    
    public static String getMail(Scanner sc) {
    	System.out.println("请输入邮箱");
		String mail = sc.next();
		if(Input.checkMail(mail)) {
			return mail;
		}
		return null;
    }
    public static void wrongInput() {
		Tools.horizontalLine();
		System.out.println("您的输入有误");
		Tools.horizontalLine();
	}

	// 输入检查
	public static boolean checkName(String name) {
		return name != null;
	}

	public static boolean checkPW(String pw) {
		return pw != null;
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
