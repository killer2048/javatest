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
		System.out.println(i1.compareTo(i2));// ��ͬ����0��i1�󷵻�1��i1С����-1
		System.out.println(i1.compareTo(i3));// ��ͬ����0��i1�󷵻�1��i1С����-1
		System.out.println(i1.compareTo(i4));// ��ͬ����0��i1�󷵻�1��i1С����-1

		System.out.println(Integer.parseInt("342342"));

		System.out.println(Integer.valueOf(123) == Integer.valueOf(123));// valueOf����-128~127�Ķ���
		System.out.println(Integer.valueOf(456) == Integer.valueOf(456));
		System.out.println(new Integer(123) == new Integer(123));

		Integer a1 = 123;
		Integer a2 = 123;

		int ii;
		ii = 1 + a1 + 1;
		System.out.println(ii);

		System.out.println(a1 == a2);// �Զ�װ���ʹ�û���

		Integer.valueOf(1);

		Boolean bbbb = new Boolean("hehe");// ֻҪ����"true"ȫ��false

		System.out.println(bbbb);

		System.out.println('��' - '��');

		Character c1 = '��';
		Character c2 = '��';
		System.out.println(c1.compareTo(c2));	
		System.out.println(Character.isDigit('a'));//�ж�һ���ַ��ǲ�������
		System.out.println(Character.isDigit('2'));//�ж�һ���ַ��ǲ�������
		System.out.println(Character.isLetter('��'));//�ж�һ���ַ��ǲ����ַ�
		System.out.println(Character.isSpace('\t'));//�ж�һ���ַ��ǲ��ǿո�س��Ʊ����
		System.out.println(Character.isWhitespace('\t'));//�ж�һ���ַ��ǲ��ǿո�س��Ʊ����
		System.out.println(Character.toLowerCase('A'));
	}
}
