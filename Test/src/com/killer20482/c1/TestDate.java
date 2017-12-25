package com.killer20482.c1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
	public static void main(String[] args) {
		Date d = new Date();//不支持时区
		System.out.println(d);
		System.out.println(d.getTime());//1970-01-01 00:00:000
		System.out.println(d.getDay());
		System.out.println(d.getMonth());//0-11
		System.out.println(d.getYear()+1900);//要+1900
		System.out.println(d.getHours());
		System.out.println(d.getMinutes());
		System.out.println(d.getSeconds());
		System.out.println("______________");
		
		
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(1));
		System.out.println(c.get(Calendar.YEAR));
		c.set(2000,10,1);
		System.out.println(c);
		
		System.out.println("_____________");
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(f.format(new Date()));
		
	}
}
