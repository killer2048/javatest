package com.killer2048.objpro.tt;

public class Children2 extends Father{
	String name = "children2";

	@Override
	public void hehe() {
		System.out.println(name);
	}
	
	public static void main(String[] args) {
		Father c = new Children2();
		c.hehe();//children2
//		c.aaa;
		
//		Children2 ccc = (Children2)new Father();//java.lang.ClassCastException 必须先经upcasting 编译通过，运行错误
		
		
		System.out.println(c instanceof Children2);
		
		Father d = new Father();
		System.out.println(d instanceof Children2);
		
		
	}
	
	
	
}
