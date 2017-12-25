package com.killer2048.objpro.test.t1;

class Players {
	private static int sum=0;
	private Players() {
		System.out.println("创建了一个对象");
	}
	
	public static Players create() {
		if(sum>10) {
			System.out.println("已经11个了");
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