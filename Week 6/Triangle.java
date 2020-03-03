package com.myorganization.shapes;

public class Triangle extends Shape{
	private double base;
	
	public void setBase(double base) {
		this.base = base;
	}
	
	public double getArea() {
		return( base * getHeight())/2;
	}

}
