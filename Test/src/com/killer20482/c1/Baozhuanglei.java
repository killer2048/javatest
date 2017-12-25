package com.killer20482.c1;

public class Baozhuanglei {
	public static void main(String[] args) {
		Integer i1 = new Integer("13");
		byte b = i1.byteValue();
		int a = i1.intValue();
		// ......
		Integer i2 = new Integer(13);
		Integer i3 = new Integer(12);
		Integer i4 = new Integer(15);
		System.out.println(i1.compareTo(i2));// 相同返回0，i1大返回1，i1小返回-1
		System.out.println(i1.compareTo(i3));// 相同返回0，i1大返回1，i1小返回-1
		System.out.println(i1.compareTo(i4));// 相同返回0，i1大返回1，i1小返回-1

		System.out.println(Integer.parseInt("342342"));

		System.out.println(Integer.valueOf(123) == Integer.valueOf(123));// valueOf缓存-128~127的对象
		System.out.println(Integer.valueOf(456) == Integer.valueOf(456));
		System.out.println(new Integer(123) == new Integer(123));

		Integer a1 = 123;
		Integer a2 = 123;

		int ii;
		ii = 1 + a1 + 1;
		System.out.println(ii);

		System.out.println(a1 == a2);// 自动装箱会使用缓存

		Integer.valueOf(1);

		Boolean bbbb = new Boolean("hehe");// 只要不是"true"全是false

		System.out.println(bbbb);

		System.out.println('他' - '她');

		Character c1 = '他';
		Character c2 = '她';
		System.out.println(c1.compareTo(c2));	
		System.out.println(Character.isDigit('a'));//判断一个字符是不是数字
		System.out.println(Character.isDigit('2'));//判断一个字符是不是数字
		System.out.println(Character.isLetter('发'));//判断一个字符是不是字符
		System.out.println(Character.isSpace('\t'));//判断一个字符是不是空格回车制表符等
		System.out.println(Character.isWhitespace('\t'));//判断一个字符是不是空格回车制表符等
		System.out.println(Character.toLowerCase('A'));
	}
}
