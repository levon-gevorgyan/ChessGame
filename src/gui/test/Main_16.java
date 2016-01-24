/*
package gui.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


*/
/**
 * Created by Levon on 1/24/2016, 2:08 AM
 * JavaFX Java GUI Tutorial - 16 - TreeView
 *//*

public class Main_16 extends Application{

    Stage window;
    TreeView<String> tree;




    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("Title");

        TreeItem<String> root,levon, megan;

        //root
        root=new TreeItem<>();
        root.setExpanded(true);

        //levon
        levon=makeBranch("levon",root);
        makeBranch("1",levon);
        makeBranch("2",levon);
        makeBranch("3", levon);
        //megan
        megan=makeBranch("megan",root);
        makeBranch("1",megan);
        makeBranch("2",megan);
        makeBranch("3",megan);

        //create Tree
        tree=new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue !=null){
                System.out.println(newValue.getValue());
            }
        });



        //Layout
        StackPane layout=new StackPane();
        layout.getChildren().add(tree);
        Scene scene=new Scene(layout,300,300);
        window.setScene(scene);
        window.show();
    }

    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item=new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }


}
*/
