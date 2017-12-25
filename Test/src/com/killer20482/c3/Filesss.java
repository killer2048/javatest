package com.killer20482.c3;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Filesss {
	public static void main(String[] args) throws IOException {
		File f = new File("C:/a.txt");
		File f2 = new File("C:/a.txt");
		File f3 = new File("C:/a");
//		f.createNewFile();
//		f2.delete();
//		f3.mkdir();
		System.out.println(Arrays.toString(f3.list()));
		System.out.println(f.separator);
		
		
		
	}
}

class aaa{
	public  aaa() {
		File aaaa = new File("C:/aaaa");
		String aaaaa = "C:\\aaaa";
		StringBuilder sss = new StringBuilder(aaaaa);
		for(int i = 0;i<1000;i++) {
			sss.append(File.separator);
			sss.append(i);
		}
		System.out.println(sss);
		File f = new File(sss.toString());
//		f.mkdirs();
	}
}
