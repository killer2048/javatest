package com.killer20482.c2.test;

import java.util.LinkedList;

public class t1 {
	public static void main(String[] args) {
		Sequence<String> s = new Sequence<>();
		System.out.println(s.isEmpty());
		s.put("1dfsdfa");
		System.out.println(s);
		s.put("2dfsdfa");
		System.out.println(s);
		s.put("3dfsdfa");
		System.out.println(s);
		s.put("4dfsdfa");
		System.out.println(s);
		s.put("5dfsdfa");
		System.out.println(s);
		
		System.out.println(s.get());
		System.out.println(s);
		System.out.println(s.get());
		System.out.println(s);
		System.out.println(s.get());
		System.out.println(s);
		System.out.println(s.isEmpty());
		
		System.out.println(s.get());
		System.out.println(s);
		System.out.println(s.get());
		System.out.println(s);
		System.out.println(s.get());
		System.out.println(s);
		System.out.println(s.isEmpty());
	}
}

class Sequence<E> {
	private LinkedList<E> data;
	
	
	public Sequence() {
		this.data = new LinkedList<>();
	}

	public void put(E o) {
		this.data.add(o);
	}
	
	public E get() {
		return this.data.poll();
	}
	public boolean isEmpty() {
		return this.data.isEmpty();
	}

	@Override
	public String toString() {
		return "Sequence <-"+this.data.toString()+"<-";
	}
	
}