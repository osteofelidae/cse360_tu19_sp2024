package cse360_tu19_sp2024;

//=== DEPENDENCIES ===========================================================
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import java.util.HashMap;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


//=== CLASS ==================================================================
public abstract class Form {
	
	// --- Configuration variables --------------------------------------------
	private final int VBOX_VER_SPACING = 5;
	
	// --- Instance variables ------------------------------------------------
	Pane formPane;
	HashMap<String, String> data = new HashMap<String, String>();
	String fileName;
	Button submitButton;
	String[] fields;
	TextField[] textFields;
	VBox vBox;
	
	
	// --- Constructor -------------------------------------------------------
	public Form(String title, String[] fields, String fileName) {
		
		// Initialize instance variables
		this.fileName = fileName;
		this.formPane = new Pane();
		this.fields = fields.clone();
		this.textFields = new TextField[fields.length];
		
		// Create main vBox
		this.vBox = new VBox(this.VBOX_VER_SPACING);
		int vBoxHeight = this.fields.length + 2;
		Node[] vBoxItems = new Node[vBoxHeight];
		
		// Create title
		vBoxItems[0] = new Label(title);
		
		// Iterate through input HashMap and create relevant fields
		for (int index = 0; index < this.fields.length; index++) {
			
			// Set up objects
			HBox row = new HBox();
			Label label = new Label(this.fields[index]+": ");
			TextField field = new TextField();
			
			// Add newly created objects to GUI and instance variables
			this.textFields[index] = field;
			row.getChildren().addAll(label, field);
			
		    vBoxItems[index+1] = row;
		}
		
		// Add submit button
		this.submitButton = new Button("Submit");
		this.submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                submit();
            }
        });
		vBoxItems[vBoxItems.length-1] = this.submitButton;
		
		vBox.getChildren().addAll(vBoxItems);
		
		this.formPane.getChildren().add(vBox);
	}
	
	// --- Pane getter -------------------------------------------------------
	public Pane getPane() {
		return this.formPane;
	}
	
	// --- Submit ------------------------------------------------------------
	protected void submit() {
		this.data.clear();
		for (int i = 0; i < fields.length; i++) {
			if (textFields[i].getText().equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("All fields must be filled out");
				alert.show();
				return;
			}
			this.data.put(fields[i], textFields[i].getText());
		}
		
		FileHandler fh = new FileHandler();
		fh.save("files/"+this.fileName, this.data);
		
	}
}
