package Coordinate;

public class Plane {
	public static void main(String[] args) {
		Coordinate c1 = new Coordinate(); //Can put 0.0,0.0 in the parenthesis to make them equal.
		Coordinate c2 = new Coordinate(0.0, 0.0);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.printf("Distance: %.2f\n", c1.findDistance(c2));
		System.out.println(c1.equals(c2) ? "They're equal!" : "They're different!");
	}
}
