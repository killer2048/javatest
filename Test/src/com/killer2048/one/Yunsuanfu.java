package com.killer2048.one;

public class Yunsuanfu {
	public static void main(String[] args) {
		int j = 2;
		j <<= 2;
		System.out.println(j);

		int i = 2;
		j = 2;
		boolean b;
		b = j == 2 && i++ == 1;
		System.out.println(b);
		System.out.println(i);
		b = j == 3 && i++ == 1;// ��·
		System.out.println(b);
		System.out.println(i);
		
		
		int a = 10;
		System.out.println(~a);
		System.out.println(1&2);
		System.out.println(-13&22);
		System.out.println(22|44);
		System.out.println(-1|2);
		
		//������ż��
		//��λ��1 ����Ϊ1��ż��Ϊ0
		System.out.println(1000&1);
		System.out.println(1001&1);
		
		System.out.println(45^36);
		System.out.println(17>>2);//�з������ƣ�����λ����������Ϊ0��0��Ϊ1��1
		System.out.println(17<<2);//���ƣ���0
		//����*2��n���ݣ�����/2�Ĵ���
		
		System.out.println(16>>32);//��ͬ
		
		System.out.println(3>>1);
		System.out.println(10>99&5<4);//&�����������㣬�������·����λ��ͬ��
		System.out.println(10>99&&5<4);
		
		System.out.println(4>3?1:2);//Ҫ����������ʽ�ķ���ֵ������ͬ
		int iii = 4>3?'1':2;
		System.out.println(iii);
	}
}
