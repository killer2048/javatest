package com.killer20482.c5.t2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	private static Socket s;
	private static BufferedReader bf;
	private static PrintWriter pw;
	private static Thread listener;
	private static Thread say;
	private static final String LEAVE = "leave";
	private static final String SERVER_SAY = "";
	private static final String CLIENT_SAY = "我说：";

	public static void main(String[] args) throws UnknownHostException, IOException {
		s = new Socket("localhost", 8890);
		bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw = new PrintWriter(s.getOutputStream());
		setListen();

	}

	private static boolean checkLeave(String s) {
		return s.equals(LEAVE);
	}

	private static void say(String s) {
		if (!checkAlive()) {
			return;
		}

		if (say == null) {
			say = new Thread(new Say(s));
			say.start();
		}
	}

	public static void setListen() {
		if (!checkAlive()) {
			return;
		}

		if (listener == null) {
			listener = new Thread(new Listen());
			listener.start();
		}

	}

	public static boolean checkAlive() {
		return s != null;
	}

	private static void leave() {
		try {
			bf.close();
			pw.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bf = null;
			pw = null;
			s = null;
			listener = null;
			say = null;
			System.out.println("--已断开连接");
			System.exit(0);
		}
	}

	private static class Listen implements Runnable {

		@Override
		public void run() {
			String ret = null;
			while (true) {
				if (!checkAlive()) {
					break;
				}
				try {
					ret = bf.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					listener = null;
					break;
				}
				if (ret != null) {
					System.out.println(SERVER_SAY + ret);
					if (checkLeave(ret)) {
						leave();
						break;
					}

				}

			}

		}

	}

	private static class Say implements Runnable {

		private String s;

		public Say(String s) {
			super();
			this.s = s;
		}

		@Override
		public void run() {
			if (!checkAlive()) {
			}
			pw.println(s);
			pw.flush();
			System.out.println(CLIENT_SAY + s);
			if (checkLeave(s)) {
				leave();
			}
		}

	}
}
