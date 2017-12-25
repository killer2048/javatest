package com.killer20482.c3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class serializablee {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		aaaa a = new aaaa(10,20);
		System.out.println(a);
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("aaaa.dat"));
		out.writeObject(a);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("aaaa.dat"));
		System.out.println((aaaa)(in.readObject()));
		in.close();
		
	}
}

class aaaa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int a;
	transient int b;
	public aaaa(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	@Override
	public String toString() {
		return "aaaa [a=" + a + ", b=" + b + "]";
	}
	
	
}