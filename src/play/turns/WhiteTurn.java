package play.turns;

import chessitems.ChessItem;
import chessitems.black.*;
import chesstable.Table;
import chesstable.cells.Cell;
import colors.Black;
import exceptions.cell.EmptySourceCell;
import exceptions.cell.InvalidSource;
import exceptions.cell.NoCell;
import exceptions.chessitem.PlayerSameChessItem;
import exceptions.game.CastlingDone;
import exceptions.game.Check;
import exceptions.game.CheckIsOpen;
import exceptions.game.Mate;
import exceptions.moves.InvalidMove;
import exceptions.moves.InvalidMoveString;
import exceptions.moves.NoAvailableCells;
import moves.BlackMove;
import moves.Move;
import moves.WhiteMove;
import moves.available.black.moves.*;
import moves.available.test.move.BlackTestMove;
import play.SaveState;
import players.BlackPlayer;
import players.WhitePlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.SortedMap;

/**
 * Created by levon.gevorgyan on 27/01/16.
 */
public class WhiteTurn extends Turn {
    private SaveState saveState;

    public SaveState getSaveState() {
        return saveState;
    }

    public WhiteTurn() {

    }

    @Override
    public void doMove(String s, Table table, WhitePlayer whitePlayer, BlackPlayer blackPlayer,
                       ArrayList<SaveState> saveStateArrayList, SaveState previousState)
            throws IOException, Mate, CheckIsOpen, CastlingDone {

        //BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while (!s.equals("exit")) {
            saveStateArrayList.add(new SaveState(table, whitePlayer, blackPlayer));
            previousState = saveStateArrayList.get(saveStateArrayList.size() - 1);
            boolean nextToBlack=false;


            System.out.println("White player moves: "+s);
            //s = reader.readLine();

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
                    throw new CheckIsOpen();
                }
                //table.toString();
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
            } /*catch (Check check) {

            }*/
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

                        for(SortedMap.Entry<String, ChessItem> item:blackPlayer.getChessItemsMap().entrySet())
                        {
                            if(item.getValue() instanceof BlackKing)
                            {
                                try {
                                    for (Cell cell:new BlackKingMoves(table.getCellByString(item.getKey()), table,true)
                                            .getMoves())
                                    {
                                        blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof BlackQueen)
                            {
                                try {
                                    for (Cell cell:new BlackQueenMoves(table.getCellByString(item.getKey()), table).getMoves())
                                    {
                                        blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof BlackBishop)
                            {
                                try {
                                    for (Cell cell:new BlackBishopMoves(table.getCellByString(item.getKey()), table).getMoves())
                                    {
                                        blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof BlackKnight)
                            {
                                try {
                                    for (Cell cell:new BlackKnightMoves(table.getCellByString(item.getKey()), table).getMoves())
                                    {
                                        blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof BlackPawn)
                            {
                                try {
                                    for (Cell cell:new BlackPawnMoves(table.getCellByString(item.getKey()), table).getMoves())
                                    {
                                        blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof BlackRook)
                            {
                                try {
                                    for (Cell cell:new BlackRookMoves(table.getCellByString(item.getKey()), table).getMoves())
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
                saveState=new SaveState(table,whitePlayer,blackPlayer);
                table.toString();
                break;
            }
        }


    }
}
