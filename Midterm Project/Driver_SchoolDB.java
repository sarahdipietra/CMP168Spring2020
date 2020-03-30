

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import static java.lang.Integer.parseInt;

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
		
			scnr = new Scanner("SchoolDB_Initial.txtf");

	        while (scnr.hasNextLine()) {
	            String personType = scnr.next();
	            if (personType.equals("Course:")) {
	                String[] teacherString = scnr.nextLine().split(",");
	                
	                if (teacherString[0].equals(" true") || teacherString[0].equals(" false")) {
	                    Boolean personIsGraduate = false;
	                    
	                    if (teacherString[0].equals(" true")) {
	                        personIsGraduate = true;
	                    }
	                    else if (teacherString.length > 1) {
	                        int personCourseNum = parseInt(teacherString[1].replace(" ", ""));
	                        String personCourseDept = teacherString[2].replace(" ", "");
	                        int personNumCredits = parseInt(teacherString[3].replace(" ", ""));
	                        Course course = new Course(personIsGraduate, personCourseNum, personCourseDept, personNumCredits);
	                        courses[numOfCourses] = course;
	                        numOfCourses++;
	                    }
	                    else {
	                        Course course = new Course();
	                        courses[numOfCourses] = course;
	                        numOfCourses++;
	                    }
	                }
	            }
	            
	            else if (personType.equals("GeneralStaff:")) {
	                String[] GenStaffString = scnr.nextLine().split(",");
	                if (GenStaffString.length == 0) {
	                    GeneralStaff staffMember1 = new GeneralStaff();
	                    generalStaff[numOfGeneralStaff] = staffMember1;
	                    numOfGeneralStaff++;
	                }
	                else if (GenStaffString.length == 1) {
	                	GenStaffString[0] = GenStaffString[0].trim();
	                    GeneralStaff staffMember1 = new GeneralStaff(GenStaffString[0]);
	                    generalStaff[numOfGeneralStaff] = staffMember1;
	                    numOfGeneralStaff++;
	                }
	                else if (GenStaffString.length == 2) {
	                    GeneralStaff staffMember1 = new GeneralStaff(GenStaffString[0], GenStaffString[1]);
	                    generalStaff[numOfGeneralStaff] = staffMember1;
	                    numOfGeneralStaff++;
	                }
	                else if (GenStaffString.length == 4) {
	                	GeneralStaff staffMember1 = new GeneralStaff(GenStaffString[0], Integer.parseInt(GenStaffString[1].replace(" ", "")), GenStaffString[2], GenStaffString[3]);
	                    generalStaff[numOfGeneralStaff] = staffMember1;
	                    numOfGeneralStaff++;
	                }
	            }

	            
	            else if (personType.equals("Faculty:")) {
	                String[] teacherString = scnr.nextLine().split(",");
	                if (teacherString[0].equals(" true") || teacherString[0].equals(" false")) {
	                	
	                    if (teacherString[0].equals(" true")) {
	                        Faculty teacher = new Faculty(true);
	                        faculty[numOfFaculty] = teacher;
	                        numOfFaculty++;
	                    }
	                }
	              	                
	                else if (teacherString.length > 1) {
	                    if (teacherString[1].replace(" ", "").equals("true") || teacherString[1].replace(" ", "").equals("false")) {
	                        String personDeptName = teacherString[0];
	                        Boolean personIsTenured = false;
	                        if (teacherString[1].equals(" true")) {
	                            personIsTenured = true;
	                        }
	                        
	                        Faculty teacher = new Faculty(personDeptName, personIsTenured);
	                        faculty[numOfFaculty] = teacher;
	                        numOfFaculty++;
	                    }
	                    else {
	                        String personName = teacherString[0] ;
	                        teacherString[1] = teacherString[1].replace(" ", "");
	                        int personBirthYear = Integer.parseInt(teacherString[1]);
	                        String personDeptName = teacherString[2].replace(" ", "");
	                        Boolean personIsTenured = false;
	                        
	                        if (teacherString[3].replace(" ", "").equals("true")) {
	                            personIsTenured = true;
	                        }
	                        
	                        Faculty teacher = new Faculty(personName, personBirthYear, personDeptName, personIsTenured);
	                        faculty[numOfFaculty] = teacher;
	                        numOfFaculty++;
	                    }
	                }
	           
	                else {
	                    Faculty teacher = new Faculty();
	                    faculty[numOfFaculty] = teacher;
	                    numOfFaculty++;
	                }
	            }
	            
	            
	            else if (personType.equals("Student:")) {
	                String[] studentString = scnr.nextLine().split(",");
	                if (studentString[0].equals("true")) {
	                    Student student = new Student(true);
	                    students[numOfStudents] = student;
	                    numOfStudents++;
	                }
	                else if (studentString[0].equals("false")) {
	                    Student student = new Student(false);
	                    students[numOfStudents] = student;
	                    numOfStudents++;
	                }
	                
	                if (studentString.length > 1) {
	                    if (studentString[1].replace(" ", "").equals("true")) {
	                        String personMajor = studentString[0];
	                        Student student = new Student(personMajor, true);
	                        students[numOfStudents] = student;
	                        numOfStudents++;
	                    }
	                    else if (studentString[1].replace(" ", "").equals("false")) {
	                        String personMajor = studentString[0];
	                        Student student = new Student(personMajor, false);
	                        students[numOfStudents] = student;
	                        numOfStudents++;
	                    }
	                    else {
	                        String personName = studentString[0];
	                        int personBirthYear = Integer.parseInt(studentString[1].replace(" ", ""));
	                        String personMajor = studentString[2].replace(" ", "");
	                        Boolean personIsGraduate = false;
	                        
	                        if (studentString[3].replace(" ", "").equals("true")) {
	                            personIsGraduate = true;
	                        }
	                        Student student = new Student(personName, personBirthYear, personMajor, personIsGraduate);
	                        students[numOfStudents] = student;
	                        numOfStudents++;
	                    }
	                }
	                
	                else {
	                    Student student = new Student();
	                    students[numOfStudents] = student;
	                    numOfStudents++;
	                }
	            }
	        }		
	        
	        try (BufferedReader pleaseReadMyCode = new BufferedReader(new FileReader("SchoolDB_Initial.txt"))) {
	            String lineOfMyCode;
	            while ((lineOfMyCode = pleaseReadMyCode.readLine()) != null) {
	                System.out.println(lineOfMyCode);
	            }
	        }
	        
	        System.out.println("\n**************************************************************\nSCHOOL DATABASE INFO:\n\n************************************************\nCOURSES:");

	        if (numOfCourses > 0) {
	            for (int i = 0; i < numOfCourses; i++) {
	                System.out.println(courses[i].toString());
	            }
	            System.out.println("************************************************\n************************************************\nPERSONS:\n************************************************\n************************************************\nEMPLOYEES:\n************************************************\n************************************************\nGENERAL STAFF:");
	        }
	        if (numOfGeneralStaff > 0) {
	            for (int j = 0; j < numOfGeneralStaff; j++) {
	                System.out.println(generalStaff[j].toString());
	            }
	            System.out.println("************************************************\n************************************************\nFACULTY:");
	        }
	        if (numOfFaculty > 0) {
	            for (int w = 0; w < numOfFaculty; w++) {
	                System.out.println(faculty[w].toString());
	            }
	            System.out.println("************************************************\n************************************************\nSTUDENTS:");
	        }
	        if (numOfStudents > 0) {
	            for (int l = 0; l < numOfStudents; l++) {
	                System.out.println(students[l].toString());
	            }
	            System.out.println("************************************************\n**************************************************************\n");
	        }
	        fileByteStream.close();
	    }
	}
