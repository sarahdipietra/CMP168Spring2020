//package FinalExam;

public class Bicycle extends Vehicle implements Comparable<Bicycle> {
	private double weight;
	protected final double ACCURACY_RANGE = 0.5;
	private static int[] filler = {1};

	public Bicycle() {
		super(1,1);
		this.weight = 0;
	}

	public Bicycle(Person driver){
		super(driver, filler);
		this.weight = 0;
	}

	public Bicycle(Person driver, double weight){
		super(driver, filler);
		this.weight = 0;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight() {
		this.weight = weight;
	}

	@Override
	public void setDriver(Person p) throws InvalidDriverException{
		if(p.getAge() >= 3) {
			super.setDriver(p);
		}
		else {
			throw new InvalidDriverException();
		}
	}


	@Override
	public String toString() {
		return String.format("Bicycle [ rider= " + getDriver().getName() + " | weight= " + weight + " ]");
	}

	@Override
	public int compareTo(Bicycle b) {
		Bicycle trike = (Bicycle) b;
		if ((Math.abs(this.getWeight() - trike.getWeight()) <= ACCURACY_RANGE)) {
			return Double.compare(this.weight, trike.weight);
		}
		else if((Math.abs(this.getWeight() - trike.getWeight()) < 0.0)) {
			return -1;
		}
		else {
			return 1;
		}
	}

	@Override
	public boolean loadPassenger(Person p) {
		return false;
	}

	public int loadPassengers(Person[] peeps){
		return 0;
	}
}
