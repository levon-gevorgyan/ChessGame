package ui.window.main;

import chessitems.BlackItem;
import chessitems.ChessItem;
import chessitems.WhiteItem;
import chessitems.black.*;
import chessitems.empty.Empty;
import chessitems.white.*;
import chesstable.Table;
import chesstable.cells.Cell;
import com.sun.org.glassfish.gmbal.ParameterNames;
import exceptions.game.Mate;
import exceptions.moves.NoAvailableCells;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import moves.available.black.moves.*;
import moves.available.white.moves.*;
import play.SaveState;
import play.turns.BlackTurn;
import play.turns.WhiteTurn;
import players.BlackPlayer;
import players.WhitePlayer;
import ui.turns.UITurn;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.SortedMap;

public class Controller implements Initializable{

    public GridPane board;

    //get All Cells list from FXML
    public Rectangle a1;
    public Rectangle a2;
    public Rectangle a3;
    public Rectangle a4;
    public Rectangle a5;
    public Rectangle a6;
    public Rectangle a7;
    public Rectangle a8;
    
    public Rectangle b1;
    public Rectangle b2;
    public Rectangle b3;
    public Rectangle b4;
    public Rectangle b5;
    public Rectangle b6;
    public Rectangle b7;
    public Rectangle b8;
    
    public Rectangle c1;
    public Rectangle c2;
    public Rectangle c3;
    public Rectangle c4;
    public Rectangle c5;
    public Rectangle c6;
    public Rectangle c7;
    public Rectangle c8;
    
    public Rectangle d1;
    public Rectangle d2;
    public Rectangle d3;
    public Rectangle d4;
    public Rectangle d5;
    public Rectangle d6;
    public Rectangle d7;
    public Rectangle d8;
    
    public Rectangle e1;
    public Rectangle e2;
    public Rectangle e3;
    public Rectangle e4;
    public Rectangle e5;
    public Rectangle e6;
    public Rectangle e7;
    public Rectangle e8;
    
    public Rectangle f1;
    public Rectangle f2;
    public Rectangle f3;
    public Rectangle f4;
    public Rectangle f5;
    public Rectangle f6;
    public Rectangle f7;
    public Rectangle f8;
    
    public Rectangle g1;
    public Rectangle g2;
    public Rectangle g3;
    public Rectangle g4;
    public Rectangle g5;
    public Rectangle g6;
    public Rectangle g7;
    public Rectangle g8;
    
    public Rectangle h1;
    public Rectangle h2;
    public Rectangle h3;
    public Rectangle h4;
    public Rectangle h5;
    public Rectangle h6;
    public Rectangle h7;
    public Rectangle h8;
    
    
    SortedMap<String, Cell> cells = null;
    ArrayList<ArrayList<Cell>> rows = null;
    ArrayList<ArrayList<Cell>> columns = null;
    WhitePlayer whitePlayer = new WhitePlayer();
    BlackPlayer blackPlayer = new BlackPlayer();

    //Creating table
    Table table = new Table(cells, rows, columns, whitePlayer, blackPlayer);
    ArrayList<Rectangle> boardCells=new ArrayList<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //create Cells list from FXML

        boardCells.add(a1);
        boardCells.add(a2);
        boardCells.add(a3);
        boardCells.add(a4);
        boardCells.add(a5);
        boardCells.add(a6);
        boardCells.add(a7);
        boardCells.add(a8);

        boardCells.add(b1);
        boardCells.add(b2);
        boardCells.add(b3);
        boardCells.add(b4);
        boardCells.add(b5);
        boardCells.add(b6);
        boardCells.add(b7);
        boardCells.add(b8);

        boardCells.add(c1);
        boardCells.add(c2);
        boardCells.add(c3);
        boardCells.add(c4);
        boardCells.add(c5);
        boardCells.add(c6);
        boardCells.add(c7);
        boardCells.add(c8);

