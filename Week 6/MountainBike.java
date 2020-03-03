package bikes;

public class MountainBike extends Bicycle{
	 private int seatHeight;
	 
	 public MountainBike(int gear, double speed, int startHeight) {
		 super(gear, speed);
		 seatHeight = startHeight;
	 }
}
