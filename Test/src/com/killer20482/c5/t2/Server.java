package com.killer20482.c5.t2;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Server {
	private static ServerSocket ss;
	private static ClientSocket s;
	private static int count=0;
	
	public static void main(String[] args) {
		try {
			ss=new ServerSocket(8890);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--��ʼ��ʧ��");
			System.exit(1);
		}
		System.out.println("--����������");
		String name = "�ͻ���"+count;
		
		try {
			s = new ClientSocket(ss.accept(),name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-- "+name+" ����ʧ��");
		} finally {
			count++ ;
		}
		s.setListen();
		Scanner sc = new Scanner(System.in);
		while(true) {
			String s = sc.nextLine();
			
		}
	
		
	}

}
