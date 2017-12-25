package com.killer20482.c1;

import java.util.Scanner;

public class StrTest {
	public static void main(String[] args) {
		System.out.println("ÇëÊäÈëÓÊÏä");
		Scanner sc = new Scanner(System.in);
		
		String mail = sc.nextLine();
		sc.close();
		if (checkEnd(mail) && checkAddress(mail)) {
			System.out.println("ÕýÈ·");
		} else {
			System.out.println("´íÎó");
		}

	}

	public static boolean checkEnd(String s) {
		// .com/.cn/!360.cn
		return (s.endsWith(".com") || s.endsWith(".cn")) && !s.endsWith("360.cn");
	}

	public static boolean checkAddress(String s) {
		String[] arr = s.split("@");
		if (arr[0].equals("") || arr.length > 2) {
			return false;
		}
		byte[] unCheck = arr[0].getBytes();
		for (int i = 0; i < unCheck.length; i++) {
			if (!checkLetter(unCheck[i], i == 0)) {
				System.out.println(i);
				return false;
			}
		}
		return true;

	}

	// ¼ì²é´«Èë×Ö·û·¶Î§£¬firstÊÇ·ñÎªÊ××ÖÄ¸
	public static boolean checkLetter(byte c, boolean first) {
		if (c >= 65 && c <= 90 || c >= 97 && c <= 122) {
			// ×ÖÄ¸
			return true;
		}

		if (!first&&(c == 45 || c == 46 || c == 95 || c >= 48 && c <= 57)) {
			return true;
		}
		return false;
	}
}
