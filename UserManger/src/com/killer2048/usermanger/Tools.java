package com.killer2048.usermanger;

public class Tools {
	// ������
	public static void horizontalLine() {
		// ��ʾ�ָ���
		System.out.println("==============================");// length=30
	}

	public static void wrongInput() {
		horizontalLine();
		System.out.println("������������");
		horizontalLine();
	}

	// ������
	public static boolean checkName(String name) {
		return name != null;
	}

	public static boolean checkPW(String pw) {
		return pw != null;
	}

	//������ַ����Ƿ�Ϊ����
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
