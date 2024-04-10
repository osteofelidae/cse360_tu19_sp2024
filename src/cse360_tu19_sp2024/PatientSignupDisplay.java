package cse360_tu19_sp2024;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane; 

// Represents the Receptionist View
public class PatientSignupDisplay extends LoginDisplay {
	VBox pane;
    TextField email, pass, passRepeat, firstName, lastName, 
    	middleName, address1, 
    	address2, postalCode;
    
    ComboBox sexList, state, dobDay, dobMonth, dobYear;

    // Starts the PatientSignupDisplay View
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Patient Signup");
        
        pane = new VBox(10);
        pane.setPadding(new Insets(20));
        
        Label title = new Label("Signup");
        Label emailLabel = new Label("Email");
        Label passLabel = new Label("Password");
        Label repeatPassLabel = new Label("Repeat Password");
        Label detailsSectionLabel = new Label("Personal Details");
        Label fnameLabel = new Label("First name");
        Label lnameLabel = new Label("Last name");
        Label mnameLabel = new Label("Middle name(s)");
        Label sexLabel = new Label("Sex");
        Label dobLabel = new Label("Date of Birth");
        Label address1Label = new Label("Address line 1");
        Label address2Label = new Label("Address line 2");
        Label stateLabel = new Label("State");
        Label postalCodeLabel = new Label("Postal Code");
        
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        emailLabel.setFont(Font.font("Times New Roman"));
        passLabel.setFont(Font.font("Times New Roman"));
        repeatPassLabel.setFont(Font.font("Times New Roman"));
        detailsSectionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        fnameLabel.setFont(Font.font("Times New Roman"));
        lnameLabel.setFont(Font.font("Times New Roman"));
        mnameLabel.setFont(Font.font("Times New Roman"));
        sexLabel.setFont(Font.font("Times New Roman"));
        dobLabel.setFont(Font.font("Times New Roman"));
        address1Label.setFont(Font.font("Times New Roman"));
        address2Label.setFont(Font.font("Times New Roman"));
        stateLabel.setFont(Font.font("Times New Roman"));
        postalCodeLabel.setFont(Font.font("Times New Roman"));
        
        email = new TextField("Enter email...");
        pass = new TextField("Enter password...");
        passRepeat = new TextField("Repeat password...");
        firstName = new TextField("Enter first name...");
        lastName = new TextField("Enter last name...");
        middleName = new TextField("Enter middle name(s)");
        address1 = new TextField("Enter address 1...");
        address2 = new TextField("Enter address 2 (optional)...");
        postalCode = new TextField("Enter postal code...");
        
        sexList = new ComboBox();
        sexList.getItems().addAll("Female", "Male","Other");
        dobMonth = new ComboBox();
        dobMonth.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        dobDay = new ComboBox();
        for (int i = 1; i <= 31; i++) {
            dobDay.getItems().add(i);
        }
        ComboBox dobYear = new ComboBox();
        for (int i = 1900; i <= 2022; i++) {
            dobYear.getItems().add(i);
        }
        ComboBox state = new ComboBox();
        state.getItems().addAll(
        	    "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
        	    "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky",
        	    "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi",
        	    "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
        	    "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
        	    "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
        	    "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
        	);
        
        sexList.setPromptText("Select...");
        dobMonth.setPromptText("Month");
        dobDay.setPromptText("Day");
        dobYear.setPromptText("Year");
        state.setPromptText("Select...");
        
        CheckBox consent = new CheckBox("I undertand that this hospital will retain this data.");

        Button signUpButton = new Button("Sign Up");
        signUpButton.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        signUpButton.setPrefWidth(100);
        signUpButton.setOnAction(e -> {
        	String[] fieldnames = {
        	        "Email",
        	        "Password",
        	        "Repeat Password",
        	        "First Name",
        	        "Last Name",
        	        "Middle Name",
        	        "Sex",
        	        "Date of Birth",
        	        "Address Line 1",
        	        "Address Line 2",
        	        "State",
        	        "Postal Code"
        	    };
        	String[] fields = parse();
        	PatientSignupForm form = new PatientSignupForm(fieldnames, fields);
            if (form.validateUserSignup()) {
            	//go to patient view
            	PatientDisplay patient = new PatientDisplay();
            	System.out.println("Opening Patient Display!");
            	patient.start(primaryStage);
            	
            } else {
            	//display some sort of error
            	System.out.println("Error.");
            }
        });

        email.setPrefWidth(250);
        pass.setPrefWidth(250);
        passRepeat.setPrefWidth(250);
        firstName.setPrefWidth(250);
        lastName.setPrefWidth(250);
        middleName.setPrefWidth(250);
        address1.setPrefWidth(250);
        address2.setPrefWidth(250);
        postalCode.setPrefWidth(250);
        
        Hyperlink back = new Hyperlink("Take me to login > ");
        
        back.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("Opening Login Display!");
                LoginDisplay loginDisplay = new LoginDisplay();
                loginDisplay.start(primaryStage);
            }
        });
        
        VBox pass1 = new VBox(10);
        pass1.getChildren().addAll(passLabel, pass);
        VBox pass2 = new VBox(10);
        pass2.getChildren().addAll(repeatPassLabel, passRepeat);
        HBox passwordInputs = new HBox(10);
        passwordInputs.getChildren().addAll(pass1, pass2);
        
        VBox fname = new VBox(10);
        fname.getChildren().addAll(fnameLabel, firstName);
        VBox lname = new VBox(10);
        lname.getChildren().addAll(lnameLabel, lastName);
        HBox nameInputs = new HBox(10);
        nameInputs.getChildren().addAll(fname, lname);
        
        HBox dob = new HBox(10);
        dob.getChildren().addAll(dobMonth, dobDay, dobYear);
        
        VBox stateBox = new VBox(10);
        stateBox.getChildren().addAll(stateLabel, state);
        VBox postalBox = new VBox(10);
        postalBox.getChildren().addAll(postalCodeLabel, postalCode);
        HBox statePostalInputs = new HBox(10);
        statePostalInputs.getChildren().addAll(stateBox, postalBox);
        
        pane.getChildren().addAll(title, emailLabel, email, passwordInputs,
        		detailsSectionLabel, nameInputs, dobLabel, dob, 
        		address1Label, address1, address2Label, address2,
        		statePostalInputs, consent, signUpButton, back);
       
        Scene scene = new Scene(this.getPane(), 500, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public Pane getPane() {
		return pane;
	}
    
    public String[] parse() {
    	String[] info = {
    	        email.getText(),
    	        pass.getText(),
    	        passRepeat.getText(),
    	        firstName.getText(),
    	        lastName.getText(),
    	        middleName.getText(),
    	        sexList.getSelectionModel().getSelectedItem().toString(),
    	        dobMonth.getValue() + " " + dobDay.getValue() + ", " + dobYear.getValue(),
    	        address1.getText(),
    	        address2.getText(),
    	        state.getSelectionModel().getSelectedItem().toString(),
    	        postalCode.getText()
    	    };
    	return info;
    }

}
