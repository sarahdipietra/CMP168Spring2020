import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadAndEditFile {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		FileWriter filewriter = new FileWriter("HomeworkOutput6-2.txt");
		BufferedReader bufferreader = null;
		String fileName = "";

		while(true) {
			try {
				System.out.println("What is the name of your file?");
				fileName = scanner.nextLine();
				bufferreader = new BufferedReader(new FileReader(new File(fileName)));
				break;
			}
			catch(Exception exception) {
				System.out.println("File Not Found " + fileName);
			}
		}
		String theLine = "initial";
		boolean written = true;
		while((theLine = bufferreader.readLine())!=null) {
			theLine = theLine.replaceAll(" +"," ");
			String[] sentence = theLine.split("[.]");
			String write_sentence = "";
			
			if(written) {
				sentence[0]=Character.toUpperCase(sentence[0].charAt(0)) + sentence[0].substring(1);
			}
			
			for(int i = 1; i < sentence.length; i++) {
				String word = sentence[i];
				word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
				sentence[i] = word;
			}
			
			for(int i = 0; i < sentence.length; i++) {
				if(i == sentence.length-1) {
					write_sentence = write_sentence + sentence[i];
				}
				else {
					write_sentence = write_sentence + sentence[i] + ".";
				}
			}
			
			if(theLine.charAt(theLine.length()-1) == '.') {
				write_sentence = write_sentence + ".";
				written = true;
			}
			else {
				written = false;
			}
			
			write_sentence = write_sentence + "\n";
			for(int i = 0; i < write_sentence.length(); i++) {
				filewriter.write(write_sentence.charAt(i));
			}
		}
		bufferreader.close();
		filewriter.close();
	}
}
