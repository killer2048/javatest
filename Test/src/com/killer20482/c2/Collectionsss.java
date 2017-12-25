package com.killer20482.c2;

import java.util.*;

public class Collectionsss {
	int a;
	
	public Collectionsss(int a) {
		super();
		this.a = a;
	}

	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		a1.add("hehe");
		a1.add(2);
		a1.add("hehe");
		a1.add(new Date());
		a1.add(2,"a");
		a1.remove(2);
		a1.remove("hehe");
		a1.remove(Integer.valueOf(2));
		
		
				
		for(int i=0;i<a1.size();i++) {
			System.out.println(a1.get(i));
		}
		
		System.out.println("____________");
//		a1.clear();
		System.out.println(a1.contains("a"));
		System.out.println(a1.indexOf(1));
		System.out.println("____________");
		a1.set(0, "hehehe");
		for(int i=0;i<a1.size();i++) {
			System.out.println(a1.get(i));
		}
		System.out.println("____________");
		a1.add(new Collectionsss(10));
		System.out.println(Arrays.toString(a1.toArray()));//µ×²ãÓÉarraycopyÊµÏÖ
	}
}
