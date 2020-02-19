package com.myorganization.employees;

public class Company {
	public static void main(String[] args) {
		Employee employee1 = new Employee(1, "Jack", "Smith", "1234 Park Ave.", 1200.0);
		//employee1.firstName = "John";
		//employee1.id = 1;
		
		/*employee1.setId(1);
		employee1.setFirstName("Jack");
		employee1.setLastName("Smith");
		employee1.setAddress("1234 Park Ave.");*/
		
		Employee employee2 = new Employee(2, "John", "McNeal", "3456 Spring Ave.", 3200.0);
		/*employee2.setId(2);
		employee2.setFirstName("John");
		employee2.setLastName("McNeal");
		employee2.setAddress("3456 Spring Ave.");*/
		
		Employee employee3 = new Employee();
		
		//System.out.println("First Employee: " + employee1.getFirstName());
		//System.out.println("Second Employee: " + employee2.getFirstName());
		
		System.out.println("Salary before raise: ");
		System.out.println(employee1);
		System.out.println(employee2);
		System.out.println(employee3);
		
		System.out.println("Salary after raise: ");
		Employee[] employees = {employee1, employee2, employee3};
		for (Employee e : employees) {
			e.increaseSalary(200.25);
			System.out.println(e);
		}
	}
}
