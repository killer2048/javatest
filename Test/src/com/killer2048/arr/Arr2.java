package com.killer2048.arr;

public class Arr2 {
	public static void main(String[] args) {
		int[][] a;//二维声明
		int []b[];//同上，不建议使用
		a = new int[3][4];
		a= new int[3][];
//		a= new int[][3];
		
		a[0][0] = 1;
		a[0] = new int[4];
		a[1] = new int[] {1,2,3};
//		a[2] = {1,2,3}
		a[2] = new int[] {1,2,3};
		
		int[][] c = new int[][]{{1,2,3},{1,1}};
		int[][] d = {{1,2,3},{1,1}};
	}
}
