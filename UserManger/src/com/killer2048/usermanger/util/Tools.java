package com.killer2048.usermanger.util;

public class Tools {
	// ������
	public static void horizontalLine() {
		// ��ʾ�ָ���
		System.out.println("==============================");// length=30
	}

	//�ַ����Ƿ�Ϊ����
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
