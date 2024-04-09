package cse360_tu19_sp2024;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.HashMap;

// Represents the PatientLoginDisplay
public class PatientLoginDisplay extends LoginDisplay {
    TextField userField, passField;

    // Starts the PatientLoginDisplay
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Patient Login");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        userField = new TextField();
        passField = new TextField();

        Label title = new Label("Patient Login");
        Label user = new Label("Username");
        Label pass = new Label("Password");
        
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        user.setFont(Font.font("Times New Roman"));
        pass.setFont(Font.font("Times New Roman"));

        Button login = new Button("Login");
        //save.setOnAction(e -> viewScanReport());

        
        login.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        login.setPrefWidth(90);
        login.setPrefHeight(20);
        
        Hyperlink newPatient = new Hyperlink("New patient? Take me to sign up >");
        Hyperlink back = new Hyperlink("Back to login selection");
        
        login.setOnAction(event -> {
            // Open another display
            System.out.println("validating login");
            
            String[] userpass = {"username", "password"};
            String[] immediates = {userField.getText(), passField.getText()};
            
            PatientLoginForm newform = new PatientLoginForm(userField.getText(), userpass, immediates, userField.getText());
            if (newform.validateUserLogin()) {
            	//go to patient view
            	System.out.println("success, now lets go to patient view");
            	
            } else {
            	//display some sort of error
            	System.out.println("Incorrect username or password");
            }
                        
        });
        
        
        
        
        newPatient.setOnAction(event -> {
            // Open another display
            System.out.println("Switching to patient sign up");
            PatientSignupDisplay newsignup = new PatientSignupDisplay();
            newsignup.start(primaryStage);
        });
        
        back.setOnAction(event -> {
            // Open another display
            System.out.println("Back to main select");
            LoginDisplay newmain = new LoginDisplay();
            newmain.start(primaryStage);
        });
        
        HBox inputBoxes = new HBox(10);
        VBox userLabelandInput = new VBox(10, user, userField);
        VBox passLabelandInput = new VBox(10, pass, passField);
        inputBoxes.getChildren().addAll(userLabelandInput, passLabelandInput);

        root.getChildren().addAll(title, inputBoxes, login, newPatient, back);

        Scene scene = new Scene(root, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
