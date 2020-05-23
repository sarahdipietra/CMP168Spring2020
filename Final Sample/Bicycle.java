//package FinalExam;

public class Bicycle extends Vehicle implements Comparable<Bicycle> {

	private double weight;
	public static int[] seats = {1};
	public static double ACCURACY_RANGE = 0.5;
	
	public Bicycle() {
		super(1, 1);
		weight = 0.0;
	}
	
	public Bicycle(Person driver) {
		super(driver, seats);
		this.weight = 0.0;
	}
	
	public Bicycle(Person driver, double weight) {
		super(driver, seats);
		if (weight < 0.0) {
			weight = 0.0;
		}
		else {
			this.weight = weight;
		}
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		if (weight > 0.0) {
			this.weight = weight;
		}
		else {
			weight = 0.0;
		}
	}			
	
	@Override
	public void setDriver(Person p) throws InvalidDriverException{
		if (p.hasDriverLicense() == false && p.getAge() < 3) {
			throw new InvalidDriverException();
		}
		else {
			personsOnBoard[0][0] = p;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Bicycle) {
			Bicycle a = (Bicycle)o;
			if(Math.abs(weight - a.getWeight()) <= 0.5) {
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
	public int compareTo(Bicycle b) {
		if (b.weight + ACCURACY_RANGE < this.weight) {
            return -1;
        }
        else if (b.weight - ACCURACY_RANGE > this.weight) {
            return 1;
        }
        else {
        	return 0;
        }
	}

	@Override
	public boolean loadPassenger(Person p) {
		return false;
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		return 0;
	}
	
	@Override
	public String toString() {
		return "Bicycle [ rider= " + getDriver().getName() + " | weight= " + weight + " ]";
	}
}