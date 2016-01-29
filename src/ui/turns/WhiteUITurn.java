package ui.turns;

import chessitems.ChessItem;
import chessitems.black.*;
import chessitems.empty.Empty;
import chessitems.white.*;
import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.game.Mate;
import exceptions.moves.NoAvailableCells;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import moves.available.black.moves.*;
import moves.available.white.moves.*;
import play.SaveState;
import play.turns.WhiteTurn;
import players.BlackPlayer;
import players.WhitePlayer;
import ui.window.main.BoardItemUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedMap;

/**
 * Created by levon.gevorgyan on 27/01/16.
 */
public class WhiteUITurn extends UITurn{
    SaveState previousState;

    public static boolean e=true;
    public WhiteUITurn(SaveState previousState) {
        this.previousState=previousState;



    }

    public void doMove(GridPane board,Table table, WhitePlayer whitePlayer, BlackPlayer blackPlayer,
                       ArrayList<SaveState> saveStateArrayList, SaveState previousState){


    }


}
