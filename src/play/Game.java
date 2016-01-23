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
                        //is Check or not?
                        Cell kingCell = table.getOpponentKingCell(BLACK, whitePlayer.getChessItemsMap(), blackPlayer.getChessItemsMap(), table);
                        if (Move.isInAllItemsOfAvailableCellListWhite(kingCell, whitePlayer.getChessItemsMap(), table)) {
                            try {
                                throw new Check();
                            } catch (Check check) {
                                System.out.println("Check to Black Army");
                                //is Mate or not?
                                ArrayList<BlackTestMove> blackTestMoves=new ArrayList<>();
                                saveStateArrayList.add(new SaveState(table, whitePlayer, blackPlayer));
                                previousState = saveStateArrayList.get(saveStateArrayList.size() - 1);

                                for(SortedMap.Entry<String,ChessItem> item:blackPlayer.getChessItemsMap().entrySet())
                                {
                                    if(item.getValue() instanceof BlackKing)
                                    {
                                        try {
                                            for (Cell cell:new BlackKingMoves(table.getCellByString(item.getKey()), table,true)
                                                    .getBlackKingMoves())
                                            {
                                                blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                            }
                                        } catch (NoAvailableCells noAvailableCells) {

                                        }
                                    }
                                    if(item.getValue() instanceof BlackQueen)
                                    {
                                        try {
                                            for (Cell cell:new BlackQueenMoves(table.getCellByString(item.getKey()), table).getBlackQueenMoves())
                                            {
                                                blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                            }
                                        } catch (NoAvailableCells noAvailableCells) {

                                        }
                                    }
                                    if(item.getValue() instanceof BlackBishop)
                                    {
                                        try {
                                            for (Cell cell:new BlackBishopMoves(table.getCellByString(item.getKey()), table).getBlackBishopMoves())
                                            {
                                                blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                            }
                                        } catch (NoAvailableCells noAvailableCells) {

                                        }
                                    }
                                    if(item.getValue() instanceof BlackKnight)
                                    {
                                        try {
                                            for (Cell cell:new BlackKnightMoves(table.getCellByString(item.getKey()), table).getBlackKnightMoves())
                                            {
                                                blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                            }
                                        } catch (NoAvailableCells noAvailableCells) {

                                        }
                                    }
                                    if(item.getValue() instanceof BlackPawn)
                                    {
                                        try {
                                            for (Cell cell:new BlackPawnMoves(table.getCellByString(item.getKey()), table).getBlackPawnMoves())
                                            {
                                                blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                            }
                                        } catch (NoAvailableCells noAvailableCells) {

                                        }
                                    }
                                    if(item.getValue() instanceof BlackRook)
                                    {
                                        try {
                                            for (Cell cell:new BlackRookMoves(table.getCellByString(item.getKey()), table).getBlackRookMoves())
                                            {
                                                blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                            }
                                        } catch (NoAvailableCells noAvailableCells) {

                                        }
                                    }
                                }


                                ArrayList<BlackTestMove> availableMoves=new ArrayList<>();
                                try {


                                    if (blackTestMoves.size() > 0) {
                                        for (BlackTestMove move : blackTestMoves) {
                                            if(move.getChessItem().equals(Black.KING))
                                            {
                                                new BlackMove(move.getSource(),move.getDestination()).move(table, whitePlayer, blackPlayer);

                                                if (!(Move.isInAllItemsOfAvailableCellListWhite(
                                                        table.getCellByString(move.getDestination()), whitePlayer.getChessItemsMap(), table))) {
                                                    availableMoves.add(move);
                                                }
                                                previousState.undoHere(table, whitePlayer, blackPlayer);
                                            }
                                            else
                                            {
                                                new BlackMove(move.getSource(),move.getDestination()).move(table, whitePlayer, blackPlayer);

                                                if (!(Move.isInAllItemsOfAvailableCellListWhite(kingCell, whitePlayer.getChessItemsMap(), table))) {
                                                    availableMoves.add(move);
                                                }
                                                previousState.undoHere(table, whitePlayer, blackPlayer);
                                            }

                                        }
                                        if (availableMoves.size() == 0) {
                                            throw new Mate(BLACK);
                                        } else {
                                            System.out.println("Available moves for black player are:");
                                            for(BlackTestMove move:availableMoves){
                                                System.out.println(move.toString());
                                            }
                                        }
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

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


                //Black player's turn
                while (!s.equals("exit")) {
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
                            table.toString();
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
                        //is Check or not?
                        Cell kingCell = table.getOpponentKingCell(WHITE, whitePlayer.getChessItemsMap(), blackPlayer.getChessItemsMap(), table);
                        if (Move.isInAllItemsOfAvailableCellListBlack(kingCell, blackPlayer.getChessItemsMap(), table)) {
                            try {
                                throw new Check();
                            } catch (Check check) {
                                System.out.println("Check to White Army");
                                //is Mate or not?
                                ArrayList<WhiteTestMove> whiteTestMoves=new ArrayList<>();
                                saveStateArrayList.add(new SaveState(table, whitePlayer, blackPlayer));
                                previousState = saveStateArrayList.get(saveStateArrayList.size() - 1);

                                for(SortedMap.Entry<String,ChessItem> item:whitePlayer.getChessItemsMap().entrySet())
                                {
                                    if(item.getValue() instanceof WhiteKing)
                                    {
                                        try {
                                            for (Cell cell:new WhiteKingMoves(table.getCellByString(item.getKey()), table,true)
                                                    .getWhiteKingMoves())
                                            {
                                                whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                            }
                                        } catch (NoAvailableCells noAvailableCells) {

                                        }
                                    }
                                    if(item.getValue() instanceof WhiteQueen)
                                    {
                                        try {
                                            for (Cell cell:new WhiteQueenMoves(table.getCellByString(item.getKey()), table).getWhiteQueenMoves())
                                            {
                                                whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                            }
                                        } catch (NoAvailableCells noAvailableCells) {

                                        }
                                    }
                                    if(item.getValue() instanceof WhiteBishop)
                                    {
                                        try {
                                            for (Cell cell:new WhiteBishopMoves(table.getCellByString(item.getKey()), table).getWhiteBishopMoves())
                                            {
                                                whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                            }
                                        } catch (NoAvailableCells noAvailableCells) {

                                        }
                                    }
                                    if(item.getValue() instanceof WhiteKnight)
                                    {
                                        try {
                                            for (Cell cell:new WhiteKnightMoves(table.getCellByString(item.getKey()), table).getWhiteKnightMoves())
                                            {
                                                whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                            }
                                        } catch (NoAvailableCells noAvailableCells) {

                                        }
                                    }
                                    if(item.getValue() instanceof WhitePawn)
                                    {
                                        try {
                                            for (Cell cell:new WhitePawnMoves(table.getCellByString(item.getKey()), table).getWhitePawnMoves())
                                            {
                                                whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                            }
                                        } catch (NoAvailableCells noAvailableCells) {

                                        }
                                    }
                                    if(item.getValue() instanceof WhiteRook)
                                    {
                                        try {
                                            for (Cell cell:new WhiteRookMoves(table.getCellByString(item.getKey()), table).getWhiteRookMoves())
                                            {
                                                whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                            }
                                        } catch (NoAvailableCells noAvailableCells) {

                                        }
                                    }
                                }


                                ArrayList<WhiteTestMove> availableMoves=new ArrayList<>();
                                try {


                                    if (whiteTestMoves.size() > 0) {
                                        for (WhiteTestMove move : whiteTestMoves) {
                                            if(move.getChessItem().equals(White.KING))
                                            {
                                                new WhiteMove(move.getSource(),move.getDestination()).move(table, whitePlayer, blackPlayer);

                                                if (!(Move.isInAllItemsOfAvailableCellListBlack(
                                                        table.getCellByString(move.getDestination()), blackPlayer.getChessItemsMap(), table))) {
                                                    availableMoves.add(move);
                                                }
                                                previousState.undoHere(table, whitePlayer, blackPlayer);
                                            }
                                            else
                                            {
                                                new WhiteMove(move.getSource(),move.getDestination()).move(table, whitePlayer, blackPlayer);

                                                if (!(Move.isInAllItemsOfAvailableCellListBlack(kingCell, blackPlayer.getChessItemsMap(), table))) {
                                                    availableMoves.add(move);
                                                }
                                                previousState.undoHere(table, whitePlayer, blackPlayer);
                                            }

                                        }
                                        if (availableMoves.size() == 0) {
                                            throw new Mate(WHITE);
                                        } else {
                                            System.out.println("Available moves for white player are:");
                                            for(WhiteTestMove move:availableMoves){
                                                System.out.println(move.toString());
                                            }
                                        }
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

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