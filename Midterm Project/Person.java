

public class Person implements Comparable<Person>{
	private String name;
	private int birthYear;
	
	public Person() {
		name = "";
		birthYear = 0;
	}
	
	public Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(int year) {
		birthYear = year;
	}
	
	@Override
	public int compareTo(Person p1) {
		return Integer.compare(this.birthYear, p1.birthYear);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Person) {
			Person p1 = (Person)object;
			if (this.name == p1.name && this.birthYear == p1.birthYear) {
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
		return String.format("Person: Name: %30s | Birth Year: %4d", name, birthYear);
	}
}
