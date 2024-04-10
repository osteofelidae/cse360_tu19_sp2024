package cse360_tu19_sp2024;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.Pane; 

// Represents the PatientLoginDisplay
public class PatientLoginDisplay extends LoginDisplay {
    TextField userField, passField;
    VBox pane;

    // Starts the PatientLoginDisplay
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Patient Login");

        pane = new VBox(10);
        pane.setPadding(new Insets(20));

        userField = new TextField();
        userField.setPromptText("Enter username...");
        passField = new TextField();
        passField.setPromptText("Enter password...");

        Label title = new Label("Patient Login");
        Label user = new Label("Username");
        Label pass = new Label("Password");
        
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        user.setFont(Font.font("Times New Roman"));
        pass.setFont(Font.font("Times New Roman"));

        Button login = new Button("Login");
        login.setOnAction(e -> {
        	if(userField.getText().equals("")) {
        		Alert alert = new Alert(AlertType.ERROR);
            	alert.setHeaderText("Invalid input");
            	alert.setContentText("Please enter a username");
            	alert.showAndWait();
        	} else if(passField.getText().equals("")) {
        		Alert alert = new Alert(AlertType.ERROR);
            	alert.setHeaderText("Invalid input");
            	alert.setContentText("Please enter a password");
            	alert.showAndWait();
        	} else if(validateUser(userField.getText(), passField.getText())) {
            	PatientDetailsDisplay patient = new PatientDetailsDisplay();
            	System.out.println("Opening Patient Display!");
            	patient.start(primaryStage);
        	} else {
        		System.out.println("Error exit");
        	}
    });

        
        login.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        login.setPrefWidth(90);
        login.setPrefHeight(20);
        
        Hyperlink newPatient = new Hyperlink("New patient? Take me to sign up >");
        Hyperlink back = new Hyperlink("Back to login selection");
        
        newPatient.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("Opening Patient Signup Display!");
                PatientSignupDisplay patientSignup = new PatientSignupDisplay();
                patientSignup.start(primaryStage);
            }
        });
        
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

        pane.getChildren().addAll(title, inputBoxes, login, newPatient, back);

        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public boolean validateUser(String username, String password) {
    	File dir = new File("files/users/");
    	File[] files = dir.listFiles();
    	if(files==null) {
    		Alert alert = new Alert(AlertType.ERROR);
        	alert.setHeaderText("Incorrect username or password.");
        	alert.setContentText("Please try again");
        	alert.showAndWait();
    		return false;
    	}
    	File newFile = new File("files/users/", username + ".txt");
    	if(!newFile.exists()) {
    		Alert alert = new Alert(AlertType.ERROR);
        	alert.setHeaderText("Incorrect username or password.");
        	alert.setContentText("Please try again");
        	alert.showAndWait();
    		return false;
    	}
    	FileHandler fh = new FileHandler();
    	HashMap<String, String> data = fh.parse("files/users/" + username + ".txt");
    	if(password.equals(data.get("Password"))) {
    		return true;
    	} else {
    		Alert alert = new Alert(AlertType.ERROR);
        	alert.setHeaderText("Incorrect username or password.");
        	alert.setContentText("Please try again");
        	alert.showAndWait();
    		return false;
    	}
    }
    
    public Pane getPane() {
		return pane;
	}
    
    public String[] parse() {
    	String[] info = {"w"};
    	return info;
    }
}
