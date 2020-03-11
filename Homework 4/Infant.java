
public class Infant extends Person {	
	private class InfantToy{
		private String infantToyName;
		private int infantToyRating;
		
		public InfantToy(String infantToyName , int infantToyRating) {
			this.infantToyName = infantToyName;
			this.infantToyRating = infantToyRating;
		}
		
		public String toString() {
			return (String.format("InfantToy: Toy Name: %20s | Rating %4d\n", infantToyName, infantToyRating)); 
		}
	}

	private String infantToyName;
	private int infantToyRating;
	private InfantToy[] toys;
	private int numInfantToys;
		
	public Infant() {
		super(); 
		toys = new InfantToy[10];
		numInfantToys = 0;
	}
	
	public Infant(String name, int birthYear, double weight, double height, char gender, int numCarryOn) {
		super(name, birthYear, weight, height, gender, numCarryOn, 0);
		numInfantToys = 0;
		toys = new InfantToy [10];
	}
	
	public void addInfantToy(String name, int rating) {
		InfantToy blob = new InfantToy(name, rating);
		if (numInfantToys < 10) {
			toys[numInfantToys] = blob;
			numInfantToys++;
		}
		else {
			System.out.print("toys has reached capacity of 10");
		}
	}
	
	public int getNumInfantToys() {
		return numInfantToys;
	}
	
	public String getInfantToyName(int index) {
		if(index <= numInfantToys && index >= 0) {
			return toys[index].infantToyName;
		}
		else {
			return "invalid index + " + index;
		}
	}
	
	public int getInfantToyRating(int index) {
		if(index < numInfantToys && index >= 0) {
			return toys[index].infantToyRating;
		}
		else {
			return -1;
		}
	}
	
	public java.lang.String getInfantToyAsString(int index) {
		if(index < numInfantToys && index >= 0) {
			return toys[index].toString();
		}
		else {
			return "invalid index + " + index;
		}
	}
	
	public int getHighestInfantToyRating() {
		if (toys.length <= 0) {
			return 0;
		}
		else {
			int best = 0;
			for(int i = 0; i < numInfantToys; i++) {
				if(toys[i].infantToyRating > best) {
					best = toys[i].infantToyRating;
				}
			}
			return best;
		}
	}

	@Override
	public String toString() {
		super.toString();
		return super.toString() + String.format("Infant: Number of Toys: %4d | Infant Toys:\n", numInfantToys, toys); 
	}
	
	@Override
	public void printDetails() {
		super.printDetails();
			System.out.printf("Infant: Number of Toys: %4d | Infant Toys:\n | InfantToy: Toy Name: %20s | Rating %4d\n", numInfantToys, toys, infantToyName, infantToyRating);
	}
}
