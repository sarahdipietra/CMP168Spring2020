package bikes;

public class Bicycle {
	private int gear;
	private double speed;
	
	public Bicycle (int gear, double speed) {
		this.gear = gear;
		this.speed = speed;
	}
	
	public void speedUp(double increment) {
		speed = speed + increment;
	}
	
	public void applyBreak(double decrement) {
		speed = Math.max(0.0,  speed - decrement);
	}
}
