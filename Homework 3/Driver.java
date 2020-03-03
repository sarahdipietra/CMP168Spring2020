public class Driver {
	public static void main(String[] args){

	Airplane aiplane1 = new Airplane(100);
	Passenger p1 = new Passenger("Albert", 1879, 198.5, 'm', 2);
	Passenger p2 = new Passenger("Grace", 1906, 105.0, 'f', 1);
	Passenger p3 = new Passenger("Tim", 1955, 216.3, 'm', 2);
	Passenger p4 = new Passenger("Steve", 1955, 160.0, 'm', 2);
	Passenger p5 = new Passenger("Sergey", 1973, 165.35, 'm', 1);

	aiplane1.addPassenger(p1);
	aiplane1.addPassenger(p2);
	aiplane1.addPassenger(p3);
	aiplane1.addPassenger(p4);
	aiplane1.addPassenger(p5);
	aiplane1.printAllDetails();
	}
}
