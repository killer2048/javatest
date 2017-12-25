package com.killer20482.c2;

import java.util.Arrays;
import java.util.HashSet;

public class TestHashSet {
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		
		hs.add(new A());
		hs.add(new B());//查重：先比hashcode.相同时比较 要插入元素.equals(已存在元素)
		System.out.println(Arrays.toString(hs.toArray()));
	}
}

class A {
	int a = 0;

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}
}

class B {
	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
}