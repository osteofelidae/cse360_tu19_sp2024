package cse360_tu19_sp2024;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

// Hamada's control panel
public class LoginDisplay extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    // Starts the main view
    public void start(Stage primaryStage) {
        System.out.println("Login Display booting up...");
        System.out.println("Ready!");
        primaryStage.setTitle("Select Login");
        
        Label label = new Label("Welcome!\nLog in as...");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        // Button for patient intake
        Button intake = new Button();
        intake.setText("New Patient");
        intake.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("Opening PatientSignupDisplay");
                PatientSignupDisplay currRecep = new PatientSignupDisplay();
                currRecep.start(primaryStage);
            }
        });
        
        // Button for PatientLoginDisplay
        Button patient = new Button();
        patient.setText("Returning Patient");
        patient.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("Opening PatientLoginDisplay!");
                PatientLoginDisplay currPatient = new PatientLoginDisplay();
                currPatient.start(primaryStage);
            }
        });
        
        // Button for PatientLoginDisplay
        Button staff = new Button();
        staff.setText("Staff");
        staff.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("Opening StaffLoginDisplay!");
                StaffLoginDisplay currStaff = new StaffLoginDisplay();
                currStaff.start(primaryStage);
            }
        });
        
        // Styling for buttons
        intake.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        patient.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        staff.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 2px;");
        
        intake.setPrefWidth(200);
        intake.setPrefHeight(20);
        patient.setPrefWidth(200);
        patient.setPrefHeight(20);
        staff.setPrefWidth(200);
        staff.setPrefHeight(20);
        
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label, intake, patient, staff);
        
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }  
}
