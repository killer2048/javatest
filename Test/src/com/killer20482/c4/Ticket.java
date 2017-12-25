package com.killer20482.c4;

public class Ticket extends Thread {
	// 多线程引发 的问题
	static int a = 15;
	static aaa aa;
	static bbb bb;

	public Ticket(aaa aa,bbb bb) {
		this.aa = aa;
		this.bb = bb;
	}
	public Ticket(bbb bb) {
		
	}
	public Ticket() {
		
	}
	@Override
	public void run() {
//			test();
			test1();
//		test2();

	}
	
	public void test2() {
		int a1=aa.getA();
		while(a1 !=-1) {
			System.out.println(a1);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a1=aa.getA();
		}
		
	}
	public synchronized void test() {
		//synchronized只能锁当前的对象(this)，如果要锁的不是当前对象不能用方法的形式
		while(true) {
			if (bb.a != 0) {
				System.out.println(bb.a);
				bb.a--;
			} else {
				break;
			}
		}
		
	}
	public void test1() {
		while(true) {
//			synchronized(this) {
//				//要锁的对象错误，起不到保护的作用，锁当前对象，并不能防止其他对象被多线程访问
//				if (bb.a != 0) {
//					System.out.println(bb.a);
//					bb.a--;
//				} else {
//					break;
//				}
//			}
			synchronized(bb) {
				//要锁的对象为bb
				if (bb.a != 0) {
					System.out.println(bb.a);
					bb.a--;
				} else {
					break;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		aaa a = new aaa();
		bbb b = new bbb();
		Ticket t1 = new Ticket(a,b);
		Ticket t2 = new Ticket(a,b);
		Ticket t3 = new Ticket(a,b);
		t1.start();
		t2.start();
		t3.start();
	}

}
class aaa{
	int a = 15;
	int getA() {
		synchronized(this) {
			if(a>0) {
				return a--;
			} else {
				return -1;
			}
		}
		
	}
}
class bbb{
	int a=15;
}
