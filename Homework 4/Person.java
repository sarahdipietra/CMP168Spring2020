

public class Person extends Passenger{
	private int numOffspring;
	
	public Person() {
		numOffspring = 0;
	}
	
	public Person(int numOffspring) {
		this.numOffspring = numOffspring;
	}
	
	public Person(String name, int birthYear, double weight, double height, char gender, int numCarryOn, int numOffspring) {
		super(name, birthYear, weight, height, gender, numCarryOn); 
		if (numOffspring < 0) {
			this.numOffspring = 0;
		}
		else {
			this.numOffspring = numOffspring;
		}	
	}	
	
	public void setNumOffspring(int numOffspring) {
		if (numOffspring < 0) {
			this.numOffspring = 0;
		}
		
		else {
			this.numOffspring = numOffspring;
		}
	}
	
	public int getNumOffspring() {
		return numOffspring;
	}
	
	@Override
	public void printDetails() {
		super.printDetails();
			System.out.printf("Person: Number of Offspring: %4d\n", numOffspring); 
		}

	@Override
	public String toString() {
		super.toString();
		return super.toString() + String.format("Person: Number of Offspring: %4d\n", numOffspring); 
	}
	
	@Override 
	public boolean equals(Object o) {
		super.equals(o);
		if (o instanceof Person) {
			Person a = (Person)o;
			if(this.numOffspring == a.numOffspring) {
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
}

	
	
	
