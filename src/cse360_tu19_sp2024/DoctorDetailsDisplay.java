package cse360_tu19_sp2024;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DoctorDetailsDisplay extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    // Starts the main view
    public void start(Stage primaryStage) {
        System.out.println("Doctor Details Display booting up...");
        System.out.println("Ready!");
        primaryStage.setTitle("Doctor Details");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        VBox column1 = new VBox(10);
        VBox column2 = new VBox(10);
        VBox column3 = new VBox(10);
        
        
        
		/*
		 *	Retrieve Patient
		*/
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
            	System.out.println("RETRIEVE PATIENT");
            }
        });
        retrievePatient.getChildren().addAll(rpTitle, rpHbox1, rpDateOfBirth, rpHbox2, rpRetrieve);
        
        
        
        /*
		 *	Personal Details
		*/
        VBox personalDetails = new VBox(10);
        personalDetails.setStyle("-fx-border-color: gray; -fx-border-width: 2px;");
        personalDetails.setPadding(new Insets(10)); 
        
        Label pdTitle = new Label("Personal details");
        pdTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        HBox pdHbox1 = new HBox(10);
        
        VBox pdFirstNameVbox = new VBox(10);
        Label pdFirstName = new Label("First name");
        pdFirstName.setFont(Font.font("Arial", 12));
        TextField pdFirstNameField = new TextField();
        pdFirstNameField.setMinWidth(100);
        pdFirstNameField.setPromptText("Enter first name...");
        pdFirstNameVbox.getChildren().addAll(pdFirstName, pdFirstNameField);
        
        VBox pdLastNameVbox = new VBox(10);
        Label pdLastName = new Label("Last name");
        pdLastName.setFont(Font.font("Arial", 12));
        TextField pdLastNameField = new TextField();
        pdLastNameField.setMinWidth(100);
        pdLastNameField.setPromptText("Enter last name...");
        pdLastNameVbox.getChildren().addAll(pdLastName, pdLastNameField);
        
        pdHbox1.getChildren().addAll(pdFirstNameVbox, pdLastNameVbox);
        
        HBox pdHbox2 = new HBox(10);
        
        VBox pdMiddleNameVbox = new VBox(10);
        Label pdMiddleName = new Label("Middle name(s)");
        pdMiddleName.setFont(Font.font("Arial", 12));
        TextField pdMiddleNameField = new TextField();
        pdMiddleNameField.setMinWidth(100);
        pdMiddleNameField.setPromptText("Enter middle name(s)...");
        pdMiddleNameVbox.getChildren().addAll(pdMiddleName, pdMiddleNameField);
        
        VBox pdSexVbox = new VBox(10);
        Label pdSex = new Label("Sex");
        pdSex.setFont(Font.font("Arial", 12));
        ComboBox pdSexList = new ComboBox();
        pdSexList.setPromptText("Select...");
        pdSexList.getItems().addAll("Female", "Male","Other");
        pdSexVbox.getChildren().addAll(pdSex, pdSexList);
        
        pdHbox2.getChildren().addAll(pdMiddleNameVbox, pdSexVbox);
        
        Label pdDateOfBirth = new Label("Date of Birth");
        pdDateOfBirth.setFont(Font.font("Arial", 12));
        
        HBox pdHbox3 = new HBox(10);
        
        ComboBox pdDateOfBirthList = new ComboBox();
        pdDateOfBirthList.setPromptText("Month");
        pdDateOfBirthList.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        
        ComboBox pdDayList = new ComboBox();
        pdDayList.setPromptText("Day");
        pdDayList.getItems().addAll("1", "2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
        
        ComboBox pdYearList = new ComboBox();
        pdYearList.setPromptText("Year");
        for (int i = 1900; i <= 2022; i++) {
        	pdYearList.getItems().add(i);
        }
        
        pdHbox3.getChildren().addAll(pdDateOfBirthList, pdDayList, pdYearList);
        
        Label pdAddressLine1 = new Label("Address line 1");
        pdAddressLine1.setFont(Font.font("Arial", 12));
        
        TextField pdAddressLine1Field = new TextField();
        pdAddressLine1Field.setMinWidth(300);
        pdAddressLine1Field.setPromptText("Enter address 1...");
        
        Label pdAddressLine2 = new Label("Address line 2");
        pdAddressLine2.setFont(Font.font("Arial", 12));
        
        TextField pdAddressLine2Field = new TextField();
        pdAddressLine2Field.setMinWidth(300);
        pdAddressLine2Field.setPromptText("Enter address 2 (optional)...");
        
        HBox pdHbox4 = new HBox(10);
        
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
        
        VBox pdPostalCodeVbox = new VBox(10);
        Label pdPostalCode = new Label("Postal Code");
        pdPostalCode.setFont(Font.font("Arial", 12));
        TextField pdPostalCodeField = new TextField();
        pdPostalCodeField.setMinWidth(100);
        pdPostalCodeField.setPromptText("Enter postal code...");
        pdPostalCodeVbox.getChildren().addAll(pdPostalCode, pdPostalCodeField);
        
        pdHbox4.getChildren().addAll(pdStateVbox, pdPostalCodeVbox);
        
        CheckBox pdDataRetain = new CheckBox("I understand that this hospital will retain this data.");
        
        Button pdUpdate = new Button();
        pdUpdate.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        pdUpdate.setPrefWidth(100);
        pdUpdate.setPrefHeight(20);
        pdUpdate.setText("Update");
        pdUpdate.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("Updated!");
            }
        });
        personalDetails.getChildren().addAll(pdTitle, pdHbox1, pdHbox2, pdDateOfBirth, pdHbox3, pdAddressLine1, pdAddressLine1Field, pdAddressLine2, pdAddressLine2Field, pdHbox4, pdDataRetain, pdUpdate);
        
        
        
        /*
		 *	Insurance
		*/
        VBox insurance = new VBox(10);
        insurance.setStyle("-fx-border-color: gray; -fx-border-width: 2px;");
        insurance.setPadding(new Insets(10)); 
        
        Label iTitle = new Label("Insurance");
        iTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        Label iInsuranceProvider = new Label("Insurance provider");
        iInsuranceProvider.setFont(Font.font("Arial", 12));
        
        TextField iInsuranceProviderField = new TextField();
        iInsuranceProviderField.setMinWidth(100);
        iInsuranceProviderField.setPromptText("Enter insurance provider...");
        
        Label iPolicyNumber = new Label("Policy number");
        iPolicyNumber.setFont(Font.font("Arial", 12));
        
        TextField iPolicyNumberField = new TextField();
        iPolicyNumberField.setMinWidth(100);
        iPolicyNumberField.setPromptText("Enter policy number...");
        
        Label iHeader = new Label("Subscriber details");
        iHeader.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        
        HBox iHbox1 = new HBox(10);
        
        VBox iFirstNameVbox = new VBox(10);
        Label iFirstName = new Label("First name");
        iFirstName.setFont(Font.font("Arial", 12));
        TextField iFirstNameField = new TextField();
        iFirstNameField.setMinWidth(100);
        iFirstNameField.setPromptText("Enter first name...");
        iFirstNameVbox.getChildren().addAll(iFirstName, iFirstNameField);
        
        VBox iLastNameVbox = new VBox(10);
        Label iLastName = new Label("Last name");
        iLastName.setFont(Font.font("Arial", 12));
        TextField iLastNameField = new TextField();
        iLastNameField.setMinWidth(100);
        iLastNameField.setPromptText("Enter last name...");
        iLastNameVbox.getChildren().addAll(iLastName, iLastNameField);
        
        iHbox1.getChildren().addAll(iFirstNameVbox, iLastNameVbox);
        
        Label iDateOfBirth = new Label("Date of Birth");
        iDateOfBirth.setFont(Font.font("Arial", 12));
        
        HBox iHbox2 = new HBox(10);
        
        ComboBox iDateOfBirthList = new ComboBox();
        iDateOfBirthList.setPromptText("Month");
        iDateOfBirthList.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        
        ComboBox iDayList = new ComboBox();
        iDayList.setPromptText("Day");
        iDayList.getItems().addAll("1", "2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
        
        ComboBox iYearList = new ComboBox();
        iYearList.setPromptText("Year");
        for (int i = 1900; i <= 2022; i++) {
        	iYearList.getItems().add(i);
        }
        
        iHbox2.getChildren().addAll(iDateOfBirthList, iDayList, iYearList);
        
        Label iRelationship = new Label("Relationship to patient");
        iRelationship.setFont(Font.font("Arial", 12));
        
        TextField iRelationshipField = new TextField();
        iRelationshipField.setMinWidth(300);
        iRelationshipField.setPromptText("Enter relationship to parent...");
        
        Button iUpdate = new Button();
        iUpdate.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        iUpdate.setPrefWidth(100);
        iUpdate.setPrefHeight(20);
        iUpdate.setText("Update");
        iUpdate.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("Updated!");
            }
        });
        insurance.getChildren().addAll(iTitle, iInsuranceProvider, iInsuranceProviderField, iPolicyNumber, iPolicyNumberField, iHeader, iHbox1, iDateOfBirth, iHbox2, iRelationship, iRelationshipField, iUpdate);
        
        
        
        /*
		 *	Medicare/Medicaid
		*/
        
        VBox medicareMedicaid = new VBox(10);
        medicareMedicaid.setStyle("-fx-border-color: gray; -fx-border-width: 2px;");
        medicareMedicaid.setPadding(new Insets(10));
        
        Label mmTitle = new Label("Medicare/Medicaid");
        mmTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        Label mmNumber = new Label("Medicaid coverage number");
        mmNumber.setFont(Font.font("Arial", 12));
        
        TextField mmNumberField = new TextField();
        mmNumberField.setMinWidth(300);
        mmNumberField.setPromptText("Enter coverage number...");
        
        Button mmUpdate = new Button();
        mmUpdate.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        mmUpdate.setPrefWidth(100);
        mmUpdate.setPrefHeight(20);
        mmUpdate.setText("Update");
        mmUpdate.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("Updated!");
            }
        });
        medicareMedicaid.getChildren().addAll(mmTitle, mmNumber, mmNumberField, mmUpdate);
        
        
        
        /*
		 *	Actions
		*/
        VBox actions = new VBox(10);
        actions.setStyle("-fx-border-color: gray; -fx-border-width: 2px;");
        actions.setPadding(new Insets(10));
        
        Label aTitle = new Label("Actions");
        aTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        Hyperlink messaging = new Hyperlink("Go to messaging >");
        messaging.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	MessagingDisplay messaging = new MessagingDisplay();
                System.out.println("Opening Messaging!");
                messaging.start(primaryStage);
            }
        });
        
        Label aHeader = new Label("Doctor actions");
        aHeader.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        
        Hyperlink visitSummaries = new Hyperlink("Go to visit summaries >");
        visitSummaries.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	VisitSummaryDisplay visit = new VisitSummaryDisplay('n');
                System.out.println("Opening Visit Summaries!");
                visit.setUsername("johndoe");  // TODO temp for testing
                visit.start(primaryStage);
            }
        });
        actions.getChildren().addAll(aTitle, messaging, aHeader, visitSummaries);
        
        
        
        /*
		 *	Emergency Contact
		*/
        VBox emergencyContact = new VBox(10);
        emergencyContact.setStyle("-fx-border-color: gray; -fx-border-width: 2px;");
        emergencyContact.setPadding(new Insets(10));
        
        Label ecTitle = new Label("Emergency contact");
        ecTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        HBox ecHbox1 = new HBox(10);
        
        VBox ecFirstNameVbox = new VBox(10);
        Label ecFirstName = new Label("First name");
        ecFirstName.setFont(Font.font("Arial", 12));
        TextField ecFirstNameField = new TextField();
        ecFirstNameField.setMinWidth(100);
        ecFirstNameField.setPromptText("Enter first name...");
        ecFirstNameVbox.getChildren().addAll(ecFirstName, ecFirstNameField);
        
        VBox ecLastNameVbox = new VBox(10);
        Label ecLastName = new Label("Last name");
        ecLastName.setFont(Font.font("Arial", 12));
        TextField ecLastNameField = new TextField();
        ecLastNameField.setMinWidth(100);
        ecLastNameField.setPromptText("Enter last name...");
        ecLastNameVbox.getChildren().addAll(ecLastName, ecLastNameField);
        
        ecHbox1.getChildren().addAll(ecFirstNameVbox, ecLastNameVbox);
        
        Label ecEmail = new Label("Email");
        ecEmail.setFont(Font.font("Arial", 12));
        
        TextField ecEmailField = new TextField();
        ecEmailField.setMinWidth(300);
        ecEmailField.setPromptText("Enter email...");
        
        Label ecPhone = new Label("Phone number");
        ecPhone.setFont(Font.font("Arial", 12));
        
        TextField ecPhoneField = new TextField();
        ecPhoneField.setMinWidth(300);
        ecPhoneField.setPromptText("Enter phone number...");
        
        Button ecUpdate = new Button();
        ecUpdate.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        ecUpdate.setPrefWidth(100);
        ecUpdate.setPrefHeight(20);
        ecUpdate.setText("Update");
        ecUpdate.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("Updated!");
            }
        });
        emergencyContact.getChildren().addAll(ecTitle, ecHbox1, ecEmail, ecEmailField, ecPhone, ecPhoneField, ecUpdate);
        
        
        
        /*
		 *	Pharmacy
		*/
        VBox pharmacy = new VBox(10);
        pharmacy.setStyle("-fx-border-color: gray; -fx-border-width: 2px;");
        pharmacy.setPadding(new Insets(10)); 
        
        Label pTitle = new Label("Pharmacy");
        pTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        Label pName = new Label("Pharmacy Name");
        pName.setFont(Font.font("Arial", 12));
        
        TextField pNameField = new TextField();
        pNameField.setMinWidth(300);
        pNameField.setPromptText("Enter pharmacy name...");
        
        Label pAddressLine1 = new Label("Address line 1");
        pAddressLine1.setFont(Font.font("Arial", 12));
        
        TextField pAddressLine1Field = new TextField();
        pAddressLine1Field.setMinWidth(300);
        pAddressLine1Field.setPromptText("Enter address 1...");
        
        Label pAddressLine2 = new Label("Address line 2");
        pAddressLine2.setFont(Font.font("Arial", 12));
        
        TextField pAddressLine2Field = new TextField();
        pAddressLine2Field.setMinWidth(300);
        pAddressLine2Field.setPromptText("Enter address 2 (optional)...");
        
        HBox pHbox1 = new HBox(10);
        
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
        
        VBox pPostalCodeVbox = new VBox(10);
        Label pPostalCode = new Label("Postal Code");
        pPostalCode.setFont(Font.font("Arial", 12));
        TextField pPostalCodeField = new TextField();
        pPostalCodeField.setMinWidth(100);
        pPostalCodeField.setPromptText("Enter postal code...");
        pPostalCodeVbox.getChildren().addAll(pPostalCode, pPostalCodeField);
        
        pHbox1.getChildren().addAll(pStateVbox, pPostalCodeVbox);
        
        Button pUpdate = new Button();
        pUpdate.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        pUpdate.setPrefWidth(100);
        pUpdate.setPrefHeight(20);
        pUpdate.setText("Update");
        pUpdate.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
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
            	String[] filenames = {"Username", "Medication"};
            	String[] fields = {"dborgo", pmNameField.getText()};
                MedicationForm mf = new MedicationForm(filenames, fields, "dborgo");
                mf.addMedication();
            }
        });
        prescribeMedication.getChildren().addAll(pmTitle, pmName, pmNameField, pmSave);
        
        
        
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
        
        
        
        column1.getChildren().addAll(retrievePatient, personalDetails);
        column2.getChildren().addAll(insurance, medicareMedicaid, actions);
        column3.getChildren().addAll(emergencyContact, pharmacy, prescribeMedication, logout);
        grid.add(column1, 0, 0);
        grid.add(column2, 1, 0);
        grid.add(column3, 2, 0);
        Scene scene = new Scene(grid, 1100, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }  
}
