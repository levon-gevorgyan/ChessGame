package gui.test.t_29;

import gui.test.t_28.Person;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Levon on 28.01.2016.
 * JavaFX Java GUI Tutorial - 28 - Properties
 */
public class Main_29 extends Application {
    Stage window;
    Button button;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("29");


        button=new Button("Sumbit");
        IntegerProperty x=new SimpleIntegerProperty(3);
        IntegerProperty y=new SimpleIntegerProperty();

        y.bind(x.multiply(10));
        System.out.println(x.getValue());
        System.out.println(y.getValue());

        x.setValue(9);
        System.out.println(x.getValue());
        System.out.println(y.getValue());

        StackPane layout=new StackPane();
        layout.getChildren().add(button);

        Scene scene=new Scene(layout,300,300);
        window.setScene(scene);
        window.show();


    }
}
