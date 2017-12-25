package com.killer20482.c3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class liu {
	public static void main(String[] args) throws IOException {
		File f = new File("C:/a/a.txt");
		f.createNewFile();
		String a = "Aaaa";
//		OutputStream os = new FileOutputStream(f);
//		os.write(a.getBytes());
//		os.close();
		
//		FileWriter fw = new FileWriter(f);
//		fw.write("dfdsf");
//		fw.flush();
//		fw.close();
		
		
//		FileReader fr = new FileReader(f);
//		System.out.println((char)fr.read());
//		long len = f.length();
//		int aaa = fr.read();
//		while(aaa!=-1) {
//			System.out.println((char)aaa);
//			aaa=fr.read();
//		}
//		fr.close();
		
		
		
		
		byte[] b =   new byte[2];
		FileInputStream fs = new FileInputStream(f);
		fs.read(b);
		String ssss = new String(b);
		System.out.println(ssss);
		
		
		
	}
}
