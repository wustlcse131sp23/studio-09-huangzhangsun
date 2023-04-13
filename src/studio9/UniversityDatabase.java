package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import assignment7.Student;

public class UniversityDatabase {
	private final Map<String, Student>  myMap;
	
	public UniversityDatabase() {
		myMap = new HashMap<>();
	}

	public void addStudent(String accountName, Student student) {
		// TODO
		myMap.put(accountName, student);
	}

	public int getStudentCount() {
		return myMap.size();
	}

	public String lookupFullName(String accountName) {
		// TODO: Complete according to studio instructions
		if (myMap.get(accountName) == null) {
			return null;
		}
		Student student = myMap.get(accountName);
		return student.getFullName();
		
	}

	public double getTotalBearBucks() {
		double total = 0;
		for(String account : myMap.keySet()) {
			total = total + myMap.get(account).getBearBucksBalance();
		}
		return total;
	}
}
