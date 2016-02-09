package api.turns;

import api.chessboard.ChessBoard;
import api.chessitems.ChessItem;
import api.chessitems.black.*;
import api.chessboard.cells.Cell;
import api.colors.Black;
import api.exceptions.cell.EmptySourceCell;
import api.exceptions.cell.InvalidSource;
import api.exceptions.cell.NoCell;
import api.exceptions.chessitem.PlayerSameChessItem;
import api.exceptions.game.*;
import api.exceptions.moves.InvalidMove;
import api.exceptions.moves.InvalidMoveString;
import api.exceptions.moves.NoAvailableCells;
import javafx.scene.control.TextArea;
import api.moves.BlackMove;
import api.moves.Move;
import api.moves.WhiteMove;
import api.moves.available.black.moves.*;
import api.moves.available.test.move.BlackTestMove;
import api.players.BlackPlayer;
import api.players.WhitePlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedMap;

/**
 * Created by levon.gevorgyan on 27/01/16.
 */
public class WhiteTurn extends Turn {
    protected SaveState saveState;

    public SaveState getSaveState() {
        return saveState;
    }

    public WhiteTurn() {

    }

    @Override
    public void doMove(String s, ChessBoard chessBoard, WhitePlayer whitePlayer, BlackPlayer blackPlayer,
                       ArrayList<SaveState> saveStateArrayList, SaveState previousState,TextArea status)
            throws IOException, Mate, CheckIsOpen, CastlingDone, ChangePawn {

        //BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while (!s.equals("exit")) {
            saveStateArrayList.add(new SaveState(chessBoard, whitePlayer, blackPlayer));
            previousState = saveStateArrayList.get(saveStateArrayList.size() - 1);
            boolean nextToBlack=false;


            System.out.println("White player moves: "+s);
            //s = reader.readLine();

            try {

                new WhiteMove(s).move(chessBoard, whitePlayer, blackPlayer);

                Cell myKingCell =
                        chessBoard.getOpponentKingCell(WHITE, whitePlayer.getChessItemsMap(), blackPlayer.getChessItemsMap(), chessBoard);

                //is Check to my king?
                if (Move.isInAllItemsOfAvailableCellListBlack(myKingCell, blackPlayer.getChessItemsMap(), chessBoard)) {
                    System.out.println("Black player will Announce you Check and Mate");
                    //Undo Last Move
                    previousState.undoHere(chessBoard, whitePlayer, blackPlayer);
                    //Undo Last Move
                    chessBoard.toString();
                    throw new CheckIsOpen();
                }
                //chessBoard.toString();
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
                Cell kingCell = chessBoard.getOpponentKingCell(BLACK, whitePlayer.getChessItemsMap(), blackPlayer.getChessItemsMap(), chessBoard);
                if (Move.isInAllItemsOfAvailableCellListWhite(kingCell, whitePlayer.getChessItemsMap(), chessBoard)) {
                    try {
                        throw new Check();
                    } catch (Check check) {
                        System.out.println("Check to Black Army");
                        //is Mate or not?
                        ArrayList<BlackTestMove> blackTestMoves=new ArrayList<>();
                        saveStateArrayList.add(new SaveState(chessBoard, whitePlayer, blackPlayer));
                        previousState = saveStateArrayList.get(saveStateArrayList.size() - 1);

                        for(SortedMap.Entry<String, ChessItem> item:blackPlayer.getChessItemsMap().entrySet())
                        {
                            if(item.getValue() instanceof BlackKing)
                            {
                                try {
                                    for (Cell cell:new BlackKingMoves(chessBoard.getCellByString(item.getKey()), chessBoard,true)
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
                                    for (Cell cell:new BlackQueenMoves(chessBoard.getCellByString(item.getKey()), chessBoard).getMoves())
                                    {
                                        blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof BlackBishop)
                            {
                                try {
                                    for (Cell cell:new BlackBishopMoves(chessBoard.getCellByString(item.getKey()), chessBoard).getMoves())
                                    {
                                        blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof BlackKnight)
                            {
                                try {
                                    for (Cell cell:new BlackKnightMoves(chessBoard.getCellByString(item.getKey()), chessBoard).getMoves())
                                    {
                                        blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof BlackPawn)
                            {
                                try {
                                    for (Cell cell:new BlackPawnMoves(chessBoard.getCellByString(item.getKey()), chessBoard).getMoves())
                                    {
                                        blackTestMoves.add(new BlackTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof BlackRook)
                            {
                                try {
                                    for (Cell cell:new BlackRookMoves(chessBoard.getCellByString(item.getKey()), chessBoard).getMoves())
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
                                        new BlackMove(move.getSource(),move.getDestination()).move(chessBoard, whitePlayer, blackPlayer);

                                        if (!(Move.isInAllItemsOfAvailableCellListWhite(
                                                chessBoard.getCellByString(move.getDestination()), whitePlayer.getChessItemsMap(), chessBoard))) {
                                            availableMoves.add(move);
                                        }
                                        previousState.undoHere(chessBoard, whitePlayer, blackPlayer);
                                    }
                                    else
                                    {
                                        new BlackMove(move.getSource(),move.getDestination()).move(chessBoard, whitePlayer, blackPlayer);

                                        if (!(Move.isInAllItemsOfAvailableCellListWhite(kingCell, whitePlayer.getChessItemsMap(), chessBoard))) {
                                            availableMoves.add(move);
                                        }
                                        previousState.undoHere(chessBoard, whitePlayer, blackPlayer);
                                    }

                                }
                                if (availableMoves.size() == 0) {
                                    throw new Mate(BLACK);
                                } else {
                                    status.appendText("Available moves for black player are:\n");
                                    System.out.println("Available moves for black player are:");
                                    for(BlackTestMove move:availableMoves){
                                        status.appendText(move.toString() + "\n");
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
                saveState=new SaveState(chessBoard,whitePlayer,blackPlayer);
                chessBoard.toString();
                break;
            }
        }


    }
}
