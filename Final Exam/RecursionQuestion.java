//package FinalExam;

import java.util.Arrays;

public class RecursionQuestion {

	public static int helper(Car c, Car[] cars, int s, int e){
		int mid = s + (e - s) / 2;
		System.out.print("s=" + s + ", e=" + e + ", mid=" + mid);
		if(s <= e) {
			if(cars[mid].equals(c)) {
				System.out.println("FOUND at " + mid);
				return mid;
			}
			if(cars[mid].compareTo(c) > 0){
				System.out.println("go left");
				return helper(c, cars, s, mid-1);
			}
			if(cars[mid].compareTo(c) < 0){
				System.out.println("go right");
				return helper(c, cars, mid+1, e);
			}
		}
		System.out.println("Not found");
		return -1;
	}

	public static int binarySearch(Car c,  Car[] cars){
		Arrays.sort(cars);
		System.out.println("Looking for Car: " + c.toString());
		return helper(c, cars, 0, cars.length - 1);
	}
	
	public static void main(String[] args) {
		System.out.print(binarySearch());
	}
}
