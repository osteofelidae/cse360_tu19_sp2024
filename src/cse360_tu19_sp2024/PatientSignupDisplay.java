package cse360_tu19_sp2024;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane; 

// Represents the Receptionist View
public class PatientSignupDisplay extends LoginDisplay {
	VBox pane;
    TextField email, pass, passRepeat, firstName, lastName, 
    	address1, 
    	address2, postalCode;
    
    ComboBox state, dobDay, dobMonth, dobYear;

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
        dobLabel.setFont(Font.font("Times New Roman"));
        address1Label.setFont(Font.font("Times New Roman"));
        address2Label.setFont(Font.font("Times New Roman"));
        stateLabel.setFont(Font.font("Times New Roman"));
        postalCodeLabel.setFont(Font.font("Times New Roman"));
        
        email = new TextField();
        email.setPromptText("Enter email...");
        pass = new TextField();
        pass.setPromptText("Enter password...");
        passRepeat = new TextField();
        passRepeat.setPromptText("Repeat password...");
        firstName = new TextField();
        firstName.setPromptText("Enter first name...");
        lastName = new TextField();
        lastName.setPromptText("Enter last name...");
        address1 = new TextField();
        address1.setPromptText("Enter address 1...");
        address2 = new TextField();
        address2.setPromptText("Enter address 2 (optional)...");
        postalCode = new TextField();
        postalCode.setPromptText("Enter postal code...");
        
        dobMonth = new ComboBox();
        dobMonth.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        dobDay = new ComboBox();
        for (int i = 1; i <= 31; i++) {
            dobDay.getItems().add(i);
        }
        dobYear = new ComboBox();
        for (int i = 1900; i <= 2022; i++) {
            dobYear.getItems().add(i);
        }
        state = new ComboBox();
        state.getItems().addAll(
        	    "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
        	    "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky",
        	    "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi",
        	    "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
        	    "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
        	    "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
        	    "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
        	);
        
        dobMonth.setPromptText("Month");
        dobDay.setPromptText("Day");
        dobYear.setPromptText("Year");
        state.setPromptText("Select...");
        
        CheckBox consent = new CheckBox("I undertand that this hospital will retain this data.");

