package com.myorganization.shapes;

public class Rectangle extends Shape {
	private double width;
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getArea() {
		return width * getHeight();
	}
}
