package play;

import chessitems.ChessItem;
import chessitems.black.*;
import chessitems.white.*;

import chesstable.cells.Cell;
import chesstable.Table;
import chesstable.cells.Letters;

import colors.Black;
import colors.Colors;
import colors.White;

import exceptions.cell.EmptySourceCell;
import exceptions.cell.InvalidSource;
import exceptions.cell.NoCell;
import exceptions.chessitem.PlayerSameChessItem;
import exceptions.game.Check;
import exceptions.game.Mate;
import exceptions.moves.InvalidMove;
import exceptions.moves.InvalidMoveString;
import exceptions.moves.NoAvailableCells;

import moves.BlackMove;
import moves.Move;
import moves.WhiteMove;
import moves.available.black.moves.*;
import moves.available.test.move.*;
import moves.available.white.moves.*;

import play.turns.BlackTurn;
import play.turns.WhiteTurn;
import players.BlackPlayer;
import players.WhitePlayer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

/**
 * Created by Levon on 1/9/2016.
 */
public class Game implements Letters, Colors{

    public static void main(String[] args) throws IOException {
        ArrayList<SaveState> saveStateArrayList=new ArrayList<>();
        SaveState previousState = null;

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

        //Start play.Game
        String s = "";
        //try {

            while (!s.equals("exit")) {

                //White player's turns
                boolean nextToBlack;
                nextToBlack = false;
                //new WhiteTurn().doMove(s,table,whitePlayer,blackPlayer,saveStateArrayList,previousState,nextToBlack);


                //Black player's turns
                boolean nextToWhite;
                nextToWhite = false;
                //new BlackTurn().doMove(s,table,whitePlayer,blackPlayer,saveStateArrayList,previousState,nextToWhite);

                }


       /* }
        catch (Mate mate)
        {
            System.out.println("Game is over");
        }*/
    }



}