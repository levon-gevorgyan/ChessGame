/*
package gui.test;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


*/
/**
 * Created by Levon on 1/24/2016, 2:08 AM
 * JavaFX Java GUI Tutorial - 15 - ListView
 *//*

public class Main_15 extends Application{

    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("Title");
        button=new Button("Order now");
        listView=new ListView<>();
        listView.getItems().addAll("aaa","bbb","ccc","ddd");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(event -> clicked());



        //Layout
        VBox layout=new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView,button);

        scene=new Scene(layout,300,150);
        window.setScene(scene);
        window.show();
    }

    private void clicked() {
        String message="";
        ObservableList<String> movies;
        movies=listView.getSelectionModel().getSelectedItems();
        for (String m:movies)
        {
            message+=m+"\n";
        }
        System.out.println(message);
    }


}
*/
