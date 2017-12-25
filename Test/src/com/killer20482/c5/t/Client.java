package com.killer20482.c5.t;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost", 8890);
		OutputStream os = s.getOutputStream();
		OutputStreamWriter isr = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(isr);
		pw.println("aaaa");
		pw.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String a = br.readLine();
		System.out.println(a);
		pw.close();
		br.close();
		s.close();
	}
}
