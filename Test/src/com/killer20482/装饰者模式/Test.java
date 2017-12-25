package com.killer20482.װ����ģʽ;

public class Test {
	public static void main(String[] args) {
		AComonpent ac = new Comonpent();
		ac.func();
		System.out.println("----------");
		Adecorator ad = new Decorator(ac);
		Adecorator ad2 = new Decorator2(ad);
		ad2.func();
	}
}


interface AComonpent
{
	//���󹹳�
	void func();
}
class Comonpent implements AComonpent{

	@Override
	public void func() {
		// TODO Auto-generated method stub
		System.out.println("Comonpent-func");
	}
//��ͨ����	
}

abstract class Adecorator implements AComonpent{
	//����װ��
	private AComonpent ac;

	public Adecorator(AComonpent ac) {
		super();
		this.ac = ac;
	}

	protected abstract void func2();
	@Override
	public void func() {
		// TODO Auto-generated method stub
		ac.func();
		func2();
		
	}
	
}

class Decorator extends Adecorator {
//��ͨװ��
	public Decorator(AComonpent ac) {
		super(ac);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void func2() {
		// TODO Auto-generated method stub
		System.out.println("Decorator-func2");
		
	}
	
}

class Decorator2 extends Adecorator{

	public Decorator2(AComonpent ac) {
		super(ac);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void func2() {
		// TODO Auto-generated method stub
		System.out.println("Decorator2-func2");
	}
	
}




