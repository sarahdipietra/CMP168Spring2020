package com.myorganization.customers;

public class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public int compareTo(Person that) {
		return Integer.compare(age, that.age);
		//return name.compareTo(that.name);
	}
	
	@Override
	public String toString() {
		return "[" + name + ", " + age + "]";
	}
}
