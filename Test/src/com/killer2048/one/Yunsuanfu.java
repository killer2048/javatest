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
		b = j == 3 && i++ == 1;// 短路
		System.out.println(b);
		System.out.println(i);
		
		
		int a = 10;
		System.out.println(~a);
		System.out.println(1&2);
		System.out.println(-13&22);
		System.out.println(22|44);
		System.out.println(-1|2);
		
		//求奇数偶数
		//按位与1 奇数为1，偶数为0
		System.out.println(1000&1);
		System.out.println(1001&1);
		
		System.out.println(45^36);
		System.out.println(17>>2);//有符号右移（符号位），即最左为0补0，为1补1
		System.out.println(17<<2);//左移，补0
		//左移*2的n次幂，右移/2的次幂
		
		System.out.println(16>>32);//不同
		
		System.out.println(3>>1);
		System.out.println(10>99&5<4);//&可以做与运算，但不会短路，按位或同样
		System.out.println(10>99&&5<4);
		
		System.out.println(4>3?1:2);//要求后两个表达式的返回值类型相同
		int iii = 4>3?'1':2;
		System.out.println(iii);
	}
}
