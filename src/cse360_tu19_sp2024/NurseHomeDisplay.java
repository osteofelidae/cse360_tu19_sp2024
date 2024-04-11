package cse360_tu19_sp2024;

import java.util.HashMap;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;


public class NurseHomeDisplay extends Application {
	TextField firstNameField, lastNameField;
	boolean found = false;
	String retrievedPatientID = "";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Retrieve a patient");

        // Create a VBox for white background with padding
        VBox whiteBackground = new VBox();
        whiteBackground.setStyle("-fx-background-color: white;");
        whiteBackground.setPadding(new Insets(20));
        whiteBackground.setPrefSize(100, 100);
        
        // Create the light gray box VBox with fixed size and padding
        VBox firstBox = new VBox(10);
        firstBox.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: black; -fx-border-width: 1px;");
        firstBox.setMinSize(100, 100);
        firstBox.setPadding(new Insets(20));
        firstNameField = new TextField();
        lastNameField = new TextField();

        Font labelFont = Font.font("Times New Roman");

        Label title = new Label("Retrieve a patient");
        title.setFont(Font.font("Arial", 24));

        Label firstNameLabel = new Label("First Name");
        firstNameLabel.setFont(labelFont);
        Label lastNameLabel = new Label("Last Name");
        lastNameLabel.setFont(labelFont);

        Label dobLabel = new Label("Date of Birth");
        dobLabel.setFont(labelFont);

        // Create an HBox for date of birth combo boxes
        HBox dobFields = new HBox(10);
        ComboBox<String> monthComboBox = new ComboBox<>();
        monthComboBox.setPromptText("Month");
        monthComboBox.getItems().addAll("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");

        ComboBox<String> dayComboBox = new ComboBox<>();
        dayComboBox.setPromptText("Day");
        for (int i = 1; i <= 31; i++) {
            dayComboBox.getItems().add(String.valueOf(i));
        }

        ComboBox<String> yearComboBox = new ComboBox<>();
        yearComboBox.setPromptText("Year");
        for (int year = 1900; year <= 2024; year++) {
            yearComboBox.getItems().add(String.valueOf(year));
        }

        dobFields.getChildren().addAll(monthComboBox, dayComboBox, yearComboBox);

        Button retrieve = new Button("Retrieve");
        retrieve.setPrefWidth(90);
        retrieve.setPrefHeight(20);

        // Add elements to the first gray box
        firstBox.getChildren().addAll(
                title, 
                createLabeledField(firstNameLabel, firstNameField),
                createLabeledField(lastNameLabel, lastNameField), 
                dobLabel, 
                dobFields,
                retrieve
        );
        
        VBox secondBox = new VBox(10);
        secondBox.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: black; -fx-border-width: 1px;");
        secondBox.setMinSize(100, 100);
        secondBox.setPadding(new Insets(20));
        
        Label actionsTitle = new Label("Actions");
        actionsTitle.setFont(Font.font("Arial", 24));

        Hyperlink goToMessagingLink = new Hyperlink("Go to messaging >");

        Label patientActionsTitle = new Label("Patient Actions");
        patientActionsTitle.setFont(Font.font("Arial", 18));

        Hyperlink enterVisitSummaryLink = new Hyperlink("Enter new visit summary >");

        // Add elements to the first gray box
        secondBox.getChildren().addAll(
        		actionsTitle, 
        		goToMessagingLink, 
        		patientActionsTitle, 
        		enterVisitSummaryLink
        );

        VBox spacer = new VBox(10);
        spacer.setStyle("-fx-background-color: white; -fx-border-color: white; -fx-border-width: 0px;");
        spacer.setMinSize(5, 5);
        spacer.setPadding(new Insets(20));
        
        Button logoutButton = new Button();
        logoutButton.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        logoutButton.setPrefWidth(100);
        logoutButton.setPrefHeight(20);
        logoutButton.setText("Log Out");
        logoutButton.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("Logging out!");
                LoginDisplay back = new LoginDisplay();
                back.start(primaryStage);
            }
        });
        // Add the gray boxes to the white background VBox
        whiteBackground.getChildren().addAll(firstBox, spacer, secondBox, logoutButton);

        whiteBackground.setPadding(new Insets(20, 20, 50, 20));
        
        Scene scene = new Scene(whiteBackground, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        goToMessagingLink.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("Opening Messaging Link!");
                MessagingDisplay mess = new MessagingDisplay("Nurse");
                mess.start(primaryStage);
            }
        });
        
        enterVisitSummaryLink.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	if(found == true) {
	            	VisitSummaryDisplay visit = new VisitSummaryDisplay('n');
	                System.out.println("Opening Visit Summaries!");
	                visit.setUsername(retrievedPatientID);
	                visit.start(primaryStage);
            	}else {
            		System.out.println("No retrieval.");
	                Alert alert = new Alert(AlertType.ERROR);
	            	alert.setHeaderText("No patient retrieved.");
	            	alert.setContentText("Retrieve a patient and try again.");
	              	alert.showAndWait();
            	}
            }
        });
        
        retrieve.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	
            	String fnameInput = firstNameField.getText();
            	String lnameInput = lastNameField.getText();
            	
            	String monthInput = monthComboBox.getValue().toString();
            	String dayInput = dayComboBox.getValue().toString();
            	String yearInput = yearComboBox.getValue().toString();
            	
            	
            	FileHandler fh = new FileHandler();
                
                File dir = new File("files/users/");
                File[] directoryListing = dir.listFiles();
                found = false;
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
                    	  retrievedPatientID = data.get("Username");
        				}
                   }
                  if(!found) {
	                  System.out.println("Not found.");
	                  Alert alert = new Alert(AlertType.ERROR);
	            	  alert.setHeaderText("Patient not found.");
	            	  alert.setContentText("Try again.");
	            	  alert.showAndWait();
                  }
                }
            }
        });
        
    }

    // Helper method to create a labeled field
    private VBox createLabeledField(Label label, TextField textField) {
        VBox fieldBox = new VBox(5);
        fieldBox.getChildren().addAll(label, textField);
        textField.setPrefWidth(200);
        return fieldBox;
    }


    public static void main(String[] args) {
        launch(args);
    }

}
