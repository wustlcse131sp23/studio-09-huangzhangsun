package assignment7;

public class Student {
	/**
	 * @param  firstName: the firstName of the student
	 * @param lastName: the lastName of the student
	 * @param ID: the id of the student
	 * @param attemptCredits:the credits the student have attempt
	 * @param passedCredirts: the passed credits of the student
	 * @param totalGradeQualityPoints:  the total points of the student
	 * @param balance: the balance in bear bucks
	 */
	private String firstName;
	private String lastName;
	private int ID;
	private int attemptCredits;
	private int passedCredits;
	private double totalGradeQualityPoints;
	private double balance;
	
	
	/**
	 * constructor
	 * @param firstName: the firstName of the student
	 * @param lastName: the lastName of the student
	 * @param ID: the id of the student
	 */
	public Student(String firstName, String lastName, int ID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ID = ID;
	}

	
	
	/**
	 * 
	 * @return: return the string of students full name
	 */
	public String getFullName() {
		String s = "";
		s = s + firstName + " " + lastName;
		return s;
	}

	
	/**
	 * 
	 * @return: return the ID
	 */
	public int getId() {
		return ID;
	}

	
	
	/**
	 * 
	 * @return: return the attempted credits
	 */
	public int getTotalAttemptedCredits() {
		return attemptCredits;
	}

	/**
	 * 
	 * @return: return the passed credits of the student
	 */
	public int getTotalPassingCredits() {
		return passedCredits;
	}

	
	/**
	 * @return: return GPA of students
	 */
	public double calculateGradePointAverage() {
		return totalGradeQualityPoints / attemptCredits;
	}

	/**
	 * 
	 * @param grade: the grade of the sutdent
	 * @param credits: the credit of the course
	 * submit the grade
	 */
	public void submitGrade(double grade, int credits) {
		attemptCredits = attemptCredits + credits;
		totalGradeQualityPoints = totalGradeQualityPoints + grade * credits;
		if (grade >= 1.7) {
			passedCredits = passedCredits + credits;
		}
		calculateGradePointAverage();

	}

	/**
	 * @return the class standing of the student
	 */
	public String getClassStanding() {
		if (passedCredits < 30) {
			return "First Year";
		} else if (passedCredits < 60) {
			return "Sophomore";
		} else if (passedCredits < 90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}

	
	/**
	 * @return return false or true of whether is eligible for phibetakapp
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (getTotalPassingCredits() >= 98 && calculateGradePointAverage() >= 3.60) {
			return true;
		}
		if (getTotalPassingCredits() >= 75 && calculateGradePointAverage() >= 3.80) {
			return true;
		}
		return false;
	}

	
	/**
	 * 
	 * @param amount
	 */
	public void depositBearBucks(double amount) {
		balance = balance + amount;
	}
	
	/**
	 * 
	 * @param amount of balance
	 */
	public void deductBearBucks(double amount) {
		balance = balance - amount;
	}
	
	/**
	 * 
	 * @return balcne of get bear buck balance
	 */
	public double getBearBucksBalance() {
		return balance;
	}

	/**
	 * 
	 * @return get the amount of cash out
	 */
	public double cashOutBearBucks() {
		double cashOut;
		if (balance > 10.0) {
			cashOut = balance - 10.0;
			balance = 0.0;
			
		} else {
			balance = 0.0;
			cashOut = 0.0;
		}
		return cashOut;
	}
	
	/**
	 * 
	 * @param firstName
	 * @param otherParent
	 * @param isHyphenated
	 * @param id
	 * @return the object of student for createLegacy
	 */
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		Student student = new Student(firstName, this.lastName + "-" + otherParent.lastName, id);
		if(!isHyphenated) {
			student.lastName = this.lastName;
		}
		student.balance = this.cashOutBearBucks() + otherParent.cashOutBearBucks();
		return student;
	}
	
	/**
	 * string to string fucntion
	 */
	public String toString() {
		String s = "";
		s = s + getFullName();
		s = s + getId();
		return s;
		
	}
}
