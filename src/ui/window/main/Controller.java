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
import players.BlackPlayer;
import players.WhitePlayer;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<SaveState> saveStateArrayList = new ArrayList<>();
        SaveState previousState = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Defining variables
        SortedMap<String, Cell> cells = null;
        ArrayList<ArrayList<Cell>> rows = null;
        ArrayList<ArrayList<Cell>> columns = null;
        WhitePlayer whitePlayer = new WhitePlayer();
        BlackPlayer blackPlayer = new BlackPlayer();

        //Creating table
        Table table = new Table(cells, rows, columns, whitePlayer, blackPlayer);
        table.setAllItems(whitePlayer, blackPlayer);
        table.toString();

            new WhiteUITurn(previousState).doMove(board,table,whitePlayer,blackPlayer,saveStateArrayList);


    }


}
