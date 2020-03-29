

public class GeneralStaff extends Employee{
	private String duty;
	
	public GeneralStaff() {
		duty = "";
	}
	
	public GeneralStaff(String duty) {
		this.duty = duty;
	}
	
	public GeneralStaff(String deptName, String duty) {
		super(deptName);
		this.duty = duty;
	}
	
	public GeneralStaff(String name, int birthYear, String deptName, String duty) {
		super(name, birthYear, deptName);
		this.duty = duty;
	}
	
	public String getDuty() {
		return duty;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof GeneralStaff) {
			GeneralStaff a = (GeneralStaff)object;
			if (super.equals(object) == true) {
				if (this.duty == a.duty){
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
	    return String.format(super.toString() + " GeneralStaff: Duty: %10s", duty);
	  }
}