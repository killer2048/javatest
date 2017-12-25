package com.killer2048.objpro.tt;

public class Demo {
private static int i = 7;
private static int j = 10;
private static int firstMethod(int i, int j){
		j = Demo.j % i;
		return Demo.i + j;	
}	
public static void main(String[] args) {
		int result = Demo.firstMethod(3, 10);
		System.out.println(result);
}
}
class A{
	protected void aaa() {
		System.out.println("aaa");
	}
	
}

//class B extends A {
//	void aaa() {//protected > default
//		System.out.println("bbb");
//	}
//}