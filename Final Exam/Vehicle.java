package FinalExam;

public abstract class Vehicle {
	protected Person [][] personsOnBoard;
	protected int numberOfRows;
	protected int maxSeatsPerRow;
	protected int [] numSeatsPerRow;

	public Vehicle(int numRows, int numSeatsPerRow) {
		this.numberOfRows = numRows;
		this.numSeatsPerRow = new int [numberOfRows];
		this.maxSeatsPerRow = numSeatsPerRow;
		personsOnBoard = new Person[numberOfRows][];
		
	}

	public Vehicle(int[] numSeatsPerRow) {
		this.numSeatsPerRow = numSeatsPerRow;
		numberOfRows = numSeatsPerRow.length;
		maxSeatsPerRow = numSeatsPerRow[0];
		personsOnBoard = new Person[numberOfRows][];
	}

	public Vehicle(Person driver, int[] numSeatsPerRow) {
		this(numSeatsPerRow);
		if(driver.hasDriverLicense()) {
			driver = personsOnBoard[0][0];
		}
	}

	abstract boolean loadPassenger(Person p);

	abstract int loadPassengers(Person [] peeps);

	public void setDriver(Person p) throws InvalidDriverException{
		if(p.hasDriverLicense() == true) {
			p = personsOnBoard[0][0];
		}
		else {
			throw new InvalidDriverException();
		}
	}

	public Person getDriver() {
		return personsOnBoard[0][0];
	}

	public boolean hasDriver() {
		return (personsOnBoard[0][0] != null);
	}

	public int getNumberOfAvailableSeats() {
		int numberOfAvailableSeats = 0;
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numSeatsPerRow[i]; j++) {
				if (personsOnBoard[i][j] == null) {
					numberOfAvailableSeats++;
				}
			}
		}
		return numberOfAvailableSeats;
	}

	public int getNumberOfAvailableSeatsInRow(int row) {
		int numberOfAvailableSeats = -1;
		if (row < numberOfRows && row >= 0) {
			numberOfAvailableSeats = 0;
			for (int i = 0; i < numSeatsPerRow[row]; i++) {
				if (personsOnBoard[row][i] == null) {
					numberOfAvailableSeats++;
				}
			}
		}
		return numberOfAvailableSeats;
	}

	public int getNumberOfPeopleOnBoards() {
		int numberOfPeopleOnBoard = 0;
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numSeatsPerRow[i]; j++) {
				if (personsOnBoard[i][j] == null) {
					numberOfPeopleOnBoard++;
				}
			}
		}
		return numberOfPeopleOnBoard;
	}

	public int getNumberOfPeopleInRow(int row) {
		int numberOfPeopleInRow = -1;
		if (row < numberOfRows && row >= 0) {
			numberOfPeopleInRow = 0;
			for (int i = 0; i < numSeatsPerRow[row]; i++) {
				if (personsOnBoard[row][i] == null) {
					numberOfPeopleInRow++;
				}
			}
		}
		return numberOfPeopleInRow;
	}

	public Person getPersonInSeat(int row, int col) {
		if (row < numberOfRows && row >= 0 && col < numSeatsPerRow[row] && col >= 0) {
			return personsOnBoard[row][col];
		}
		return null;
	}

	public int[] getLocationOfPersonInVehicle(Person p) {
		int locationOfPersonInVehicle[] = {-1, -1};
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numSeatsPerRow[i]; j++) {
				if (personsOnBoard[i][j] == null) {
					if(personsOnBoard[i][j].equals(p)) {
						locationOfPersonInVehicle[i] = 0;
						locationOfPersonInVehicle[j]= 1;
					}
				}
			}
		}
		return locationOfPersonInVehicle;
	}

	public Person[] getPeopleInRow(int row) {
		int numberOfPeople = getNumberOfPeopleInRow(row);
		if (numberOfPeople > 0) {
			Person [] peopleInRow = new Person[numberOfPeople];
			int totalPeopleInRow = 0;
			for (int i = 0; i < numSeatsPerRow[row]; i++) {
				if (personsOnBoard[row][i] != null) {
					peopleInRow[totalPeopleInRow] = personsOnBoard[row][i].clone();
					totalPeopleInRow++;
				}
			}
			return peopleInRow;
		}
		return null;
	}

	public Person [][] getPeopleOnBoard() {
		Person [][] peopleOnBoard = new Person[numberOfRows][];
		for (int i = 0; i < numberOfRows; i++) {
			int totalPeopleOnBoard = getNumberOfPeopleInRow(i);
			if (totalPeopleOnBoard <= 0) {
				totalPeopleOnBoard = 0;
			}
			peopleOnBoard[i] = new Person [totalPeopleOnBoard];
			if (peopleOnBoard[i].length > 0) {
				peopleOnBoard[i] = getPeopleInRow(i);
			}
		}
		return peopleOnBoard;
	}

	public boolean isPersonInVehicle(Person p) {
		int locationOfPersonInVehicle[] = getLocationOfPersonInVehicle(p);
		return locationOfPersonInVehicle[0] != -1;
	}

	public boolean isPersonDriver(Person p) {
		return personsOnBoard[0][0].equals(p);
	}

}
