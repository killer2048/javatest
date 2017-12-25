package com.killer2048.arr;

public class Arr {
    public static void main(String[] args) {
    	int[] a;//动态初始化，创建时不赋值
    	a = new int[3];
    	a[1]=1;
    	//...........
    	int[] b = new int[3];
    	b[0]=1;
    	//*****************
    	int[] c = new int[] {1,2,3};//静态初始化
    	//*********
    	int[] d = {1,2,3};//只能在声明时这样写
//    	d = {1,2,3};
    	
    	int[] e;
    	System.out.println(a.length);//数组长
    	
    	for(int i=0;i<c.length;i++) {
    		System.out.println(c[i]);
    	}
    	
    	
    }
}
