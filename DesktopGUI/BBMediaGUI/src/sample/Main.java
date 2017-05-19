package sample;

import javafx.application.Application;


import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane();
        primaryStage.setTitle("B.B.Media");
        Button SignUp= new Button("Sign Up");

        SignUp.setLayoutX(80);
        SignUp.setLayoutY(275/2);

        Pane pane2 = new Pane();


        Text serverStatus = new Text("ServerStatus: Inactive");
        serverStatus.setLayoutX(80);
        serverStatus.setLayoutY(135);
        Text Filepath = new Text("File path: NULL");
        Filepath.setLayoutX(80);
        Filepath.setLayoutY(160);
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));

        String ip = in.readLine();
        Text IPAddress = new Text("External IP Address: "+ ip);
        IPAddress.setLayoutX(80);
        IPAddress.setLayoutY(180);


        Button SelectFile= new Button("Select File");
        SelectFile.setOnAction(event -> {
            try {
                Runtime.getRuntime().exec("explorer C:\\bin");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        SelectFile.setLayoutX(80);
        SelectFile.setLayoutY(90);
        pane2.getChildren().add(SelectFile);
        pane2.getChildren().add(serverStatus);
        pane2.getChildren().add(Filepath);
        pane2.getChildren().add(IPAddress);

        Button Login= new Button("Login");
        Login.setOnAction(event -> primaryStage.setScene(new Scene(pane2,300 ,275)));
        Login.setLayoutX(160);
        Login.setLayoutY(275/2);

        TextField userName = new TextField("User Name");
        userName.setLayoutX(80);
        userName.setLayoutY(70);
        TextField password = new TextField("Password");
        password.setLayoutX(80);
        password.setLayoutY(105);

        root.getChildren().add(userName);
        root.getChildren().add(password);
        root.getChildren().add(SignUp);
        root.getChildren().add(Login);
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
