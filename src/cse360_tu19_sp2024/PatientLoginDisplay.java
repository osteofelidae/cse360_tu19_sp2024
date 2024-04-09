package asuHelloWorldJavaFX;

import javafx.scene.Scene;

import javafx.scene.control.Button;
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

// Represents the PatientLoginDisplay
public class PatientLoginDisplay extends LoginDisplay {
    TextField userField, passField;

    // Starts the PatientLoginDisplay
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Patient Login");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        userField = new TextField("Enter username...");
        passField = new TextField("Enter password...");

        Label title = new Label("Patient Login");
        Label user = new Label("Username");
        Label pass = new Label("Password");
        
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        user.setFont(Font.font("Times New Roman"));
        pass.setFont(Font.font("Times New Roman"));

        Button login = new Button("Login");
        //login.setOnAction(e -> viewScanReport());

        
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

        root.getChildren().addAll(title, inputBoxes, login, newPatient, back);

        Scene scene = new Scene(root, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
