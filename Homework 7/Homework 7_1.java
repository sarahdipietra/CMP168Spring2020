//package Homework7;

import java.util.Arrays; 

public class Homework7_1 {


	public static int fib(int n) { 
		if (n == 0) { 
			return 0; 
		}
		
		else if (n == 1) {
			return 1;
		}
		
		else {
			return fib(n-1) + fib(n-2); 
		}

	} 

	
	public static int getPowerOfXtoN(int xBase, int nExp) {
		if (nExp == 0) {
			return 1;
		}
		
		else if (nExp == 1) {
			return xBase;
		}
		
		else {
			return xBase * (getPowerOfXtoN(xBase, nExp-1));
		}
	}

	
	public static int helper(String target, String[] words, int high, int low){
		if(high > low) {
			return -1;
		}
		
		int median = high + (low - high) / 2;
		
		if(words[median].equals(target)) {
			return median;
		}
		
		if(words[median].compareTo(target) < 0) {
			return helper(target, words, median + 1, low);
		}
		
		return helper(target, words, high, low - 1);
	}

	
	public static int binarySearch(String target, String[] words){
		Arrays.sort(words);
		return helper(target, words, 0, words.length - 1);
	}
 
	
	public static int organizeParade(int paradeLength) {
		if (paradeLength == 1) {
			return 2;
		}
		
		else if (paradeLength == 2) {
			return 3;
		}
		
		else {
			return organizeParade(paradeLength-1) + organizeParade(paradeLength-2);
		}
	}

	
	public static int numJarsNeeded(int candyCount, int jarCapacity) {
        if (candyCount == 0) {
            return 0;
        }
        
        else if (candyCount <= jarCapacity) {
            return 1;
        }
        
        else if ((double) candyCount / 2 <= jarCapacity) {
            return 2;
        }
        
        else {
            if (candyCount % 2 == 0) {
                return 2 * numJarsNeeded(candyCount / 2, jarCapacity);
            }
            else {
                return (numJarsNeeded((candyCount + 1) / 2, jarCapacity) + 1);
            }
        }

    }
}
