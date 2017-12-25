package com.killer20482.c2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Hashmapp {
	public static void main(String[] args) {
		Map m1 = new HashMap();
		m1.put("aa", "111");
		m1.put("aa", "22");
		m1.put("bb", "22");
		m1.put("cc", "22");
		m1.put("dd", "22");
		System.out.println(m1.size());
		System.out.println(m1.containsKey("aa"));
		System.out.println(m1.get("aa"));
		System.out.println(m1.remove("aa"));
		System.out.println("________________");
		Iterator i = m1.keySet().iterator();
		while (i.hasNext()) {
			System.out.println(m1.get(i.next()));
			
		}
		System.out.println("________________");
		Set s = m1.entrySet();
		Iterator ii = s.iterator();
		while(ii.hasNext()) {
			Map.Entry me= (Map.Entry)ii.next();
			System.out.println(me.getValue());
			System.out.println(me.getKey());
		}
		
		for (Object ia : s) {
			System.out.println(m1);
		}
	}
}
