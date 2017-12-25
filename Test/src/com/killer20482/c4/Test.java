//package com.killer20482.c4;
//
//public class Test {
//	public static void main(String[] args) {
//		
//		A a = new A("a");
//		B b = new B("b");
//		Thread bt = new Thread(b);
//		a.start();
//		bt.start();
//	}
//	
//
//	public static void haha(String a) {
//		for(int  i=0;i<10;i++) {
//			System.out.println(a);
//		}
//	}
//	
//}
//
//class A extends Thread{
//	//¼Ì³ÐThread
//	String a;
//	
//	
//
//	public A(String a) {
//		super();
//		this.a = a;
//	}
//
//
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		for(int  i=0;i<10;i++) {
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(a);
//		}
//		notifyAll();
//	}
//}
//
//
//class B implements Runnable{
//
//	String a;
//	
//	public B(String a) {
//		super();
//		this.a = a;
//	}
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		for(int  i=0;i<10;i++) {
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if(i==2) {
//				try {
//					wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			System.out.println(a);
//		}
//	}
//	
//}