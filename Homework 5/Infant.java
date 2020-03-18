
public class Infant extends Person implements Mover{	
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
		if(index < numInfantToys && index >= 0) {
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
        String s = super.toString() + String.format("Infant: Number of Toys: %4d | Infant Toys:\n", numInfantToys);
        for (int i = 0; i < numInfantToys; i++) {
            s = s + toys[i].infantToyName + ", " + toys[i].infantToyRating + "; ";
        }
        return s;
    }

	public String getInfantToyAsString(int index) {
		if (index < numInfantToys && index >= 0) {
			String a = toys[index].toString();
			return a;
		}
		else {
			return "invalid index " + index;
		}
	}

	
	@Override
	public void printDetails() {
		super.printDetails();
			System.out.printf("Infant: Number of Toys: %4d | Infant Toys:\n | InfantToy: Toy Name: %20s | Rating %4d\n", numInfantToys, toys, infantToyName, infantToyRating);
	}
	
	@Override
	public double metabolizeAccumulatedCalories() {
		double weightGained = 0;
		int calories = this.getCaloriesAccumulator();
		while (calories - 1200 >= 0) {
			weightGained++;
			this.gainWeight();
			calories = calories - 1200;
		}
		if (calories < 1200) {
			double frac = calories / 1200.00;
			this.gainWeight(frac);
		}
		this.setCaloriesAccumulator(0);
		return weightGained;
	}
	
	@Override
	public String move() {
		return "flail arms and legs";
	}
	
	@Override
	public String move(int count) {
		String movement = "";
		for (int i = 0; i<= count; i++) {
			movement.concat("flail arms and legs \n");
		}
		return movement;
	}
	
	@Override
	public void eat(Food food) {
		int foodCals = food.getCalories();
		
		int calsConsumed = this.getCaloriesConsumed();
		this.setCaloriesConsumed(calsConsumed + foodCals);
		
		int calsAccumulated = this.getCaloriesAccumulator();
		this.setCaloriesAccumulator(calsAccumulated + foodCals);
	}
	
	@Override
	public void eat(Food[] food) {
		int totalCaloriesAdded = 0;
		for (Food nomnom : food) {
			totalCaloriesAdded = totalCaloriesAdded + nomnom.getCalories();
		}
		
		int caloriesConsumed = this.getCaloriesConsumed();
		this.setCaloriesConsumed(caloriesConsumed + totalCaloriesAdded);
		
		int caloriesAccumulated = this.getCaloriesAccumulator();
		this.setCaloriesAccumulator(caloriesAccumulated + totalCaloriesAdded);
	}
	
}









