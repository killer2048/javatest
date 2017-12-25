package com.killer2048.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Eee {
	public static void main(String[] args) {
		try {
			FileInputStream f = new FileInputStream("C:/dddd");
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
