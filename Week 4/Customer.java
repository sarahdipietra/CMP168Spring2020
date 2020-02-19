package com.myorganization.customers;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import com.myorganization.employees.Employee;
//The .* imports everything but .class imports just the specific class

public class Customer {
	public static void main(String[] args) {
		//Employee myEmployee = new Employee();
		//myEmployee.lastName = "Smith";
		Person person1 = new Person("Mike", 28);
		Person person2 = new Person("Marry", 25);
		Person person3 = new Person("Harry", 40);
		Person person4 = new Person("Tom", 18);
		List<Person> people = new ArrayList<>(Arrays.asList(person1, person2, person3, person4));
		System.out.println(people);
		Collections.sort(people);
		System.out.println(people);
	}
}
