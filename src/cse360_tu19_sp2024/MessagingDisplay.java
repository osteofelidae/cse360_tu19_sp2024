package cse360_tu19_sp2024;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MessagingDisplay extends Application {

    private ListView<String> userList;
    private TextArea chatArea;
    private TextField messageField;
    private Button sendButton;
    private String accountType;
    private String username;

    // Hash map for storing patient information
    private Map<String, Map<String, String>> patientInfo = new HashMap<>();

    // Hash map for storing chat history
    private Map<String, StringBuilder> chatHistory = new HashMap<>();

    public MessagingDisplay(String accountType) {
        this.accountType = accountType;
    }
    
    public void setUsername(String username) {
    	this.username = username;
    }

    @Override
    public void start(Stage primaryStage) {
        if (accountType.equals("Patient")) {
            handlePatientMessaging(primaryStage);
        } else {
            handleStaffMessaging(primaryStage);
        }
    }

    private void handlePatientMessaging(Stage primaryStage) {
        // Create the user list with "Office" as the only option
    	System.out.println("here man");
        userList = new ListView<>(FXCollections.observableArrayList("Office"));
        userList.setStyle("-fx-background-color: transparent; -fx-border-color: black;");

        // Creates chat area
        chatArea = new TextArea();
        chatArea.setEditable(false);

        // Creates text field for sending messages
        messageField = new TextField();
        sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendPatientMessage());

        HBox messageInputBox = new HBox(10);
        messageInputBox.getChildren().addAll(messageField, sendButton);
        HBox.setHgrow(messageField, Priority.ALWAYS);
        sendButton.setMaxWidth(Double.MAX_VALUE);

        userList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> updateChat(newValue));

        // Create the Messaging title at the top
        Label messagingTitle = new Label("Messaging");
        messagingTitle.setStyle("-fx-font-family: Arial; -fx-font-weight: bold; -fx-font-size: 20;");

        // Create the back to home button
        Button backToHomeButton = new Button("Back to Home");
        backToHomeButton.setOnAction(e -> {
            // CHANGE FOR FINAL INTEGRATION
            System.out.println("Back to Home button clicked");
            PatientDetailsDisplay newpatient = new PatientDetailsDisplay();
            newpatient.setUsername(this.username);
            newpatient.start(primaryStage);
        });

        // Alignment
        HBox titleBox = new HBox(10);
        titleBox.getChildren().addAll(messagingTitle);
        HBox.setHgrow(messagingTitle, Priority.ALWAYS);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(titleBox, backToHomeButton);
        StackPane.setAlignment(backToHomeButton, Pos.TOP_RIGHT);

        HBox userChatBox = new HBox(10);
        userChatBox.getChildren().addAll(userList, chatArea);
        HBox.setHgrow(chatArea, Priority.ALWAYS);

        VBox root = new VBox(10);
        root.getChildren().addAll(stackPane, userChatBox, messageInputBox);
        VBox.setVgrow(userChatBox, Priority.ALWAYS);

        VBox.setMargin(stackPane, new Insets(10));
        VBox.setMargin(messageInputBox, new Insets(10, 10, 10, 10));
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Messaging Display");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Read patient information from files
        //readPatientInfo(userList);
    }

    private void handleStaffMessaging(Stage primaryStage) {
        // Create the user list with all registered patients
        userList = new ListView<>(FXCollections.observableArrayList(patientInfo.keySet()));
        userList.setStyle("-fx-background-color: transparent; -fx-border-color: black;");
        
        readPatientInfo(userList);

        // Creates chat area
        chatArea = new TextArea();
        chatArea.setEditable(false);

        // Creates text field for sending messages
        messageField = new TextField();
        sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendStaffMessage());

        HBox messageInputBox = new HBox(10);
        messageInputBox.getChildren().addAll(messageField, sendButton);
        HBox.setHgrow(messageField, Priority.ALWAYS);
        sendButton.setMaxWidth(Double.MAX_VALUE);

        userList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> updateChat(newValue));

        // Create the Messaging title at the top
        Label messagingTitle = new Label("Messaging");
        messagingTitle.setStyle("-fx-font-family: Arial; -fx-font-weight: bold; -fx-font-size: 20;");

        // Create the back to home button
        Button backToHomeButton = new Button("Back to Home");
        backToHomeButton.setOnAction(e -> {
            // CHANGE FOR FINAL INTEGRATION
            System.out.println("Back to Home button clicked");
            if (accountType.equals("Nurse")) {
            	NurseHomeDisplay newnurse = new NurseHomeDisplay();
            	newnurse.start(primaryStage);
            } else {
            	DoctorDetailsDisplay newdoctor = new DoctorDetailsDisplay();
            	newdoctor.start(primaryStage);
            }
        });

        // Alignment
        HBox titleBox = new HBox(10);
        titleBox.getChildren().addAll(messagingTitle);
        HBox.setHgrow(messagingTitle, Priority.ALWAYS);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(titleBox, backToHomeButton);
        StackPane.setAlignment(backToHomeButton, Pos.TOP_RIGHT);

        HBox userChatBox = new HBox(10);
        userChatBox.getChildren().addAll(userList, chatArea);
        HBox.setHgrow(chatArea, Priority.ALWAYS);

        VBox root = new VBox(10);
        root.getChildren().addAll(stackPane, userChatBox, messageInputBox);
        VBox.setVgrow(userChatBox, Priority.ALWAYS);

        VBox.setMargin(stackPane, new Insets(10));
        VBox.setMargin(messageInputBox, new Insets(10, 10, 10, 10));

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Messaging Display");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Read patient information from files
        
    }

    private void readPatientInfo(ListView userlist) {
        File directory = new File("files/users");
        if (directory.exists() && directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    String user_name = file.getName().replace(".txt", "");
                    Map<String, String> info = new HashMap<>();
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(": ");
                            if (parts.length == 2) {
                                info.put(parts[0], parts[1]);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    userlist.getItems().add(user_name);
                }
            }
        }
    }

    private void updateChat(String selectedUser) {
        chatArea.clear();
        if (selectedUser != null) {
            //chatArea.appendText(chatHistory.get(selectedUser).toString());
            FileHandler fh = new FileHandler();
            ArrayList<String> data = fh.read("files/allMessages.txt");
            
            for (int i = 0; i < data.size()-2; i++) {
            	String line = data.get(i);
            	String line2 = data.get(i+1);
            	String line3 = data.get(i+2);
            	//System.out.println(line + ":::"+ line2 + ":::" + line3 + ":::");
            	if ((line.equals("To: Office") && line2.equals("From: "+selectedUser)) || (line.equals("To: "+selectedUser) && line2.equals("From: Office"))) {
            		// Display it
            		//System.out.println("YES");
            		String[] lineParts = line2.split(": ");
            		String from = lineParts[1];
            		String[] parts = line3.split(": ");
            		String message = parts[1];
            		chatArea.appendText(from + ": " + message + "\n");
            	}
            }
            //chatArea.appendText(selectedUser);
        }
    }
    private void sendPatientMessage() {
        String selectedUser = userList.getSelectionModel().getSelectedItem();
        String message = messageField.getText().trim();
        if (!message.isEmpty() && selectedUser != null && selectedUser.equals("Office")) {
            String fromName = this.username;
            appendMessageToFile("Office", fromName, message);
            StringBuilder userChatHistory = chatHistory.computeIfAbsent(selectedUser, k -> new StringBuilder());
            String formattedMessage = "You: " + message + "\n";
            userChatHistory.append(formattedMessage);
            chatArea.appendText(formattedMessage);
            messageField.clear();
        }
    }

    private void sendStaffMessage() {
        String selectedUser = userList.getSelectionModel().getSelectedItem();
        String message = messageField.getText().trim();
        if (!message.isEmpty() && selectedUser != null) {
            String fromName = "Office";
            appendMessageToFile(selectedUser, fromName, message);
            StringBuilder userChatHistory = chatHistory.computeIfAbsent(selectedUser, k -> new StringBuilder());
            String formattedMessage = "You: " + message + "\n";
            userChatHistory.append(formattedMessage);
            chatArea.appendText(formattedMessage);
            messageField.clear();
        }
    }

    private void appendMessageToFile(String toUser, String fromUser, String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("files/allMessages.txt", true))) {
            writer.write("To: " + toUser + "\n");
            writer.write("From: " + fromUser + "\n");
            writer.write("Message: " + message + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
