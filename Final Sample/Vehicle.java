//package FinalExam;

public abstract class Vehicle {

	protected Person[][] personsOnBoard;
	protected int numberOfRows;
	protected int maxSeatsPerRow;
	protected int[] numSeatsPerRow;
	
	public Vehicle(int numRows, int numSeatPerRow) {
		numberOfRows = numRows;
		maxSeatsPerRow = numSeatPerRow;
		numSeatsPerRow = new int[numSeatPerRow];
		personsOnBoard = new Person[numberOfRows][numSeatPerRow];
		for (int i = 0; i< numberOfRows; i++) {
			numSeatsPerRow[i] = numSeatPerRow;
		}
	}
	
	public Vehicle(int[] numSeatPerRow) {
		numSeatsPerRow = numSeatPerRow;
		numberOfRows = numSeatsPerRow.length;
		maxSeatsPerRow = 0;
		personsOnBoard = new Person[numberOfRows][maxSeatsPerRow];
		for (int i = 0; i < numberOfRows; i++) {
			if (maxSeatsPerRow < numSeatsPerRow[i]) {
				maxSeatsPerRow = numSeatsPerRow[i];
			}
		}
	}
	
	public Vehicle(Person driver, int[] numSeatsPerRow) {
		this.numSeatsPerRow = numSeatsPerRow;
		numberOfRows = numSeatsPerRow.length;
		maxSeatsPerRow = 0;
		personsOnBoard = new Person[numberOfRows][maxSeatsPerRow];
		for (int i = 0; i < numberOfRows; i++) {
			if (maxSeatsPerRow < numSeatsPerRow[i]) {
				maxSeatsPerRow = numSeatsPerRow[i];
			}
		}
		if (driver.hasDriverLicense()) {
			personsOnBoard[0][0] = driver;
		}
	}
	
	public abstract boolean loadPassenger(Person p);
	
	public abstract int loadPassengers(Person[] peeps);
	
	public void setPersonInSeat(Person p, int row, int seat) {
		this.personsOnBoard[row][seat] = p;
	}
	
	public void setDriver(Person p) throws InvalidDriverException{
		if (!(p.hasDriverLicense())) {
			throw new InvalidDriverException();
		}
		else {
			personsOnBoard[0][0] = p;
		}
	}
	
	public Person getDriver() {
		if (personsOnBoard[0][0] instanceof Person) {
			return personsOnBoard[0][0];
		}
		else {
			return null;
		}
	}
	
	public boolean hasDriver() {
		if (personsOnBoard[0][0] instanceof Person ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getNumberOfAvailableSeats() {
		int availableSeats = 0;
		for (int i = 0; i<numberOfRows; i++) {
			for (int j = 0; j<numSeatsPerRow[i]; j++) {
				
				if (!(personsOnBoard[i][j] instanceof Person)){
					availableSeats++;
				}
			}
		}
		return availableSeats;
	}
	
	public int getNumberOfAvailableSeatsInRow(int row) {
		int availableSeats = 0;
		if(row < 0 || row > this.numberOfRows) {
			availableSeats = -1;
		}
		else {
			for (int i = 0; i < this.numSeatsPerRow[row]; i++) {
				if (this.personsOnBoard[row][i] == null) {
					availableSeats++;
				}
			}
		}
		return availableSeats;
	}
	
	public int getNumberOfPeopleOnBoard() {
		int onBoard = 0;
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numSeatsPerRow[i]; j++) {
				if (personsOnBoard[i][j] instanceof Person) {
					onBoard++;
				}
			}
		}
		return onBoard;
	}
	
	public int getNumberOfPeopleInRow(int row) {
		int inTheRow = 0;
		for (int i = 0; i < numSeatsPerRow[row]; i++) {
			if (personsOnBoard[row][i] instanceof Person) {
				inTheRow++;
			}
		}
		return inTheRow;
	}
	
	public Person getPersonInSeat(int row, int col) {
		return personsOnBoard[row][col];
	}
	
	public int[] getLocationOfPersonInVehicle(Person p) {
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numSeatsPerRow[i]; j++) {
				if (personsOnBoard[i][j].equals(p)) {
					int[] fir = {i, j};
					return fir;
				}
			}
		}
		int[] sec = {-1, 1};
		return sec;
	}
	
	public Person[] getPeopleInRow(int row) {
		if (row < 0 || row >= numberOfRows) {
            return null;
        }
        boolean itsNull = true;
        Person[] peopleInRow = new Person[getNumberOfPeopleInRow(row)];
        for (int i = 0; i < maxSeatsPerRow; i++) {
            if (personsOnBoard[row][i] != null) {
                for (int j = 0; j < numSeatsPerRow[row]; j++) {
                    if (peopleInRow[j] == null) {
                        peopleInRow[j] = personsOnBoard[row][i].clone();
                        break;
                    }
                }
                itsNull = false;
            }
        }
        if (itsNull == true) {
            return null;
        }
        else {
            return peopleInRow;
        }
	}
	
	public Person[][] getPeopleOnBoard() {
		Person[][] peopleOnBoard = new Person[personsOnBoard.length][];
		for (int i = 0; i < personsOnBoard.length; i++) {
			peopleOnBoard[i] = personsOnBoard[i].clone();
				
		}
		return peopleOnBoard;
	}
	
	public boolean isPersonInVehicle(Person p) {
		int[] locationInVehicle = getLocationOfPersonInVehicle(p);
		return (locationInVehicle[0] != -1);
	}
	
	public boolean isPersonDriver(Person p) {
		if (personsOnBoard[0][0].equals(p)) {
			return true;
		}
		else {
			return false;
		}
	}
}