        Button signUpButton = new Button("Sign Up");
        signUpButton.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        signUpButton.setPrefWidth(100);
        signUpButton.setOnAction(e -> {
        	HashMap<String, String> data = new HashMap<String, String>();
        	
        	// --- Check if email is formatted to be an email -------------------------------------
        	Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
            Matcher matcher = pattern.matcher(email.getText());
            
            // If formatted correctly, add to 'data'
            if (matcher.matches()) {
            	data.put("Email", email.getText());
            	
            	// If not, display alert and interrupt function flow
            } else {
            	Alert alert = new Alert(AlertType.ERROR);
            	alert.setHeaderText("Invalid input");
            	alert.setContentText("Email is wrongly formatted");
            	alert.showAndWait();
            	return;
            }
        	
            // --- Check if password matches ------------------------------------------------------
            // If password is empty or default, display alert and interrupt function flow
            if (pass.getText() == null || pass.getText().equals("Enter password...")) {
	        	Alert alert = new Alert(AlertType.ERROR);
	        	alert.setHeaderText("Invalid input");
	        	alert.setContentText("Please set password");
	        	alert.showAndWait();
	        	return;
            	
            // If passwords do not match, display alert and interrupt function flow
            } else if (!pass.getText().equals(passRepeat.getText())) {
            	Alert alert = new Alert(AlertType.ERROR);
            	alert.setHeaderText("Invalid input");
            	alert.setContentText("Passwords do not match");
            	alert.showAndWait();
            	return;
            	
            // If password input is valid, add to'data'
            } else {
            	data.put("Password", pass.getText());
            }
            
            // --- Check if first name and last name are not empty --------------------------------
            // If first name is empty or not set, display alert and interrupt function flow
            if (firstName.getText() == null || firstName.getText().equals("Enter first name...")) {
            	Alert alert = new Alert(AlertType.ERROR);
            	alert.setHeaderText("Invalid input");
            	alert.setContentText("Please set first name");
            	alert.showAndWait();
            	return;
            
            // If first name input is valid, add to'data'
            } else {
            	data.put("First name", firstName.getText());
            }
            
            // If last name is empty or not set, display alert and interrupt function flow
            if (lastName.getText() == null || lastName.getText().equals("Enter last name...")) {
            	Alert alert = new Alert(AlertType.ERROR);
            	alert.setHeaderText("Invalid input");
            	alert.setContentText("Please set last name");
            	alert.showAndWait();
            	return;
            
            // If last name input is valid, add to'data'
            } else {
            	data.put("Last name", lastName.getText());
            }
        	
            // --- Check if DOB combo boxes are set -----------------------------------------------
            // If DOB month is not set, display alert and interrupt function flow
            if (dobMonth.getSelectionModel().isEmpty()) {
            	Alert alert = new Alert(AlertType.ERROR);
            	alert.setHeaderText("Invalid input");
            	alert.setContentText("DOB Month is not set");
            	alert.showAndWait();
            	return;
            	
            // If DOB month input is valid, add to'data'
            } else {
            	data.put("DOB Month", dobMonth.getValue().toString());
            }
            
            // If DOB day is not set, display alert and interrupt function flow
            if (dobDay.getSelectionModel().isEmpty()) {
            	Alert alert = new Alert(AlertType.ERROR);
            	alert.setHeaderText("Invalid input");
            	alert.setContentText("DOB Day is not set");
            	alert.showAndWait();
            	return;
            	
            // If DOB day input is valid, add to'data'
            } else {
            	data.put("DOB Day", dobDay.getValue().toString());
            }
            
            // If DOB year is not set, display alert and interrupt function flow
            if (dobYear.getSelectionModel().isEmpty()) {
            	Alert alert = new Alert(AlertType.ERROR);
            	alert.setHeaderText("Invalid input");
            	alert.setContentText("DOB Year is not set");
            	alert.showAndWait();
            	return;
            	
            // If DOB year input is valid, add to'data'
            } else {
            	data.put("DOB Year", dobYear.getValue().toString());
            }
        	
            // --- Check if address is set --------------------------------------------------------
            // If address is not set, display alert and interrupt function flow
            if (address1.getText() == null || address1.getText().equals("Enter address 1...")) {
            	Alert alert = new Alert(AlertType.ERROR);
            	alert.setHeaderText("Invalid input");
            	alert.setContentText("Please set Address 1");
            	alert.showAndWait();
            	return;
            	
            // If Address 1 input is valid, add to'data'
            } else {
            	data.put("Address 1", address1.getText());
            }
            
            // If Address 2 is set, add to 'data'
            if (address2.getText() != null && !address2.getText().equals("Enter address 2 (optional)...")) {
            	data.put("Address 2", address2.getText());
            }
        	
        	// --- Check if state is set ----------------------------------------------------------
        	// If state is not set, display alert and interrupt function flow
        	if (state.getSelectionModel().isEmpty()) {
        		Alert alert = new Alert(AlertType.ERROR);
            	alert.setHeaderText("Invalid input");
            	alert.setContentText("State is not set");
            	alert.showAndWait();
            	return;
        		
        	// If state input is valid, add to'data'
            } else {
           		data.put("State", (String) state.getValue());
            }
        	
        	// --- Check if postal code is set ----------------------------------------------------
        	// If postal code is set, add to 'data'
            if (postalCode.getText() != null) {
            	data.put("Postal code", postalCode.getText());
            	
            // If not, display alert and interrupt function flow
            } else {
            	Alert alert = new Alert(AlertType.ERROR);
            	alert.setHeaderText("Invalid input");
            	alert.setContentText("Address 1 cannot be empty");
            	alert.showAndWait();
            	return;
            }
        	
            // Save to file
        	FileHandler fh = new FileHandler();
        	fh.save("patient.txt", data);  // TODO make a unique filename
        });

        email.setPrefWidth(250);
        pass.setPrefWidth(250);
        passRepeat.setPrefWidth(250);
        firstName.setPrefWidth(250);
        lastName.setPrefWidth(250);
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
    
    // NOW DEPRECIATED
    public String[] parse() {
    	String[] info = {
    	        email.getText(),
    	        pass.getText(),
    	        passRepeat.getText(),
    	        firstName.getText(),
    	        lastName.getText(),
    	        dobMonth.getValue() + " " + dobDay.getValue() + ", " + dobYear.getValue(),
    	        address1.getText(),
    	        address2.getText(),
    	        state.getSelectionModel().getSelectedItem().toString(),
    	        postalCode.getText()
    	    };
    	return info;
    }

}
