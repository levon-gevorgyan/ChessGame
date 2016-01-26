package ui.window.main;

import chessitems.ChessItem;
import chessitems.black.*;
import chessitems.empty.Empty;
import chessitems.white.*;
import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.moves.NoAvailableCells;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import moves.available.test.move.WhiteTestMove;
import moves.available.white.moves.*;
import play.SaveState;
import players.BlackPlayer;
import players.WhitePlayer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;

public class Controller implements Initializable{
    @FXML
    private GridPane board;





    @Override
    public void initialize(URL location, ResourceBundle resources) {


        ArrayList<SaveState> saveStateArrayList=new ArrayList<>();
        SaveState previousState;



        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        //Defining variables
        SortedMap<String,Cell> cells = null;
        ArrayList<ArrayList<Cell>> rows = null;
        ArrayList<ArrayList<Cell>> columns = null;
        WhitePlayer whitePlayer = new WhitePlayer();
        BlackPlayer blackPlayer = new BlackPlayer();

        //Creating table
        Table table=new Table(cells,rows,columns,whitePlayer,blackPlayer);
        table.setAllItems(whitePlayer, blackPlayer);
        table.toString();
        SaveState save=new SaveState(table, whitePlayer, blackPlayer);
        ArrayList<BoardItemUI> list=new ArrayList<>();
        save.getAllChessItems();
        save.getGridCells();

        for(SortedMap.Entry<String, ChessItem> pair:save.getAllChessItems().entrySet()){
            list.add(new BoardItemUI(pair.getKey(),pair.getValue(),getImageString(pair.getValue())));
        }


        for(SortedMap.Entry<String, ChessItem> pair:save.getAllChessItems().entrySet()){

            board.add(new Rectangle(62,62,getUI(pair.getValue())),getGridColumn(pair.getKey()),getGridRow(pair.getKey()));
        }
        //System.out.println(getImageString(board.getChildren().get(0)));

        Node source;//=board.getChildren().get(1);
        final Node[] target = new Node[1];//=board.getChildren().get(6);
        final int[] from = new int[1];
        final int[] to = new int[1];

        final String[] src = new String[1];
        String trg;
        final ArrayList<Cell>[] cellArrayList = new ArrayList[]{new ArrayList<Cell>()};


        for (int i=0;i<64;i++) {
            source = board.getChildren().get(i);
            final Node finalSource = source;
            final int finalI = i;
            source.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                    System.out.println("onDragDetected");

                /* allow any transfer mode */
                    Dragboard db = finalSource.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                    ClipboardContent content = new ClipboardContent();
                    content.putString(getImageString(finalSource));
                    db.setContent(content);


                    from[0] = finalI;
                    System.out.println(from[0]);
                    src[0] = getString(save.getGridCells(), from[0]);
                    System.out.println(src[0]);
                    if (table.getCellByString(src[0]).getChessItem() instanceof WhiteKing) {
                        try {
                            cellArrayList[0] = new WhiteKingMoves(table.getCellByString(src[0]), table, false).getWhiteKingMoves();
                        } catch (NoAvailableCells noAvailableCells) {
                            noAvailableCells.printStackTrace();
                        }
                    }

                    /*if(table.getCellByString(src[0]).getChessItem() instanceof WhiteQueen)
                    {
                        try {
                            for (Cell cell:new WhiteQueenMoves(table.getCellByString(item.getKey()), table).getWhiteQueenMoves())
                            {
                                whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                            }
                        } catch (NoAvailableCells noAvailableCells) {

                        }
                    }
                    if(table.getCellByString(src[0]).getChessItem() instanceof WhiteBishop)
                    {
                        try {
                            for (Cell cell:new WhiteBishopMoves(table.getCellByString(item.getKey()), table).getWhiteBishopMoves())
                            {
                                whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                            }
                        } catch (NoAvailableCells noAvailableCells) {

                        }
                    }
                    if(table.getCellByString(src[0]).getChessItem() instanceof WhiteKnight)
                    {
                        try {
                            for (Cell cell:new WhiteKnightMoves(table.getCellByString(item.getKey()), table).getWhiteKnightMoves())
                            {
                                whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                            }
                        } catch (NoAvailableCells noAvailableCells) {

                        }
                    }
                    if(table.getCellByString(src[0]).getChessItem() instanceof WhitePawn)
                    {
                        try {
                            for (Cell cell:new WhitePawnMoves(table.getCellByString(item.getKey()), table).getWhitePawnMoves())
                            {
                                whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                            }
                        } catch (NoAvailableCells noAvailableCells) {

                        }
                    }
                    if(table.getCellByString(src[0]).getChessItem() instanceof WhiteRook)
                    {
                        try {
                            for (Cell cell:new WhiteRookMoves(table.getCellByString(item.getKey()), table).getWhiteRookMoves())
                            {
                                whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                            }
                        } catch (NoAvailableCells noAvailableCells) {

                        }
                    }*/

                    System.out.println(cellToInt(cellArrayList[0],save));
                    for (int i:cellToInt(cellArrayList[0],save)) {
                        target[0] = board.getChildren().get(i);
                        final Node finalTarget = target[0];
                        target[0].setOnDragOver(new EventHandler<DragEvent>() {
                            public void handle(DragEvent event) {
                /* data is dragged over the target */
                                System.out.println("onDragOver");

                /* accept it only if it is  not dragged from the same node
                 * and if it has a string data */
                                if (event.getGestureSource() != finalTarget &&
                                        event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                                }

                                event.consume();
                            }
                        });


        /*target.setOnDragEntered(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                *//* the drag-and-drop gesture entered the target *//*
                System.out.println("onDragEntered");
                *//* show to the user that it is an actual gesture target *//*
                if (event.getGestureSource() != target &&
                        event.getDragboard().hasString()) {
                    target.setFill(Color.GREEN);
                }

                event.consume();
            }
        });*/

        /*target.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                *//* mouse moved away, remove the graphical cues *//*
                target.setFill(Color.BLACK);

                event.consume();
            }
        });*/

                        final Node finalTarget1 = target[0];
                        final int finalI = i;
                        target[0].setOnDragDropped(new EventHandler<DragEvent>() {
                            public void handle(DragEvent event) {
                /* data dropped */
                                System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                                Dragboard db = event.getDragboard();
                                boolean success = false;
                                if (db.hasString()) {
                                    setFill(finalTarget1, db.getString());
                                    success = true;
                                    to[0] = finalI;
                                    System.out.println(to[0]);
                                }
                /* let the source know whether the string was successfully
                 * transferred and used */
                                event.setDropCompleted(success);

                                event.consume();
                            }
                        });
                    }
                    event.consume();
                }
            });
        }




        /*for (int i:cellToInt(cellArrayList[0],save)) {
            target = board.getChildren().get(i);
            final Node finalTarget = target;
            target.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                *//* data is dragged over the target *//*
                    System.out.println("onDragOver");

                *//* accept it only if it is  not dragged from the same node
                 * and if it has a string data *//*
                    if (event.getGestureSource() != finalTarget &&
                            event.getDragboard().hasString()) {
                    *//* allow for both copying and moving, whatever user chooses *//*
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                    }

                    event.consume();
                }
            });


        *//*target.setOnDragEntered(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                *//**//* the drag-and-drop gesture entered the target *//**//*
                System.out.println("onDragEntered");
                *//**//* show to the user that it is an actual gesture target *//**//*
                if (event.getGestureSource() != target &&
                        event.getDragboard().hasString()) {
                    target.setFill(Color.GREEN);
                }

                event.consume();
            }
        });*//*

        *//*target.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                *//**//* mouse moved away, remove the graphical cues *//**//*
                target.setFill(Color.BLACK);

                event.consume();
            }
        });*//*

            final Node finalTarget1 = target;
            final int finalI = i;
            target.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                *//* data dropped *//*
                    System.out.println("onDragDropped");
                *//* if there is a string data on dragboard, read it and use it *//*
                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasString()) {
                        setFill(finalTarget1, db.getString());
                        success = true;
                        to[0] = finalI;
                        System.out.println(to[0]);
                    }
                *//* let the source know whether the string was successfully
                 * transferred and used *//*
                    event.setDropCompleted(success);

                    event.consume();
                }
            });
        }*/
        for (int i=0;i<64;i++) {
            source = board.getChildren().get(i);
            final Node finalSource1 = source;

            source.setOnDragDone(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                    System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                    if (event.getTransferMode() == TransferMode.MOVE) {
                        setFill(finalSource1, Empty.getImageString());
                    }

                    event.consume();

                }
            });
        }



    }

    private String getString(SortedMap<String, Integer> map, int i){
        for (SortedMap.Entry<String,Integer> pair:map.entrySet())
        {
            if (i==pair.getValue())
                return pair.getKey();
        }
        return null;
    }
    private ArrayList<Integer> cellToInt (ArrayList<Cell> cells,SaveState save){
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



    private String getImageString(Node node){
        Rectangle a=(Rectangle)node;
        ImagePattern b= (ImagePattern) a.getFill();
        MyImage c= (MyImage) b.getImage();
        return c.toString();
    }
    private ImagePattern getImagePattern(Node node){
        Rectangle a=(Rectangle)node;
        return  (ImagePattern) a.getFill();

    }
    private void setFill(Node nodeS,String string){
        Rectangle S=(Rectangle)nodeS;

        S.setFill(new ImagePattern(new MyImage(string)));

    }
    
    private String  getImageString(ChessItem chessItem){
        if ((chessItem instanceof Empty))
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
        return null;
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
        if (chessItem instanceof Empty)
            return Empty.getUI();
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
