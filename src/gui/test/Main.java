package gui.test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 * Created by Levon on 1/24/2016, 2:08 AM
 */
public class Main extends Application{

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("Title");

        button=new Button("Click");
        button.setOnAction(e->
        {
            boolean result=ConfirmBox.display("Title","Question?");
            System.out.println(result);
        });

        StackPane layout=new StackPane();
        layout.getChildren().add(button);
        Scene scene=new Scene(layout,600,300);

        window.setScene(scene);
        window.show();

    }


}
