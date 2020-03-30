
public class Faculty extends Employee{
	private Course[] coursesTaught = new Course[50];
	private int numCoursesTaught;
	private boolean isTenured;
	
	public Faculty() {
		coursesTaught = new Course[50];
		numCoursesTaught = 0;
		isTenured = false;
	}
	
	public Faculty(boolean isTenured) {
		coursesTaught = new Course[50];
		numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	
	public Faculty(String deptName, boolean isTenured) {
		super(deptName);
		coursesTaught = new Course[50];
		numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	
	public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
		super(name, birthYear, deptName);
		coursesTaught = new Course[50];
		numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	
	public boolean isTenured() {
		if (isTenured) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getNumCoursesTaught() {
		return numCoursesTaught;
	}
	
	public void setIsTenured(boolean isTenured) {
		this.isTenured = isTenured;
	}
	
	public void addCourseTaught(Course course) {
		if (numCoursesTaught < coursesTaught.length) {
			coursesTaught[numCoursesTaught] = course;
			numCoursesTaught++;
		}
	}
	
	public void addCoursesTaught(Course[] course) {
		if (numCoursesTaught < coursesTaught.length) {
			if (course.length <= coursesTaught.length - numCoursesTaught) {
				for (Course c1: course) {
					addCourseTaught(c1);
				}
			}
		}
	}
	
	public Course getCourseTaught(int index) {
		if (index>=0 && index<numCoursesTaught) {
			return coursesTaught[index];
		}
		else {
			return null;
		}
	}
	
	public String getCourseTaughtAsString(int index) {
		if (index >= 0 && index < numCoursesTaught) {
			return "courseDept-courseNum";
		}
		else {
			return "";
		}
	}
	
	public String getAllCoursesTaughtAsString() {
		String totalCourses = "";
		if (numCoursesTaught > 0) {
	          for (int i = 0; i < numCoursesTaught; i++) {
	              totalCourses = totalCourses +  coursesTaught[i].toString();
	          }
	      }
	      return totalCourses;
	  }	
	
	@Override
	public int compareTo(Person p1) {
		Faculty f1 = (Faculty) p1;
		return Integer.compare(this.numCoursesTaught, f1.numCoursesTaught);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Faculty) {
			Faculty teacher = (Faculty)object;
			if (super.equals(object) == true) {
				if (this.coursesTaught == teacher.coursesTaught && this.numCoursesTaught == teacher.numCoursesTaught && this.isTenured == teacher.isTenured){
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
	    if (isTenured) {
	      return String.format(super.toString() + " Faculty:  Is Tenured | Number of Courses Taught: %3d | Courses Taught: %s", numCoursesTaught, getAllCoursesTaughtAsString());
	    }
	    else {
	      return String.format(super.toString() + " Faculty: Not Tenured | Number of Courses Taught: %3d | Courses Taught: %s", numCoursesTaught, getAllCoursesTaughtAsString());
	    }
	  }
}
