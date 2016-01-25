package ui.window.main;

import chessitems.ChessItem;
import chessitems.black.*;
import chessitems.white.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import players.BlackPlayer;
import players.WhitePlayer;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.SortedMap;

public class Controller implements Initializable{
    @FXML
    private GridPane board;

    private ArrayList<Rectangle> whiteItemsUI=new ArrayList<>();
    private ArrayList<Rectangle> blackItemsUI=new ArrayList<>();




    @Override
    public void initialize(URL location, ResourceBundle resources) {


        WhitePlayer whitePlayer=new WhitePlayer();
        BlackPlayer blackPlayer=new BlackPlayer();

        for(SortedMap.Entry<String, ChessItem> pair:whitePlayer.getChessItemsMap().entrySet()){

            board.add(new Rectangle(62,62,getUI(pair.getValue())),getGridColumn(pair.getKey()),getGridRow(pair.getKey()));
        }
        for(SortedMap.Entry<String, ChessItem> pair:blackPlayer.getChessItemsMap().entrySet()){

            board.add(new Rectangle(62,62,getUI(pair.getValue())),getGridColumn(pair.getKey()),getGridRow(pair.getKey()));
        }






       /* Image image=new Image("ui/window/main/board.jpg");
        board.setBackground(new Background(new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));*/
        //board.setStyle("-fx-background-image: url('board.jpg')");
       // rook.setFill(new ImagePattern(new Image("/ui/window/main/images/rook.png")));

    }
    
    private ImagePattern getUI(ChessItem chessItem){
        if(chessItem instanceof WhiteBishop)
            return WhiteBishop.getUI();
        if(chessItem instanceof WhiteKing)
            return WhiteKing.getUI();
        if(chessItem instanceof WhiteKnight)
            return WhiteKnight.getUI();
        if(chessItem instanceof WhitePawn)
            return WhitePawn.getUI();
        if(chessItem instanceof WhiteQueen)
            return WhiteQueen.getUI();
        if(chessItem instanceof WhiteRookA)
            return WhiteRook.getUI();
        if(chessItem instanceof WhiteRookH)
            return WhiteRook.getUI();
        if(chessItem instanceof BlackBishop)
            return BlackBishop.getUI();
        if(chessItem instanceof BlackKing)
            return BlackKing.getUI();
        if(chessItem instanceof BlackKnight)
            return BlackKnight.getUI();
        if(chessItem instanceof BlackPawn)
            return BlackPawn.getUI();
        if(chessItem instanceof BlackQueen)
            return BlackQueen.getUI();
        if(chessItem instanceof BlackRookA)
            return BlackRook.getUI();
        if(chessItem instanceof BlackRookH)
            return BlackRook.getUI();
        return null;
    }

    private int getGridColumn(String cell){
        if(cell.toCharArray()[0]=='a'){
            return 0;
        }
        if(cell.toCharArray()[0]=='b'){
            return 1;
        }
        if(cell.toCharArray()[0]=='c'){
            return 2;
        }
        if(cell.toCharArray()[0]=='d'){
            return 3;
        }
        if(cell.toCharArray()[0]=='e'){
            return 4;
        }
        if(cell.toCharArray()[0]=='f'){
            return 5;
        }
        if(cell.toCharArray()[0]=='g'){
            return 6;
        }
        if(cell.toCharArray()[0]=='h'){
            return 7;
        }
        return Integer.parseInt(null);
    }
    private int getGridRow(String cell){
        if(cell.toCharArray()[1]=='1'){
            return 7;
        }
        if(cell.toCharArray()[1]=='2'){
            return 6;
        }
        if(cell.toCharArray()[1]=='3'){
            return 5;
        }
        if(cell.toCharArray()[1]=='4'){
            return 4;
        }
        if(cell.toCharArray()[1]=='5'){
            return 3;
        }
        if(cell.toCharArray()[1]=='6'){
            return 2;
        }
        if(cell.toCharArray()[1]=='7'){
            return 1;
        }
        if(cell.toCharArray()[1]=='8'){
            return 0;
        }


        return Integer.parseInt(null);
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
}
