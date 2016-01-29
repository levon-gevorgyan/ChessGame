/*
package gui.test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


*/
/**
 * Created by Levon on 1/24/2016, 2:08 AM
 * JavaFX Java GUI Tutorial - 14 - ComboBox
 *//*

public class Main_14 extends Application{

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("Title");
        button=new Button("Order now");
        comboBox=new ComboBox<>();
        comboBox.getItems().addAll(
                "aaaa",
                "bbbb"
        );

        comboBox.setPromptText("What is yours?");
        comboBox.setEditable(true);

        button.setOnAction(event -> print());

        comboBox.setOnAction(event -> System.out.println("selected "+comboBox.getValue()));

        //Layout
        VBox layout=new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(comboBox,button);

        scene=new Scene(layout,300,300);
        window.setScene(scene);
        window.show();
    }

    private void print() {
        System.out.println(comboBox.getValue());
    }


}
*/
