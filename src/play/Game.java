package play;

import chessitems.ChessItem;
import chessitems.WhiteItem;
import chessitems.black.BlackKing;
import chessitems.white.WhiteKing;
import chesstable.cells.Cell;
import chesstable.Table;
import chesstable.cells.Letters;

import colors.Colors;
import exceptions.cell.EmptySourceCell;
import exceptions.cell.InvalidSource;
import exceptions.cell.NoCell;
import exceptions.cell.NotEmptyCell;
import exceptions.chessitem.PlayerSameChessItem;
import exceptions.game.Check;
import exceptions.game.Mate;
import exceptions.moves.InvalidMove;
import exceptions.moves.InvalidMoveString;
import exceptions.moves.NoAvailableCells;
import exceptions.table.OutOfTable;
import moves.BlackMove;
import moves.Move;
import moves.WhiteMove;
import moves.available.black.moves.BlackKingMoves;
import moves.available.white.moves.WhiteKingMoves;
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

        boolean whiteKingHasNoMoves=false;
        boolean blackKingHasNoMoves=false;

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
        try {
            while (!s.equals("exit")) {

                //White player's turn
                while (!s.equals("exit")) {
                    saveStateArrayList.add(new SaveState(table, whitePlayer, blackPlayer));
                    previousState = saveStateArrayList.get(saveStateArrayList.size() - 1);
                    boolean nextToBlack;
                    nextToBlack = false;

                    System.out.print("White player's turn: ");
                    s = reader.readLine();

                    try {

                        new WhiteMove(s).move(table, whitePlayer, blackPlayer);

                        Cell myKingCell =
                                table.getOpponentKingCell(WHITE, whitePlayer.getChessItemsMap(), blackPlayer.getChessItemsMap(), table);

                        //is Check to my king?
                        if (Move.isInAllItemsOfAvailableCellListBlack(myKingCell, blackPlayer.getChessItemsMap(), table)) {
                            System.out.println("Black player will Announce you Check and Mate");

                            //Undo Last Move
                            previousState.undoHere(table, whitePlayer, blackPlayer);
                            //Undo Last Move
                            table.toString();
                            throw new Check();
                        }
                        table.toString();
                        nextToBlack = true;
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
                    if (nextToBlack) {
                        //is Check or not
                        Cell kingCell = table.getOpponentKingCell(BLACK, whitePlayer.getChessItemsMap(), blackPlayer.getChessItemsMap(), table);
                        if (Move.isInAllItemsOfAvailableCellListWhite(kingCell, whitePlayer.getChessItemsMap(), table)) {
                            try {
                                throw new Check();
                            } catch (Check check) {
                                System.out.println("Check to Black Army");
                                saveStateArrayList.add(new SaveState(table, whitePlayer, blackPlayer));
                                previousState = saveStateArrayList.get(saveStateArrayList.size() - 1);
                                BlackKingMoves kingMoves = new BlackKingMoves(kingCell, table);
                                ArrayList<Cell> blackNonMateCells = new ArrayList<>();


                                try {
                                    ArrayList<Cell> moves = kingMoves.getBlackKingMoves();
                                    if (moves.size() > 0) {
                                        for (Cell cell : moves) {
                                            new BlackMove(kingCell.toString(), cell.toString()).move(table, whitePlayer, blackPlayer);
                                            //table.toString();
                                            if (!(Move.isInAllItemsOfAvailableCellListWhite(cell, whitePlayer.getChessItemsMap(), table))) {
                                                blackNonMateCells.add(cell);
                                            }

                                            previousState.undoHere(table, whitePlayer, blackPlayer);
                                            //table.toString();
                                        }
                                        if (blackNonMateCells.size() == 0) {
                                            throw new NoAvailableCells();
                                        } else {
                                            System.out.print("Available Moves for black king are: |");
                                            for (Cell cell1: blackNonMateCells) {
                                                System.out.print(cell1 + "|");
                                            }
                                            System.out.println("");
                                        }
                                    }
                                } catch (NoAvailableCells noAvailableCells) {
                                    System.out.print("Is Check-Mate to black? (yes/no): ");
                                    String answer="";

                                    while (!(answer.toLowerCase().equals("yes"))||answer.toLowerCase().equals("no"))
                                    {
                                        answer=reader.readLine();
                                        if(answer.equals("yes"))
                                        {
                                            throw new Mate(BLACK);
                                        }
                                        else if(answer.equals("no"))
                                        {
                                            break;
                                        }
                                        else
                                        {
                                            System.out.print("You have mistyped. Try again: ");
                                        }
                                    }


                                } catch (NoCell noCell) {

                                } catch (InvalidMove invalidMove) {

                                } catch (PlayerSameChessItem playerSameChessItem) {

                                } catch (EmptySourceCell emptySourceCell) {

                                } catch (InvalidSource invalidSource) {

                                }
                            }
                        }

                        table.toString();
                        break;
                    }
                }


                while (!s.equals("exit")) //Black player's turn
                {
                    saveStateArrayList.add(new SaveState(table, whitePlayer, blackPlayer));
                    previousState = saveStateArrayList.get(saveStateArrayList.size() - 1);
                    boolean nextToWhite;
                    nextToWhite = false;

                    System.out.print("Black player's turn: ");
                    s = reader.readLine();

                    try {

                        new BlackMove(s).move(table, whitePlayer, blackPlayer);

                        Cell myKingCell =
                                table.getOpponentKingCell(BLACK, whitePlayer.getChessItemsMap(), blackPlayer.getChessItemsMap(), table);

                        //is Check to my king?
                        if (Move.isInAllItemsOfAvailableCellListWhite(myKingCell, whitePlayer.getChessItemsMap(), table)) {
                            System.out.println("White player will Announce you Check and Mate");
                            //Undo Last Move
                            previousState.undoHere(table, whitePlayer, blackPlayer);
                            //Undo Last Move

                            throw new Check();
                        }
                        table.toString();
                        nextToWhite = true;
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
                    if (nextToWhite) {
                        //is Check or not
                        Cell kingCell = table.getOpponentKingCell(WHITE, whitePlayer.getChessItemsMap(), blackPlayer.getChessItemsMap(), table);
                        if (Move.isInAllItemsOfAvailableCellListBlack(kingCell, blackPlayer.getChessItemsMap(), table)) {
                            try {
                                throw new Check();
                            } catch (Check check) {
                                System.out.println("Check to White Army");
                                saveStateArrayList.add(new SaveState(table, whitePlayer, blackPlayer));
                                previousState = saveStateArrayList.get(saveStateArrayList.size() - 1);
                                WhiteKingMoves kingMoves = new WhiteKingMoves(kingCell, table);
                                ArrayList<Cell> whiteNonMateCells = new ArrayList<>();


                                try {
                                    ArrayList<Cell> moves = kingMoves.getWhiteKingMoves();
                                    if (moves.size() > 0) {
                                        for (Cell cell : moves) {
                                            new WhiteMove(kingCell.toString(), cell.toString()).move(table, whitePlayer, blackPlayer);
                                            //table.toString();
                                            if (!(Move.isInAllItemsOfAvailableCellListBlack(cell, blackPlayer.getChessItemsMap(), table))) {
                                                whiteNonMateCells.add(cell);
                                            }

                                            previousState.undoHere(table, whitePlayer, blackPlayer);
                                            //table.toString();
                                        }
                                        if (whiteNonMateCells.size() == 0) {
                                            throw new NoAvailableCells();
                                        } else {
                                            System.out.print("Available Moves for white king are: |");
                                            for (Cell cell1: whiteNonMateCells) {
                                                System.out.print(cell1 + "|");
                                            }
                                            System.out.println("");
                                        }
                                    }
                                } catch (NoAvailableCells noAvailableCells) {
                                    System.out.print("Is Check-Mate to white? (yes/no): ");
                                    String answer="";

                                    while (!(answer.toLowerCase().equals("yes"))||answer.toLowerCase().equals("no"))
                                    {
                                        answer=reader.readLine();
                                        if(answer.equals("yes"))
                                        {
                                            throw new Mate(WHITE);
                                        }
                                        else if(answer.equals("no"))
                                        {
                                            break;
                                        }
                                        else
                                        {
                                            System.out.print("You have mistyped. Try again: ");
                                        }
                                    }


                                } catch (NoCell noCell) {

                                } catch (InvalidMove invalidMove) {

                                } catch (PlayerSameChessItem playerSameChessItem) {

                                } catch (EmptySourceCell emptySourceCell) {

                                } catch (InvalidSource invalidSource) {

                                }
                            }
                        }

                        table.toString();
                        break;
                    }

                }

            }
        }
        catch (Mate mate)
        {
            System.out.println("Game is over");
        }
    }



}

