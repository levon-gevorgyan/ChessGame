package gui.test;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;



/**
 * Created by Levon on 1/24/2016, 2:08 AM
 * JavaFX Java GUI Tutorial - 25 - CSS Themes and Styles
 */
public class Main extends Application{
    Stage window;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("Title");

        GridPane grid=new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        //username
        Label nameLabel=new Label("UserName");
        GridPane.setConstraints(nameLabel,0,0);

        //input

        TextField textField=new TextField("test");
        GridPane.setConstraints(textField, 1, 0);
        //password
        Label passwordLabel=new Label("Pasword");
        GridPane.setConstraints(passwordLabel, 0, 1);

        //input

        TextField passField=new TextField();
        passField.setPromptText("password");
        GridPane.setConstraints(passField, 1, 1);

        Button login=new Button("Log in");
        GridPane.setConstraints(login,1,2);



        /*login.setOnAction(event -> {
            setUserAgentStylesheet(STYLESHEET_CASPIAN);
        });*/

        grid.getChildren().addAll(nameLabel, textField, passwordLabel, passField,login);

        Scene scene=new Scene(grid,300,300);
        window.setScene(scene);



        window.show();

    }



}
