/*
package gui.test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


*/
/**
 * Created by Levon on 1/24/2016, 2:08 AM
 *//*

public class Main_10 extends Application{

    Stage window;
    Scene scene;
    Button button;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("Title");



        TextField nameInput=new TextField();
        button=new Button("Log in");
        button.setOnAction(e-> isInt(nameInput,nameInput.getText()));

        //Layout
        VBox layout=new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(nameInput,button);



        scene=new Scene(layout,300,300);
        window.setScene(scene);



        window.show();

    }

    private boolean isInt(TextField nameInput, String message) {
        try {
            int age=Integer.parseInt(nameInput.getText());
            System.out.println("User is "+age);
            return  true;
        }catch (NumberFormatException e){
            System.out.println("Error "+message+" is not a number");
            return false;
        }
    }


}
*/
