package cse360_tu19_sp2024;

import java.io.File;
import java.util.HashMap;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DoctorDetailsDisplay extends Application {
	
	// === INSTANCE VARAIBLES =====================================================================
	private String username;  // TODO temp thing for testing
	
	// === MAIN DRIVER ============================================================================
    public static void main(String[] args) {
        launch(args);
    }
    
    // === SET USERNAME ===========================================================================
    // Usage: this must be used directly after the constructor to specify which user will be
    //        displayed.
    public void setUsername(String username) {
    	this.username = username;
    }
    
    // === START MAIN VIEW ========================================================================
    public void start(Stage primaryStage) {
        System.out.println("Doctor Details Display booting up...");
        System.out.println("Ready!");
        primaryStage.setTitle("Doctor Details");
        
        // --- Set up structural elements ---------------------------------------------------------
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        VBox column1 = new VBox(10);
        VBox column2 = new VBox(10);
        VBox column3 = new VBox(10);
        
        /*
		 *	Logout Button
		*/
        Button logout = new Button();
        logout.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        logout.setPrefWidth(100);
        logout.setPrefHeight(20);
        logout.setText("Log Out");
        logout.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("Logged out!");
            }
        });
        
        // --- Retrieve patient -------------------------------------------------------------------
        VBox retrievePatient = new VBox(10);
        retrievePatient.setStyle("-fx-border-color: gray; -fx-border-width: 2px;");
        retrievePatient.setPadding(new Insets(10)); 
        
        Label rpTitle = new Label("Retrieve a patient");
        rpTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        HBox rpHbox1 = new HBox(10);
        
        VBox rpFirstNameVbox = new VBox(10);
        Label rpFirstName = new Label("First name");
        rpFirstName.setFont(Font.font("Arial", 12));
        TextField rpFirstNameField = new TextField();
        rpFirstNameField.setMinWidth(100);
        rpFirstNameField.setPromptText("Enter first name...");
        rpFirstNameVbox.getChildren().addAll(rpFirstName, rpFirstNameField);
        
        VBox rpLastNameVbox = new VBox(10);
        Label rpLastName = new Label("Last name");
        rpLastName.setFont(Font.font("Arial", 12));
        TextField rpLastNameField = new TextField();
        rpLastNameField.setMinWidth(100);
        rpLastNameField.setPromptText("Enter last name...");
        rpLastNameVbox.getChildren().addAll(rpLastName, rpLastNameField);
        
        rpHbox1.getChildren().addAll(rpFirstNameVbox, rpLastNameVbox);
        
        Label rpDateOfBirth = new Label("Date of Birth");
        rpDateOfBirth.setFont(Font.font("Arial", 12));
        
        HBox rpHbox2 = new HBox(10);
        
        ComboBox rpDateOfBirthList = new ComboBox();
        rpDateOfBirthList.setPromptText("Month");
        rpDateOfBirthList.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        
        ComboBox rpDayList = new ComboBox();
        rpDayList.setPromptText("Day");
        rpDayList.getItems().addAll("1", "2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
        
        ComboBox rpYearList = new ComboBox();
        rpYearList.setPromptText("Year");
        for (int i = 1900; i <= 2022; i++) {
        	rpYearList.getItems().add(i);
        }
        
        rpHbox2.getChildren().addAll(rpDateOfBirthList, rpDayList, rpYearList);
        
        Button rpRetrieve = new Button();
        rpRetrieve.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        rpRetrieve.setPrefWidth(100);
        rpRetrieve.setPrefHeight(20);
        rpRetrieve.setText("Retrieve");
        rpRetrieve.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	String fnameInput = "";
            	String lnameInput = "";
            	String monthInput = "";
            	String dayInput = "";
            	String yearInput = "";
            	if(rpFirstNameField.getText().equals("")) {
            		Alert alert = new Alert(AlertType.ERROR);
                	alert.setHeaderText("Invalid input");
                	alert.setContentText("Please enter a first name");
                	alert.showAndWait();
                	return;
            	} else if(rpLastNameField.getText().equals("")) {
            		Alert alert = new Alert(AlertType.ERROR);
                	alert.setHeaderText("Invalid input");
                	alert.setContentText("Please enter a last name");
                	alert.showAndWait();
                	return;
            	} else if(rpDateOfBirthList.getSelectionModel().isEmpty()) {
            		Alert alert = new Alert(AlertType.ERROR);
                	alert.setHeaderText("Invalid input");
                	alert.setContentText("Please enter a month");
                	alert.showAndWait();
                	return;
            	} else if(rpDayList.getSelectionModel().isEmpty()) {
            		Alert alert = new Alert(AlertType.ERROR);
                	alert.setHeaderText("Invalid input");
                	alert.setContentText("Please enter a day");
                	alert.showAndWait();
                	return;
            	} else if(rpYearList.getSelectionModel().isEmpty()) {
            		Alert alert = new Alert(AlertType.ERROR);
                	alert.setHeaderText("Invalid input");
                	alert.setContentText("Please enter a year");
                	alert.showAndWait();
                	return;
            	} else {
            		fnameInput = rpFirstNameField.getText();
	            	lnameInput = rpLastNameField.getText();
	            	monthInput = rpDateOfBirthList.getValue().toString();
	            	dayInput = rpDayList.getValue().toString();
	            	yearInput = rpYearList.getValue().toString();
            	}
            	
            	FileHandler fh = new FileHandler();
                
                File dir = new File("files/users/");
                File[] directoryListing = dir.listFiles();
                boolean found = false;
                if (directoryListing != null) {
                  for (File child : directoryListing) {
                	  HashMap<String, String> data = fh.parse("files/users/"+child.getName());
                      String fname = data.get("First name");
                      String lname = data.get("Last name");
                      String dobMonth = data.get("DOB Month");
                      String dobDay = data.get("DOB Day");
                      String dobYear = data.get("DOB Year");
                      
                      System.out.println(fname + lname +dobMonth +dobDay + dobYear);
                      
                      if(fnameInput.equals(fname) && lnameInput.equals(lname) && monthInput.equals(dobMonth) && dayInput.equals(dobDay) && yearInput.equals(dobYear)){
                    	  System.out.println("Found!");
                    	  Alert alert = new Alert(AlertType.CONFIRMATION);
                    	  alert.setHeaderText("Patient retrieved.");
                    	  alert.setContentText("You can now enter their visit summary.");
                    	  alert.showAndWait();
                    	  found = true;
                    	  setUsername(data.get("Username"));
        				}
                   }
                  if(!found) {
	                  System.out.println("Not found.");
	                  Alert alert = new Alert(AlertType.ERROR);
	            	  alert.setHeaderText("Patient not found.");
	            	  alert.setContentText("Try again.");
	            	  alert.showAndWait();
	            	  return;
                  }
                }
                
                // --- Retrieve patient file --------------------------------------------------------------
                String fileName = "files/users/"+username+".txt";
                HashMap<String, String> data = fh.parse(fileName);  // Retrieve patient data
                String field;  // Temp string to hold current field
                
                // --- Personal details -------------------------------------------------------------------
                VBox personalDetails = new VBox(10);
                personalDetails.setStyle("-fx-border-color: gray; -fx-border-width: 2px;");
                personalDetails.setPadding(new Insets(10)); 
                
                Label pdTitle = new Label("Personal details");
                pdTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                
                HBox pdHbox1 = new HBox(10);
                
                // --- First name -------------------------------------------------------------------------
                VBox pdFirstNameVbox = new VBox(10);
                Label pdFirstName = new Label("First name");
                pdFirstName.setFont(Font.font("Arial", 12));
                TextField pdFirstNameField = new TextField();
                pdFirstNameField.setMinWidth(100);
                pdFirstNameField.setPromptText("Enter first name...");
                pdFirstNameVbox.getChildren().addAll(pdFirstName, pdFirstNameField);
                
                // If existing first name exists, display it
                field = data.get("First name");
                if (field != null) {
                	pdFirstNameField.setText(field);
                }
                
                // --- Last name --------------------------------------------------------------------------
                VBox pdLastNameVbox = new VBox(10);
                Label pdLastName = new Label("Last name");
                pdLastName.setFont(Font.font("Arial", 12));
                TextField pdLastNameField = new TextField();
                pdLastNameField.setMinWidth(100);
                pdLastNameField.setPromptText("Enter last name...");
                pdLastNameVbox.getChildren().addAll(pdLastName, pdLastNameField);
                
                // If existing last name exists, display it
                field = data.get("Last name");
                if (field != null) {
                	pdLastNameField.setText(field);
                }
                
                pdHbox1.getChildren().addAll(pdFirstNameVbox, pdLastNameVbox);
                
                HBox pdHbox2 = new HBox(10);
                
                // --- Middle name ------------------------------------------------------------------------
                VBox pdMiddleNameVbox = new VBox(10);
                Label pdMiddleName = new Label("Middle name(s)");
                pdMiddleName.setFont(Font.font("Arial", 12));
                TextField pdMiddleNameField = new TextField();
                pdMiddleNameField.setMinWidth(100);
                pdMiddleNameField.setPromptText("Enter middle name(s)...");
                
                // If existing middle name exists, display it
                field = data.get("Middle name");
                if (field != null) {
                	pdMiddleNameField.setText(field);
                }
                
                pdMiddleNameVbox.getChildren().addAll(pdMiddleName, pdMiddleNameField);
                
                // --- Sex --------------------------------------------------------------------------------
                VBox pdSexVbox = new VBox(10);
                Label pdSex = new Label("Sex");
                pdSex.setFont(Font.font("Arial", 12));
                ComboBox pdSexList = new ComboBox();
                pdSexList.setPromptText("Select...");
                pdSexList.getItems().addAll("Female", "Male","Other");
                pdSexVbox.getChildren().addAll(pdSex, pdSexList);
                
                // If existing sex exists, display it
                field = data.get("Sex");
                if (field != null) {
                	pdSexList.getSelectionModel().select(field);
                }
                
                pdHbox2.getChildren().addAll(pdMiddleNameVbox, pdSexVbox);
                
                // --- Date of birth ----------------------------------------------------------------------
                Label pdDateOfBirth = new Label("Date of Birth");
                pdDateOfBirth.setFont(Font.font("Arial", 12));
                
                HBox pdHbox3 = new HBox(10);
                
                // --- Month of birth ---------------------------------------------------------------------
                ComboBox pdDateOfBirthList = new ComboBox();
                pdDateOfBirthList.setPromptText("Month");
                pdDateOfBirthList.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
                // If existing month exists, display it
                field = data.get("DOB Month");
                if (field != null) {
                	pdDateOfBirthList.getSelectionModel().select(field);
                }
                
                // --- Day of birth -----------------------------------------------------------------------
                ComboBox pdDayList = new ComboBox();
                pdDayList.setPromptText("Day");
                pdDayList.getItems().addAll("1", "2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                
                // If existing day exists, display it
                field = data.get("DOB Day");
                if (field != null) {
                	pdDayList.getSelectionModel().select(field);
                }
                
                // --- Year of birth ----------------------------------------------------------------------
                ComboBox pdYearList = new ComboBox();
                pdYearList.setPromptText("Year");
                for (int i = 1900; i <= 2022; i++) {
                	pdYearList.getItems().add(i);
                }
                
                // If existing year exists, display it
                field = data.get("DOB Year");
                if (field != null) {
                	pdYearList.getSelectionModel().select(field);
                }
                
                pdHbox3.getChildren().addAll(pdDateOfBirthList, pdDayList, pdYearList);
                
                // --- Address 1 --------------------------------------------------------------------------
                Label pdAddressLine1 = new Label("Address line 1");
                pdAddressLine1.setFont(Font.font("Arial", 12));
                
                TextField pdAddressLine1Field = new TextField();
                pdAddressLine1Field.setMinWidth(300);
                pdAddressLine1Field.setPromptText("Enter address 1...");
                
                // If existing address 1 exists, display it
                field = data.get("Address 1");
                if (field != null) {
                	pdAddressLine1Field.setText(field);
                }
                
                // --- Address 2 --------------------------------------------------------------------------
                Label pdAddressLine2 = new Label("Address line 2");
                pdAddressLine2.setFont(Font.font("Arial", 12));
                
                TextField pdAddressLine2Field = new TextField();
                pdAddressLine2Field.setMinWidth(300);
                pdAddressLine2Field.setPromptText("Enter address 2 (optional)...");
                
                // If existing address 2 exists, display it
                field = data.get("Address 2");
                if (field != null) {
                	pdAddressLine2Field.setText(field);
                }
                
                HBox pdHbox4 = new HBox(10);
                
                // --- State ------------------------------------------------------------------------------
                VBox pdStateVbox = new VBox(10);
                Label pdState = new Label("State");
                pdState.setFont(Font.font("Arial", 12));
                ComboBox pdStateList = new ComboBox();
                pdStateList.setPromptText("Select...");
                pdStateList.getItems().addAll(
                	    "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
                	    "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky",
                	    "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi",
                	    "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
                	    "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
                	    "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
                	    "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
                	);
                pdStateVbox.getChildren().addAll(pdState, pdStateList);
                
                // If existing state exists, display it
                field = data.get("State");
                if (field != null) {
                	pdStateList.getSelectionModel().select(field);
                }
                
                // --- Postal code ------------------------------------------------------------------------
                VBox pdPostalCodeVbox = new VBox(10);
                Label pdPostalCode = new Label("Postal Code");
                pdPostalCode.setFont(Font.font("Arial", 12));
                TextField pdPostalCodeField = new TextField();
                pdPostalCodeField.setMinWidth(100);
                pdPostalCodeField.setPromptText("Enter postal code...");
                pdPostalCodeVbox.getChildren().addAll(pdPostalCode, pdPostalCodeField);
                
                // If existing postal code exists, display it
                field = data.get("Postal code");
                if (field != null) {
                	pdPostalCodeField.setText(field);
                }
                
                pdHbox4.getChildren().addAll(pdStateVbox, pdPostalCodeVbox);
                
                
                // --- Data retain checkbox ---------------------------------------------------------------
                CheckBox pdDataRetain = new CheckBox("I understand that this hospital will retain this data.");
                
                // --- Update button ----------------------------------------------------------------------
                Button pdUpdate = new Button();
                pdUpdate.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                pdUpdate.setPrefWidth(100);
                pdUpdate.setPrefHeight(20);
                pdUpdate.setText("Update");
                pdUpdate.setOnAction(new EventHandler<>() {
                    public void handle(ActionEvent event) {
                    	// HashMaps for data
                    	HashMap<String, String> toUpdate = new HashMap<String, String>();
                    	
                    	// If first name is not set, show an error
                    	if (pdFirstNameField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("First name is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If first name is valid, add to 'toUpdate'
                    	} else {
                    		toUpdate.put("First name", pdFirstNameField.getText());
                    	}
                    	
                    	// If last name is not set, show an error
                    	if (pdLastNameField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Last name is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If last name is valid, add to 'toUpdate'
                    	} else {
                    		toUpdate.put("Last name", pdLastNameField.getText());
                    	}
                    	
                    	// If middle name is not set, remove it
                    	if (pdMiddleNameField.getText().equals("")) {
                    		fh.removeAttr(fileName, "Middle name");
                        
                        // If first name is valid, add to 'toUpdate'
                    	} else {
                    		toUpdate.put("First name", pdFirstNameField.getText());
                    	}
                    	
                    	// If sex is not set, display alert and interrupt function flow
                        if (pdSexList.getSelectionModel().isEmpty()) {
                        	Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Sex is not set");
                        	alert.showAndWait();
                        	return;
                        	
                        // If sex input is valid, add to'data'
                        } else {
                        	toUpdate.put("Sex", pdSexList.getValue().toString());
                        }
                        
                        // If month is not set, display alert and interrupt function flow
                        if (pdDateOfBirthList.getSelectionModel().isEmpty()) {
                        	Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("DOB Month is not set");
                        	alert.showAndWait();
                        	return;
                        	
                        // If month input is valid, add to'data'
                        } else {
                        	toUpdate.put("DOB Month", pdDateOfBirthList.getValue().toString());
                        }
                        
                        // If day is not set, display alert and interrupt function flow
                        if (pdDayList.getSelectionModel().isEmpty()) {
                        	Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("DOB Day is not set");
                        	alert.showAndWait();
                        	return;
                        	
                        // If day input is valid, add to'data'
                        } else {
                        	toUpdate.put("DOB Day", pdDayList.getValue().toString());
                        }
                        
                        // If year is not set, display alert and interrupt function flow
                        if (pdYearList.getSelectionModel().isEmpty()) {
                        	Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("DOB Year is not set");
                        	alert.showAndWait();
                        	return;
                        	
                        // If year input is valid, add to'data'
                        } else {
                        	toUpdate.put("DOB Year", pdYearList.getValue().toString());
                        }
                        
                        // If address line 1 is not set, show an error
                    	if (pdAddressLine1Field.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Address line 1 is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If address line 1 is valid, add to 'toUpdate'
                    	} else {
                    		toUpdate.put("Address 1", pdAddressLine1Field.getText());
                    	}
                    	
                    	// If address line 2 is not set, remove it
                    	if (pdAddressLine2Field.getText().equals("")) {
                    		fh.removeAttr(fileName, "Address 2");
                        
                        // If first name is valid, add to 'toUpdate'
                    	} else {
                    		toUpdate.put("Address 2", pdAddressLine2Field.getText());
                    	}
                    	
                    	// If state is not set, display alert and interrupt function flow
                        if (pdStateList.getSelectionModel().isEmpty()) {
                        	Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("State is not set");
                        	alert.showAndWait();
                        	return;
                        	
                        // If state input is valid, add to'data'
                        } else {
                        	toUpdate.put("State", pdStateList.getValue().toString());
                        }
                        
                        // If postal code is not set, show an error
                    	if (pdPostalCodeField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Postal code is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If address line 1 is valid, add to 'toUpdate'
                    	} else {
                    		toUpdate.put("Postal code", pdPostalCodeField.getText());
                    	}
                    	
                    	fh.updateAttrs(fileName, toUpdate);
                    	
                        System.out.println("Updated!");
                    }
                });
                
                personalDetails.getChildren().addAll(pdTitle, pdHbox1, pdHbox2, pdDateOfBirth, pdHbox3, pdAddressLine1, pdAddressLine1Field, pdAddressLine2, pdAddressLine2Field, pdHbox4, pdDataRetain, pdUpdate);

             // --- Insurance --------------------------------------------------------------------------
                VBox insurance = new VBox(10);
                insurance.setStyle("-fx-border-color: gray; -fx-border-width: 2px;");
                insurance.setPadding(new Insets(10)); 
                
                Label iTitle = new Label("Insurance");
                iTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                
                // --- Insurance provider -----------------------------------------------------------------
                Label iInsuranceProvider = new Label("Insurance provider");
                iInsuranceProvider.setFont(Font.font("Arial", 12));
                
                TextField iInsuranceProviderField = new TextField();
                iInsuranceProviderField.setMinWidth(100);
                iInsuranceProviderField.setPromptText("Enter insurance provider...");
                
                // If existing insurance provider exists, display it
                field = data.get("Insurance provider");
                if (field != null) {
                	iInsuranceProviderField.setText(field);
                }
                
                // --- Policy number ----------------------------------------------------------------------
                Label iPolicyNumber = new Label("Policy number");
                iPolicyNumber.setFont(Font.font("Arial", 12));
                
                TextField iPolicyNumberField = new TextField();
                iPolicyNumberField.setMinWidth(100);
                iPolicyNumberField.setPromptText("Enter policy number...");
                
                // If existing policy number exists, display it
                field = data.get("Policy number");
                if (field != null) {
                	iPolicyNumberField.setText(field);
                }

                // --- Subscriber details -----------------------------------------------------------------
                Label iHeader = new Label("Subscriber details");
                iHeader.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                
                HBox iHbox1 = new HBox(10);
                
                // --- Subscriber first name --------------------------------------------------------------
                VBox iFirstNameVbox = new VBox(10);
                Label iFirstName = new Label("First name");
                iFirstName.setFont(Font.font("Arial", 12));
                TextField iFirstNameField = new TextField();
                iFirstNameField.setMinWidth(100);
                iFirstNameField.setPromptText("Enter first name...");
                iFirstNameVbox.getChildren().addAll(iFirstName, iFirstNameField);
                
                // If existing subscriber first name exists, display it
                field = data.get("Subscriber first name");
                if (field != null) {
                	iFirstNameField.setText(field);
                }
                
                // --- Subscriber last name ---------------------------------------------------------------
                VBox iLastNameVbox = new VBox(10);
                Label iLastName = new Label("Last name");
                iLastName.setFont(Font.font("Arial", 12));
                TextField iLastNameField = new TextField();
                iLastNameField.setMinWidth(100);
                iLastNameField.setPromptText("Enter last name...");
                iLastNameVbox.getChildren().addAll(iLastName, iLastNameField);
                
                // If existing subscriber last name exists, display it
                field = data.get("Subscriber last name");
                if (field != null) {
                	iLastNameField.setText(field);
                }
                
                iHbox1.getChildren().addAll(iFirstNameVbox, iLastNameVbox);
                
                // --- Date of birth ----------------------------------------------------------------------
                Label iDateOfBirth = new Label("Date of Birth");
                iDateOfBirth.setFont(Font.font("Arial", 12));
                
                HBox iHbox2 = new HBox(10);
                
                // --- Insurance DOB month ----------------------------------------------------------------
                ComboBox iDateOfBirthList = new ComboBox();
                iDateOfBirthList.setPromptText("Month");
                iDateOfBirthList.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
                
                // If existing insurance DOB month exists, display it
                field = data.get("Insurance DOB month");
                if (field != null) {
                	iDateOfBirthList.getSelectionModel().select(field);
                }
                
                // --- Insurance DOB day ------------------------------------------------------------------
                ComboBox iDayList = new ComboBox();
                iDayList.setPromptText("Day");
                iDayList.getItems().addAll("1", "2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                
                // If existing insurance DOB day exists, display it
                field = data.get("Insurance DOB day");
                if (field != null) {
                	iDayList.getSelectionModel().select(field);
                }
                
                // --- Insurance DOB year
                ComboBox iYearList = new ComboBox();
                iYearList.setPromptText("Year");
                for (int i = 1900; i <= 2022; i++) {
                	iYearList.getItems().add(i);
                }
                
                // If existing insurance DOB year exists, display it
                field = data.get("Insurance DOB year");
                if (field != null) {
                	iYearList.getSelectionModel().select(field);
                }
                
                iHbox2.getChildren().addAll(iDateOfBirthList, iDayList, iYearList);
                
                // --- Insurance relationship -------------------------------------------------------------
                Label iRelationship = new Label("Relationship to patient");
                iRelationship.setFont(Font.font("Arial", 12));
                
                TextField iRelationshipField = new TextField();
                iRelationshipField.setMinWidth(300);
                iRelationshipField.setPromptText("Enter relationship to parent...");
                
                // If existing insurance relationship exists, display it
                field = data.get("Insurance relationship");
                if (field != null) {
                	iRelationshipField.setText(field);
                }
                
                // --- Update button ----------------------------------------------------------------------
                Button iUpdate = new Button();
                iUpdate.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                iUpdate.setPrefWidth(100);
                iUpdate.setPrefHeight(20);
                iUpdate.setText("Update");
                iUpdate.setOnAction(new EventHandler<>() {
                    public void handle(ActionEvent event) {
                    	
                    	// HashMaps for data
                    	HashMap<String, String> toUpdate = new HashMap<String, String>();
                    	
                    	// If insurance provider is not set, show an error
                    	if (iInsuranceProviderField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Insurance provider is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If insurance provider is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Insurance provider", iInsuranceProviderField.getText());
                    	}
                    	
                    	// If policy number is not set, show an error
                    	if (iPolicyNumberField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Policy number is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If policy number is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Policy number", iPolicyNumberField.getText());
                    	}
                    	
                    	// If subscriber first name is not set, show an error
                    	if (iFirstNameField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("First name is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If subscriber first name is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Subscriber first name", iFirstNameField.getText());
                    	}
                    	
                    	// If subscriber first name is not set, show an error
                    	if (iLastNameField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Last name is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If subscriber first name is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Subscriber last name", iLastNameField.getText());
                    	}
                    	
                    	// If insurance DOB month is not set, display alert and interrupt function flow
                        if (iDateOfBirthList.getSelectionModel().isEmpty()) {
                        	Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Insurance DOB month is not set");
                        	alert.showAndWait();
                        	return;
                        	
                        // If sex input is valid, add to'data'
                        } else {
                        	toUpdate.put("Insurance DOB month", iDateOfBirthList.getValue().toString());
                        }
                        
                        // If insurance DOB day is not set, display alert and interrupt function flow
                        if (iDayList.getSelectionModel().isEmpty()) {
                        	Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Insurance DOB day is not set");
                        	alert.showAndWait();
                        	return;
                        	
                        // If insurance DOB day input is valid, add to'data'
                        } else {
                        	toUpdate.put("Insurance DOB day", iDayList.getValue().toString());
                        }
                        
                        // If insurance DOB year is not set, display alert and interrupt function flow
                        if (iYearList.getSelectionModel().isEmpty()) {
                        	Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Insurance DOB year is not set");
                        	alert.showAndWait();
                        	return;
                        	
                        // If insurance DOB day input is valid, add to'data'
                        } else {
                        	toUpdate.put("Insurance DOB year", iYearList.getValue().toString());
                        }
                        
                        // If subscriber first name is not set, show an error
                    	if (iRelationshipField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Insurance relationship is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If subscriber first name is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Insurance relationship", iRelationshipField.getText());
                    	}
                    	
                    	fh.updateAttrs(fileName, toUpdate);
                        System.out.println("Updated!");
                    }
                });
                insurance.getChildren().addAll(iTitle, iInsuranceProvider, iInsuranceProviderField, iPolicyNumber, iPolicyNumberField, iHeader, iHbox1, iDateOfBirth, iHbox2, iRelationship, iRelationshipField, iUpdate);
                
             // --- Medicare/Medicaid ------------------------------------------------------------------
                VBox medicareMedicaid = new VBox(10);
                medicareMedicaid.setStyle("-fx-border-color: gray; -fx-border-width: 2px;");
                medicareMedicaid.setPadding(new Insets(10));
                
                Label mmTitle = new Label("Medicare/Medicaid");
                mmTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                
                // --- Coverage number --------------------------------------------------------------------
                Label mmNumber = new Label("Medicaid coverage number");
                mmNumber.setFont(Font.font("Arial", 12));
                
                TextField mmNumberField = new TextField();
                mmNumberField.setMinWidth(300);
                mmNumberField.setPromptText("Enter coverage number...");
                
                // If existing coverage number exists, display it
                field = data.get("Coverage number");
                if (field != null) {
                	mmNumberField.setText(field);
                }
                
                // --- Button -----------------------------------------------------------------------------
                Button mmUpdate = new Button();
                mmUpdate.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                mmUpdate.setPrefWidth(100);
                mmUpdate.setPrefHeight(20);
                mmUpdate.setText("Update");
                mmUpdate.setOnAction(new EventHandler<>() {
                    public void handle(ActionEvent event) {
                    	
                    	// HashMaps for data
                    	HashMap<String, String> toUpdate = new HashMap<String, String>();
                    	
                    	// If coverage number is not set, show an error
                    	if (mmNumberField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Coverage number is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If insurance provider is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Coverage number", mmNumberField.getText());
                    	}
                    	
                    	fh.updateAttrs(fileName, toUpdate);
                        System.out.println("Updated!");
                    }
                });
                medicareMedicaid.getChildren().addAll(mmTitle, mmNumber, mmNumberField, mmUpdate);
                
                // --- Actions ----------------------------------------------------------------------------
                VBox actions = new VBox(10);
                actions.setStyle("-fx-border-color: gray; -fx-border-width: 2px;");
                actions.setPadding(new Insets(10));
                
                Label aTitle = new Label("Actions");
                aTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                
                Hyperlink messaging = new Hyperlink("Go to messaging >");
                messaging.setOnAction(new EventHandler<>() {
                    public void handle(ActionEvent event) {
                    	MessagingDisplay messaging = new MessagingDisplay("");
                        System.out.println("Opening Messaging!");
                        messaging.start(primaryStage);
                    }
                });
                
                Label aHeader = new Label("Patient actions");
                aHeader.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                
                Hyperlink visitSummaries = new Hyperlink("Go to visit summaries >");
                visitSummaries.setOnAction(new EventHandler<>() {
                    public void handle(ActionEvent event) {
                    	VisitSummaryDisplay visit = new VisitSummaryDisplay('p');
                        System.out.println("Opening Visit Summaries!");
                        visit.setUsername(username);
                        visit.start(primaryStage);
                    }
                });
                actions.getChildren().addAll(aTitle, messaging, aHeader, visitSummaries);
                
                // --- Emergency contact ------------------------------------------------------------------
                VBox emergencyContact = new VBox(10);
                emergencyContact.setStyle("-fx-border-color: gray; -fx-border-width: 2px;");
                emergencyContact.setPadding(new Insets(10));
                
                Label ecTitle = new Label("Emergency contact");
                ecTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                
                HBox ecHbox1 = new HBox(10);
                
                // --- Emergency first name ---------------------------------------------------------------
                VBox ecFirstNameVbox = new VBox(10);
                Label ecFirstName = new Label("First name");
                ecFirstName.setFont(Font.font("Arial", 12));
                TextField ecFirstNameField = new TextField();
                ecFirstNameField.setMinWidth(100);
                ecFirstNameField.setPromptText("Enter first name...");
                ecFirstNameVbox.getChildren().addAll(ecFirstName, ecFirstNameField);
                
                // If existing coverage number exists, display it
                field = data.get("Emergency first name");
                if (field != null) {
                	ecFirstNameField.setText(field);
                }
                
                // --- Emergency last name ----------------------------------------------------------------
                VBox ecLastNameVbox = new VBox(10);
                Label ecLastName = new Label("Last name");
                ecLastName.setFont(Font.font("Arial", 12));
                TextField ecLastNameField = new TextField();
                ecLastNameField.setMinWidth(100);
                ecLastNameField.setPromptText("Enter last name...");
                ecLastNameVbox.getChildren().addAll(ecLastName, ecLastNameField);
                
                // If existing coverage number exists, display it
                field = data.get("Emergency last name");
                if (field != null) {
                	ecLastNameField.setText(field);
                }
                
                ecHbox1.getChildren().addAll(ecFirstNameVbox, ecLastNameVbox);
                
                // --- Emergency email --------------------------------------------------------------------
                Label ecEmail = new Label("Email");
                ecEmail.setFont(Font.font("Arial", 12));
                
                TextField ecEmailField = new TextField();
                ecEmailField.setMinWidth(300);
                ecEmailField.setPromptText("Enter email...");
                
                // If existing emergency email exists, display it
                field = data.get("Emergency email");
                if (field != null) {
                	ecEmailField.setText(field);
                }
                
                // --- Emergency phone number -------------------------------------------------------------
                Label ecPhone = new Label("Phone number");
                ecPhone.setFont(Font.font("Arial", 12));
                
                TextField ecPhoneField = new TextField();
                ecPhoneField.setMinWidth(300);
                ecPhoneField.setPromptText("Enter phone number...");
                
                // If existing emergency email exists, display it
                field = data.get("Emergency phone number");
                if (field != null) {
                	ecPhoneField.setText(field);
                }
                
                // --- Submit button ----------------------------------------------------------------------
                Button ecUpdate = new Button();
                ecUpdate.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                ecUpdate.setPrefWidth(100);
                ecUpdate.setPrefHeight(20);
                ecUpdate.setText("Update");
                ecUpdate.setOnAction(new EventHandler<>() {
                    public void handle(ActionEvent event) {
                    	
                    	// HashMaps for data
                    	HashMap<String, String> toUpdate = new HashMap<String, String>();
                    	
                    	// If first name is not set, show an error
                    	if (ecFirstNameField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("First name is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If first name is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Emergency first name", ecFirstNameField.getText());
                    	}
                    	
                    	// If last name is not set, show an error
                    	if (ecLastNameField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Last name is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If last name is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Emergency last name", ecLastNameField.getText());
                    	}
                    	
                    	// If email is not set, show an error
                    	if (ecEmailField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Email is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If email is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Emergency email", ecEmailField.getText());
                    	}
                    	
                    	// If phone number is not set, show an error
                    	if (ecPhoneField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Phone number is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If phone number is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Emergency phone number", ecPhoneField.getText());
                    	}
                    	
                    	fh.updateAttrs(fileName, toUpdate);
                    	
                        System.out.println("Updated!");
                    }
                });
                emergencyContact.getChildren().addAll(ecTitle, ecHbox1, ecEmail, ecEmailField, ecPhone, ecPhoneField, ecUpdate);
                
                
                
                // --- Pharmacy ---------------------------------------------------------------------------
                VBox pharmacy = new VBox(10);
                pharmacy.setStyle("-fx-border-color: gray; -fx-border-width: 2px;");
                pharmacy.setPadding(new Insets(10)); 
                
                Label pTitle = new Label("Pharmacy");
                pTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                
                // --- Pharmacy name ----------------------------------------------------------------------
                Label pName = new Label("Pharmacy Name");
                pName.setFont(Font.font("Arial", 12));
                
                TextField pNameField = new TextField();
                pNameField.setMinWidth(300);
                pNameField.setPromptText("Enter pharmacy name...");
                
                // If existing pharmacy name exists, display it
                field = data.get("Pharmacy name");
                if (field != null) {
                	pNameField.setText(field);
                }
                
                // --- Pharmacy address 1 -----------------------------------------------------------------
                Label pAddressLine1 = new Label("Address line 1");
                pAddressLine1.setFont(Font.font("Arial", 12));
                
                TextField pAddressLine1Field = new TextField();
                pAddressLine1Field.setMinWidth(300);
                pAddressLine1Field.setPromptText("Enter address 1...");
                
                // If existing pharmacy address 1 exists, display it
                field = data.get("Pharmacy address 1");
                if (field != null) {
                	pAddressLine1Field.setText(field);
                }
                
                // --- Pharmacy address 2 -----------------------------------------------------------------
                Label pAddressLine2 = new Label("Address line 2");
                pAddressLine2.setFont(Font.font("Arial", 12));
                
                // If existing pharmacy address 1 exists, display it
                field = data.get("Pharmacy address 1");
                if (field != null) {
                	pAddressLine1Field.setText(field);
                }
                
                TextField pAddressLine2Field = new TextField();
                pAddressLine2Field.setMinWidth(300);
                pAddressLine2Field.setPromptText("Enter address 2 (optional)...");
                
                // If existing pharmacy address 2 exists, display it
                field = data.get("Pharmacy address 2");
                if (field != null) {
                	pAddressLine2Field.setText(field);
                }
                
                HBox pHbox1 = new HBox(10);
                
                // --- Pharmacy state  --------------------------------------------------------------------
                VBox pStateVbox = new VBox(10);
                Label pState = new Label("State");
                pState.setFont(Font.font("Arial", 12));
                ComboBox pStateList = new ComboBox();
                pStateList.setPromptText("Select...");
                pStateList.getItems().addAll(
                	    "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
                	    "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky",
                	    "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi",
                	    "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
                	    "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
                	    "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
                	    "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
                	);
                pStateVbox.getChildren().addAll(pState, pStateList);
                
                // If existing state exists, display it
                field = data.get("Pharmacy state");
                if (field != null) {
                	pStateList.getSelectionModel().select(field);
                }
                
                // --- Pharmacy postal code ---------------------------------------------------------------
                VBox pPostalCodeVbox = new VBox(10);
                Label pPostalCode = new Label("Postal Code");
                pPostalCode.setFont(Font.font("Arial", 12));
                TextField pPostalCodeField = new TextField();
                pPostalCodeField.setMinWidth(100);
                pPostalCodeField.setPromptText("Enter postal code...");
                pPostalCodeVbox.getChildren().addAll(pPostalCode, pPostalCodeField);
                
                // If existing pharmacy address 2 exists, display it
                field = data.get("Pharmacy postal code");
                if (field != null) {
                	pPostalCodeField.setText(field);
                }
                
                pHbox1.getChildren().addAll(pStateVbox, pPostalCodeVbox);
                
                // --- Update button ----------------------------------------------------------------------
                Button pUpdate = new Button();
                pUpdate.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                pUpdate.setPrefWidth(100);
                pUpdate.setPrefHeight(20);
                pUpdate.setText("Update");
                pUpdate.setOnAction(new EventHandler<>() {
                    public void handle(ActionEvent event) {
                    	
                    	// HashMaps for data
                    	HashMap<String, String> toUpdate = new HashMap<String, String>();
                    	
                    	// If coverage number is not set, show an error
                    	if (pNameField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Pharmacy name is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If insurance provider is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Pharmacy name", pNameField.getText());
                    	}
                    	
                    	// If pharmacy address 1 is not set, show an error
                    	if (pAddressLine1Field.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Pharmacy address 1 is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If insurance provider is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Pharmacy address 1", pAddressLine1Field.getText());
                    	}
                    	
                    	// If pharmacy address 2 is not set, delete it
                    	if (pAddressLine2Field.getText().equals("")) {
                    		fh.removeAttr(fileName, "Pharmacy address 2");
                        
                        // If insurance provider is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Pharmacy address 2", pAddressLine2Field.getText());
                    	}
                    	
                    	// If state is not set, display alert and interrupt function flow
                        if (pStateList.getSelectionModel().isEmpty()) {
                        	Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("State is not set");
                        	alert.showAndWait();
                        	return;
                        	
                        // If state input is valid, add to'data'
                        } else {
                        	toUpdate.put("Pharmacy state", pStateList.getValue().toString());
                        }
                        
                        // If postal code is not set, alert
                    	if (pPostalCodeField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Postal code is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If postal code is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Pharmacy postal code", pPostalCodeField.getText());
                    	}
                    	
                    	fh.updateAttrs(fileName, toUpdate);
                    	
                        System.out.println("Updated!");
                    }
                });
                pharmacy.getChildren().addAll(pTitle, pName, pNameField, pAddressLine1, pAddressLine1Field, pAddressLine2, pAddressLine2Field, pHbox1, pUpdate);
                
                
                
                /*
        		 *	Pharmacy
        		*/
                VBox prescribeMedication = new VBox(10);
                prescribeMedication.setStyle("-fx-border-color: gray; -fx-border-width: 2px;");
                prescribeMedication.setPadding(new Insets(10)); 
                
                Label pmTitle = new Label("Prescribe Medication");
                pmTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                
                Label pmName = new Label("Medication name");
                pmName.setFont(Font.font("Arial", 12));
                
                TextField pmNameField = new TextField();
                pmNameField.setMinWidth(300);
                pmNameField.setPromptText("Enter medication name...");
                
                Button pmSave = new Button();
                pmSave.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                pmSave.setPrefWidth(100);
                pmSave.setPrefHeight(20);
                pmSave.setText("Save");
                pmSave.setOnAction(new EventHandler<>() {
                    public void handle(ActionEvent event) {
                    	HashMap<String, String> toUpdate = new HashMap<String, String>();
                    	
                    	// If pharmacy address 1 is not set, show an error
                    	if (pmNameField.getText().equals("")) {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setHeaderText("Invalid input");
                        	alert.setContentText("Pharmacy address 1 is not set");
                        	alert.showAndWait();
                        	return;
                        
                        // If insurance provider is valid, add to 'toUpdate'
                    	} else {
                    		
                    		toUpdate.put("Medication", pmNameField.getText());
                    	}
                    	
                    	fh.updateAttrs(fileName, toUpdate);
                    	
                        System.out.println("Updated!");
                    }
                });
                prescribeMedication.getChildren().addAll(pmTitle, pmName, pmNameField, pmSave);
                
                // ADD STUFF TO COLUMNS
                column1.getChildren().addAll(retrievePatient, personalDetails);
                column2.getChildren().addAll(insurance, medicareMedicaid, actions);
                column3.getChildren().addAll(emergencyContact, pharmacy, prescribeMedication, logout);
                grid.add(column1, 0, 0);
                grid.add(column2, 1, 0);
                grid.add(column3, 2, 0);
            }
        });
        retrievePatient.getChildren().addAll(rpTitle, rpHbox1, rpDateOfBirth, rpHbox2, rpRetrieve);
        
        
        grid.add(retrievePatient, 0, 0);
        grid.add(logout, 1, 0);
        Scene scene = new Scene(grid, 1100, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }  
}
