package com.killer2048.usermanger.util;

import java.util.Scanner;

public class Input {
    public static String getName(Scanner sc) {
    	System.out.println("�������û���");
		String name = sc.next();
		if(Input.checkName(name)) {
			return name;
		}
		return null;
    }
    
    public static String getPw(Scanner sc) {
    	System.out.println("����������");
		String pw = sc.next();
		if(Input.checkPW(pw)) {
			return pw;
		}
		return null;
    }
    
    public static String getMail(Scanner sc) {
    	System.out.println("����������");
		String mail = sc.next();
		if(Input.checkMail(mail)) {
			return mail;
		}
		return null;
    }
    public static void wrongInput() {
		Tools.horizontalLine();
		System.out.println("������������");
		Tools.horizontalLine();
	}

	// ������
	public static boolean checkName(String name) {
		return name != null;
	}

	public static boolean checkPW(String pw) {
		return pw != null;
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
