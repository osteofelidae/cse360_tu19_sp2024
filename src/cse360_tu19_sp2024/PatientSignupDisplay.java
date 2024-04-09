package cse360_tu19_sp2024;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Hyperlink;

// Represents the Receptionist View
public class PatientSignupDisplay extends LoginDisplay {

    TextField fname, lname, email, num, hist, insID;
    Label errorMessage;

    // Starts the PatientSignupDisplay View
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Receptionist View");

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        fname = new TextField();
        lname = new TextField();
        email = new TextField();
        num = new TextField();
        hist = new TextField();
        insID = new TextField();

        Label flab = new Label("First Name: ");
        Label llab = new Label("Last Name: ");
        Label elab = new Label("Email: ");
        Label nlab = new Label("Phone Number: ");
        Label hlab = new Label("Health History: ");
        Label ilab = new Label("Insurance ID: ");

        Button save = new Button("Save");
        Hyperlink back = new Hyperlink("Take me to login");
        
        save.setStyle("-fx-background-color: royalblue; -fx-text-fill: black;");
        //save.setOnAction(e -> savePatientIntake());
        
        
        
        save.setOnAction(event -> {
        	System.out.println("validating signup");
            
            String[] categories = {"first name", "last name", "email", "phone number", "health history", "insurance id"};
            String[] immediates = {fname.getText(), lname.getText(), email.getText(), num.getText(), hist.getText(), insID.getText()};
            
            PatientSignupForm newform = new PatientSignupForm("title", categories, immediates, fname.getText() + lname.getText());
            if (newform.validateUserSignup()) {
            	//go to patient view
            	//create new patient account
            	System.out.println("success, now lets go to patient view");
            	
            } else {
            	//display some sort of error
            	System.out.println("Sorry, please try again");
            }
        });
        
        back.setOnAction(event -> {
            // Open another display
            System.out.println("going to login");
            PatientLoginDisplay newlogin = new PatientLoginDisplay();
            newlogin.start(primaryStage);
        });

        fname.setPrefWidth(250);
        lname.setPrefWidth(250);
        email.setPrefWidth(250);
        num.setPrefWidth(250);
        hist.setPrefWidth(250);
        insID.setPrefWidth(250);

        Insets ins = new Insets(0,0,0,0);
        VBox.setMargin(flab, ins);

        VBox left = new VBox(20);
        left.getChildren().addAll(flab, llab, elab, nlab, hlab, ilab);

        VBox center = new VBox(10);
        center.getChildren().addAll(fname, lname, email, num, hist, insID);

        VBox botright = new VBox(10);
        botright.getChildren().addAll(save, back);

        left.setAlignment(Pos.TOP_LEFT);
        center.setAlignment(Pos.TOP_LEFT);
        botright.setAlignment(Pos.BOTTOM_RIGHT);

        root.setLeft(left);
        root.setCenter(center);
        root.setBottom(botright);

        errorMessage = new Label();
        errorMessage.setStyle("-fx-text-fill: red;");
        botright.getChildren().add(0, errorMessage);

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
