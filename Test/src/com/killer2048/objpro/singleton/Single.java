package com.killer2048.objpro.singleton;

//����ģʽ
public class Single {
	private static Single single = new Single();//������̬��������Ψһ�Ķ���
	private Single(){
		//˽�й�����,��ֹ�ⲿ���ɶ���
	}
	
	public static Single getInstance() {
		//�ṩһ�����ض���ľ�̬����
		return single;
	}
	
	public static void main(String[] args) {
		//�Ǻ�
		System.out.println(Single.single);
		System.out.println(Single.single.single);
		System.out.println(Single.single.single.single);
		System.out.println(Single.single.single.single.single.single);
	}
}
