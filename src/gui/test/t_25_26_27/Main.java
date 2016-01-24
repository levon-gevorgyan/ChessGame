package gui.test.t_25_26_27;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * Created by Levon on 1/24/2016, 2:08 AM
 * JavaFX Java GUI Tutorial - 25 - CSS Themes and Styles
 * JavaFX Java GUI Tutorial - 26 - CSS Inline Styles and Selectors
 * JavaFX Java GUI Tutorial - 27 - CSS Custom Style Classes and Selectors
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
        nameLabel.setStyle("-fx-text-fill: azure");
        nameLabel.setId("bold-label");
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
        GridPane.setConstraints(login, 1, 2);

        Button signUpButton=new Button("Sign up");
        signUpButton.getStyleClass().addAll("button-blue");
        GridPane.setConstraints(signUpButton,1,3);

        

        /*login.setOnAction(event -> {
            setUserAgentStylesheet(STYLESHEET_CASPIAN);
        });*/

        grid.getChildren().addAll(nameLabel, textField, passwordLabel, passField, login,signUpButton);

        Scene scene=new Scene(grid,300,300);
        scene.getStylesheets().add("gui/test/t_25_26_27/Viper.css");
        window.setScene(scene);



        window.show();

    }



}
