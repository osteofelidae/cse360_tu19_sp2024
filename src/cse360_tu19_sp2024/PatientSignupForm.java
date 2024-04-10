package cse360_tu19_sp2024;

import java.util.Random;
import java.io.*;

public class PatientSignupForm extends Form {
	
	String userIDcandidate;

	public PatientSignupForm(String[] fieldnames, String[] fields, String filename) {
		super(fieldnames, fields, filename);
		// TODO Auto-generated constructor stub
		userIDcandidate = "";
	}
	
	public boolean validateUserSignup() {
		for (int i = 0; i < 5; i++) {
			Random r = new Random();
			char c = (char)(r.nextInt(26) + 'a');
			int k = (int) c;
			userIDcandidate += k;
		}
		File newfile = new File("files/" + userIDcandidate);
		if (newfile.exists()) {
			System.out.println("sorry, that username is already taken. please try again");
			return false;
		} else {
			//succes
			//create new patient account
			//PatientAccount newpatient = new PatientAccount(userIDcandidate, )
			System.out.println("success");
			return true;
			//bruh
		}
	}
}
