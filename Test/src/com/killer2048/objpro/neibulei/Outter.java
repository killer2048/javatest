package com.killer2048.objpro.neibulei;

public class Outter {

	private int a=geta();
	int c=1;
	void haha() {
		new Inner().hehe();//ʹ���ڲ���
		System.out.println(c);
		int ad = 100;
		class A{
			//�ֲ��ڲ���
			int aaaaa =ad; 
		}
	}
	
	int geta() {
		return 1;
	}
	class Inner{
		//��Ա�ڲ���
		
		int b=a;//ʹ���ⲿ������
		int c=2;
		void hehe() {
			System.out.println(c);//ͬ��ʱ�����Ⱦֲ�����-�ڲ�������-�ⲿ������
//			haha();//����
		}
	}
	
	static class Inner2{
		int aaa=1;
		static int aaaa = 2;
	}
}
