package com.killer20482.c1;

public class Objectt {
	public static void main(String[] args) {
		Object o = new Object();
		System.out.println(o);//��ȡĳ���������
		System.out.println(o.getClass());//��ȡĳ���������
		System.out.println(o.getClass().getName());
		System.out.println(Integer.toHexString(15));//10ת16����
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
		return "�Ǻ�"+name;
	}
	
	
}