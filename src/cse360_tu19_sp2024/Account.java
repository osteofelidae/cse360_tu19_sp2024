package cse360_tu19_sp2024;

import java.util.*;

public class Account {
	private int userId;
	private String userPasswordHash;
	private HashMap<String, String> information;
//	private int accessLevel;

	public Account(int uId, String uPH) {
		userId = uId;
		userPasswordHash = uPH;
		information = new HashMap<>();
	}
	
	public void setInformation(HashMap<String, String> info) {
		information = info;
	}
	
	public HashMap<String, String> getInformation() {
		return information;
	}
	
	public boolean authenticate(int uId, String uPH) {
		if(userId == uId && userPasswordHash.equals(uPH)) {
			return true;
		}
		return false;
	}
	
	public void parse(String data) {
		// ???
	}
	
/*	public void setAccessLevel(int aL) {
		accessLevel = aL;
	} */
	
/*	public int getAccessLevel() {
		return accessLevel;
	} */
}