package com.killer2048.objpro.neibulei;

import com.killer2048.objpro.neibulei.Outter.Inner;
import com.killer2048.objpro.neibulei.Outter.Inner2;
import com.killer2048.objpro.chouxiang.*;

public class Test {
	public static void main(String[] args) {
		Outter  o = new Outter();
		o.haha();
		
		Inner i = new Outter().new Inner();
		
		
		Inner2 inn = new Outter.Inner2();
		int aaa = Outter.Inner2.aaaa;//ʹ�þ�̬�ڲ���ľ�̬��Ա
		
		fly fffff = new fly() {
			//�����ڲ���
			@Override
			public void fly3() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
