//package FinalExam;

import java.util.Arrays;

public class Car extends Vehicle implements Comparable<Car>, Announcements {
	private int numDoors;
	private int numWindows;

	public Car(int numDoors, int numWindows){
		super(2 ,2);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}

	public Car(int numDoors, int numWindows, int numSeatsPerRow ) {
		super(2, numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}

	public Car(int numDoors, int numWindows, int [ ] numSeatsPerRow ) {
		super(numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}

	public Car(int numDoors, int numWindows, Person driver, int [ ] numSeatsPerRow) {
		super(driver, numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}

	public boolean canOpenDoor(Person p) {
		int[] locationInVehicle = getLocationOfPersonInVehicle(p);
		int[] testLocation = {-1, -1};

		if (!(Arrays.equals(locationInVehicle, testLocation))) {
			if (locationInVehicle[1] == 0 || (locationInVehicle[1] == numSeatsPerRow[(locationInVehicle[0])] -1) ) {
				if (p.getAge() <= 5) {
					return false;
				}
				else if (numDoors < (2 * numberOfRows) && locationInVehicle[0] > (numDoors / 2)) {
					return false;
				}
				else{
					return true;
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

	public boolean canOpenWindow(Person p) {
		int[] locationInVehicle = getLocationOfPersonInVehicle(p);
		int[] testLocation = {-1, -1};

		if (!(Arrays.equals(locationInVehicle, testLocation))) {
			if (locationInVehicle[1] == 0 || (locationInVehicle[1] == numSeatsPerRow[(locationInVehicle[0])] -1) ) {
				if (p.getAge() <= 2) {
					return false;
				}
				else if (numWindows < (2 * numberOfRows) && locationInVehicle[0] > (numWindows / 2)) {
					return false;
				}
				else{
					return true;
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

	public int getNumWindows() {
		return numWindows;
	}

	public int getNumDoors() {
		return numDoors;
	}	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Car) {
			Car c = (Car)object;
			if (super.equals(c)) {
				if (this.numDoors == c.numDoors && this.numWindows == c.numWindows && this.numberOfRows == c.numberOfRows && this.maxSeatsPerRow == c.maxSeatsPerRow) {
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
	
	@Override
	public String toString() {
		return String.format("Car: number of doors= %02d | number of windows = %02d | number of rows= %02d | seats per row= %s | names of people on board= %s\n", numDoors, numWindows, numberOfRows, maxSeatsPerRow);
	}

	public int compareTo(Car c) {
		if (c.numSeatsPerRow.length > this.numSeatsPerRow.length) {
			return -1;
		}
		else if (c.numSeatsPerRow.length < this.numSeatsPerRow.length) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean loadPassenger(Person p) {
		boolean loadPass = false;
		if(p.getAge() < 5 || p.getHeight() < 36) {
			for(int i = 1; i < this.numberOfRows; i++) {
				for(int j = 0; j < this.numSeatsPerRow.length; j++) {
					if(this.personsOnBoard[i][j] == null) {
						loadPass = true;;
					}
					else {
						loadPass = false;;
					}
				}
			}
		}
		else {
			for(int i = 1; i < this.numberOfRows; i++) {
				for(int j = 0; j < this.numSeatsPerRow.length; j++) {
					if(this.personsOnBoard[i][j] == null) {
						loadPass = true;
					}
					else {
						loadPass = false;
					}
				}
			}
		}
		return loadPass;
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		int passengersAdded = 0;
		for(int i = 0; i < peeps.length; i++) {
			if(loadPassenger(peeps[i]) == true) {
				passengersAdded = passengersAdded + 1;
			}
		}
		return passengersAdded;
	}
	
	@Override
	public String departure() {
		return "All Aboard\n";
	}

	@Override
	public String arrival() {
		return "Everyone Out\n";
	}

	@Override
	public String doNotDisturbTheDriver() {
		return "No Backseat Driving\n";
	}
}
