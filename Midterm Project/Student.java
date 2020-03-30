

public class Student extends Person{
	private static int numStudents; 
	private int studentID; 
	private Course[] coursesTaken;
	private int numCoursesTaken;
	private boolean isGraduate; 
	private String major;
	
	public Student() {
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		isGraduate = false;
		studentID = numStudents + 1;
		numStudents++;
		major = "undeclared";
	}
	
	public Student(boolean isGraduate) {
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		studentID = numStudents + 1;
		numStudents++;
		major = "undeclared";
		this.isGraduate = isGraduate;
	}
	
	public Student(String major, boolean isGraduate) {
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		studentID = numStudents + 1;
		numStudents++;
		this.isGraduate = isGraduate;
		this.major = major;
	}
	
	public Student(String name, int birthYear, String major, boolean isGraduate) {
		super(name, birthYear);
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		studentID = numStudents + 1;
		numStudents++;
		this.isGraduate = isGraduate;
		this.major = major;
	}
	
	public boolean isGraduate() {
		return isGraduate;
	}
	
	public int getNumCoursesTaken() {
		return numCoursesTaken;
	}
	
	public static int getNumStudents() {
		return numStudents;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public void setIsGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}

	public void addCourseTaken(Course course) {
	    if (numCoursesTaken >= 0 && numCoursesTaken < coursesTaken.length) {
	      coursesTaken[numCoursesTaken] = course;
	      numCoursesTaken++;
	    }
	  }
	
	public void addCoursesTaken(Course[] course) {
		if (numCoursesTaken < coursesTaken.length) {
			if (course.length <= coursesTaken.length - numCoursesTaken) {
				for (Course c1: course) {
					addCourseTaken(c1);
				}
			}
		}
	}
	
	public Course getCourseTaken(int index) {
		if (index >= 0 && index < numCoursesTaken) {
			return coursesTaken[index];
		}
		else {
			return null;
		}
	}
	
	public String getCourseTakenAsString(int index) {
		if (index >= 0 && index < numCoursesTaken) {
			String courseDept = coursesTaken[index].getCourseDept();
			int courseNumm = coursesTaken[index].getCourseNum();
			String courseNum = Integer.toString(courseNumm);
			return courseDept + "-" + courseNum;
		}
		else {
			return null;
		}
	}
	
	public String getAllCoursesTakenAsString()  {
		String totalCourses = "";
		for (int i = 0; i < numCoursesTaken - 1; i++) {
			String moreCourses = getCourseTakenAsString(i) + ", ";
			totalCourses = totalCourses + moreCourses;
		}
		totalCourses = totalCourses + getCourseTakenAsString(numCoursesTaken-1);
		return totalCourses;
	}
	
	@Override
	public int compareTo(Person person) {
		Student student = (Student) person;
		return Integer.compare(this.studentID, student.studentID);
	}
	
	@Override 
	public boolean equals(Object object) {
		if (object instanceof Student) {
			Student stud1 = (Student)object;
			if (super.equals(object) == true) {
				if (this.studentID == stud1.studentID && this.coursesTaken == stud1.coursesTaken && this.numCoursesTaken == stud1.numCoursesTaken && this.isGraduate == stud1.isGraduate && this.major == stud1.major){
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		if (isGraduate) {
		      return String.format(super.toString() + " Student: studentID: %04d | Major %20s |       Graduate | Number of Courses Taken: %3d | Courses Taken: %s", studentID, major, numCoursesTaken, getAllCoursesTakenAsString());
		    }
		else {
		      return String.format(super.toString() + " Student: studentID: %04d | Major %20s |  Undergraduate | Number of Courses Taken: %3d | Courses Taken: %s", studentID, major, numCoursesTaken, getAllCoursesTakenAsString());
		}
	}
}