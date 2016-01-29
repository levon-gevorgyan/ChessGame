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

public class Main_5 extends Application{

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("Title");

        window.setOnCloseRequest(e -> {
            e.consume();//do my code
            closeProgram();
        });


        button=new Button("Close");
        button.setOnAction(e->closeProgram());


        StackPane layout=new StackPane();
        layout.getChildren().add(button);
        Scene scene=new Scene(layout,600,300);

        window.setScene(scene);
        window.show();

    }

    private void closeProgram() {
        boolean answer=ConfirmBox.display("Title","Are you sure?");
        if(answer)
        {
            window.close();
        }
    }
*/
/*
    private void closeProgram() {
        System.out.println("is saved");
        window.close();
    }
*//*



}
*/
