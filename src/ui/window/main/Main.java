package ui.window.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        primaryStage.setTitle("Play Chess");
        Scene scene=new Scene(root, 1000, 650);

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        this.primaryStage=primaryStage;
    }



}
