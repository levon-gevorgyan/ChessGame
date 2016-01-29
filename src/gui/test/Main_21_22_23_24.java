package gui.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * Created by Levon on 1/24/2016, 2:08 AM
 * JavaFX Java GUI Tutorial - 21 - Making Menus
 * JavaFX Java GUI Tutorial - 22 - Handling Menu Clicks
 * JavaFX Java GUI Tutorial - 23 - CheckMenuItem
 * JavaFX Java GUI Tutorial - 24 - RadioMenuItem
 */
public class Main_21_22_23_24 extends Application{

    Stage window;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("Title");

        Menu fileMenu=new Menu("File");

        MenuItem newFile=new MenuItem("New...");
        newFile.setOnAction(e -> System.out.println("new file"));


        fileMenu.getItems().add(newFile);
        fileMenu.getItems().add(new MenuItem("Open"));
        fileMenu.getItems().add(new MenuItem("Save"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit"));

        Menu editMenu=new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Undo"));
        editMenu.getItems().add(new MenuItem("Redo"));

        MenuItem paste=new MenuItem("Paste");
        paste.setOnAction(event -> System.out.println("Pasted"));
        paste.setDisable(true);
        editMenu.getItems().add(paste);

        Menu helpMenu=new Menu("_Help");
        CheckMenuItem showLines =new CheckMenuItem("Show line Items");
        showLines.setOnAction(event -> {
            if (showLines.isSelected()) {
                System.out.println("Enabled");
            } else
                System.out.println("Disabled");
        });
        CheckMenuItem autoSave=new CheckMenuItem("Enable auto save");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);

        Menu difficultyMenu=new Menu("Difficulty");
        ToggleGroup difficultyToggle=new ToggleGroup();

        RadioMenuItem easy=new RadioMenuItem("easy");
        RadioMenuItem medium=new RadioMenuItem("medium");
        RadioMenuItem hard=new RadioMenuItem("hard");

        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        difficultyMenu.getItems().addAll(easy,medium,hard);



        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu,helpMenu,difficultyMenu);

        //Layout
        layout=new BorderPane();
        layout.setTop(menuBar);

        Scene scene=new Scene(layout,400,300);
        window.setScene(scene);
        window.show();
    }



}
