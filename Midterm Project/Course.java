

public class Course {
	private boolean isGraduateCourse;
	private int courseNum;
	private String courseDept;
	private int numCredits;
	
	public Course() {
	    isGraduateCourse = false;
	    courseNum = 0;
	    courseDept = "";
	    numCredits = 0;
	  }
	
	public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits) {
		this.isGraduateCourse = isGraduateCourse;
		this.courseNum = courseNum;
		this.courseDept = courseDept;
		this.numCredits = numCredits;
	}
	
	public boolean isGraduateCourse() {
		return this.isGraduateCourse;
	}
	
	public void setCourseNum(int courseNum) {
	    this.courseNum = courseNum;
	  }
	
	public int getCourseNum() {
		return courseNum;
	}
	
	public void setCourseDept(String courseDept) {
	    this.courseDept = courseDept;
	  }
	
	public String getCourseDept() {
		return courseDept;
	}
	
	public void setNumCredits(int numCredits) {
	    this.numCredits = numCredits;
	  }
	
	public int getNumCredits() {
		return numCredits;
	}
	
	public String getCourseName() {
		if (isGraduateCourse) {
			return "G" + courseDept + courseNum;
		}
		else {
			return "U" + courseDept + courseNum;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Course) {
			Course c1 = (Course)obj;
			if (this.isGraduateCourse == c1.isGraduateCourse && this.courseNum == c1.courseNum && this.courseDept == c1.courseDept && this.numCredits == c1.numCredits) {
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
	
	@Override
	public String toString() {
		if (isGraduateCourse) {
			return String.format("Course: %3s-%3d | Number of Credits: %02d | Graduate", courseDept, courseNum, numCredits);
		}
		else {
			String string = String.format("Course: %3s-%3d | Number of Credits: %02d | Undergraduate", courseDept, courseNum, numCredits);
			return string;
		}
	}
	
	
	public int compareTo(Course course) {
		if (this.courseNum > course.courseNum) {
			return 1;
		}
		else if (this.courseNum == course.courseNum) {
			return 0;
		}
		else {
			return -1;
		}
	}

}
