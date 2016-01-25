package ui.window.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    public GridPane board;
    public Rectangle rook;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
       /* Image image=new Image("ui/window/main/board.jpg");
        board.setBackground(new Background(new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));*/
        //board.setStyle("-fx-background-image: url('board.jpg')");
       // rook.setFill(new ImagePattern(new Image("/ui/window/main/images/rook.png")));

    }
}
