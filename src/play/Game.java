package play;

import api.chesstable.cells.Cell;
import api.chesstable.Table;
import api.chesstable.cells.Letters;

import api.colors.Colors;

import api.players.BlackPlayer;
import api.players.WhitePlayer;
import api.turns.SaveState;


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