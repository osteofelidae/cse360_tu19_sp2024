package cse360_tu19_sp2024;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class visitSummariesForm extends Form {

	public visitSummariesForm(String[] fieldnames, String[] fields, String filename) {
		super(fieldnames, fields, filename);
		// TODO Auto-generated constructor stub
	}
	
	public boolean saveInfo() {
		// return true if successful, false if not
		for(int i = 0; i < fields.length; i++) {
			if (this.fields[i].equals(null)) {
				System.out.println("All fields must be completed");
				return false;
			}
		}
		
		submit();
		return true;
	}
	
	public boolean retrieveInfo() {
        retrieve();
        for(int i = 0; i < fields.length; i++) {
			if (this.fields[i].equals(null)) {
				System.out.println("NOTE: Not all fields are complete.");
				return false;
			}
		}
        
        return true;

}
}
