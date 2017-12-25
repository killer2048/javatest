package com.killer20482.c2.test;
import java.util.*;
public class t3 {
	public static void main(String[] args) {
		List<String> li = new ArrayList<>();
		li.add("apple");
		li.add("grape");
		li.add("banana");
		li.add("pear");
		Collections.sort(li);
		System.out.println(li.get(0));
		System.out.println(li.get(li.size()-1));
		System.out.println(li);
	}
}
