package ui.window.main;

import chessitems.ChessItem;
import chessitems.black.*;
import chessitems.empty.Empty;
import chessitems.white.*;
import chesstable.Table;
import chesstable.cells.Cell;
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
import play.turns.WhiteTurn;
import players.BlackPlayer;
import players.WhitePlayer;
import ui.turns.UITurn;
import ui.turns.WhiteUITurn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.SortedMap;

public class Controller implements Initializable{
    @FXML
    private GridPane board;
    SortedMap<String, Cell> cells = null;
    ArrayList<ArrayList<Cell>> rows = null;
    ArrayList<ArrayList<Cell>> columns = null;
    WhitePlayer whitePlayer = new WhitePlayer();
    BlackPlayer blackPlayer = new BlackPlayer();

    //Creating table
    Table table = new Table(cells, rows, columns, whitePlayer, blackPlayer);


    boolean bool=false;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        play();
        //new WhiteUITurn(previousState).doMove(board, table, whitePlayer, blackPlayer, saveStateArrayList);
        //new WhiteUITurn(previousState).doMove(board,table,whitePlayer,blackPlayer,saveStateArrayList);


    }

    public void play(){
        ArrayList<SaveState> saveStateArrayList = new ArrayList<>();
        SaveState previousState = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Defining variables
        table.setAllItems(whitePlayer, blackPlayer);
        table.toString();

        if (!bool) {
            doMove(board, table, whitePlayer, blackPlayer, saveStateArrayList, previousState);
        }
        if (bool)
        {
            doMove(board,table,whitePlayer,blackPlayer,saveStateArrayList,previousState);
        }
    }

    public void doMove(GridPane board,Table table, WhitePlayer whitePlayer, BlackPlayer blackPlayer,
                       ArrayList<SaveState> saveStateArrayList, SaveState previousState){
        saveStateArrayList.add(new SaveState(table, whitePlayer, blackPlayer));
        previousState = saveStateArrayList.get(saveStateArrayList.size() - 1);

        ArrayList<BoardItemUI> list=new ArrayList<>();
        previousState.getAllChessItems();
        previousState.getGridCells();

        for(SortedMap.Entry<String, ChessItem> pair:previousState.getAllChessItems().entrySet()){
            list.add(new BoardItemUI(pair.getKey(),pair.getValue(), UITurn.getImageString(pair.getValue())));
        }


        for(SortedMap.Entry<String, ChessItem> pair:previousState.getAllChessItems().entrySet()){

            board.add(new Rectangle(62,62,UITurn.getUI(pair.getValue())),UITurn.getGridColumn(pair.getKey()),UITurn.getGridRow(pair.getKey()));
        }
        //System.out.println(getImageString(board.getChildren().get(0)));

        Node source;
        final Node[] target = new Node[1];
        final int[] from = new int[1];
        final int[] to = new int[1];

        final String[] src = new String[1];
        final String[] trg = new String[1];
        final ArrayList<Cell>[] cellArrayList = new ArrayList[]{new ArrayList<Cell>()};
        final ArrayList<Integer>[] srcInt = new ArrayList[]{previousState.getWhiteOnlyGridCells()};




        for (Integer i: srcInt[0]) {
            source = board.getChildren().get(i);
            final Node finalSource = source;
            final int finalI = i;
            final SaveState finalPreviousState = previousState;
            final SaveState finalPreviousState1 = previousState;
            source.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                    System.out.println("onDragDetected");

                /* allow any transfer mode */
                    Dragboard db = finalSource.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                    ClipboardContent content = new ClipboardContent();
                    content.putString(UITurn.getImageString(finalSource));
                    db.setContent(content);


                    from[0] = finalI;
                    System.out.println(from[0]);
                    src[0] = UITurn.getString(finalPreviousState.getGridCells(), from[0]);
                    System.out.println(src[0]);
                    if (table.getCellByString(src[0]).getChessItem() instanceof WhiteKing) {
                        try {
                            cellArrayList[0] = new WhiteKingMoves(table.getCellByString(src[0]), table, false).getMoves();
                        } catch (NoAvailableCells noAvailableCells) {
                            noAvailableCells.printStackTrace();
                        }
                    }

                    if(table.getCellByString(src[0]).getChessItem() instanceof WhiteQueen)
                    {
                        try {
                            cellArrayList[0] = new WhiteQueenMoves(table.getCellByString(src[0]), table).getMoves();
                        } catch (NoAvailableCells noAvailableCells) {
                            noAvailableCells.printStackTrace();
                        }
                    }
                    if(table.getCellByString(src[0]).getChessItem() instanceof WhiteBishop)
                    {
                        try {
                            cellArrayList[0] = new WhiteBishopMoves(table.getCellByString(src[0]), table).getMoves();
                        } catch (NoAvailableCells noAvailableCells) {
                            noAvailableCells.printStackTrace();
                        }
                    }
                    if(table.getCellByString(src[0]).getChessItem() instanceof WhiteKnight)
                    {
                        try {
                            cellArrayList[0] = new WhiteKnightMoves(table.getCellByString(src[0]), table).getMoves();
                        } catch (NoAvailableCells noAvailableCells) {
                            noAvailableCells.printStackTrace();
                        }
                    }
                    if(table.getCellByString(src[0]).getChessItem() instanceof WhitePawn)
                    {
                        try {
                            cellArrayList[0] = new WhitePawnMoves(table.getCellByString(src[0]), table).getMoves();
                        } catch (NoAvailableCells noAvailableCells) {
                            noAvailableCells.printStackTrace();
                        }
                    }
                    if(table.getCellByString(src[0]).getChessItem() instanceof WhiteRook)
                    {
                        try {
                            cellArrayList[0] = new WhiteRookMoves(table.getCellByString(src[0]), table).getMoves();
                        } catch (NoAvailableCells noAvailableCells) {
                            noAvailableCells.printStackTrace();
                        }
                    }


                    System.out.println(UITurn.cellToInt(cellArrayList[0], finalPreviousState));
                    for (int i:UITurn.cellToInt(cellArrayList[0], finalPreviousState)) {
                        target[0] = board.getChildren().get(i);
                        final Node finalTarget = target[0];
                        target[0].setOnDragOver(new EventHandler<DragEvent>() {
                            public void handle(DragEvent event) {
                                /* data is dragged over the target */
                                //System.out.println("onDragOver");
                                /* accept it only if it is  not dragged from the same node
                                * and if it has a string data */
                                if (event.getGestureSource() != finalTarget &&
                                        event.getDragboard().hasString()) {
                                    /* allow for both copying and moving, whatever user chooses */
                                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                                }
                                //event.consume();
                            }
                        });

                        final Node finalTarget1 = target[0];
                        final int finalI = i;
                        finalTarget1.setOnDragDropped(new EventHandler<DragEvent>() {
                            public void handle(DragEvent event) {
                                /* data dropped */
                                System.out.println("onDragDropped");
                                /* if there is a string data on dragboard, read it and use it */
                                Dragboard db = event.getDragboard();
                                boolean success = false;
                                if (db.hasString()) {
                                    UITurn.setFill(finalTarget1, db.getString());
                                    success = true;
                                    to[0] = finalI;
                                    trg[0] =UITurn.getString(finalPreviousState1.getGridCells(), to[0]);
                                    System.out.println(trg[0]);

                                }
                                /* let the source know whether the string was successfully
                                 * transferred and used */
                                event.setDropCompleted(success);

                                //event.consume();
                            }
                        });
                    }
                    //event.consume();
                }
            });

            source = board.getChildren().get(i);
            final Node finalSource1 = source;
            final SaveState finalPreviousState2 = previousState;
            final Node finalSource2 = source;
            source.setOnDragDone(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    /* the drag-and-drop gesture ended */
                    System.out.println("onDragDone");
                    /* if the data was successfully moved, clear it */
                    if (event.getTransferMode() == TransferMode.MOVE) {
                        UITurn.setFill(finalSource1, Empty.getImageString());
                        boolean nextToBlack = false;
                        try {
                            WhiteTurn whiteTurn=new WhiteTurn();
                            whiteTurn.doMove(src[0] + trg[0], table, whitePlayer, blackPlayer, saveStateArrayList, finalPreviousState2, nextToBlack);
                            //new WhiteUITurn(whiteTurn.getSaveState());
                            //finalSource2.setOnDragDetected(null);
                            bool=true;
                            play();



                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (Mate mate) {
                            mate.printStackTrace();
                        }
                        /*for (Integer i: srcInt[0]) {
                            board.getChildren().get(i).setOnDragDetected(null);
                        }*/

                    }
                    //event.consume();
                    // doMove(board,table,whitePlayer,blackPlayer,saveStateArrayList);
                }
            });
        }

    }

}
