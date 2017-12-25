package com.killer2048.obj.t1;

public class Point {
	int x;
	int y;
	public Point() {}
	public Point(int x0,int y0) {
		this.x = x0;
		this.y = y0;
	}
	
	public void movePoint(int dx,int dy) {
		x+=dx;
		y+=dy;
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(10,20);
		Point p2 = new Point(35,44);
		p1.movePoint(-5,10);
		p2.movePoint(1500, 32);
		
		System.out.println(p1.x+" "+p1.y);
		System.out.println(p2.x+" "+p2.y);
	}
}
