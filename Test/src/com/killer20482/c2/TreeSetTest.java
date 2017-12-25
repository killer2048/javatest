package com.killer20482.c2;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();//默认从小到大
		ts.add(1);
		ts.add(3);
		ts.add(6);
		ts.add(2);
//		ts.add("a");//
		
		Iterator i = ts.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
