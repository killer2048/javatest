package com.killer20482.c2.test;
import java.util.*;
public class t5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] arr = input.split(" ");
		List<String> li = new ArrayList<>();
		for (String string : arr) {
			li.add(string);
		}
		
		int size = li.size();
		String curr;
		String next;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size-1-i;j++) {
				curr = li.get(j);
				next = li.get(j+1);
				if(curr.compareToIgnoreCase(next)>0) {
					li.set(j, next);
					li.set(j+1, curr);
				}
			}
		}
		System.out.println(li);

	}

}
