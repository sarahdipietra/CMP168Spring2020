//package FinalExam;

public class Bus extends Car {
	public Bus(int[] numSeatsPerRow) {
		super(2, (2 * numSeatsPerRow.length) - 1, numSeatsPerRow);
	}
	
	public Bus(Person driver, int[] numSeatsPerRow) {
		super(2, (2 * numSeatsPerRow.length) - 1, driver, numSeatsPerRow);
	}
	
	public String departure() {
		return super.departure() + "The Bus\n";
	}
	
	public String arrival() {
		return super.arrival() + "Of The Bus\n";
	}
	
	public String doNotDisturbTheDriver() {
		return super.doNotDisturbTheDriver() + "On The Bus\n";
	}
	
	public boolean canOpenDoor(Person p) {
		boolean ability = false;
		if(p.getAge() <= 5 || p.getHeight() <= 40) {
			if(super.canOpenDoor(p)) {
				ability = true;
			}
			else {
				ability = false;
			}
		}
		else {
			ability = false;
		}
		return ability;
	}
	
	public boolean canOpenWindow(Person p) {
		boolean ability = false;
		if(p.getAge() <= 5 || p.getHeight() <= 40 || super.canOpenWindow(p) == false) {
			ability = false;
		}
		else {
			ability = true;
		}
		return ability;
	}
	
	
	public String toString() {
		return "Bus is an extension of " + super.toString();
	}
}