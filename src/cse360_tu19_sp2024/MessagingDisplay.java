package cse360_tu19_sp2024;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.util.HashMap;
import java.util.Map;

public class MessagingDisplay extends Application {

    private ListView<String> userList;
    private TextArea chatArea;
    private TextField messageField;
    private Button sendButton;

    // Hash map for storing messages
    // CHANGE FOR FINAL INTEGRATION
    private Map<String, StringBuilder> chatHistory = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        userList = new ListView<>(FXCollections.observableArrayList("Zach", "Stefan", "Diego"));
        userList.setStyle("-fx-background-color: transparent; -fx-border-color: black;");

        // Creates chat area
        chatArea = new TextArea();
        chatArea.setEditable(false);

        // Creates text field for sending messages
        messageField = new TextField();
        sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());	// CHANGE FOR FINAL INTEGRATION
        // Send message function called

        HBox messageInputBox = new HBox(10);
        messageInputBox.getChildren().addAll(messageField, sendButton);
        HBox.setHgrow(messageField, Priority.ALWAYS);
        sendButton.setMaxWidth(Double.MAX_VALUE);

        userList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> updateChat(newValue));

        // Create the Messaging title at the top
        Label messagingTitle = new Label("Messaging");
        messagingTitle.setStyle("-fx-font-family: Arial; -fx-font-weight: bold; -fx-font-size: 20;");

        // Create the back to home button, add the home class call here
        Button backToHomeButton = new Button("Back to Home");
        backToHomeButton.setOnAction(e -> {
        	// CHANGE FOR FINAL INTEGRATION
            System.out.println("Back to Home button clicked");
        });

        // Alignment
        HBox titleBox = new HBox(10);
        titleBox.getChildren().addAll(messagingTitle);
        HBox.setHgrow(messagingTitle, Priority.ALWAYS);
        // More alignment
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(titleBox, backToHomeButton);
        StackPane.setAlignment(backToHomeButton, Pos.TOP_RIGHT);
        // More alignment
        HBox userChatBox = new HBox(10);
        userChatBox.getChildren().addAll(userList, chatArea);
        HBox.setHgrow(chatArea, Priority.ALWAYS);
        // More alignment
        VBox root = new VBox(10);
        root.getChildren().addAll(stackPane, userChatBox, messageInputBox);
        VBox.setVgrow(userChatBox, Priority.ALWAYS);
        // More alignment
        VBox.setMargin(stackPane, new Insets(10));
        VBox.setMargin(messageInputBox, new Insets(10, 10, 10, 10));
        // More alignment
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Messaging Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // CHANGE FOR FINAL INTEGRATION
    private void updateChat(String selectedUser) {
        chatArea.clear();
        if (selectedUser != null && chatHistory.containsKey(selectedUser)) {
            chatArea.appendText(chatHistory.get(selectedUser).toString());
        }
    }
    // CHANGE FOR FINAL INTEGRATION
    private void sendMessage() {
        String selectedUser = userList.getSelectionModel().getSelectedItem();
        String message = messageField.getText().trim();
        if (!message.isEmpty() && selectedUser != null) {
            StringBuilder userChatHistory = chatHistory.computeIfAbsent(selectedUser, k -> new StringBuilder());
            String formattedMessage = "You: " + message + "\n";
            userChatHistory.append(formattedMessage);
            chatArea.appendText(formattedMessage);
            messageField.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
