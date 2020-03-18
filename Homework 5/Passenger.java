

import java.lang.String;
import java.lang.Object;

abstract class Passenger implements Eater{
	private String name;
	private int birthYear; 
	private double weight;
	private char gender;
	private int numCarryOn;
	private double height;

	public Passenger() {
		name = "";
		birthYear = 1900;
		weight = 0.0;
		height = 0.0;
		gender = 'u';
		numCarryOn = 0;
	}
	public Passenger(String name, int birthYear, double weight, double height, char gender, int numCarryOn) {
		this.name  = name;
		this.birthYear = birthYear;
		
		if (weight < 0.0) {
			this.weight = -1.0;
		}
		else {
			this.weight = weight;
		}
		
		if (height < 0.0) {
			this.height = -1.0;
		}
		else {
			this.height = height;
		}
		
		if ((gender != 'm') || (gender != 'f') || (gender != 'u')) {
			this.gender = 'u';
		}
		if ((gender == 'm') || (gender == 'f')){
			this.gender = gender;
		}
		
		if (numCarryOn < 0) {
			this.numCarryOn = 0;
		}
		else if (numCarryOn == 1) {
			this.numCarryOn = 1;
		}
		else if (numCarryOn > 2) {
			this.numCarryOn = 2;
		}
		else {
			this.numCarryOn = numCarryOn;
		}	
	}	
	
	public int calculateAge(int currentYear) {
		if (birthYear > currentYear) {
			return -1;
		}
		else { 
			return currentYear - birthYear;
		}
	}
	
	public void gainWeight() {
		weight = weight + 1.0;
	}
	
	public void gainWeight(double weightGained) {
		if(weightGained < (weight * -1.0)) {
			weight = 0.0;
		}
		else {
			weight = weight + weightGained;
		}
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public char getGender() {
		return gender;
	}

	public String getName(){
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getHeight() {
		return height;
	}
	
	public int getNumCarryOn() {
		return numCarryOn;
	}
	
	public boolean isFemale() {
		if (gender != 'f') {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean isMale() {
		if (gender != 'm') {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void loseWeight() {
		weight = weight - 1.0;
		if (weight < 0.0) {
			weight = 0.0;
		}
	}
	
	public void loseWeight(double weightLost) {
		if(weightLost > weight) {
			weight = 0.0;
		}
		if (!(weightLost > weight)){
			weight = weight - weightLost;
		}
	}
	
	public void printDetails() {
		System.out.printf("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f | Gender: %c | NumCarryOn: %2d\n", name, birthYear, weight, gender, numCarryOn);
	}
	
	public void setGender(char gender) {
		if(gender != 'm' || gender != 'f' || gender != 'u') {
			this.gender = 'u';
		}
		if (gender == 'm' || gender == 'f') {
			this.gender = gender;
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public void setWeight(double weight) {
		if (weight < 0.0) {
			this.weight = -1.0;
		}
		else {
			this.weight = weight;
		}
	}
	
	public void setHeight(double height) {
		if (height < 0.0) {
			this.height = -1.0;
		}
		else {
			this.height = height;
		}
	}
	
	public void setNumCarryOn(int numCarryOn) {
		if (numCarryOn < 0) {
			this.numCarryOn = -1;
		}
		else if (numCarryOn == 1) {
			this.numCarryOn = numCarryOn;
		}
		else {
			this.numCarryOn = 2;
		}
	}
	
	public double calculateBMI() {
		return (weight * 703)/ (height * height);
	}
	
	@Override
	public java.lang.String toString() {
		String s = String.format("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f | Gender: %c | NumCarryOn: %2d\n", name, birthYear, weight, height, gender, numCarryOn);
		return s;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Passenger) {
			Passenger passenger = (Passenger)o;
			if (this.name == passenger.name && this.birthYear == passenger.birthYear && this.gender == passenger.gender) {
				if (Math.abs(this.weight - passenger.weight) <= 0.5 && Math.abs(this.weight - passenger.weight) <= 0.5) {
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
		else {
			return false;
		}
	}
	
	private  int caloriesConsumed = 0;
	private  int caloriesAccumulator = 0;
	
	
	public void setCaloriesConsumed(int caloriesConsumed) {
		this.caloriesConsumed = caloriesConsumed;
	}
	
	public int getCaloriesConsumed() {
		return caloriesConsumed;
	}
	
	public void setCaloriesAccumulator(int caloriesAccumulator) {
		this.caloriesAccumulator = caloriesAccumulator;
	}
	
	public int getCaloriesAccumulator() {
		return caloriesAccumulator;
	}
	
	public abstract double metabolizeAccumulatedCalories();
}
