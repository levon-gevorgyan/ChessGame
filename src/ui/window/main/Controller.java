package ui.window.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    public GridPane board;
    public void test(){


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        board.setVgap(2);
        board.setHgap(2);

    }
}
