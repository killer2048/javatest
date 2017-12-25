package com.killer20482.c3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ttttt {
	public static void main(String[] args) {
		System.out.println(findd("C:/a","ÐÂ"));
	}

	public static List<File> findd(String rootdirS,String str) {
		File rootdir = new File(rootdirS);
		File[] list = rootdir.listFiles();
		List<File> ret = new ArrayList<>();
		for(File i : list) {
			if(i.isDirectory()) {
				if(i.getName().indexOf(str)>=0)
				{
					ret.add(i);
				}
				ret.addAll(findd(i.toString(),str));
			} else {
				//×Ö·û´®²éÕÒ
				if(i.getName().indexOf(str)>=0)
				{
					ret.add(i);
				}
			}
		}
		return ret;
	}
}
