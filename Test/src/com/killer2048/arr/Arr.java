package com.killer2048.arr;

public class Arr {
    public static void main(String[] args) {
    	int[] a;//��̬��ʼ��������ʱ����ֵ
    	a = new int[3];
    	a[1]=1;
    	//...........
    	int[] b = new int[3];
    	b[0]=1;
    	//*****************
    	int[] c = new int[] {1,2,3};//��̬��ʼ��
    	//*********
    	int[] d = {1,2,3};//ֻ��������ʱ����д
//    	d = {1,2,3};
    	
    	int[] e;
    	System.out.println(a.length);//���鳤
    	
    	for(int i=0;i<c.length;i++) {
    		System.out.println(c[i]);
    	}
    	
    	
    }
}
