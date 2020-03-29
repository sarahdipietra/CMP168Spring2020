

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver_SchoolDB {
	public static void main(String[] args) throws IOException {

		FileInputStream fileByteStream = null;
		fileByteStream = new FileInputStream("SchoolDB_Initial.txt");
		Scanner scnr = new Scanner(fileByteStream);
		
		Course[] courses = new Course[50];
		int numOfCourses = 0;
		GeneralStaff[] generalStaff = new GeneralStaff[50];
		int numOfGeneralStaff = 0;
		Faculty[] faculty = new Faculty[50];
		int numOfFaculty = 0;
		Student[] students = new Student[50];
		int numOfStudents = 0;
		
		try {
			scnr = new Scanner("SchoolDB_Initial.txt");
			while (scnr.hasNextLine()) {
				String line = scnr.nextLine();
				String getRidOfCommas = line.replace(", ", "");
				String[] array = line.split(" ");

				if (array[0] == "Course:") {
					Course course1 = new Course(Boolean.parseBoolean(array[1]), Integer.parseInt(array[2]), array[3], Integer.parseInt(array[4]));
					courses[numOfCourses] = course1;
					numOfCourses++;
					System.out.println(numOfCourses);
				}
				
				else if (array[0] == "Faculty:") {
					if (array.length == 1) {
						Faculty teacher = new Faculty();
						faculty[numOfFaculty] = teacher;
						numOfFaculty++;
					}
					if (array.length == 2) {
						Faculty teacher = new Faculty(Boolean.parseBoolean(array[1]));
						faculty[numOfFaculty] = teacher;
						numOfFaculty++;
					}
					if (array.length == 3) {
						Faculty teacher = new Faculty(array[1], Boolean.parseBoolean(array[2]));
						faculty[numOfFaculty] = teacher;
						numOfFaculty++;
					}
					if (array.length == 5) {
						Faculty teacher = new Faculty(array[1], Integer.parseInt(array[2]), array[3], Boolean.parseBoolean(array[4]));
						faculty[numOfFaculty] = teacher;
						numOfFaculty++;
					}
					else {
	                    Faculty teacher = new Faculty();
	                    faculty[numOfFaculty] = teacher;
	                    numOfFaculty++;
	                }
				}
				
				else if (array[0] == "GeneralStaff:") {
					if (array.length == 1) {
						GeneralStaff staffMember1 = new GeneralStaff();
						generalStaff[numOfGeneralStaff] = staffMember1;
						numOfGeneralStaff++;
					}
					if (array.length == 2) {
						GeneralStaff staffMember1 = new GeneralStaff(array[1]);
						generalStaff[numOfGeneralStaff] = staffMember1;
						numOfGeneralStaff++;
					}
					if (array.length == 3) {
						GeneralStaff staffMember1 = new GeneralStaff(array[1],array[2]);
						generalStaff[numOfGeneralStaff] = staffMember1;
						numOfGeneralStaff++;
					}
					if (array.length == 5) {
						GeneralStaff staffMember1 = new GeneralStaff(array[1], Integer.parseInt(array[2]), array[3], array[4]);
						generalStaff[numOfGeneralStaff] = staffMember1;
						numOfGeneralStaff++;
					}
					else {
						GeneralStaff staffMember1 = new GeneralStaff();
						generalStaff[numOfGeneralStaff] = staffMember1;
	                    numOfGeneralStaff++;
	                }
				}
				
				else if (array[0] == "Student:") {
					if (array.length == 1) {
						Student student = new Student();
						students[numOfStudents] = student;
						numOfStudents++;
					}
					if (array.length == 2) {
						Student student = new Student(Boolean.parseBoolean(array[1]));
						students[numOfStudents] = student;
						numOfStudents++;
					}
					if (array.length == 3) {
						Student student = new Student(array[1], Boolean.parseBoolean(array[2]));
						students[numOfStudents] = student;
						numOfStudents++;
					}
					if (array.length == 5) {
						Student student = new Student(array[1], Integer.parseInt(array[2]), array[3], Boolean.parseBoolean(array[4]));
						students[numOfStudents] = student;
						numOfStudents++;
					}
					else {
						Student student = new Student();
						students[numOfStudents] = student;
						numOfStudents++;
	                }
				}
				
			}
		} 
		finally {
			if (scnr != null) {
				scnr.close();
			}
		}
	}
}
