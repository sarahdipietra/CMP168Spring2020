public class Airplane {
	private Passenger [] passengers;
	private String airplaneName;
	private int numPassengers;
	
	public Airplane (){
		passengers = new Passenger[100];
		airplaneName = "";
		numPassengers = 0;
	}
	
	public Airplane (String airplaneName){
		passengers = new Passenger[100];
		this.airplaneName = airplaneName;
		numPassengers = 0;
	}
	
	public Airplane (int maxPassengers){
		if(maxPassengers < 0) {
			maxPassengers = 0;
		}
		passengers = new Passenger[maxPassengers];
		numPassengers = 0;
		airplaneName = "";
	}
	
	public Airplane(String airplaneName, int maxPassengers) {
		if(maxPassengers < 0) {
			maxPassengers = 0;
		}
		this.airplaneName = airplaneName;
		this.numPassengers = 0;
		passengers = new Passenger[maxPassengers];
	}
	
	public void addPassenger(Passenger a) {
		if(numPassengers < passengers.length) {
			passengers[numPassengers] = a;
			numPassengers++;
		}
		else {
			passengers[numPassengers] = a;
			numPassengers++;
		}
	}
	
	public String getAirplaneName() {
		return airplaneName;
	}
	
	public Passenger getPassenger(int index) {
		if(index <= numPassengers && index >= 0) {
			return passengers[index];
		}
		else {
			return null;
		}
	}
	
	public int getNumPassengers() {
		return numPassengers;
	}

	public Passenger getFirstPassenger() {
		if (passengers[0] != null) {
		return passengers[0];
		}
		else {
			return null;
		}
	}
	
	public Passenger getLastPassenger() {
		return passengers[numPassengers - 1];
	}
	
	public Passenger[] getPassengers() {
		return passengers;
	}
	
	public void setAirplaneName(String name) {
		this.airplaneName = name;
	}
	
	public void printAllDetails() {
		System.out.printf("AirplaneName: %20s | Number of Passengers: %4d | Airplane Size: %4d\n", airplaneName, numPassengers, passengers.length);
		for(int i = 0; i < numPassengers; ++i) {
				passengers[i].printDetails(); 
		}
	}
	
	public Passenger removePassenger(int index) {
		if(index < numPassengers && index >= 0) {
			Passenger removedPassenger = passengers[index];
			for(int i = index; i < numPassengers - 1; i++) {
				passengers[i] = passengers[i + 1];
			}
			passengers[numPassengers - 1] = null;
			numPassengers--;
			return removedPassenger;
		}
		else {
			return null;
		}
	}
	
	public void removeAllPassengers() {
		for(int i = 0; i < numPassengers; i++) {
			 passengers[i] = null;
		}
		numPassengers = 0;
	}
	
	public double getTotalWeightOfAllPassengers() {
		double totalWeight = 0.0;
		for(int i = 0; i < numPassengers; i++) {
			totalWeight = totalWeight + passengers[i].getWeight();
		}
		return totalWeight;
	}
	
	public double getAverageWeightOfAllPassengers() {
		double averageWeight = 0.0;
		for(int i = 0; i < passengers.length-1; i++) {
			averageWeight = averageWeight + passengers[i].getWeight();
		}
		return averageWeight / numPassengers;
	}
	
	public int getNumberOfPassengersAboveWeight(double weight) {
		int abovePassengers = 0;
		for(int i = 0; i < passengers.length-1; ++i) {
			if(passengers[i].getWeight() > weight) {
				abovePassengers++;
			}
		}
		return abovePassengers;
	}
	
	public int getNumberOfPassengersBelowWeight(double weight) {
		int belowPassengers = 0;
		for(int i = 0; i < passengers.length-1; ++i) {
			if(passengers[i].getWeight() < weight) {
				belowPassengers++;
			}
		}
		return belowPassengers;
	}
	
	public void increaseWeightOfAllPassengers() {
		for(int i = 0; i < passengers.length-1; ++i) {
			passengers[i].gainWeight();
		}
	}
	
	public void increaseWeightOfAllPassengers(double weight) {
		for(int i = 0; i < passengers.length-1; ++i) {
			passengers[i].gainWeight(weight);
		}
	}
}
