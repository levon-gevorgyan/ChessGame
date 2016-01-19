package play;

import chessitems.ChessItem;
import chessitems.black.BlackKing;
import chessitems.white.WhiteKing;
import chesstable.cells.Cell;
import chesstable.Table;
import chesstable.cells.Letters;

/*import colors.Colors;
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
import moves.WhiteMove;*/

import colors.Colors;
import exceptions.cell.EmptySourceCell;
import exceptions.cell.InvalidSource;
import exceptions.cell.NoCell;
import exceptions.chessitem.PlayerSameChessItem;
import exceptions.game.Check;
import exceptions.moves.InvalidMove;
import exceptions.moves.InvalidMoveString;
import exceptions.moves.NoAvailableCells;
import moves.Move;
import moves.WhiteMove;
import players.BlackPlayer;
import players.Player;
import players.WhitePlayer;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by Levon on 1/9/2016.
 */
public class Game implements Letters, Colors{


    private static ArrayList<SaveState> saveStateArrayList=new ArrayList<>();



    public static void main(String[] args)
            throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


        Table table=new Table();
        //TABLE=table;
        table.getAllCells();

        Player whitePlayer = new WhitePlayer();
        Player blackPlayer = new BlackPlayer();

        Map<String, ChessItem> whitePlayerItems = whitePlayer.getChessItemsMap();
        Map<String, ChessItem> blackPlayerItems = blackPlayer.getChessItemsMap();

        //MAKING TABLE, DO NOT REMOVE---BEGIN
        setAllItems(table, whitePlayerItems, blackPlayerItems);
        table.toString();
        //MAKING TABLE, DO NOT REMOVE---END



        //TESTING PART----->Begin
        /*new BlackMove(s).move(table, whitePlayerItems, blackPlayerItems);
        setAllItems(table, whitePlayerItems, blackPlayerItems);*/

        //TESTING PART----->End

        //Start play.Game
        String s = "";

        while (!s.equals("exit"))
        {

            while (!s.equals("exit")) //White player's turn
            {
                boolean nextToBlack;
                nextToBlack=false;

                System.out.print("White player's turn: ");
                s=reader.readLine();
                saveStateArrayList.add(new SaveState(s,whitePlayerItems,blackPlayerItems,table));
                SaveState previousState=saveStateArrayList.get(saveStateArrayList.size()-1);

                try {
                    new WhiteMove(s).move(table, whitePlayerItems, blackPlayerItems);
                    setAllItems(table, whitePlayerItems, blackPlayerItems);
                    Cell myKingCell=table.getOpponentKingCell(WHITE, whitePlayerItems, blackPlayerItems,table);

                    //is Check to my king?
                    if(Move.isInAllItemsOfAvailableCellListBlack(myKingCell, blackPlayerItems,table))
                    {
                        System.out.println("Black player will Announce you Check and Mate");
                        //Undo Last Move
                        whitePlayerItems=previousState.getWhitePlayerItems();
                        blackPlayerItems=previousState.getBlackPlayerItems();

                        table.getCellByString(Character.toString(s.toCharArray()[0])+Character.toString(s.toCharArray()[1])).
                                setChessItem(previousState.getCellFrom().getChessItem());
                        table.getCellByString(Character.toString(s.toCharArray()[2])+Character.toString(s.toCharArray()[3])).
                                setChessItem(previousState.getCellTo().getChessItem());
                        setAllItems(table, whitePlayerItems, blackPlayerItems);
                        table.toString();
                        //Undo Last Move

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

                }
                if(nextToBlack)
                {
                    setAllItems(table, whitePlayerItems, blackPlayerItems);
                    //is Check or not
                    Cell kingCell=table.getOpponentKingCell(BLACK,whitePlayerItems,blackPlayerItems,table);
                    if(Move.isInAllItemsOfAvailableCellListWhite(kingCell, whitePlayerItems,table))
                    {
                        try {
                            throw new Check();
                        } catch (Check check) {
                            System.out.println("Check to Black Army");
                        }
                    }

                    break;
                }

            }
            /*while (!s.equals("exit")) //Black player's turn
            {
                boolean nextToWhite;
                nextToWhite=false;

                System.out.print("Black player's turn: ");
                s=reader.readLine();
                saveStateArrayList.add(new SaveState(s,whitePlayerItems,blackPlayerItems));
                SaveState previousState=saveStateArrayList.get(saveStateArrayList.size()-1);

                try {
                    new BlackMove(s).move(table, whitePlayerItems, blackPlayerItems);
                    setAllItems(table, whitePlayerItems, blackPlayerItems);
                    Cell myKingCell=getOpponentKingCell(BLACK, whitePlayerItems, blackPlayerItems);

                    //is Check to my king?
                    if(Move.isInAllItemsOfAvailableCellListWhite(myKingCell, whitePlayerItems))
                    {
                        System.out.println("White player will Announce you Check and Mate");
                        //Undo Last Move
                        whitePlayerItems=previousState.getWhitePlayerItems();
                        blackPlayerItems=previousState.getBlackPlayerItems();

                        getCellByString(Character.toString(s.toCharArray()[0])+Character.toString(s.toCharArray()[1])).
                                setChessItem(previousState.getCellFrom().getChessItem());
                        getCellByString(Character.toString(s.toCharArray()[2])+Character.toString(s.toCharArray()[3])).
                                setChessItem(previousState.getCellTo().getChessItem());
                        setAllItems(table, whitePlayerItems, blackPlayerItems);
                        table.toString();
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

                }
                if(nextToWhite)
                {
                    setAllItems(table, whitePlayerItems, blackPlayerItems);
                    //is Check or not
                    Cell kingCell=getOpponentKingCell(WHITE,whitePlayerItems,blackPlayerItems);
                    if(Move.isInAllItemsOfAvailableCellListBlack(kingCell, blackPlayerItems))
                    {
                        try {
                            throw new Check();
                        } catch (Check check) {
                            System.out.println("Check to White Army");
                        }

                    }
                    break;
                }

            }*/

        }
    }

    //Setting up all items on the table
    private static void setAllItems(Table table,Map<String, ChessItem> whitePlayerItems,Map<String, ChessItem> blackPlayerItems){

        for (SortedMap.Entry<String, Cell> cell : table.getAllCells().entrySet()) {
            for (Map.Entry<String, ChessItem> item : whitePlayerItems.entrySet()) {
                if (cell.getKey().equals(item.getKey())) {
                    cell.getValue().setChessItem(item.getValue());
                }
            }
            for (Map.Entry<String, ChessItem> item : blackPlayerItems.entrySet()) {
                if (cell.getKey().equals(item.getKey())) {
                    cell.getValue().setChessItem(item.getValue());
                }
            }

        }
    }

}

