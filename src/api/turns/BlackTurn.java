package api.turns;

import api.chessboard.ChessBoard;
import api.chessitems.ChessItem;
import api.chessitems.white.*;
import api.chessboard.cells.Cell;
import api.colors.White;
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
import api.moves.available.test.move.WhiteTestMove;
import api.moves.available.white.moves.*;
import api.players.BlackPlayer;
import api.players.WhitePlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedMap;

/**
 * Created by levon.gevorgyan on 27/01/16.
 */
public class BlackTurn extends Turn {
    protected SaveState saveState;

    public SaveState getSaveState() {
        return saveState;
    }

    public BlackTurn() {

    }

    @Override
    public void doMove(String s, ChessBoard chessBoard, WhitePlayer whitePlayer, BlackPlayer blackPlayer,
                       ArrayList<SaveState> saveStateArrayList, SaveState previousState,TextArea status)
            throws IOException, Mate, CheckIsOpen, CastlingDone, ChangePawn {
        //BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while (!s.equals("exit")) {
            saveStateArrayList.add(new SaveState(chessBoard, whitePlayer, blackPlayer));
            previousState = saveStateArrayList.get(saveStateArrayList.size() - 1);
            boolean nextToWhite=false;


            System.out.println("Black player moves: "+s);
            //s = reader.readLine();

            try {

                new BlackMove(s).move(chessBoard, whitePlayer, blackPlayer);

                Cell myKingCell =
                        chessBoard.getOpponentKingCell(BLACK, whitePlayer.getChessItemsMap(), blackPlayer.getChessItemsMap(), chessBoard);

                //is Check to my king?
                if (Move.isInAllItemsOfAvailableCellListWhite(myKingCell, whitePlayer.getChessItemsMap(), chessBoard)) {
                    System.out.println("White player will Announce you Check and Mate");
                    //Undo Last Move
                    previousState.undoHere(chessBoard, whitePlayer, blackPlayer);
                    //Undo Last Move
                    chessBoard.toString();
                    throw new CheckIsOpen();
                }
                //chessBoard.toString();
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
            } /*catch (Check check) {

            }*/
            if (nextToWhite) {
                //is Check or not?
                Cell kingCell = chessBoard.getOpponentKingCell(WHITE, whitePlayer.getChessItemsMap(), blackPlayer.getChessItemsMap(), chessBoard);
                if (Move.isInAllItemsOfAvailableCellListBlack(kingCell, blackPlayer.getChessItemsMap(), chessBoard)) {
                    try {
                        throw new Check();
                    } catch (Check check) {
                        System.out.println("Check to White Army");
                        //is Mate or not?
                        ArrayList<WhiteTestMove> whiteTestMoves=new ArrayList<>();
                        saveStateArrayList.add(new SaveState(chessBoard, whitePlayer, blackPlayer));
                        previousState = saveStateArrayList.get(saveStateArrayList.size() - 1);

                        for(SortedMap.Entry<String, ChessItem> item:whitePlayer.getChessItemsMap().entrySet())
                        {
                            if(item.getValue() instanceof WhiteKing)
                            {
                                try {
                                    for (Cell cell:new WhiteKingMoves(chessBoard.getCellByString(item.getKey()), chessBoard,true)
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
                                    for (Cell cell:new WhiteQueenMoves(chessBoard.getCellByString(item.getKey()), chessBoard).getMoves())
                                    {
                                        whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof WhiteBishop)
                            {
                                try {
                                    for (Cell cell:new WhiteBishopMoves(chessBoard.getCellByString(item.getKey()), chessBoard).getMoves())
                                    {
                                        whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof WhiteKnight)
                            {
                                try {
                                    for (Cell cell:new WhiteKnightMoves(chessBoard.getCellByString(item.getKey()), chessBoard).getMoves())
                                    {
                                        whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof WhitePawn)
                            {
                                try {
                                    for (Cell cell:new WhitePawnMoves(chessBoard.getCellByString(item.getKey()), chessBoard).getMoves())
                                    {
                                        whiteTestMoves.add(new WhiteTestMove(item.getValue().toString(),item.getKey(),cell.toString()));
                                    }
                                } catch (NoAvailableCells noAvailableCells) {

                                }
                            }
                            if(item.getValue() instanceof WhiteRook)
                            {
                                try {
                                    for (Cell cell:new WhiteRookMoves(chessBoard.getCellByString(item.getKey()), chessBoard).getMoves())
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
                                        new WhiteMove(move.getSource(),move.getDestination()).move(chessBoard, whitePlayer, blackPlayer);

                                        if (!(Move.isInAllItemsOfAvailableCellListBlack(
                                                chessBoard.getCellByString(move.getDestination()), blackPlayer.getChessItemsMap(), chessBoard))) {
                                            availableMoves.add(move);
                                        }
                                        previousState.undoHere(chessBoard, whitePlayer, blackPlayer);
                                    }
                                    else
                                    {
                                        new WhiteMove(move.getSource(),move.getDestination()).move(chessBoard, whitePlayer, blackPlayer);

                                        if (!(Move.isInAllItemsOfAvailableCellListBlack(kingCell, blackPlayer.getChessItemsMap(), chessBoard))) {
                                            availableMoves.add(move);
                                        }
                                        previousState.undoHere(chessBoard, whitePlayer, blackPlayer);
                                    }

                                }
                                if (availableMoves.size() == 0) {
                                    throw new Mate(WHITE);
                                } else {
                                    status.appendText("Available moves for white player are:\n");
                                    System.out.println("Available moves for white player are:");
                                    for(WhiteTestMove move:availableMoves){
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