        boardCells.add(d1);
        boardCells.add(d2);
        boardCells.add(d3);
        boardCells.add(d4);
        boardCells.add(d5);
        boardCells.add(d6);
        boardCells.add(d7);
        boardCells.add(d8);

        boardCells.add(e1);
        boardCells.add(e2);
        boardCells.add(e3);
        boardCells.add(e4);
        boardCells.add(e5);
        boardCells.add(e6);
        boardCells.add(e7);
        boardCells.add(e8);

        boardCells.add(f1);
        boardCells.add(f2);
        boardCells.add(f3);
        boardCells.add(f4);
        boardCells.add(f5);
        boardCells.add(f6);
        boardCells.add(f7);
        boardCells.add(f8);

        boardCells.add(g1);
        boardCells.add(g2);
        boardCells.add(g3);
        boardCells.add(g4);
        boardCells.add(g5);
        boardCells.add(g6);
        boardCells.add(g7);
        boardCells.add(g8);

        boardCells.add(h1);
        boardCells.add(h2);
        boardCells.add(h3);
        boardCells.add(h4);
        boardCells.add(h5);
        boardCells.add(h6);
        boardCells.add(h7);
        boardCells.add(h8);

        ArrayList<BoardItemUI> boardItems=new ArrayList<>();

        //Defining variables
        table.setAllItems(whitePlayer, blackPlayer);
        table.toString();

