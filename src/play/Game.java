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


    private static ArrayList<SaveState> saveStateArrayList=new ArrayList<>();





    public static void main(String[] args) throws IOException {

        //boolean whiteKingHasNoMoves=false;
        //boolean blackKingHasNoMoves=false;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        SortedMap<String,Cell> cells = null;
        SortedMap<String,Cell> cellsSave = null;

        ArrayList<ArrayList<Cell>> rows = null;
        ArrayList<ArrayList<Cell>> rowsSave = null;

        ArrayList<ArrayList<Cell>> columns = null;
        ArrayList<ArrayList<Cell>> columnsSave = null;

        WhitePlayer whitePlayer = new WhitePlayer();
        WhitePlayer whitePlayerSave = new WhitePlayer();

        BlackPlayer blackPlayer = new BlackPlayer();
        BlackPlayer blackPlayerSave = new BlackPlayer();

        ArrayList<Cell> rowsCells=new ArrayList<>();
        ArrayList<Cell> columnsCells=new ArrayList<>();

        Table table=new Table(cells,rows,rowsCells,columns,columnsCells,whitePlayer,blackPlayer);
        //Table tableSave=new Table(cellsSave,rowsSave,columnsSave,whitePlayerSave,blackPlayerSave);



        SortedMap<String, ChessItem> whiteItemsMapSave=new TreeMap<>(whitePlayer.getChessItemsMap());
        SortedMap<String, ChessItem> blackItemsMapSave=new TreeMap<>(blackPlayer.getChessItemsMap());
        /*tableSave.setCells(table.getCells());
        tableSave.setRows(table.getRows());
        tableSave.setColumns(table.getColumns());*/
        Table table1=new Table(table);
        table.toString();




        /*try {
          new WhiteMove("a2a4").move(table, whitePlayer, blackPlayer);

        } catch (PlayerSameChessItem playerSameChessItem) {
            playerSameChessItem.printStackTrace();
        } catch (EmptySourceCell emptySourceCell) {
            emptySourceCell.printStackTrace();
        } catch (InvalidSource invalidSource) {
            invalidSource.printStackTrace();
        } catch (NoCell noCell) {
            noCell.printStackTrace();
        } catch (InvalidMove invalidMove) {
            invalidMove.printStackTrace();
        } catch (NoAvailableCells noAvailableCells) {
            noAvailableCells.printStackTrace();
        } catch (InvalidMoveString invalidMoveString) {
            invalidMoveString.printStackTrace();
        }*/
        //table.toString();
       /* table.setCells(tableSave.getCells());
        table.setColumns(tableSave.getColumns());
        table.setRows(tableSave.getRows());
        whitePlayer.setChessItemsMap(whiteItemsMapSave);
        blackPlayer.setChessItemsMap(blackItemsMapSave);
        table.toString();*/






        /*//MAKING TABLE, DO NOT REMOVE---BEGIN
        table.setAllItems(whitePlayer, blackPlayer);
        table.toString();
        //MAKING TABLE, DO NOT REMOVE---END

        String s = "";
        s=reader.readLine();
        try {
            new WhiteMove(s).move(table, whitePlayer, blackPlayer);
        } catch (PlayerSameChessItem playerSameChessItem) {
            playerSameChessItem.printStackTrace();
        } catch (EmptySourceCell emptySourceCell) {
            emptySourceCell.printStackTrace();
        } catch (InvalidSource invalidSource) {
            invalidSource.printStackTrace();
        } catch (NoCell noCell) {
            noCell.printStackTrace();
        } catch (InvalidMove invalidMove) {
            invalidMove.printStackTrace();
        } catch (NoAvailableCells noAvailableCells) {
            noAvailableCells.printStackTrace();
        } catch (InvalidMoveString invalidMoveString) {
            invalidMoveString.printStackTrace();
        }
        table.toString();
        System.out.println(whitePlayer.getChessItemsMap().toString());
        System.out.println(whiteItemsMapCOPY.toString());
        whitePlayer.setChessItemsMap(whiteItemsMapCOPY);
        System.out.println(whitePlayer.getChessItemsMap().toString());
        System.out.println(tableTest.getCells().toString());

*/
        //TESTING PART----->Begin



        //TESTING PART----->End

        //Start play.Game


        /*while (!s.equals("exit"))
        {

            while (!s.equals("exit")) //White player's turn
            {
                boolean nextToBlack;
                nextToBlack=false;

                System.out.print("White player's turn: ");
                s=reader.readLine();
                whiteItemsMapTest.putAll(whiteItemsMap);
                blackItemsMapTest.putAll(blackItemsMap);
                saveStateArrayList.add(new SaveState(s,whiteItemsMapTest,blackItemsMapTest,table));
                SaveState previousState=saveStateArrayList.get(saveStateArrayList.size()-1);

                try {
                    new WhiteMove(s).move(table, whiteItemsMap, blackItemsMap);
                    table.setAllItems(whiteItemsMap, blackItemsMap);
                    Cell myKingCell=table.getOpponentKingCell(WHITE, whiteItemsMap, blackItemsMap,table);

                    //is Check to my king?
                    if(Move.isInAllItemsOfAvailableCellListBlack(myKingCell, blackItemsMap, table))
                    {
                        System.out.println("Black player will Announce you Check and Mate");
                        //Undo Last Move
                        whiteItemsMap=previousState.getwhiteItemsMap();
                        blackItemsMap=previousState.getblackItemsMap();

                        table.getCellByString(Character.toString(s.toCharArray()[0]) + Character.toString(s.toCharArray()[1])).
                                setChessItem(previousState.getCellFrom().getChessItem());
                        table.getCellByString(Character.toString(s.toCharArray()[2]) + Character.toString(s.toCharArray()[3])).
                                setChessItem(previousState.getCellTo().getChessItem());
                        table.setAllItems(whiteItemsMap, blackItemsMap);
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
                    table.setAllItems(whiteItemsMap, blackItemsMap);
                    //is Check or not
                    Cell kingCell=table.getOpponentKingCell(BLACK, whiteItemsMap, blackItemsMap, table);
                    if(Move.isInAllItemsOfAvailableCellListWhite(kingCell, whiteItemsMap,table))
                    {
                        try {
                            throw new Check();
                        } catch (Check check) {
                            System.out.println("Check to Black Army");
                        }

                        // is Mate or not
                        saveStateArrayList.add(new SaveState(s,whiteItemsMap,blackItemsMap,table));
                        previousState=saveStateArrayList.get(saveStateArrayList.size()-1);
                        previousState.getTable().toString();
                        SortedMap<Cell,Boolean> kingAvailableMovesMap=new TreeMap<>();
                        try {
                            ArrayList<Cell> kingAvailableCells=new BlackKingMoves(kingCell,table).getBlackKingMoves();

                                for (Cell cell : kingAvailableCells) {
                                    try {
                                        new BlackMove(kingCell.toString(), cell.toString()).move(table, whiteItemsMap, blackItemsMap);

                                        table.setAllItems(whiteItemsMap, blackItemsMap);
                                        table.toString();





                                        //table = previousState.getTable();
                                        whitePlayer.setChessItemsMap(previousState.getwhiteItemsMap());
                                        blackPlayer.setChessItemsMap(previousState.getblackItemsMap());
                                        System.out.println(whiteItemsMap.toString());
                                        System.out.println(blackItemsMap.toString());



                                    } catch (InvalidMove invalidMove) {
                                        invalidMove.printStackTrace();
                                    } catch (PlayerSameChessItem playerSameChessItem) {
                                        playerSameChessItem.printStackTrace();
                                    } catch (NoCell noCell) {
                                        noCell.printStackTrace();
                                    } catch (NoAvailableCells noAvailableCells) {
                                        noAvailableCells.printStackTrace();
                                    } catch (InvalidSource invalidSource) {
                                        invalidSource.printStackTrace();
                                    } catch (EmptySourceCell emptySourceCell) {
                                        emptySourceCell.printStackTrace();
                                    }
                                }


                        } catch (NoAvailableCells noAvailableCells) {
                            noAvailableCells.printStackTrace();
                        }


                    }

                    break;
                }

            }
            *//*while (!s.equals("exit")) //Black player's turn
            {
                boolean nextToWhite;
                nextToWhite=false;

                System.out.print("Black player's turn: ");
                s=reader.readLine();
                saveStateArrayList.add(new SaveState(s,whiteItemsMap,blackItemsMap));
                SaveState previousState=saveStateArrayList.get(saveStateArrayList.size()-1);

                try {
                    new BlackMove(s).move(table, whiteItemsMap, blackItemsMap);
                    setAllItems(table, whiteItemsMap, blackItemsMap);
                    Cell myKingCell=getOpponentKingCell(BLACK, whiteItemsMap, blackItemsMap);

                    //is Check to my king?
                    if(Move.isInAllItemsOfAvailableCellListWhite(myKingCell, whiteItemsMap))
                    {
                        System.out.println("White player will Announce you Check and Mate");
                        //Undo Last Move
                        whiteItemsMap=previousState.getwhiteItemsMap();
                        blackItemsMap=previousState.getblackItemsMap();

                        getCellByString(Character.toString(s.toCharArray()[0])+Character.toString(s.toCharArray()[1])).
                                setChessItem(previousState.getCellFrom().getChessItem());
                        getCellByString(Character.toString(s.toCharArray()[2])+Character.toString(s.toCharArray()[3])).
                                setChessItem(previousState.getCellTo().getChessItem());
                        setAllItems(table, whiteItemsMap, blackItemsMap);
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
                    setAllItems(table, whiteItemsMap, blackItemsMap);
                    //is Check or not
                    Cell kingCell=getOpponentKingCell(WHITE,whiteItemsMap,blackItemsMap);
                    if(Move.isInAllItemsOfAvailableCellListBlack(kingCell, blackItemsMap))
                    {
                        try {
                            throw new Check();
                        } catch (Check check) {
                            System.out.println("Check to White Army");
                        }

                    }
                    break;
                }

            }*//*

        }*/
    }



}

