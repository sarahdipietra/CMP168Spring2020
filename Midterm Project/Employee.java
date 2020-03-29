

public class Employee extends Person{
	private String deptName;
	private static int numEmployees;
	private int employeeID = 0;
	
	public Employee() {
		deptName = "";
		employeeID = numEmployees + 1;
		numEmployees++;
	}
	
	public Employee(String deptName) {
	    this.deptName = deptName;
	    this.numEmployees = 0;
	    this.employeeID++;
	  }

	
	public Employee(String name, int birthYear, String deptName) {
		super(name, birthYear);
		this.deptName = deptName;
		employeeID = numEmployees + 1;
		numEmployees++;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public static int getNumEmployees() {
		return numEmployees;
	}
	
	public int getEmployeeID() {
		return numEmployees + 1;
	}
	
	public void setEmployeeID(int employeeID) {
	    this.employeeID = employeeID;
	  }
	
	@Override
	public int compareTo(Person p) {
		Employee employee = (Employee) p;
		return Integer.compare(this.employeeID, employee.employeeID);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Employee) {
			Employee e1 = (Employee)object;
			if (super.equals(object) == true) {
				if (this.deptName == e1.deptName && this.employeeID == e1.employeeID) {
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
	    return String.format(super.toString() + " Employee: Department: %20s | Employee Number: %3d", deptName, employeeID+1);
	  }
}