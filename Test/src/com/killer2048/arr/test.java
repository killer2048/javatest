package com.killer2048.arr;


public class test {
	public static void main(String[] args) {
		//简单数组复制
		int[] a = {1,2,3,4,5,6,7};
		int[] b = new int[a.length];
		int[] c = new int[a.length+1];
		for(int i = 0;i<b.length;i++) {
			b[i] = a[i];
		}
		for(int i = 0;i<b.length;i++) {
			System.out.print(b[i]+",");
		}
		System.out.println();
		
		//(原数组，原数组起始复制位置，目标数组，目标位置，要复制的长度)
		System.arraycopy(a, 0, c, 1, a.length);
		for(int i = 0;i<c.length;i++) {
			System.out.print(c[i]+",");
		}
	}
}
