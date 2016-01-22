package play;

import chessitems.ChessItem;
import chessitems.black.BlackKing;
import chessitems.white.WhiteKing;
import chesstable.cells.Cell;
import chesstable.Table;
import chesstable.cells.Letters;

import colors.Colors;
import exceptions.cell.EmptySourceCell;
import exceptions.cell.InvalidSource;
import exceptions.cell.NoCell;
import exceptions.chessitem.PlayerSameChessItem;
import exceptions.game.Check;
import exceptions.moves.InvalidMove;
import exceptions.moves.InvalidMoveString;
import exceptions.moves.NoAvailableCells;
import moves.BlackMove;
import moves.Move;
import moves.WhiteMove;
import moves.available.black.moves.BlackKingMoves;
import players.BlackPlayer;
import players.Player;
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
        SaveState previousState;

        //boolean whiteKingHasNoMoves=false;
        //boolean blackKingHasNoMoves=false;
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

        while (!s.equals("exit"))
        {

            //White player's turn
            while (!s.equals("exit"))
            {
                saveStateArrayList.add(new SaveState(table,whitePlayer,blackPlayer));
                previousState=saveStateArrayList.get(saveStateArrayList.size()-1);
                boolean nextToBlack;
                nextToBlack=false;

                System.out.print("White player's turn: ");
                s=reader.readLine();

                try {

                    new WhiteMove(s).move(table, whitePlayer, blackPlayer);

                    Cell myKingCell=
                            table.getOpponentKingCell(WHITE, whitePlayer.getChessItemsMap(), blackPlayer.getChessItemsMap(),table);

                    //is Check to my king?
                    if(Move.isInAllItemsOfAvailableCellListBlack(myKingCell, blackPlayer.getChessItemsMap(), table))
                    {
                        System.out.println("Black player will Announce you Check and Mate");

                        //Undo Last Move
                        previousState.undoHere(table,whitePlayer,blackPlayer);
                        //Undo Last Move
                        table.toString();
                        throw new Check();
                    }
                    table.toString();
                    nextToBlack=true;
                } catch (PlayerSameChessItem playerSameChessItem) {
                    System.out.println("Source & Target are the same");

                } catch (EmptySourceCell emptySourceCell) {
                    System.out.println("Source Cell is empty");

                } catch (InvalidSource invalidSource) {
                    System.out.println("Source is invalid");

                } catch (NoCell noCell) {

                } catch (InvalidMoveString invalidMoveString) {
                    System.out.println("String is invalid");

                } catch (InvalidMove invalidMove) {


                } catch (NoAvailableCells noAvailableCells) {
                    System.out.println("No Available Cells");
                } catch (Check check) {
                    check.printStackTrace();
                }
                if(nextToBlack)
                {
                    //is Check or not
                    Cell kingCell=table.getOpponentKingCell(BLACK, whitePlayer.getChessItemsMap(), blackPlayer.getChessItemsMap(), table);
                    if(Move.isInAllItemsOfAvailableCellListWhite(kingCell, whitePlayer.getChessItemsMap(),table)) {
                        try {
                            throw new Check();
                        } catch (Check check) {
                            System.out.println("Check to Black Army");
                        }
                    }

                    table.toString();
                    break;
                }




            }


            while (!s.equals("exit")) //Black player's turn
            {
                saveStateArrayList.add(new SaveState(table,whitePlayer,blackPlayer));
                previousState=saveStateArrayList.get(saveStateArrayList.size()-1);
                boolean nextToWhite;
                nextToWhite=false;

                System.out.print("Black player's turn: ");
                s=reader.readLine();

                try {
                    new BlackMove(s).move(table, whitePlayer, blackPlayer);

                    Cell myKingCell=
                            table.getOpponentKingCell(BLACK, whitePlayer.getChessItemsMap(), blackPlayer.getChessItemsMap(), table);

                    //is Check to my king?
                    if(Move.isInAllItemsOfAvailableCellListWhite(myKingCell, whitePlayer.getChessItemsMap(),table))
                    {
                        System.out.println("White player will Announce you Check and Mate");
                        //Undo Last Move
                        previousState.undoHere(table, whitePlayer, blackPlayer);
                        //Undo Last Move

                        throw new Check();
                    }
                    table.toString();
                    nextToWhite=true;
                } catch (PlayerSameChessItem playerSameChessItem) {
                    System.out.println("Source & Target are the same");

                } catch (EmptySourceCell emptySourceCell) {
                    System.out.println("Source Cell is empty");

                } catch (InvalidSource invalidSource) {
                    System.out.println("Source is invalid");

                } catch (NoCell noCell) {

                } catch (InvalidMoveString invalidMoveString) {
                    System.out.println("String is invalid");

                } catch (InvalidMove invalidMove) {


                } catch (NoAvailableCells noAvailableCells) {
                    System.out.println("No Available Cells");
                } catch (Check check) {
                    check.printStackTrace();
                }
                if(nextToWhite)
                {
                    //is Check or not
                    Cell kingCell=table.getOpponentKingCell(WHITE, whitePlayer.getChessItemsMap(), blackPlayer.getChessItemsMap(), table);
                    if(Move.isInAllItemsOfAvailableCellListBlack(kingCell, blackPlayer.getChessItemsMap(),table)){
                        try {
                            throw new Check();
                        } catch (Check check) {
                            System.out.println("Check to White Army");
                        }
                    }

                    table.toString();
                    break;
                }

            }

        }
    }



}

