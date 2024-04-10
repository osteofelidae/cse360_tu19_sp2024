package cse360_tu19_sp2024;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StaffLoginForm extends Form {

	public StaffLoginForm(String[] fieldnames, String[] fields, String filename) {
		super(fieldnames, fields, filename);
		// TODO Auto-generated constructor stub
	}
	
	public boolean validateUserLogin() {
		//determine if there exists a user associated with the username
		//if so, determine if that user's password matches the one given
		if (this.fields[0].equals("")) {
			System.out.println("Username must be nonempty");
			return false;
		}
		File patientFile = new File("files/" + this.fields[0]);
        if (!patientFile.exists()) {
            System.out.println("Error: Staff information file does not exist for patient with username " + this.fields[0]);
            return false;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("files/" + this.fields[0]))) {
        	String line;
        	while ((line = reader.readLine()) != null) {
        		String[] parts = line.split(":");
        		if (parts.length == 2) {
        			String key = parts[0].trim();
        			String value = parts[1].trim();
        			if (key.equals("password")) {
        				if (value.equals(this.fields[1])) {
        					return true;
        				}
        			}
        	   }
           }
        
        
	   } catch (IOException e) {
		   System.out.println("Failed at IO");
		   e.printStackTrace();
	   }
	
	return false;

}
}
