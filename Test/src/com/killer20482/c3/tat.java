package com.killer20482.c3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class tat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException {
		File fs = new File("");
		FileInputStream in = new FileInputStream(fs);
		FileOutputStream out = new FileOutputStream("C:/aaa.txt");
		
		BufferedInputStream bin = new BufferedInputStream(in);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		
//		int a = bin.read();
//		while(a!=-1) {
//			bout.write(a);
//			a = bin.read();
//		}
//		bout.flush();
//		bout.close();
//		bin.close();
//		in.close();
//		out.close();
		
		byte[] b = new byte[4096];
		int a = bin.read(b);
		while(a!=-1) {
			bout.write(b,0,a);
			a=bin.read(b);
		}
		bout.close();
		bin.close();
	}
	
}
