package com.killer20482.c2;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class Settt {
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add(1);
		hs.add(2);
		hs.add("dfasf");
		hs.add("dfasfdf");
		hs.add("dfa3423sf");
		hs.add(new Date());
		hs.add(2);
		hs.add(2);
		System.out.println(hs.size());
		System.out.println("_______________");
		Object[] o = hs.toArray();
		for (int i = 0; i < o.length; i++) {
			System.out.println("# "+o[i].hashCode());
			System.out.println(o[i]);
		}
		System.out.println("_______________");
		
		Iterator it = hs.iterator();
		while(it.hasNext()) {
			Object o1 = it.next();
			System.out.println(o1);
		}
	}
}
