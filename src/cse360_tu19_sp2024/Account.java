package cse360_tu19_sp2024;

import java.util.*;

public class Account {
	private int userId;
	private String userPassword;
	private HashMap<String, String> information;
	private int accessLevel;

	public Account(int uI, String uP) {
		userId = uI;
		userPassword = uP;
		information = new HashMap<>();
	}
	
	public void setUserId(int uI) {
		userId = uI;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserPassword(String uP) {
		userPassword = uP;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setInformation(HashMap<String, String> info) {
		information = info;
	}
	
	public HashMap<String, String> getInformation() {
		return information;
	}
	
	public void setAccessLevel(int aL) {
		accessLevel = aL;
	}
	
	public int getAccessLevel() {
		return accessLevel;
	}
	
	public boolean authenticate(int uI, String uP) {
		if(userId == uI && userPassword.equals(uP)) {
			return true;
		}
		return false;
	}
	
	public void setAttr(String key, String value) {
		information.put(key, value);
	}
	
	public String getAttr(String key) {
		return information.get(key);
	}
	
	public String toString() {
		String ret = "Account Info:";
		ret += "\n- User ID: " + this.getUserId();
		ret += "\n- User Password: " + this.getUserPassword();
		ret += "\n- Access Level: " + this.getAccessLevel();
		for(Map.Entry<String, String> e : information.entrySet()) {
			ret += "\n  - " + e.getKey() + ": " + e.getValue();
		}
		ret += "\n";
		return ret;
	}
}