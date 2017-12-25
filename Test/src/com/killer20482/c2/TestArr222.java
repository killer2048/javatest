package com.killer20482.c2;

import java.util.Date;

public class TestArr222 {
	public static void main(String[] args) {
		ArrayList22 a = new ArrayList22();
		a.add(1);
		a.add("dfsadfa");
		a.add("dfsadfa");
		a.add("dfsadfa");
		a.add("dfsadfa");
		a.add("dfsadfa");
		a.add("dfsadfa");
		a.add("dfsadfa");
		a.add("dfsadfa");
		a.add("dfsadfa");
		a.add("dfsadfa");
		a.add("dfsadfa");
		a.add("dfsadfa");
		a.add("dfsadfa");
		a.add(1);
		a.add(new Date());
		
		System.out.println(a.size());
		System.out.println(a.isFull());
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i));
		}
		System.out.println("____________________");
		Iteratorrr it = a.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		it.next();
	}
	
	
}