        for (Rectangle cell:boardCells){
            for(SortedMap.Entry<String,Cell> pair:table.getCells().entrySet()){
                if(cell.getId().equals(pair.getKey())){
                    cell.setStyle("-fx-fill: url('"+UITurn.getImageString(pair.getValue().getChessItem())+"')");
                }
            }
        }



/*

        ArrayList<SaveState> saveStateArrayList = new ArrayList<>();
        SaveState previousState = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Defining variables
        table.setAllItems(whitePlayer, blackPlayer);
        table.toString();

        doMove(board, table, whitePlayer, blackPlayer, saveStateArrayList, previousState);
*/
    }


    boolean whitePlayerTurn=true;
    boolean blackPlayerTurn=false;

    ArrayList<SaveState> saveStateArrayList=new ArrayList<>();
    SaveState previousState;
    ArrayList<Cell> cellArrayList=new ArrayList<>();

    @FXML
    void dragDetected(MouseEvent event){

        saveStateArrayList.add(new SaveState(table, whitePlayer, blackPlayer));
        previousState = saveStateArrayList.get(saveStateArrayList.size() - 1);
        Rectangle source= (Rectangle) event.getSource();


                /* allow any transfer mode */
        Dragboard db = source.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
        ClipboardContent content = new ClipboardContent();
        String s=UITurn.getImageString(table.getCellByString(source.getId()).getChessItem());
        content.putString(s);
        //System.out.println(s);
        db.setContent(content);
        if(whitePlayerTurn && !blackPlayerTurn) {

            if (table.getCellByString(source.getId()).getChessItem() instanceof WhiteKing) {
                try {
                    cellArrayList = new WhiteKingMoves(table.getCellByString(source.getId()), table, false).getMoves();
                } catch (NoAvailableCells noAvailableCells) {
                    //noAvailableCells.printStackTrace();
                }
            }
            if (table.getCellByString(source.getId()).getChessItem() instanceof WhiteQueen) {
                try {
                    cellArrayList = new WhiteQueenMoves(table.getCellByString(source.getId()), table).getMoves();
                } catch (NoAvailableCells noAvailableCells) {
                    //noAvailableCells.printStackTrace();
                }
            }
            if (table.getCellByString(source.getId()).getChessItem() instanceof WhiteBishop) {
                try {
                    cellArrayList = new WhiteBishopMoves(table.getCellByString(source.getId()), table).getMoves();
                } catch (NoAvailableCells noAvailableCells) {
                    //noAvailableCells.printStackTrace();
                }
            }
            if (table.getCellByString(source.getId()).getChessItem() instanceof WhiteKnight) {
                try {
                    cellArrayList = new WhiteKnightMoves(table.getCellByString(source.getId()), table).getMoves();
                } catch (NoAvailableCells noAvailableCells) {
                    //noAvailableCells.printStackTrace();
                }
            }
            if (table.getCellByString(source.getId()).getChessItem() instanceof WhitePawn) {
                try {
                    cellArrayList = new WhitePawnMoves(table.getCellByString(source.getId()), table).getMoves();
                } catch (NoAvailableCells noAvailableCells) {
                    //noAvailableCells.printStackTrace();
                }
            }
            if (table.getCellByString(source.getId()).getChessItem() instanceof WhiteRook) {
                try {
                    cellArrayList = new WhiteRookMoves(table.getCellByString(source.getId()), table).getMoves();
                } catch (NoAvailableCells noAvailableCells) {
                    //noAvailableCells.printStackTrace();
                }
            }
        }

        if(!whitePlayerTurn && blackPlayerTurn) {
            if (table.getCellByString(source.getId()).getChessItem() instanceof BlackKing) {
                try {
                    cellArrayList = new BlackKingMoves(table.getCellByString(source.getId()), table, false).getMoves();
                } catch (NoAvailableCells noAvailableCells) {
                    //noAvailableCells.printStackTrace();
                }
            }

            if(table.getCellByString(source.getId()).getChessItem() instanceof BlackQueen)
            {
                try {
                    cellArrayList = new BlackQueenMoves(table.getCellByString(source.getId()), table).getMoves();
                } catch (NoAvailableCells noAvailableCells) {
                    //noAvailableCells.printStackTrace();
                }
            }
            if(table.getCellByString(source.getId()).getChessItem() instanceof BlackBishop)
            {
                try {
                    cellArrayList = new BlackBishopMoves(table.getCellByString(source.getId()), table).getMoves();
                } catch (NoAvailableCells noAvailableCells) {
                    //noAvailableCells.printStackTrace();
                }
            }
            if(table.getCellByString(source.getId()).getChessItem() instanceof BlackKnight)
            {
                try {
                    cellArrayList = new BlackKnightMoves(table.getCellByString(source.getId()), table).getMoves();
                } catch (NoAvailableCells noAvailableCells) {
                    //noAvailableCells.printStackTrace();
                }
            }
            if(table.getCellByString(source.getId()).getChessItem() instanceof BlackPawn)
            {
                try {
                    cellArrayList = new BlackPawnMoves(table.getCellByString(source.getId()), table).getMoves();
                } catch (NoAvailableCells noAvailableCells) {
                    //noAvailableCells.printStackTrace();
                }
            }
            if(table.getCellByString(source.getId()).getChessItem() instanceof BlackRook)
            {
                try {
                    cellArrayList = new BlackRookMoves(table.getCellByString(source.getId()), table).getMoves();
                } catch (NoAvailableCells noAvailableCells) {
                    //noAvailableCells.printStackTrace();
                }
            }
        }
        event.consume();


    }

    @FXML
    void dragOver(DragEvent event){
        Rectangle cell= (Rectangle) event.getSource();
        for (Cell item:cellArrayList){
            if (item.toString().equals(cell.getId())){
                /* data is dragged over the target */
                //System.out.println("onDragOver");
                                /* accept it only if it is  not dragged from the same node
                                * and if it has a string data */
                if (event.getGestureSource() != cell &&
                        event.getDragboard().hasString()) {
                                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        }


    }
    Rectangle target;
    @FXML
    void dragDroped(DragEvent event){
        Rectangle cell= (Rectangle) event.getSource();
        for (Cell item:cellArrayList){
            if (item.toString().equals(cell.getId())){

                 /* data dropped */
                //System.out.println("onDragDropped");
                                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    UITurn.setFill(cell, db.getString());
                    success = true;

                   // System.out.println(cell.getId());

                }
                                /* let the source know whether the string was successfully
                                 * transferred and used */
                event.setDropCompleted(success);
                target=cell;
                event.consume();
            }
        }





    }
    @FXML
    void dragDone(DragEvent event){
        /* the drag-and-drop gesture ended */
        //System.out.println("onDragDone");
                    /* if the data was successfully moved, clear it */
        if (event.getTransferMode() == TransferMode.MOVE) {


            try {
                Rectangle source= (Rectangle) event.getSource();

                UITurn.setFill(((Rectangle) event.getSource()), Empty.getImageString());
                if(whitePlayerTurn) {
                    WhiteTurn whiteTurn = new WhiteTurn();
                    whiteTurn.doMove(source.getId() + target.getId(),
                            table, whitePlayer, blackPlayer, saveStateArrayList, previousState, false);
                }
                if(blackPlayerTurn){
                    BlackTurn blackTurn = new BlackTurn();
                    blackTurn.doMove(source.getId() + target.getId(),
                            table, whitePlayer, blackPlayer, saveStateArrayList, previousState, false);
                }
                saveStateArrayList.add(new SaveState(table,whitePlayer,blackPlayer));
                if(whitePlayerTurn && !blackPlayerTurn) {
                    whitePlayerTurn=false;
                    blackPlayerTurn=true;
                    System.out.println("Black player's turn");

                }
                else if(!whitePlayerTurn && blackPlayerTurn) {
                    whitePlayerTurn=true;
                    blackPlayerTurn=false;
                    System.out.println("White player's turn");
                }

            } catch (IOException e) {
                //e.printStackTrace();
            } catch (Mate mate) {
                mate.printStackTrace();
            }
                        /*for (Integer i: srcInt[0]) {
                            board.getChildren().get(i).setOnDragDetected(null);
                        }*/

        }
        event.consume();

    }

   /* private ArrayList<Rectangle> getRectangleListByCell(ArrayList<Cell> cellList){
        ArrayList<Rectangle> list=new ArrayList<>();
        for (Cell cell:cellList){
            for (Rectangle rectangle:boardCells){
                if(cell.toString().equals(rectangle.getId())){
                    list.add(rectangle);
                }
            }
        }
        return list;
    }*/

}
/*final Rectangle[] target = {null};
        for (Rectangle cell:getRectangleListByCell(cellArrayList)){

            cell.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                                *//* data is dragged over the target *//*
                    //System.out.println("onDragOver");
                                *//* accept it only if it is  not dragged from the same node
                                * and if it has a string data *//*
                    if (event.getGestureSource() != cell &&
                            event.getDragboard().hasString()) {
                                    *//* allow for both copying and moving, whatever user chooses *//*
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                    }
                    //event.consume();
                }
            });

            cell.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                                *//* data dropped *//*
                    System.out.println("onDragDropped");
                                *//* if there is a string data on dragboard, read it and use it *//*
                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasString()) {
                        UITurn.setFill(cell, db.getString());
                        success = true;

                        System.out.println(cell.getId());

                    }
                                *//* let the source know whether the string was successfully
                                 * transferred and used *//*
                    event.setDropCompleted(success);


                    event.consume();
                    target[0] = cell;
                }
            });

        }
        source.setOnDragDone(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                    *//* the drag-and-drop gesture ended *//*
                System.out.println("onDragDone");
                    *//* if the data was successfully moved, clear it *//*
                if (event.getTransferMode() == TransferMode.MOVE) {


                    try {

                        UITurn.setFill(source, Empty.getImageString());
                        WhiteTurn whiteTurn = new WhiteTurn();
                        whiteTurn.doMove(source.getId()+target[0].getId(),
                                table, whitePlayer, blackPlayer, saveStateArrayList,previousState , false);
                        saveStateArrayList.add(new SaveState(table,whitePlayer,blackPlayer));

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Mate mate) {
                        mate.printStackTrace();
                    }
                        *//*for (Integer i: srcInt[0]) {
                            board.getChildren().get(i).setOnDragDetected(null);
                        }*//*

                }
                event.consume();
                // doMove(board,table,whitePlayer,blackPlayer,saveStateArrayList);
            }
        });


*/