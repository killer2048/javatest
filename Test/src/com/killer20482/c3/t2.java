package com.killer20482.c3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class t2 {
	public static void main(String[] args) throws IOException {
		String resstr = "C:/a/a.txt";
		String targetstr = "C:/a/a/a.txt";
		
		File res = new File(resstr);
		FileReader in = new FileReader(res);
		FileWriter out = new FileWriter(targetstr);
		int a = in.read();
		while(a != -1) {
			out.write(a);
			a=in.read();
		}
		in.close();
		out.close();
		
		
	}
}
