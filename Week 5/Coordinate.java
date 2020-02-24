package Coordinate;

import java.util.Objects;

public class Coordinate {
	private double x;
	private double y;
	
	public Coordinate() {
		this(1.0, 1.0);
	}
	
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double findDistance(Coordinate that) {
		return Math.sqrt(Math.pow(x - that.x, 2) + Math.pow(y - that.y, 2));
	}
	
	@Override 
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Coordinate)) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		Coordinate that = (Coordinate) obj;
		return x == that.x && y == that.y;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x,y);
	}
	
	
	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}
}
