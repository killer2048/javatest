package com.killer20482.c4;

public class JoinT {
	public static void main(String[] args) {
		a a = new a();
		b b = new b();
		b.start();
//		a.start();
		for(int i=0;i<50;i++) {
			System.out.println("___");
//			if(i==5) {
//				try {
//					a.join();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
			if(i==5) {
//				Thread.yield();//�ó���ǰ�̵߳�cup(main)
				b.yield();//ͬ�ϣ�static����
			}
			
			
		}
	}
}
class a extends Thread{
	public void run() {
		for(int i=0;i<50;i++) {
			if(i==10) {
				Thread.yield();//ֻ�ǵ�ʱ�ó��������join�����������
			}
			System.out.println("a");
			try {
				this.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class b extends Thread{
	public void run() {
		for(int i=0;i<50;i++) {
			
			System.out.println("b");
			
		}
	}
}