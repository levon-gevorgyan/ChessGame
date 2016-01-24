/*
package gui.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


*/
/**
 * Created by Levon on 1/24/2016, 2:08 AM
 *//*

public class Main_2 extends Application{
    Button button;
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TEST");
        button=new Button();
        button.setText("click");
        button.setOnAction(e ->
        {
            System.out.println("BBB");
            System.out.println("aaa");
        });
*/
/*
old
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("AAAA");
            }
        });
*//*

        StackPane layout=new StackPane();
        layout.getChildren().add(button);
        Scene scene =new Scene(layout,300,250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
*/
