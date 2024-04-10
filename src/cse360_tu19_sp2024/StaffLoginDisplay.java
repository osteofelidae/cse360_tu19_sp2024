package cse360_tu19_sp2024;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.Pane; 

// Represents the PatientLoginDisplay
public class StaffLoginDisplay extends LoginDisplay {
    TextField userField, passField;
    VBox pane;

    // Starts the PatientLoginDisplay
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Staff Login");
        pane = new VBox(10);
        pane.setPadding(new Insets(20));

        userField = new TextField();
        userField.setPromptText("Enter username...");
        passField = new TextField();
        passField.setPromptText("Enter password...");

        Label title = new Label("Staff Login");
        Label user = new Label("Username");
        Label pass = new Label("Password");
        
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        user.setFont(Font.font("Times New Roman"));
        pass.setFont(Font.font("Times New Roman"));
      
        ComboBox staffSelect = new ComboBox();
        staffSelect.setPromptText("Select staff position");
        staffSelect.getItems().addAll("Nurse", "Doctor");

        Button login = new Button("Login");
        login.setOnAction(e -> {
        	String[] fieldnames = {
        	        "Username",
        	        "Password"
        	    };
        try {
        	String[] fields = parse();

//        	StaffLoginForm form = new StaffLoginForm(fieldnames, fields, user.getText());
//            if (form.validateUserLogin()) {
        		if(staffSelect.getSelectionModel().getSelectedItem().toString().equals("Nurse")) {
        			RetrievePatientDisplay nurse = new RetrievePatientDisplay();
        			System.out.println("Opening Nurse Display!");
        			nurse.start(primaryStage);
        		} else {
	            	DoctorDetailsDisplay doctor = new DoctorDetailsDisplay();
	            	System.out.println("Opening Doctor Display!");
	            	doctor.start(primaryStage);
        		}
            	
//            } else {
//            	//display some sort of error
//            	System.out.println("Invalid username or password.");
//            }
        	
        } catch(Exception exe) {
        	//display some sort of error
        	System.out.println("Error.");
        };
    });

        
        login.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        login.setPrefWidth(90);
        login.setPrefHeight(20);
        
        Label message = new Label("Please contact the system administrator to create an account.");
        message.setFont(Font.font("Times New Roman", 13));
        
        Hyperlink back = new Hyperlink("Back to login selection");
        
        back.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("Opening Login Display!");
                LoginDisplay loginDisplay = new LoginDisplay();
                loginDisplay.start(primaryStage);
            }
        });
        
        HBox inputBoxes = new HBox(10);
        VBox userLabelandInput = new VBox(10, user, userField);
        VBox passLabelandInput = new VBox(10, pass, passField);
        inputBoxes.getChildren().addAll(userLabelandInput, passLabelandInput);

        pane.getChildren().addAll(title, staffSelect, inputBoxes, login, message, back);

        Scene scene = new Scene(pane, 400, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public Pane getPane() {
		return pane;
    }
    
    public String[] parse() {
    	String[] info = {""};
    	return info;
    }
}
