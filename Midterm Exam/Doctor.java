

 public class Doctor implements SeesPatients, Comparable<Doctor>{
	private static int numDoctors = 0;
	private String name;
	private int licenseNumber;
	private Patient patients[];
	private int numberOfPatients;

	public Doctor() {
		name = "";
		licenseNumber = numDoctors;
		numberOfPatients = 0;
		patients = new Patient[100];
		numDoctors++;
	}

	public Doctor (String name) {
		this.name = name;
		this.licenseNumber = numDoctors;
		this.numberOfPatients = 0;
		patients = new Patient[100];
		numDoctors++;
	}

	public static int getNumDoctors() {
		return numDoctors;
	}

	public int getLicenseNumber() {
		return licenseNumber;
	}

	public String getName() {
		return name;
	}

	public int getNumberOfPatients() {
		return numberOfPatients;
	}

	public Patient[] getPatients() {
		return patients;
	}

	public void addPatient(Patient p) throws PatientException {
		if (numberOfPatients < 100) {
			patients[numberOfPatients] = p;
			numberOfPatients++;
		}
		else {
			throw new PatientException("Too many patients");
		}
	}
	
	public String getPatientsAsString() {
		String stringy = "patients= ";
		if (numberOfPatients > 0) {
			stringy = stringy + patients[0].toString();
			for (int i = 1; i < numberOfPatients; i++) {
				stringy = stringy + ", ";
				stringy = stringy + patients[i].toString();
			}
		}
		return stringy;
	}

	public boolean isPatient(Patient pat) {
		for (int i = 0; i < numberOfPatients; i++) {
			if (patients[i].equals(pat)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Doctor: name= %20s | license number= %06d | %s", name, licenseNumber, getPatientsAsString());
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Doctor) {
			Doctor doc1 = (Doctor)object;
			if (this.name == doc1.name && this.numberOfPatients == doc1.numberOfPatients) {
				return true;
			}
		}
		return false;
	}

	public int compareTo(Doctor doctor) {
		if (doctor.numberOfPatients > this.numberOfPatients) {
			return -1;
		}
		else if (doctor.numberOfPatients < this.numberOfPatients) {
			return 1;
		}
		return 0;
	}

}


