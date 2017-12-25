package com.killer20482.c1;

import java.util.Random;

public class rand {
	public static void main(String[] args) {
		Random r1 = new Random(44444L);
		Random r2 = new Random(44444L);
		for(int i=0;i<10;i++) {
			System.out.print(r1.nextInt());
			System.out.print(" ");
			System.out.print(r2.nextInt());
			System.out.println();
		}
		
	}
}