/* TEST
SortedMap<String,ArrayList<Cell>> otherChessItemsCell=new TreeMap<>();
                                SortedMap<String,ArrayList<ChessItem>> listSortedMap=new TreeMap<>();


                                try {
                                    if(Move.moveUpUntilNotEmpty(kingCell,table).size()>0)
                                    {
                                        ArrayList<Cell> list=new ArrayList<>();
                                        list.addAll(Move.moveUpUntilNotEmpty(kingCell, table));
                                        if (table.upCell(list.get(list.size()-1)).getChessItem() instanceof WhiteItem)
                                        {
                                            list.add(table.upCell(list.get(list.size()-1)));
                                        }
                                        otherChessItemsCell.put("UP",list);
                                    }
                                } catch (OutOfTable outOfTable) {

                                } catch (NoCell noCell) {

                                } catch (NotEmptyCell notEmptyCell) {

                                }
                                try {
                                    if(Move.moveDownUntilNotEmpty(kingCell, table).size()>0)
                                    {
                                        ArrayList<Cell> list=new ArrayList<>();
                                        list.addAll(Move.moveDownUntilNotEmpty(kingCell, table));
                                        if (table.downCell(list.get(list.size() - 1)).getChessItem() instanceof WhiteItem)
                                        {
                                            list.add(table.downCell(list.get(list.size() - 1)));
                                        }
                                        otherChessItemsCell.put("DOWN",list);
                                    }
                                } catch (OutOfTable outOfTable) {

                                } catch (NoCell noCell) {

                                } catch (NotEmptyCell notEmptyCell) {

                                }
                                try {
                                    if(Move.moveLeftUntilNotEmpty(kingCell, table).size()>0)
                                    {
                                        ArrayList<Cell> list=new ArrayList<>();
                                        list.addAll(Move.moveLeftUntilNotEmpty(kingCell, table));
                                        if (table.leftCell(list.get(list.size() - 1)).getChessItem() instanceof WhiteItem)
                                        {
                                            list.add(table.leftCell(list.get(list.size() - 1)));
                                        }
                                        otherChessItemsCell.put("LEFT",list);
                                    }
                                } catch (OutOfTable outOfTable) {

                                } catch (NoCell noCell) {

                                } catch (NotEmptyCell notEmptyCell) {

                                }
                                try {
                                    if(Move.moveRightUntilNotEmpty(kingCell, table).size()>0)
                                    {
                                        ArrayList<Cell> list=new ArrayList<>();
                                        list.addAll(Move.moveRightUntilNotEmpty(kingCell, table));
                                        if (table.rightCell(list.get(list.size() - 1)).getChessItem() instanceof WhiteItem)
                                        {
                                            list.add(table.rightCell(list.get(list.size() - 1)));
                                        }
                                        otherChessItemsCell.put("RIGHT",list);
                                    }
                                } catch (OutOfTable outOfTable) {

                                } catch (NoCell noCell) {

                                } catch (NotEmptyCell notEmptyCell) {

                                }
                                try {
                                    if(Move.moveDiagLeftDownUntilNotEmpty(kingCell, table).size()>0)
                                    {
                                        ArrayList<Cell> list=new ArrayList<>();
                                        list.addAll(Move.moveDiagLeftDownUntilNotEmpty(kingCell, table));
                                        if (table.diagonalLeftDownCell(list.get(list.size() - 1)).getChessItem() instanceof WhiteItem)
                                        {
                                            list.add(table.diagonalLeftDownCell(list.get(list.size() - 1)));
                                        }
                                        otherChessItemsCell.put("LEFT-DOWN",list);
                                    }
                                } catch (OutOfTable outOfTable) {

                                } catch (NoCell noCell) {

                                } catch (NotEmptyCell notEmptyCell) {

                                }
                                try {
                                    if(Move.moveDiagLeftUpUntilNotEmpty(kingCell, table).size()>0)
                                    {
                                        ArrayList<Cell> list=new ArrayList<>();
                                        list.addAll(Move.moveDiagLeftUpUntilNotEmpty(kingCell, table));
                                        if (table.diagonalLeftUpCell(list.get(list.size() - 1)).getChessItem() instanceof WhiteItem)
                                        {
                                            list.add(table.diagonalLeftUpCell(list.get(list.size() - 1)));
                                        }
                                        otherChessItemsCell.put("LEFT-UP",list);
                                    }
                                } catch (OutOfTable outOfTable) {

                                } catch (NoCell noCell) {

                                } catch (NotEmptyCell notEmptyCell) {

                                }
                                try {
                                    if(Move.moveDiagRightDownUntilNotEmpty(kingCell, table).size()>0)
                                    {
                                        ArrayList<Cell> list=new ArrayList<>();
                                        list.addAll(Move.moveDiagRightDownUntilNotEmpty(kingCell, table));
                                        if (table.diagonalRightDownCell(list.get(list.size() - 1)).getChessItem() instanceof WhiteItem)
                                        {
                                            list.add(table.diagonalRightDownCell(list.get(list.size() - 1)));
                                        }
                                        otherChessItemsCell.put("RIGHT-DOWN",list);
                                    }
                                } catch (OutOfTable outOfTable) {

                                } catch (NoCell noCell) {

                                } catch (NotEmptyCell notEmptyCell) {

                                }
                                try {
                                    if(Move.moveDiagRightUpUntilNotEmpty(kingCell, table).size()>0)
                                    {
                                        ArrayList<Cell> list=new ArrayList<>();
                                        list.addAll(Move.moveDiagRightUpUntilNotEmpty(kingCell, table));
                                        if (table.diagonalRightUpCell(list.get(list.size() - 1)).getChessItem() instanceof WhiteItem)
                                        {
                                            list.add(table.diagonalRightUpCell(list.get(list.size() - 1)));
                                        }
                                        otherChessItemsCell.put("RIGHT-UP",list);
                                    }
                                } catch (OutOfTable outOfTable) {

                                } catch (NoCell noCell) {

                                } catch (NotEmptyCell notEmptyCell) {

                                }
                                */