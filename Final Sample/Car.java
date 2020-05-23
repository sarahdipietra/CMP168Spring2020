//package FinalExam;

import java.util.Arrays;

public class Car extends Vehicle implements Comparable<Car>, Announcements{

	private int numDoors;
	private int numWindows;

	public Car(int numDoors, int numWindows) {
		super(2, 2);
		this.numDoors = numDoors; 
		this.numWindows = numWindows;
	}

	public Car(int numDoors, int numWindows, int numSeatsPerRow) {
		super(2, numSeatsPerRow);
		this.numDoors = numDoors; 
		this.numWindows = numWindows;
	}

	public Car(int numDoors, int numWindows, int[] numSeatsPerRow) {
		super(numSeatsPerRow);
		this.numDoors = numDoors; 
		this.numWindows = numWindows;
	}

	public Car(int numDoors, int numWindows, Person driver, int[] numSeatsPerRow) {
		super(driver, numSeatsPerRow);
		this.numDoors = numDoors; 
		this.numWindows = numWindows;
	}

	public boolean canOpenDoor(Person p) {
		if (p.getAge() <= 5 || p.getHeight() <= 40) {
			return false;
		}
		else {
			if (personsOnBoard[0][0] == p || personsOnBoard[numberOfRows - 1][0] == p || personsOnBoard[numberOfRows - 1][1] == p) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	public boolean canOpenWindow(Person p) {
		if (p.getAge() <= 5 || p.getHeight() <= 40) {
			return false;
		}
		else {
			if (personsOnBoard[0][0] == p || personsOnBoard[0][1] == p || personsOnBoard[numberOfRows - 1][0] == p || personsOnBoard[numberOfRows - 1][1] == p) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	public int getNumWindows() {
		return this.numWindows;
	}

	public int getNumDoors() {
		return this.numDoors;
	}

	@Override 
	public boolean equals(Object o) {
		if (o instanceof Car) {
			Car a = (Car)o;
			boolean checkArray = true;
			if (numberOfRows == a.numberOfRows && maxSeatsPerRow == a.maxSeatsPerRow) {
				for (int i = 0; i<numberOfRows; i++) {
					if (numSeatsPerRow[i] != a.numSeatsPerRow[i]) {
						checkArray = false;
					}
				}
			}
			if (checkArray && a.numDoors == numDoors && a.numWindows == numWindows) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String uno = "[";
		for (int i = 0; i < numberOfRows; i++) {
			uno = uno + Integer.toString(numSeatsPerRow[i]);
			if (i != numberOfRows - 1) {
				uno += ",";
			}
		}
		uno = uno + "]";
		String dos = "[";
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < maxSeatsPerRow; j++) {
				if (personsOnBoard[i][j] instanceof Person) {
					dos = dos + personsOnBoard[i][j].getName();
					dos = dos + ",";
				}
			}
		}
		if (dos.endsWith(",")) {
			dos = dos.substring(0, dos.length()-1);
		}
		dos = dos + "]";
		return String.format("Car: number of doors = %02d | number of windows = %02d | number of rows = %02d | seats per row = %s | names of people on board = %s\n", numDoors, numWindows, numberOfRows, uno, dos );
	}

	public int compareTo(Car c) {
		int totalSeats = c.getNumberOfAvailableSeats() + c.getNumberOfPeopleOnBoard();
		int currTotalSeats = getNumberOfAvailableSeats() + getNumberOfPeopleOnBoard();

		if (currTotalSeats < totalSeats) {
			return -1;
		}
		else if (currTotalSeats == totalSeats) {
			return 0;
		}
		else {
			return 1;
		}
	}

	@Override
	public boolean loadPassenger(Person p) {
		for (int i = 0; i<numberOfRows; i++) {
			for (int j = 0; j<numSeatsPerRow[i]; j++) {

				if (personsOnBoard[i][j] == null && i == 0) {
					if (p.getAge() > 4 && p.getHeight() > 35) {
						personsOnBoard[i][j] = p;
						return true;
					}
				}

				if (personsOnBoard[i][j] == null && i>0) {
					personsOnBoard[i][j] = p;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		int count = 0;
		int numPeopleToLoad = peeps.length;

		while (getNumberOfAvailableSeats() > 0 && numPeopleToLoad > 0) {
			for (Person p : peeps) {
				loadPassenger(p);
				count++;
				numPeopleToLoad--;
			}
		}
		return count;
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
