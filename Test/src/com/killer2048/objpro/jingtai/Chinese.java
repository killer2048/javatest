package com.killer2048.objpro.jingtai;

public class Chinese {
	String name;
	static String gj;
	void hehe() {
		System.out.println(name);
		byby();
	}
	
	static void byby() {
		System.out.println("byby");
	}
	
	
	public static void main(String[] args) {
		System.out.println(Chinese.gj);
		System.out.println(new Chinese().gj);
		new Chinese().hehe();
		
		
		Chinese c1 = new Chinese();
		Chinese c2 = new Chinese();
		c1.name="aaa";
		System.out.println(c1.name);
		System.out.println(c2.name);
		c2.name="bbb";
		System.out.println(c1.name);
		System.out.println(c2.name);
		
		c1.gj="111aaa";
		System.out.println(c1.gj);
		System.out.println(c2.gj);
		c2.gj="222bbb";
		System.out.println(c1.gj);
		System.out.println(c2.gj);
	}
	
	
//	static void aaaaa() {//�ھ�̬�����в���ʹ�÷Ǿ�̬���ԣ�����this��
//		System.out.println(name);
//	}
}
