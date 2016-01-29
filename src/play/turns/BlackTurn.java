package play.turns;

import chessitems.ChessItem;
import chessitems.white.*;
import chesstable.Table;
import chesstable.cells.Cell;
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
import moves.available.test.move.WhiteTestMove;
import moves.available.white.moves.*;
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
public class BlackTurn extends Turn {
    private SaveState saveState;

    public SaveState getSaveState() {
        return saveState;
    }

    public BlackTurn() {

    }

    @Override
    public void doMove(String s, Table table, WhitePlayer whitePlayer, BlackPlayer blackPlayer,
                       ArrayList<SaveState> saveStateArrayList, SaveState previousState, boolean nextToWhite) throws IOException, Mate {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while (!s.equals("exit")) {
            saveStateArrayList.add(new SaveState(table, whitePlayer, blackPlayer));
            previousState = saveStateArrayList.get(saveStateArrayList.size() - 1);



            System.out.println("Black player's turns: ");
            //s = reader.readLine();

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

                        for(SortedMap.Entry<String, ChessItem> item:whitePlayer.getChessItemsMap().entrySet())
                        {
                            if(item.getValue() instanceof WhiteKing)
                            {
                                try {
                                    for (Cell cell:new WhiteKingMoves(table.getCellByString(item.getKey()), table,true)
                                            .getMoves())
                                    {
                                        whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof WhiteQueen)
                            {
                                try {
                                    for (Cell cell:new WhiteQueenMoves(table.getCellByString(item.getKey()), table).getMoves())
                                    {
                                        whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof WhiteBishop)
                            {
                                try {
                                    for (Cell cell:new WhiteBishopMoves(table.getCellByString(item.getKey()), table).getMoves())
                                    {
                                        whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof WhiteKnight)
                            {
                                try {
                                    for (Cell cell:new WhiteKnightMoves(table.getCellByString(item.getKey()), table).getMoves())
                                    {
                                        whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof WhitePawn)
                            {
                                try {
                                    for (Cell cell:new WhitePawnMoves(table.getCellByString(item.getKey()), table).getMoves())
                                    {
                                        whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof WhiteRook)
                            {
                                try {
                                    for (Cell cell:new WhiteRookMoves(table.getCellByString(item.getKey()), table).getMoves())
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
        saveState=new SaveState(table,whitePlayer,blackPlayer);

    }
}
