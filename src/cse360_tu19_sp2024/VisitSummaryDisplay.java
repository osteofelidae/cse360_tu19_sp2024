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
import javafx.geometry.Pos;
import javafx.stage.Stage;


public class VisitSummaryDisplay extends LoginDisplay {

    TextField emailField, passField, repPassField, firstNameField, lastNameField, middleNameField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("VisitSummaryDisplay");

        // Create a VBox for white background with padding
        VBox whiteBackground = new VBox();
        whiteBackground.setStyle("-fx-background-color: white;");
        whiteBackground.setPadding(new Insets(20));
        whiteBackground.setPrefSize(100, 100);
        
        // Create the light gray box VBox with fixed size and padding
        VBox firstBox = new VBox(10);
        firstBox.setMinSize(500, 360);
        firstBox.setPadding(new Insets(20));

        emailField = new TextField();
        passField = new TextField();
        repPassField = new TextField();
        firstNameField = new TextField();
        lastNameField = new TextField();

        Font labelFont = Font.font("Times New Roman");

        Label title = new Label("Visit Summaries - [Name]");
        title.setFont(Font.font("Arial", 24));
        
        Label vitals = new Label("Patient Vitals");
        vitals.setFont(Font.font("Arial", 20));

        // Weight Field
        Label weightLabel = new Label("Weight");
        weightLabel.setFont(labelFont);
        Label lbs = new Label("lbs");
        lbs.setFont(Font.font("Arial", 18));
        TextField weightField = new TextField();
        HBox weightFieldwLBS = new HBox(10);       
        weightFieldwLBS.getChildren().addAll(weightField, lbs);
        weightField.setPrefWidth(36);
        weightField.setPrefHeight(16);
        
        // Height Field
        Label heightLabel = new Label("Height");
        heightLabel.setFont(labelFont);
        Label ft = new Label("ft.");
        Label in = new Label("in.");
        ft.setFont(Font.font("Arial", 18));
        in.setFont(Font.font("Arial", 18));
        TextField ftField = new TextField();
        TextField inField = new TextField();
        HBox heightFieldwFTIN = new HBox(10);       
        heightFieldwFTIN.getChildren().addAll(ftField, ft, inField, in);
        ftField.setPrefWidth(36);
        ftField.setPrefHeight(16);
        inField.setPrefWidth(36);
        inField.setPrefHeight(16);
        
        // Temperature Field
        Label tempLabel = new Label("Temperature");
        tempLabel.setFont(labelFont);
        Label degF = new Label("\u00B0F");
        degF.setFont(Font.font("Arial", 18));
        TextField tempField = new TextField();
        HBox tempFieldwDegF = new HBox(10);       
        tempFieldwDegF.getChildren().addAll(tempField, degF);
        tempField.setPrefWidth(36);
        tempField.setPrefHeight(16);
        
        // Blood Pressure Field
        Label bpLabel = new Label("Blood Pressure");
        bpLabel.setFont(labelFont);
        Label firstLabel = new Label("mmHg");
        Label secondLabel = new Label("mmHg");
        firstLabel.setFont(Font.font("Arial", 18));
        secondLabel.setFont(Font.font("Arial", 18));
        TextField firstField = new TextField();
        TextField secondField = new TextField();
        Label overLabel = new Label("over");
        overLabel.setFont(Font.font("Arial", 18));
        HBox bpFieldWithLabels = new HBox(10);
        bpFieldWithLabels.getChildren().addAll(firstField, firstLabel, overLabel, secondField, secondLabel);
        firstField.setPrefWidth(36);
        firstField.setPrefHeight(16);
        secondField.setPrefWidth(36);
        secondField.setPrefHeight(16);

        // Other Notes Field
        Label notesLabel = new Label("Other Notes");
        notesLabel.setFont(Font.font("Arial", 18));
        TextField notesField = new TextField();
        HBox hnotesField = new HBox(10);
        hnotesField.getChildren().addAll(notesField);
        notesField.setPrefWidth(400);
        notesField.setPrefHeight(100);
        
        VBox spacer = new VBox(10);
        spacer.setMinSize(1, 1);
        spacer.setPadding(new Insets(10));

