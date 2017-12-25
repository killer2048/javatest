package com.killer2048.objpro.test.t3;



public  class T3 {
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle("red", 50, 100);
		Circle  c = new Circle("black", 5.5);
		r.showAll();
		c.showAll();
	}
	
	

}

abstract class Shape{
	double area;
	double per;
	String color;
	public Shape(String color) {
		super();
		this.color = color;
	}
	public Shape() {
		super();
	}
	
	abstract double getArea();
	abstract double getPer();
	abstract void showAll();
	
	String getColor() {
		return color;
	}
}

class Rectangle extends Shape{
	double width;
	double height;
	@Override
	double getArea() {
		area=width*height;
		return area;
	}
	@Override
	double getPer() {
		per=2*(width+height);
		return per;
	}
	@Override
	void showAll() {
		System.out.println(getArea()+" "+getPer()+" ÂÔ");
	}
	public Rectangle(String color, double width, double height) {
		super(color);
		this.width = width;
		this.height = height;
	}
	public Rectangle() {
		super();
	}
	
}
class Circle extends Shape{
	double radius;

	@Override
	double getArea() {
		area=Math.PI*radius*radius;
		return area;
	}

	@Override
	double getPer() {
		per=2*Math.PI*radius;
		return per;
	}

	@Override
	void showAll() {
		System.out.println(getArea()+" "+getPer()+" ÂÔ");

	}

	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}

	public Circle() {
	}
}
