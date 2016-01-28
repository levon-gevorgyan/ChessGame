package gui.test.t_28;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Levon on 28.01.2016.
 * JavaFX Java GUI Tutorial - 28 - Properties
 */
public class Main_28 extends Application {
    Stage window;
    Button button;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("28");

        Person bucky=new Person();

        bucky.firstNameProperty().addListener(((observable, oldValue, newValue) -> {
            System.out.println("Name change to "+ newValue);
            System.out.println(bucky.firstNameProperty());
            System.out.println(bucky.getFirstName());
        }));

        button=new Button("Sumbit");
        button.setOnAction(e->bucky.setFirstName("Porky"));

        StackPane layout=new StackPane();
        layout.getChildren().add(button);

        Scene scene=new Scene(layout,300,300);
        window.setScene(scene);
        window.show();


    }
}
