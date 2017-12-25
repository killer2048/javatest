package com.killer20482.c1;

public class Objectt {
	public static void main(String[] args) {
		Object o = new Object();
		System.out.println(o);//获取某个对象的类
		System.out.println(o.getClass());//获取某个对象的类
		System.out.println(o.getClass().getName());
		System.out.println(Integer.toHexString(15));//10转16进制
		System.out.println(Integer.toHexString(o.hashCode()));
		
		Person p = new Person();
		System.out.println(p);
		
		int i=12;
		i+=i-=i*=i;
	}
}

class Person {
	String name="aaa";

	@Override
	public String toString() {
		return "呵呵"+name;
	}
	
	
}