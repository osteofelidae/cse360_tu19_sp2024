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

// Represents the Receptionist View
public class StaffLoginDisplay extends LoginDisplay {

    TextField fname, lname, email, num, hist, insID;
    Label errorMessage;

    // Starts the StaffLoginDisplay View
    public void start(Stage primaryStage) {

        primaryStage.setTitle("StaffLoginDisplay");

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
        save.setStyle("-fx-background-color: royalblue; -fx-text-fill: black;");
        //save.setOnAction(e -> savePatientIntake());

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
        botright.getChildren().addAll(save);

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
