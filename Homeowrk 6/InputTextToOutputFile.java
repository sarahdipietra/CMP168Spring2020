

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class InputTextToOutputFile {
	public static void main(String[] args) {
		System.out.println("What is the name of your output file?");
		Scanner scanner = new Scanner(System.in); 
		String fileName = scanner.nextLine(); 

		try{
			FileWriter filewriter = new FileWriter(fileName); 
			while(true){ 
				String theLine = scanner.nextLine();
				if (theLine.contains("STOP!")){
					filewriter.write(theLine); 
					break;
				}
				filewriter.write(theLine + '\n');
			}
			filewriter.close(); 
		}
		catch(Exception exception){ 
			System.out.println("error");
		}
	}
}