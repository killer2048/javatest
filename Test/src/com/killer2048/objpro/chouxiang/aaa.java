package com.killer2048.objpro.chouxiang;

public class aaa extends Haha implements Jiekou,fly{

	
	@Override
	public void fly() {
//		a=10;
		System.out.println("fly");
	}
	
	

	@Override
	void hehe() {
		// TODO Auto-generated method stub
		
	}

	void test() {
		System.out.println("test");
	}

	@Override
	public void fly2() {
		super.fly2();
		System.out.println("fly2");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly3() {
		System.out.println("fly3");
		// TODO Auto-generated method stub
		
	}
	public void pr() {
//		System.out.println(a);
//		System.out.println((Jiekou)ff.a);
		System.out.println(super.a);//只能通过super和接口名区分同名属性
		System.out.println(Jiekou.a);
	}
	public static void main(String[] args) {
//		new aaa().fly2();
		
		Jiekou f = new aaa();
		aaa ff = new aaa();
		f.fly();
		f.fly2();
		((aaa)f).test();
		((fly)f).fly3();
//		((fly)f).fly();
		ff.pr();
	}
	
}
