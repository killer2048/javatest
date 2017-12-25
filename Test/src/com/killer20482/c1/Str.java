package com.killer20482.c1;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Str {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s11 = "aa"+"bb";
		String s1 = new String();//空字符串
		byte[] b = {56,85,73};
		String s2 = new String(b);
		System.out.println(s2);
		String s3 = new String("aaa");
		String s4 = new String("aaa");
		String s5 = "aaa";
		String s6 = "aaa";
		System.out.println(s3==s4);
		System.out.println(s3==s6);
		System.out.println(s6==s5);
		System.out.println("-----------");
		
		StringBuffer sb = new StringBuffer("aa");
		sb.append(1);
		System.out.println(sb);
		StringBuilder sb1 = new StringBuilder("aa");//单线程时速度快与StringBuffer
		sb1.append(1);
		System.out.println(sb1);
		System.out.println("________________");
		String sss = "abc啊";
		byte[] bbb = sss.getBytes();
		byte[] ccc = sss.getBytes("iso8859-1");
		byte[] ddd = sss.getBytes("utf-8");
		System.out.println(Arrays.toString(bbb));
		System.out.println(Arrays.toString(ddd));
		System.out.println(Arrays.toString(ccc));//63=>?
		System.out.println(new String(ddd));
		System.out.println(new String(ddd,"utf-8"));
		
		System.out.println(Arrays.toString(new String(ddd,"iso8859-1").getBytes("utf-8")));;
		System.out.println(Arrays.toString(new String(ccc).getBytes()));
		
		System.out.println("___________________");
		
		String a12 = "dafs4df5d4fasdf42";
		System.out.println(a12.indexOf(100));
		System.out.println(a12.isEmpty());
		System.out.println(a12.length());
		System.out.println(a12.replace("a","x"));
		System.out.println(a12.substring(1,3));
		System.out.println(Arrays.toString(a12.toCharArray()));//拷贝自身的value后返回拷贝
		String a00 = "afds:dfa::DFa:ASDf:Erws::dsdsfs";
		String[] sarr = a00.split(":");
		System.out.println(Arrays.toString(sarr));
		System.out.println("dfas.dfsaf".split(".").length);//用.截取的长度为0
		System.out.println("dfas.dfsaf".split("\\.").length);//用.截取的长度为0
		System.out.println("dfasAAA".toLowerCase());
		System.out.println("dfasAAA".toUpperCase());
		System.out.println("\t dfsdf afs \n\r".trim());//去空格，制表符等
	}
}
