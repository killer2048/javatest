package com.killer2048.obj.t1;

public class Rectangle {
	int width;
	int height;
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getArea() {
		return width*height;
	}
	public int getPer() {
		return (width+height)*2;
	}
	public void showAll() {
		System.out.println(width+" "+height+" "+getArea()+" "+getPer());
	}
	
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(456,12);
		r.showAll();
	}
	
	
}
