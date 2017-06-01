package sample;

import javafx.application.Application;


import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;

import javafx.stage.Stage;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane mainPane = new Pane();
        primaryStage.setTitle("B.B.Media");
        Button SignUp= new Button("Sign Up");

        SignUp.setLayoutX(80);
        SignUp.setLayoutY(275/2);

        Pane serverPane = new Pane();


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
        IPAddress.setLayoutY(200);



        Button SelectFile= new Button("Select File");


        SelectFile.setLayoutX(80);
        SelectFile.setLayoutY(90);


        Button Login= new Button("Login");

        Login.setLayoutX(160);
        Login.setLayoutY(275/2);

        TextField userName = new TextField();
        userName.setLayoutX(80);
        userName.setLayoutY(70);

        TextField password = new TextField();
        password.setLayoutX(80);
        password.setLayoutY(105);

        userName.setPromptText("Username");
        password.setPromptText("Password");

        Text invalidLogin = new Text("");
        invalidLogin.setLayoutX(80);
        invalidLogin.setLayoutY(200);



        serverPane.getChildren().add(SelectFile);
        serverPane.getChildren().add(serverStatus);
        serverPane.getChildren().add(Filepath);
        serverPane.getChildren().add(IPAddress);

        mainPane.getChildren().add(userName);
        mainPane.getChildren().add(password);
        mainPane.getChildren().add(SignUp);
        mainPane.getChildren().add(Login);
        mainPane.getChildren().add(invalidLogin);
        primaryStage.setMinWidth(350);
;        primaryStage.setScene(new Scene(mainPane, 350, 275));

        primaryStage.show();
        Login.setOnAction(event -> {
            if(userName.getText().equals("brennan")&&password.getText().equals("test")){
                primaryStage.setScene(new Scene(serverPane, 350, 275));
            }
            else {
                invalidLogin.setText("Wrong Login");

            }

        });
        SignUp.setOnAction(event -> {
            if(!userName.getText().equals("brennan")&&!password.getText().equals("test")){
                //save text
                invalidLogin.setText("User name and password created");
            }
            else {
                invalidLogin.setText("User name exist");

            }

        });
        SelectFile.setOnAction((ActionEvent event) -> {
            try {
                //Create a file chooser
                DirectoryChooser fileChooser = new DirectoryChooser();
                fileChooser.setTitle("Open Resource File");
                File file= fileChooser.showDialog(primaryStage);

                Filepath.setText(file.getAbsolutePath());
                Filepath.setWrappingWidth(250);
                try(Stream<Path> paths= Files.walk(Paths.get(file.toURI()))){
                    paths.filter(Files::isRegularFile).forEach(System.out::println);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    public static void main(String[] args) throws IOException {
    	ServerThreadDriver std = new ServerThreadDriver();
    	std.start();
        launch(args);
        std.StopServer();
    }
}
