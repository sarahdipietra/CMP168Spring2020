package com.myorganization.employees;

public class Employee {
	private int id;
	private String firstName; 
	public String lastName;
	private String address;
	private double salary;
	
	public Employee() {
		//TODO
		this(0, "John", "Doe", "nod address", 800.0);
	}
	 
	public Employee(int id, String firstName, String lastName, String address, double salary) {
		this.id = id; 
		this.firstName = firstName;
		this.lastName = lastName; 
		this.address = address;
		this.salary = salary;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAddress(String theAddress) {
		address = theAddress;
	}
	
	public void setSalary(double salary) {
		if (salary >= 0.0) {
			this.salary = salary;
		}
	}
	
	public void increaseSalary(double amount) {
		if (amount >= 0) {
			salary = salary + amount;
		}
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getTheAddress() {
		return address;
	}
	
	public double getSalary() {
		return salary;
	}
	
	@Override //Makes the compiler check if there is a method in the super class and override to check it 
	public String toString() {
		return "[" + firstName + " " + lastName + ", " + salary + "]";
	}
}
