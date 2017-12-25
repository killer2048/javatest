package com.killer2048.objpro.test.t2;

public class T2 {
	public static void main(String[] args) {
		Vehicle v = new Vehicle("benz", "black");
		
		
		Car c = new Car("Honda","red",2);
		System.out.println(c.getBrand());
	}
}

class Vehicle {
	private final String brand;
	private String color;
	private double speed;

	public Vehicle(String brand, String color) {
		super();
		this.brand = brand;
		this.color = color;
		this.speed = 0.0;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getBrand() {
		return brand;
	}

	public void run() {
		System.out.println("Vehicle~~~~~~~~`");
	}

}

class Car extends Vehicle {
	private int loader;

	public Car(String brand, String color, int loader) {
		super(brand, color);
		this.loader = loader;
	}

	public int getLoader() {
		return loader;
	}

	public void setLoader(int loader) {
		this.loader = loader;
	}

	@Override
	public void run() {
		System.out.println("Car~~~~~~~~`");
	}
	
	
	
	
	
}