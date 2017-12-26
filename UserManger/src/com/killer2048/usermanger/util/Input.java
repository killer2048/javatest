package com.killer2048.usermanger.util;

import java.util.*;
import java.util.Scanner;

import com.killer2048.usermanger.Main;

public class Input {
	private static Scanner getScanner() {
		return new Scanner(System.in);
	}
	public static int getInt() {
		Scanner sc = getScanner();
		String in = sc.nextLine();
		if(Tools.isNumeric(in)) {
			return Integer.parseInt(in);
		} else {
			return 0;
		}
	}
	
	public static String getString() {
		Scanner sc = getScanner();
		String in = sc.nextLine();
		return in;
	}
    public static String getName() {
    	System.out.println("请输入用户名");
		String name = getString();
		if(Input.checkName(name)) {
			return name;
		}
		return null;
    }
    
    public static String getPw() {
    	System.out.println("请输入密码");
		String pw = getString();
		if(Input.checkPW(pw)) {
			return pw;
		}
		return null;
    }
    
    public static String getMail() {
    	System.out.println("请输入邮箱");
		String mail = getString();
		if(Input.checkMail(mail)) {
			return mail;
		}
		return null;
    }
    
    public static int getId() {
    	int id = getInt();
    	if(Input.checkId(id)) {
    		return id;
    	}
    	return 0;    
    }
    public static String rightsString(Map<Integer, String> list,int maxRights) {
    	StringBuilder sb = new StringBuilder();
    	for(int i=1;i<=maxRights;i++) {
    		String temp = list.get(Integer.valueOf(i));
    		if(temp != null) {
				sb.append("/");
				sb.append(temp);
    		}
    	}
    	if(sb.length()>0) {
    		sb.deleteCharAt(0);
    	}
    	return sb.toString();
    }
    public static int getRights(int maxRights) {
    	Map<Integer, String> list = Main.getInstance().getRightList();
    	System.out.println("请输入要修改的用户权限（"+rightsString(list,maxRights)+"）");
    	String rights = getString();
    	int rightsInt = Input.getRightInt(list,maxRights,rights);
		if(rightsInt>0) {
			return rightsInt;
		}
		return 0;
    	
    }
    public static int getRightInt(Map<Integer, String> list,int maxRights,String rights) {
    	for(int i=1;i<=maxRights;i++) {
    		String temp = list.get(Integer.valueOf(i));
    		if(temp.equals(rights)) {
				if(i>maxRights) {
					return 0;
				} else {
					return i;
				}
    		}
    	}
    	return 0;
		
	}
    public static void wrongInput() {
		Tools.horizontalLine();
		System.out.println("您的输入有误");
	}

	// 输入检查
	public static boolean checkName(String name) {
		return name != null;
	}

	public static boolean checkPW(String pw) {
		return pw != null;
	}
	public static boolean checkId(int id) {
		return id>0;
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
