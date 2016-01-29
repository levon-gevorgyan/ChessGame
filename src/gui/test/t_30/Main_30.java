package gui.test.t_30;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Levon on 28.01.2016.
 * JavaFX Java GUI Tutorial - 28 - Properties
 */
public class Main_30 extends Application {
    Stage window;
    Button button;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("30");

        TextField userInput=new TextField();
        userInput.setMaxWidth(200);
        Label firstLabel=new Label("HI ");
        Label secondLabel=new Label();
        HBox bottomText=new HBox(firstLabel,secondLabel);
        bottomText.setAlignment(Pos.CENTER);


        VBox vBox=new VBox(10,userInput,bottomText);
        vBox.setAlignment(Pos.CENTER);

        secondLabel.textProperty().bind(userInput.textProperty());

        Scene scene=new Scene(vBox,300,300);
        window.setScene(scene);
        window.show();


    }
}
