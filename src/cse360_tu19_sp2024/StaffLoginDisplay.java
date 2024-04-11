package cse360_tu19_sp2024;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
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
        staffSelect.getSelectionModel().selectFirst();

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
        	} else {
        		String accountType = validateUser(userField.getText(), passField.getText());
        		if(!accountType.equals("")) {
	        		if(staffSelect.getSelectionModel().getSelectedItem().toString().equals("Nurse")) {
	        			if(accountType.equals("Nurse")) {
		        			NurseHomeDisplay nurse = new NurseHomeDisplay();
		                	System.out.println("Opening Nurse Display!");
		                	nurse.start(primaryStage);
	        			} else {
	        				Alert alert = new Alert(AlertType.ERROR);
	        	        	alert.setHeaderText("Incorrect account type");
	        	        	alert.setContentText("Please select the correct account type you are logging into. If you are a patient, please return to the main login display and select Returning Patient");
	        	        	alert.showAndWait();
	        			}
	        		} else {
	        			if(accountType.equals("Doctor")) {
		        			DoctorDetailsDisplay doctor = new DoctorDetailsDisplay();
		                	System.out.println("Opening Doctor Display!");
		                	doctor.start(primaryStage);
	        			} else {
	        				Alert alert = new Alert(AlertType.ERROR);
	        	        	alert.setHeaderText("Incorrect account type");
	        	        	alert.setContentText("Please select the correct account type you are logging into. If you are a patient, please return to the main login display and select Returning Patient");
	        	        	alert.showAndWait();
	        			}
	        		}
	        	} else {
	        		System.out.println("Error exit");
	        	}
        	}
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
    
    public String validateUser(String username, String password) {
    	File dir = new File("files/users/");
    	File[] files = dir.listFiles();
    	if(files==null) {
    		Alert alert = new Alert(AlertType.ERROR);
        	alert.setHeaderText("Incorrect username or password.");
        	alert.setContentText("Please try again");
        	alert.showAndWait();
    		return "";
    	}
    	File newFile = new File("files/users/", username + ".txt");
    	if(!newFile.exists()) {
    		Alert alert = new Alert(AlertType.ERROR);
        	alert.setHeaderText("Incorrect username or password.");
        	alert.setContentText("Please try again");
        	alert.showAndWait();
    		return "";
    	}
    	FileHandler fh = new FileHandler();
    	HashMap<String, String> data = fh.parse("files/users/" + username + ".txt");
    	if(password.equals(data.get("Password"))) {
    		return data.get("Account type");
    	} else {
    		Alert alert = new Alert(AlertType.ERROR);
        	alert.setHeaderText("Incorrect username or password.");
        	alert.setContentText("Please try again");
        	alert.showAndWait();
    		return "";
    	}
    }
    
    public Pane getPane() {
		return pane;
    }
    
    public String[] parse() {
    	String[] info = {""};
    	return info;
    }
}
