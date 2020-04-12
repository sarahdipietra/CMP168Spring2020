

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ReadAndPrintFile {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		BufferedReader bufferedreader = null;
		String fileName = "";

		while(true) {
			try {
				System.out.println("What is the name of your file?");
				fileName = scanner.nextLine();
				bufferedreader = new BufferedReader(new FileReader(new File(fileName)));
				break;
			}
			catch(Exception exception) {
				System.out.println("File Not Found " + fileName);
			}
		}
		
		String theLine = bufferedreader.readLine();
		while (theLine != null) {
			System.out.println(theLine);
			theLine = bufferedreader.readLine();
		}
	}
}