        // Add elements to the first gray box
        firstBox.getChildren().addAll(
                title, 
                createLabeledField(weightLabel, weightFieldwLBS),
                createLabeledField(heightLabel, heightFieldwFTIN),
                createLabeledField(tempLabel, tempFieldwDegF),
                createLabeledField(bpLabel, bpFieldWithLabels),
                spacer,
                createLabeledField(notesLabel, hnotesField)
        );     
        
        VBox secondBox = new VBox(10);
        secondBox.setMinSize(500, 360);
        secondBox.setPadding(new Insets(20));
        
        // Date field
        Label dobLabel = new Label("Date:");
        dobLabel.setFont(labelFont);
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
        
        // Allergy Field
        Label allLabel = new Label("Allergies");
        allLabel.setFont(labelFont);
        TextField allField = new TextField();
        HBox hallField = new HBox(10);
        hallField.getChildren().addAll(allField);
        allField.setPrefWidth(400);
        allField.setPrefHeight(60);
        
        // Allergy Field
        Label medLabel = new Label("Medications");
        medLabel.setFont(labelFont);
        TextField medField = new TextField();
        HBox hmedField = new HBox(10);
        hmedField.getChildren().addAll(medField);
        medField.setPrefWidth(400);
        medField.setPrefHeight(60);
        
        // Immunization Field
        Label immLabel = new Label("Immunization History");
        immLabel.setFont(labelFont);
        TextField immField = new TextField();
        HBox himmField = new HBox(10);
        himmField.getChildren().addAll(immField);
        immField.setPrefWidth(400);
        immField.setPrefHeight(60);
        
        // Health Field
        Label healLabel = new Label("Previous health concerns");
        healLabel.setFont(labelFont);
        TextField healField = new TextField();
        HBox hhealField = new HBox(10);
        hhealField.getChildren().addAll(healField);
        healField.setPrefWidth(400);
        healField.setPrefHeight(60);
        
        secondBox.getChildren().addAll(
        		createLabeledField(dobLabel, dobFields), 
                createLabeledField(allLabel, hallField),
                createLabeledField(medLabel, hmedField),
                createLabeledField(immLabel, himmField),
                createLabeledField(healLabel, hhealField)
        );
        
        HBox screen = new HBox(10); 
        screen.getChildren().addAll(
        		firstBox,
        		secondBox
        		);
        
        Button home = new Button("Back to Home");
        home.setPrefWidth(150);
        home.setPrefHeight(20);
        home.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        
        Button save = new Button("Save");
        save.setPrefWidth(150);
        save.setPrefHeight(20);
        save.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        
        HBox buttons = new HBox(10);
        buttons.setPrefSize(50, 50);
        buttons.setPadding(new Insets(0, 80, 30, 0));
        buttons.setAlignment(Pos.CENTER_RIGHT);
        buttons.getChildren().addAll(
        		home,
        		save
        		);
        
        VBox finalScreen = new VBox(10);
        finalScreen.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: black; -fx-border-width: 1px;");
        finalScreen.getChildren().addAll(
        		screen,
        		buttons
        		);
        
        // Add the gray boxes to the white background VBox
        whiteBackground.getChildren().addAll(finalScreen);

        whiteBackground.setPadding(new Insets(20, 20, 50, 20));
        
        Scene scene = new Scene(whiteBackground, 1050, 550);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        ///////////////////////////////////////////////////
        
        save.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                // TODO
            }
        });
        
        home.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                // TODO
            }
        });
        
        weightField.setText("180");
        ftField.setText("5");
        inField.setText("10");
        tempField.setText("98");
        firstField.setText("120");
        secondField.setText("80");
        notesField.setText("No notes.");
        
        allField.setText("No allergies.");
        medField.setText("No medications.");
        immField.setText("Fully vaccinated.");
        healField.setText("No previous health risks.");
        
        
        
    }

    // Helper method to create a labeled field
    private VBox createLabeledField(Label label, HBox textField) {
        VBox fieldBox = new VBox(5);
        fieldBox.getChildren().addAll(label, textField);
        textField.setPrefWidth(200);
        return fieldBox;
    }

}