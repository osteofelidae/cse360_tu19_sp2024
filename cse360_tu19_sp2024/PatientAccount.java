package cse360_tu19_sp2024;

import java.util.*;

public class PatientAccount extends Account {
	public PatientAccount(int uI, String uP) {
		super(uI, uP);
		super.setInformation(new HashMap<String, String>());
		super.setAccessLevel(1);
	}
}