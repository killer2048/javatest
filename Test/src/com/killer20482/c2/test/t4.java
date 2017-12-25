package com.killer20482.c2.test;

import java.util.*;

public class t4 {
	public static void main(String[] args) {
		Map<Integer,Bank> m = new HashMap<>();
		for(int i=0;i<10;i++) {
			m.put(Integer.valueOf(i), new Bank(i,"aaa"+i,i*100*Math.random()));
		}
		
		Set<Map.Entry<Integer, Bank>> s = m.entrySet();
		Iterator<Map.Entry<Integer, Bank>> i = s.iterator();
		while(i.hasNext()) {
			Map.Entry<Integer, Bank> b = i.next();
			System.out.println(b.getValue());
		}
	}
}

class Bank{
	int id;
	String name;
	double money;
	public Bank(int id, String name, double money) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", money=" + money + "]";
	}
	
	
	
	
	
}
