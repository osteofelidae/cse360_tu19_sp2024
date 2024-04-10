package cse360_tu19_sp2024;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Launch extends Application{
	public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Temporary test thingy");
        primaryStage.show();
    }
}

