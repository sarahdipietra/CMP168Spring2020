//package FinalExam;

public class Person {
	private String name;
	private boolean hasDriverLicense;
	private int age;
	private int height;
	
	public Person(String name,  boolean hasDriverLicense, int age, int height) {
		this.name = name;
		this.age = age;
		this.hasDriverLicense = hasDriverLicense;
		this.height = height;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean hasDriverLicense() {
		return this.hasDriverLicense;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public Person clone() {
		Person copy = new Person(this.name, this.hasDriverLicense, this.age, this.height); 
		return copy; 
	}
	
	public boolean equals(Object o) {
		if(o instanceof Person) {
			Person p = (Person)o;
			if(this.name == p.name && this.hasDriverLicense == p.hasDriverLicense && this.age == p.age && this.height == p.height) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String license;
		if(this.hasDriverLicense == true) {
			license = "has license";
		}
		else {
			license = "no license";
		}
		return String.format("Person [name= %10s | age= %02d | height= %02d | %10s]", name, age, height, license);
	}
}