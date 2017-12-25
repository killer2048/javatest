package com.killer20482.c5.t;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8890);
		Socket s = ss.accept();
		InputStream  is= s.getInputStream();
		InputStreamReader os = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(os);
		String a = br.readLine();
		System.out.println(a);
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		pw.println("hehe");
		pw.flush();
		
		br.close();
		pw.close();
	s.close();
	ss.close();
	}
}
