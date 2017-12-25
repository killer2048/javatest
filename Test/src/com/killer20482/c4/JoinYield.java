package com.killer20482.c4;

public class JoinYield {
	public static void main(String[] args) {
		
		Aa a = new Aa("a");
		Bb b = new Bb("b");
		Thread bt = new Thread(b);
		a.start();
		bt.start();
		int i=0;
		while(i<=20) {
			System.out.println(1);
			i++;
			if(i==3) {
				try {
					a.join();//使main在a结束前阻塞，但a与b无先后关系
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

	public static void haha(String a) {
		for(int  i=0;i<10;i++) {
			System.out.println(a);
		}
	}
	
}

class Aa extends Thread{
	//继承Thread
	String a;
	
	

	public Aa(String a) {
		super();
		this.a = a;
	}
	


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int  i=0;i<10;i++) {
			if(i==7) {
				this.yield();//让出当前线程，但可能被cpu再次调度
			}
			System.out.println(a);
		}
	}
}


class Bb implements Runnable{

	String a;
	
	public Bb(String a) {
		super();
		this.a = a;
	}
public void stopandwait(Thread a) {
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int  i=0;i<10;i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==2) {
//				Thread.yield();
			}
			System.out.println(a);
		}
	}
	
}