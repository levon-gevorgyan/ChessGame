package api.turns;

import api.chessitems.ChessItem;
import api.chessitems.black.*;
import api.chessitems.empty.Empty;
import api.chessitems.white.*;
import api.chesstable.cells.Cell;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import api.turns.SaveState;
import ui.window.main.MyImage;

import java.util.ArrayList;
import java.util.SortedMap;

/**
 * Created by levon.gevorgyan on 27/01/16.
 */
public abstract class UITurn {
    public static String getString(SortedMap<String, Integer> map, int i){
        for (SortedMap.Entry<String,Integer> pair:map.entrySet())
        {
            if (i==pair.getValue())
                return pair.getKey();
        }
        return null;
    }
    public static ArrayList<Integer> cellToInt (ArrayList<Cell> cells, SaveState save){
        ArrayList<Integer> list=new ArrayList<>();
        for (Cell cell:cells){
            for (SortedMap.Entry<String,Integer> pair:save.getGridCells().entrySet()){
                if(cell.toString().equals(pair.getKey())){
                    list.add(pair.getValue());
                    break;
                }

            }

        }
        return list;

    }



    public static String getImageString(Node node){
        Rectangle a=(Rectangle)node;
        ImagePattern b= (ImagePattern) a.getFill();
        MyImage c= (MyImage) b.getImage();
        return c.toString();
    }
    public static ImagePattern getImagePattern(Node node){
        Rectangle a=(Rectangle)node;
        return  (ImagePattern) a.getFill();

    }
    public static void setFill(Node nodeS,String string){
        Rectangle S=(Rectangle)nodeS;

        S.setFill(new ImagePattern(new MyImage(string)));

    }

    public static String  getImageString(ChessItem chessItem){
        if (chessItem instanceof Empty)
            return Empty.getImageString();
        if(chessItem instanceof WhiteBishop)
            return WhiteBishop.getImageString();
        if(chessItem instanceof WhiteKing)
            return WhiteKing.getImageString();
        if(chessItem instanceof WhiteKnight)
            return WhiteKnight.getImageString();
        if(chessItem instanceof WhitePawn)
            return WhitePawn.getImageString();
        if(chessItem instanceof WhiteQueen)
            return WhiteQueen.getImageString();
        if(chessItem instanceof WhiteRookA)
            return WhiteRook.getImageString();
        if(chessItem instanceof WhiteRookH)
            return WhiteRook.getImageString();
        if(chessItem instanceof WhiteRook)
            return WhiteRook.getImageString();
        if(chessItem instanceof BlackBishop)
            return BlackBishop.getImageString();
        if(chessItem instanceof BlackKing)
            return BlackKing.getImageString();
        if(chessItem instanceof BlackKnight)
            return BlackKnight.getImageString();
        if(chessItem instanceof BlackPawn)
            return BlackPawn.getImageString();
        if(chessItem instanceof BlackQueen)
            return BlackQueen.getImageString();
        if(chessItem instanceof BlackRookA)
            return BlackRook.getImageString();
        if(chessItem instanceof BlackRookH)
            return BlackRook.getImageString();
        if(chessItem instanceof BlackRook)
            return BlackRook.getImageString();
        return null;
    }
    public static ImagePattern getUI(ChessItem chessItem){
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
        if(chessItem instanceof WhiteRook)
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
        if(chessItem instanceof BlackRook)
            return BlackRook.getUI();
        if (chessItem instanceof Empty)
            return Empty.getUI();
        return null;
    }

    public static int getGridColumn(String cell){
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
    public static int getGridRow(String cell){
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

    public static Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
}
