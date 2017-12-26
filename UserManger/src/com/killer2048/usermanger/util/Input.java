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
    	System.out.println("�������û���");
		String name = getString();
		if(Input.checkName(name)) {
			return name;
		}
		return null;
    }
    
    public static String getPw() {
    	System.out.println("����������");
		String pw = getString();
		if(Input.checkPW(pw)) {
			return pw;
		}
		return null;
    }
    
    public static String getMail() {
    	System.out.println("����������");
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
    	System.out.println("������Ҫ�޸ĵ��û�Ȩ�ޣ�"+rightsString(list,maxRights)+"��");
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
		System.out.println("������������");
	}

	// ������
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
		// ��������ʽ
		/*
		 * �Ϸ������ַ��������@��������.��ֻ����һ��@��
		 * 
		 * @���±겻�ܴ���.�ģ�@�����ǵ�һ���ַ� .���������һ���ַ�
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
		// ����ĸ�ʽ����
		System.out.println("���������ʽ����");

	}
}
