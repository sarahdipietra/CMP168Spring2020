//package FinalExam;

public class Person {
	private String name;
	private boolean hasDriverLicense;
	private int age;
	private int height;

	public Person(String name, boolean hasDriverLicense, int age, int height) {
		this.name = name;
		this.hasDriverLicense = hasDriverLicense;
		this.age = age;
		this.height = height;
	}

	public String getName() {
		return this.name;
	}
	
	public boolean hasDriverLicense() {
		if(hasDriverLicense) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public Person clone() { 
		Person copy = new Person(name, hasDriverLicense, age, height); 
		return copy; 
	} 
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Person) {
			Person p1 = (Person)object;
			if (this.name == p1.name && this.hasDriverLicense == p1.hasDriverLicense && this.age == p1.age && this.height == p1.height) {
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
	
	@Override
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
