package cse360_tu19_sp2024;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class NurseHomeDisplay extends Application {

    TextField emailField, passField, repPassField, firstNameField, lastNameField, middleNameField;

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

        emailField = new TextField();
        passField = new TextField();
        repPassField = new TextField();
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
        
        // Add the gray boxes to the white background VBox
        whiteBackground.getChildren().addAll(firstBox, spacer, secondBox);

        whiteBackground.setPadding(new Insets(20, 20, 50, 20));
        
        Scene scene = new Scene(whiteBackground, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        goToMessagingLink.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("Opening Messaging Link!");
                MessagingDisplay mess = new MessagingDisplay();
                mess.start(primaryStage);
            }
        });
        
        enterVisitSummaryLink.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                // TBD
            }
        });
        
        retrieve.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                // TBD
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
