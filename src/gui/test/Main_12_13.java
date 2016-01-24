/*
package gui.test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


*/
/**
 * Created by Levon on 1/24/2016, 2:08 AM
 * JavaFX Java GUI Tutorial - 12 - ChoiceBox (Drop Down Menu)
 * JavaFX Java GUI Tutorial - 13 - Listening for Selection Changes
 *//*

public class Main_12_13 extends Application{

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
        button=new Button("Order now");

        ChoiceBox<String> choiceBox=new ChoiceBox<>();
        choiceBox.getItems().add("Apple");
        choiceBox.getItems().add("Banana");
        choiceBox.getItems().addAll("Bacon", "Ham", "Meatballs");
        choiceBox.setValue("Banana");
        //button.setOnAction(event -> getChoice(choiceBox));

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue));

        //Layout
        VBox layout=new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(choiceBox,button);

        scene=new Scene(layout,300,300);
        window.setScene(scene);
        window.show();
    }

   */
/* private void getChoice(ChoiceBox<String> choiceBox) {
        String food=choiceBox.getValue();
        System.out.println(food);
    }*//*



}
*/
