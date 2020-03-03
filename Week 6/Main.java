package com.myorganization.shapes;

public class Main {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();
		rectangle.setHeight(3.4);
		rectangle.setWidth(6.28);
		System.out.println("Rectangle");
		System.out.printf("Height: %.2f\n", rectangle.getHeight());
		System.out.printf("Area: %.2f", rectangle.getArea());
		
		System.out.println();
		
		Triangle triangle = new Triangle();
		triangle.setBase(7.9);
		triangle.setHeight(10.2);
		System.out.println("Traingle");
		System.out.printf("Height: %.2f\n", triangle.getHeight());
		System.out.printf("Area: %.2f\n", triangle.getArea());
		
		Shape shape = triangle;
		shape.getHeight();
		
		shape = rectangle;
		shape.getHeight();
		
		Triangle t = (Triangle)shape;
		t.getArea();
		
		//Rectangle r = (Rectangle)shape;
		//r.getArea();
		
		if (shape instanceof Rectangle) {
			Rectangle r = (Rectangle)shape;
			System.out.println("After downcasting: ");
			System.out.println("Area: " + r.getArea());
		}
		
		Shape[] shapes = {triangle, rectangle};
		for (Shape s : shapes) {
			System.out.println("Height: " + s.getHeight());
		}
	}
}
