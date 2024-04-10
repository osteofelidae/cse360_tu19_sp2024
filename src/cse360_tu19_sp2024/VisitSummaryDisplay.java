package cse360_tu19_sp2024;

import java.util.HashMap;

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
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;


public class VisitSummaryDisplay extends Application {

    TextField weightField,
    ftField,
    inField,
    tempField,
    firstField,
    secondField;
	TextArea notesField, 
	medField,
	immField, 
	healField, 
	allField;
    private char accessLevel;
    String username;
    
    // === SET USERNAME ===========================================================================
    // Usage: this must be used directly after the constructor to specify which user will be
    //        displayed.
    public void setUsername(String username) {
    	this.username = username;
    }

    public VisitSummaryDisplay(char accessLevel){
    	this.accessLevel = accessLevel;
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visit Summary Display");

        // Create a VBox for white background with padding
        VBox whiteBackground = new VBox();
        whiteBackground.setStyle("-fx-background-color: white;");
        whiteBackground.setPadding(new Insets(20));
        whiteBackground.setPrefSize(100, 100);
        
        // Create the light gray box VBox with fixed size and padding
        VBox firstBox = new VBox(10);
        firstBox.setMinSize(500, 360);
        firstBox.setPadding(new Insets(20));

        Font labelFont = Font.font("Times New Roman");

        FileHandler fh = new FileHandler();
        String fname = fh.getAttr(username, "First name");
        String lname = fh.getAttr(username, "Last name");
        Label title = new Label("Visit Summaries - " + fname + " " + lname);
        title.setFont(Font.font("Arial", 24));
        
        Label vitals = new Label("Patient Vitals");
        vitals.setFont(Font.font("Arial", 20));

        // Weight Field
        Label weightLabel = new Label("Weight");
        weightLabel.setFont(labelFont);
        Label lbs = new Label("lbs");
        lbs.setFont(Font.font("Arial", 18));
        weightField = new TextField();
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
        ftField = new TextField();
        inField = new TextField();
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
        tempField = new TextField();
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
        firstField = new TextField();
        secondField = new TextField();
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
        notesField = new TextArea();
        notesField.setWrapText(true);
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
        
        // Allergy Field
        Label allLabel = new Label("Allergies");
        allLabel.setFont(labelFont);
        allField = new TextArea();
        allField.setWrapText(true);
        HBox hallField = new HBox(10);
        hallField.getChildren().addAll(allField);
        allField.setPrefWidth(400);
        allField.setPrefHeight(60);
        
        // Medication Field
        Label medLabel = new Label("Medications");
        medLabel.setFont(labelFont);
        medField = new TextArea();
        medField.setWrapText(true);
        //medField.setWrapText(true);
        HBox hmedField = new HBox(10);
        hmedField.getChildren().addAll(medField);
        medField.setPrefWidth(400);
        medField.setPrefHeight(60);
        
        // Immunization Field
        Label immLabel = new Label("Immunization History");
        immLabel.setFont(labelFont);
        immField = new TextArea();
        immField.setWrapText(true);
        //immField.setWrapText(true);
        HBox himmField = new HBox(10);
        himmField.getChildren().addAll(immField);
        immField.setPrefWidth(400);
        immField.setPrefHeight(60);
        
        // Health Field
        Label healLabel = new Label("Previous health concerns");
        healLabel.setFont(labelFont);
        healField = new TextArea();
        healField.setWrapText(true);
        //healField.setWrapText(true);
        HBox hhealField = new HBox(10);
        hhealField.getChildren().addAll(healField);
        healField.setPrefWidth(400);
        healField.setPrefHeight(60);
        
        secondBox.getChildren().addAll(
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
        
        
        VBox finalScreen = new VBox(10);
        finalScreen.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: black; -fx-border-width: 1px;");
        
        ///////////////////////////////////////////////////
        
        save.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                FileHandler fh = new FileHandler();
                HashMap<String, String> data = new HashMap<String, String>();
                data.put("Weight", weightField.getText());
                data.put("Feet", ftField.getText());
                data.put("Inches", inField.getText());
                data.put("Temperature", tempField.getText());
                data.put("Pressure1", firstField.getText());
                data.put("Pressure2", secondField.getText());
                data.put("Notes", notesField.getText());
                data.put("Allergies", allField.getText());
                data.put("Medications", medField.getText());
                data.put("Immunizations", immField.getText());
                data.put("Concerns", healField.getText());
                fh.updateAttrs(username, data);
            }
        });
        
        home.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                if(accessLevel == 'p') { //patient details
                	PatientDetailsDisplay display = new PatientDetailsDisplay();
                	display.start(primaryStage);
                }
                if(accessLevel == 'd') { //doctor patient details
                	DoctorDetailsDisplay display = new DoctorDetailsDisplay();
                	display.start(primaryStage);
                }
                if(accessLevel == 'n') { //nurse home
                	NurseHomeDisplay display = new NurseHomeDisplay();
                	display.start(primaryStage);
                }
            }
        });
        
        if(accessLevel == 'p'){
        	setEditable(false);
            
            weightField.setText("0");
            ftField.setText("0");
            inField.setText("0");
            tempField.setText("0");
            firstField.setText("0");
            secondField.setText("0");
            notesField.setText("No notes.");
            
            allField.setText("No allergies.");
            medField.setText("No medications.");
            immField.setText("Fully vaccinated.");
            healField.setText("No previous health risks.");
            
            HashMap<String, String> data = fh.parse(username);
            if(fh.getAttr(username, "Weight") != null) {
            	weightField.setText(data.get("Weight"));
                ftField.setText(data.get("Feet"));
                inField.setText(data.get("Inches"));
                tempField.setText(data.get("Temperature"));
                firstField.setText(data.get("Pressure1"));
                secondField.setText(data.get("Pressure2"));
            }
            if(fh.getAttr(username, "Notes") != null) {
                notesField.setText(data.get("Notes"));
            }
            if(fh.getAttr(username, "Allergies") != null) {
                allField.setText(data.get("Allergies"));
            }
            if(fh.getAttr(username, "Medications") != null) {
                medField.setText(data.get("Medications"));
            }
            if(fh.getAttr(username, "Immunizations") != null) {
                immField.setText(data.get("Immunizations"));
            }
            if(fh.getAttr(username, "Concerns") != null) {
                healField.setText(data.get("Concerns"));
            }
            
            buttons.getChildren().addAll(
            		home
            		);
        }
        else if(accessLevel == 'd'){ //doctor
        	setEditable(false);
        	allField.setEditable(true);
            medField.setEditable(true);
            immField.setEditable(true);
            healField.setEditable(true);
            
            weightField.setText("0");
            ftField.setText("0");
            inField.setText("0");
            tempField.setText("0");
            firstField.setText("0");
            secondField.setText("0");
            notesField.setText("No notes.");
            
            allField.setText("No allergies.");
            medField.setText("No medications.");
            immField.setText("Fully vaccinated.");
            healField.setText("No previous health risks.");
            
            HashMap<String, String> data = fh.parse(username);
            if(fh.getAttr(username, "Weight") != null) {
            	weightField.setText(data.get("Weight"));
                ftField.setText(data.get("Feet"));
                inField.setText(data.get("Inches"));
                tempField.setText(data.get("Temperature"));
                firstField.setText(data.get("Pressure1"));
                secondField.setText(data.get("Pressure2"));
            }
            if(fh.getAttr(username, "Notes") != null) {
                notesField.setText(data.get("Notes"));
            }
            if(fh.getAttr(username, "Allergies") != null) {
                allField.setText(data.get("Allergies"));
            }
            if(fh.getAttr(username, "Medications") != null) {
                medField.setText(data.get("Medications"));
            }
            if(fh.getAttr(username, "Immunizations") != null) {
                immField.setText(data.get("Immunizations"));
            }
            if(fh.getAttr(username, "Concerns") != null) {
                healField.setText(data.get("Concerns"));
            }
            
            
            
        	buttons.getChildren().addAll(
            		home,
            		save
            		);
        }else { //nurse
        	setEditable(true);
        	buttons.getChildren().addAll(
            		home,
            		save
            		);
        }
        
        ///////////////////////////////////////////////////
        
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
        
        
    }

    private void setEditable(boolean value){
    	weightField.setEditable(value);
        ftField.setEditable(value);
        inField.setEditable(value);
        tempField.setEditable(value);
        firstField.setEditable(value);
        secondField.setEditable(value);
        notesField.setEditable(value);
        
        allField.setEditable(value);
        medField.setEditable(value);
        immField.setEditable(value);
        healField.setEditable(value);
    }
    // Helper method to create a labeled field
    private VBox createLabeledField(Label label, HBox textField) {
        VBox fieldBox = new VBox(5);
        fieldBox.getChildren().addAll(label, textField);
        textField.setPrefWidth(200);
        return fieldBox;
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}