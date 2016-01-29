/*
package gui.test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


*/
/**
 * Created by Levon on 1/24/2016, 2:08 AM
 *//*

public class Main_11 extends Application{

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

        //Checkboxes
        CheckBox box1=new CheckBox("Bacon");
        CheckBox box2=new CheckBox("Tuna");
        box2.setSelected(true);



        button=new Button("Order now");
        button.setOnAction(event -> {
            handleOptions(box1,box2);
        });


        //Layout
        VBox layout=new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(box1,box2,button);



        scene=new Scene(layout,300,300);
        window.setScene(scene);



        window.show();

    }

    private void handleOptions(CheckBox box1, CheckBox box2) {
        String message="User's order: \n";
        if(box1.isSelected()){
            message+="bacon\n";
        }
        if(box2.isSelected()){
            message+="tuna\n";
        }
        System.out.println(message);
    }


}
*/
