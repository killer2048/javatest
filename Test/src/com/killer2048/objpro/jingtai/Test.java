package com.killer2048.objpro.jingtai;

public class Test {
	public static void main(String[] args) {
//		new Children();
//		System.out.println("___________________");
//		Children.hehe(3);
		
		Father f = new Children();
		f.hehe();
	}
}

class Father {
	static int a = 10;
	public Father() {
		System.out.println("father");
	}

	{
		System.out.println("father-block");
	}

	static void hehe() {
		System.out.println("father-staticfun");
	}
	static {
		System.out.println("father-staticblock");
	}
}

class Children extends Father {
	static int a = 1000;
	static int b = 5555;
	{
		System.out.println("Children-block");
	}

	public Children() {
		super();
		System.out.println("Children");
	}

	static void hehe() {
		System.out.println("Children-staticfun");
	}
	static void hehe2() {
		System.out.println("Children-staticfun222");
	}
	static void hehe(int a) {
		System.out.println("Children-staticfun2 "+a);
	}
	static {
		System.out.println("Children-staticblock");
	}

}