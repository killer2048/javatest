package com.killer20482.c5.t2;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ClientSocket {
	public final String NAME;
	private Socket s;
	private BufferedReader bf;
	private PrintWriter pw;
	private Thread listener;
	private Thread say;

	private static final String LEAVE = "leave";
	private final String SERVER_SAY = "服务器说：";
	private final String CLIENT_SAY;

	public ClientSocket(Socket s,String name) {
		this.s = s;
		NAME=name;
		CLIENT_SAY=NAME+"说：";
		System.out.println("-- "+NAME+" 已连接");

	}

	private void setInput() throws IOException {
		this.bf = new BufferedReader(new InputStreamReader(s.getInputStream()));

	}

	private void setOutput() throws IOException {
		this.pw = new PrintWriter(s.getOutputStream());
	}

	private boolean checkLeave(String s) {
		return s.equals(LEAVE);
	}

	public void leave() {
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
			System.out.println("--客户端已断开");
		}

	}

	public void say(String s) {
		if (!checkAlive()) {
			return;
		}
		if (pw == null) {
			try {
				setOutput();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (say == null) {
			say = new Thread(new Say(s));
			say.start();
		}

	}

	public void setListen() {
		if (!checkAlive()) {
			return;
		}
		if (bf == null) {
			try {
				setInput();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (listener == null) {
			listener = new Thread(new Listen());
			listener.start();
		}
	}

	public boolean checkAlive() {
		return s != null;
	}

	private class Listen implements Runnable {

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
					System.out.println(CLIENT_SAY + ret);
					if (checkLeave(ret)) {
						leave();
						break;
					}

				}

			}

		}

	}

	private class Say implements Runnable {
		private String a;
		
		public Say(String a) {
			super();
			this.a = a;
		}

		@Override
		public void run() {
				if (!checkAlive()) {
				}
				pw.println(a);
				pw.flush();
				System.out.println(SERVER_SAY + s);
				if (checkLeave(a)) {
					leave();
				}
		}

	}
}
