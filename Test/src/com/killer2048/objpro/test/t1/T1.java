package com.killer2048.objpro.test.t1;

class Players {
	private static int sum=0;
	private Players() {
		System.out.println("������һ������");
	}
	
	public static Players create() {
		if(sum>10) {
			System.out.println("�Ѿ�11����");
			return null;
		}
		sum++;
		return new Players();
	}
}

public class T1{
	public static void main(String[] args) {
		Players[] arr = new Players[11];
		
		for(int i = 0;i<arr.length;i++) {
			arr[i] = Players.create();
		}
		
		System.out.println(Players.create());
	}
}