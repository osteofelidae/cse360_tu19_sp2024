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
import java.io.File;


//=== CLASS ==================================================================
public abstract class Form {
	
	// --- Configuration variables --------------------------------------------
	private final int VBOX_VER_SPACING = 5;
	
	// --- Instance variables ------------------------------------------------
	Pane formPane;
	HashMap<String, String> data = new HashMap<String, String>();
	String fileName;
	String[] fieldnames;
	Button submitButton;
	String[] fields;
	TextField[] textFields;
	VBox vBox;
	
	
	// --- Constructor -------------------------------------------------------
	public Form(String[] fieldnames, String[] fields, String fileName) {
		
		// Initialize instance variables
		this.fileName = fileName;
		this.formPane = new Pane();
		this.fields = fields.clone();
    
		this.fieldnames = fieldnames.clone();
		this.textFields = new TextField[fields.length];
		
		for (int i = 0; i < fields.length; i++) {
			this.data.put(fieldnames[i], fields[i]);
			//System.out.println(fieldnames[i]);
			//System.out.println(fields[i]);
		}
		
		// Create main vBox
		this.vBox = new VBox(this.VBOX_VER_SPACING);
		int vBoxHeight = this.fields.length + 2;
		Node[] vBoxItems = new Node[vBoxHeight];
		
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
		//this.data.clear();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("All fields must be filled out");
				alert.show();
				return;
			}
			//this.data.put(fields[i], textFields[i].getText());
			//this.data.put(fields[i], fields[i]);
		}
		
		FileHandler fh = new FileHandler();
		String directory = "files/";
		File directoryFile = new File(directory);
		if (!directoryFile.exists()) {
			directoryFile.mkdirs();
		}
		fh.save("files/"+this.fileName, this.data);
		
	}
	
	//Retrieve
	
	protected HashMap retrieve() {
		this.data.clear();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("All fields must be filled out");
				alert.show();
				return this.data;
			}
		}
		FileHandler fh = new FileHandler();
		String directory = "files/";
		File directoryFile = new File(directory);
		if (!directoryFile.exists()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("User not found");
			alert.show();
			return this.data; //maybe not right
		}
		//HashMap current = fh.parse(this.fileName);
		/*if (!current[password].equals(this.data[password])) {
			
		}*/
		return fh.parse(this.fileName);
		
		
		
		
	}
}
