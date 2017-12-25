package com.killer2048.arr;

import java.util.Arrays;

public class Sortarr {
	public static void main(String[] args) {
		int[] a = {2,15,415,41546,15,3,51,654,65,4,165,55,41546,15,3,51};
		int[] b = {2,15,415,41546,15,3,51,654,65,4,165,55,41546,15,3,51};
		int[] c = {2,15,415,41546,15,3,51,654,65,4,165,55,41546,15,3,51};
		
		int counta = 0;
		int countb = 0;
		int countc = 0;
		//÷±Ω”—°‘Ò≈≈–Ú
		for(int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length;j++) {
				counta++;
				if(a[i]<a[j]) {
					
					a[i]=a[i]^a[j];
					a[j]=a[i]^a[j];
					a[i]=a[i]^a[j];
				}
			}
		}
		System.out.println(Arrays.toString(a));
		System.out.println(counta);
		
		//√∞≈›≈≈–Ú
		for(int i = 1;i<b.length;i++) {
			for(int j = 0;j<b.length-i;j++) {
				countb++;
				if(b[j]>b[j+1]) {
					
					b[i]=b[i]^b[i+1];
					b[i+1]=b[i]^b[i+1];
					b[i]=b[i]^b[i+1];
				}
			}
		}
		System.out.println(Arrays.toString(b));
		System.out.println(countb);
		
	}
}
