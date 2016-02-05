package ui.window.alerts;

import api.colors.Colors;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * Created by levon.gevorgyan on 29/01/16.
 */
public class ChangePawnBox implements Colors{
    private static String item;

    public static String  display(String player){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Changing Pawn to...");
        window.setMinWidth(250);

        Label label1=new Label("Queen");
        Label label2=new Label("Bishop");
        Label label3=new Label("Rook");
        Label label4=new Label("Knight");

        Rectangle queen=new Rectangle(62,62); //queen
        Rectangle bishop=new Rectangle(62,62); //bishop
        Rectangle rook=new Rectangle(62,62); //rook
        Rectangle knight=new Rectangle(62,62); //knight
        HBox layout=new HBox(20);
        VBox item1=new VBox(20);
        VBox item2=new VBox(20);
        VBox item3=new VBox(20);
        VBox item4=new VBox(20);

        item1.getChildren().addAll(label1,queen);
        item1.setAlignment(Pos.CENTER);
        item2.getChildren().addAll(label2, bishop);
        item2.setAlignment(Pos.CENTER);
        item3.getChildren().addAll(label3, rook);
        item3.setAlignment(Pos.CENTER);
        item4.getChildren().addAll(label4, knight);
        item4.setAlignment(Pos.CENTER);

        if(player.equals(WHITE)){
            queen.setStyle("-fx-fill: url('/ui/window/main/images/items/WhiteQueen.png')");
            bishop.setStyle("-fx-fill: url('/ui/window/main/images/items/WhiteBishop.png')");
            rook.setStyle("-fx-fill: url('/ui/window/main/images/items/WhiteRook.png')");
            knight.setStyle("-fx-fill: url('/ui/window/main/images/items/WhiteKnight.png')");
        }

        if(player.equals(BLACK)){
            queen.setStyle("-fx-fill: url('/ui/window/main/images/items/BlackQueen.png')");
            bishop.setStyle("-fx-fill: url('/ui/window/main/images/items/BlackBishop.png')");
            rook.setStyle("-fx-fill: url('/ui/window/main/images/items/BlackRook.png')");
            knight.setStyle("-fx-fill: url('/ui/window/main/images/items/BlackKnight.png')");
        }
        queen.setOnMouseClicked(event -> {
            item="queen";
            window.close();
        });
        bishop.setOnMouseClicked(event -> {
            item = "bishop";
            window.close();
        });
        rook.setOnMouseClicked(event -> {
            item = "rook";
            window.close();
        });
        knight.setOnMouseClicked(event -> {
            item = "knight";
            window.close();
        });


        layout.getChildren().addAll(item1, item2, item3, item4);
        layout.setAlignment(Pos.CENTER);
        Scene scene=new Scene(layout);
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();

        return item;
    }
}
