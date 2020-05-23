//package FinalExam;

import java.util.Arrays;
import java.util.Scanner;

public class RecursionQuestion {



public static int binarySearch(Car[] cars, Car c) {
		
		System.out.println("Looking for " + c.toString());
		
		Arrays.sort(cars);
		return helper(cars, 0, cars.length-1, c);
		
	}
	
	public static int helper(Car[] cars, int s, int e, Car c) {
		
		boolean notInExistance = true;
		
		int mid = s + (e-s) /2;
		
		if (s<=e && notInExistance) {

			System.out.println("s=" + s + ", e=" + e + ", mid=" + mid);

			if (c.compareTo(cars[mid]) == -1) {
				System.out.println("go left");
				helper(cars, s, mid-1, c);
			}
			else if (c.compareTo(cars[mid]) == 1) {
				System.out.println("go right");
				helper(cars, mid + 1, e, c);
			}
			else {
				System.out.println("FOUND at " + mid);
				System.out.println();
				System.out.println();
				return mid;
			}
		}
		else {
			System.out.println("s=" + s + ", e=" + e );
			System.out.println("Not Found\n");
			notInExistance = false;
		}
		return -1;
	}

	public static void main(String[] args) {
		Car [] cars = new Car[10];
		int [][] seatConfigurations = {new int[]{2,2}, new int[]{2,3}, new int[]{2,2,3}, new int[]{2,3,3}, new int[]{2,3,4}, new int[]{2,4,3}, new int[]{2,3,5}, new int[]{2,4,4}, new int[]{2,4,5}, new int[]{3,4,5}};
		for(int i=0; i<cars.length; i++){
			cars[i] = new Car(2, 4, seatConfigurations[i]);
		}
		Scanner kb = new Scanner(System.in);
		String [] input = kb.nextLine().split(" ");
		int [] rowSeats = new int[input.length];
		for(int i=0; i<input.length; i++){
			rowSeats[i] = Integer.parseInt(input[i]);
		}
		Car a = new Car(2, 4, rowSeats);
		binarySearch(cars, a);
	}
}

/*public static int helper(Car c, Car[] cars, int s, int e){
boolean theSeat = false;
int mid = s + (e - s) / 2;
System.out.print("s=" + s + ", e=" + e + ", mid=" + mid);
if(s <= e && theSeat) {
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
}*/