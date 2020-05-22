//package FinalExam;

public class Bus extends Car {
	public Bus(int[] numSeatsPerRow) {
		super(2, (2 * numSeatsPerRow.length) - 1);
	}

	public Bus(Person driver, int[] numSeatsPerRow) {
		super(2, (2 * numSeatsPerRow.length) - 1, driver, numSeatsPerRow);
	}

	public boolean canOpenDoor(Person p) {
		boolean abilityToOpen = false;
		if(super.canOpenDoor(p)) {
			abilityToOpen = true;
		}
		else {
			abilityToOpen = false;
		}
		return abilityToOpen;
	}

	public boolean canOpenWindow(Person p) {
		boolean abilityToOpen;
		if(super.canOpenWindow(p)) {
			abilityToOpen = true;
		}
		else {
			abilityToOpen = false;
		}
		return abilityToOpen;
	}

	public String toString() {
		return "Bus is an extension of " + super.toString();
	}
}	

