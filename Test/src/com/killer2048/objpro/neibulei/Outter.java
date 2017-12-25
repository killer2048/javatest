package com.killer2048.objpro.neibulei;

public class Outter {

	private int a=geta();
	int c=1;
	void haha() {
		new Inner().hehe();//使用内部类
		System.out.println(c);
		int ad = 100;
		class A{
			//局部内部类
			int aaaaa =ad; 
		}
	}
	
	int geta() {
		return 1;
	}
	class Inner{
		//成员内部类
		
		int b=a;//使用外部类属性
		int c=2;
		void hehe() {
			System.out.println(c);//同名时，优先局部变量-内部类属性-外部类属性
//			haha();//方法
		}
	}
	
	static class Inner2{
		int aaa=1;
		static int aaaa = 2;
	}
}
