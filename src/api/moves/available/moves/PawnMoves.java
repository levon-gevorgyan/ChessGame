package api.moves.available.moves;

import api.chessboard.ChessBoard;
import api.chessboard.cells.Cell;
import api.exceptions.cell.NoCell;
import api.exceptions.table.OutOfTable;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public abstract class PawnMoves extends AvailableMoves {

    //White Pawn
    protected ArrayList<Cell> getWhitePawnMove(Cell cell, ChessBoard ChessBoard) {
        ArrayList<Cell> whitePawnMove = new ArrayList<>();
        try {
            whitePawnMove.add(ChessBoard.upCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }
        return whitePawnMove;
    }

    protected ArrayList<Cell> getWhitePawnEatMoves(Cell cell, ChessBoard ChessBoard) {
        ArrayList<Cell> whitePawnEatMoves = new ArrayList<>();
        {
            try {
                whitePawnEatMoves.add(ChessBoard.diagonalLeftUpCell(cell));

            } catch (OutOfTable outOfTable) {

            } catch (NoCell noCell) {

            }
            try {
                whitePawnEatMoves.add(ChessBoard.diagonalRightUpCell(cell));

            } catch (OutOfTable outOfTable) {

            } catch (NoCell noCell) {

            }


            return whitePawnEatMoves;
        }
    }

    protected ArrayList<Cell> getWhitePawnMove2(Cell cell, ChessBoard ChessBoard) {
        ArrayList<Cell> whitePawnMoves2 = new ArrayList<>();
        {
            try {

                boolean isAllowed=false;
                for (Cell theCell: ChessBoard.getRows().get(1)) {
                    if (theCell.equals(cell))
                    {
                        isAllowed=true;
                        break;
                    }
                }
                if(isAllowed) {
                    cell= ChessBoard.upCell(cell);

                    whitePawnMoves2.add(ChessBoard.upCell(cell));
                }


            } catch (OutOfTable outOfTable) {

            } catch (NoCell noCell) {

            }



            return whitePawnMoves2;
        }
    }


    //Black Pawn
    protected ArrayList<Cell> getBlackPawnMove (Cell cell, ChessBoard ChessBoard){
        ArrayList<Cell> blackPawnMove = new ArrayList<>();
        try {
            blackPawnMove.add(ChessBoard.downCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }
        return blackPawnMove;
    }

    protected ArrayList<Cell> getBlackPawnEatMoves (Cell cell, ChessBoard ChessBoard){
        ArrayList<Cell> blackPawnEatMoves = new ArrayList<>();
        {
            try {
                blackPawnEatMoves.add(ChessBoard.diagonalLeftDownCell(cell));

            } catch (OutOfTable outOfTable) {

            } catch (NoCell noCell) {

            }
            try {
                blackPawnEatMoves.add(ChessBoard.diagonalRightDownCell(cell));

            } catch (OutOfTable outOfTable) {

            } catch (NoCell noCell) {

            }


            return blackPawnEatMoves;
        }


    }

    protected ArrayList<Cell> getBlackPawnMove2(Cell cell, ChessBoard ChessBoard) {
        ArrayList<Cell> blackPawnMoves2 = new ArrayList<>();
        {
            try {

                boolean isAllowed=false;
                for (Cell theCell: ChessBoard.getRows().get(6)) {
                    if (theCell.equals(cell))
                    {
                        isAllowed=true;
                    }
                }
                if(isAllowed) {
                    cell= ChessBoard.downCell(cell);
                    blackPawnMoves2.add(ChessBoard.downCell(cell));
                }


            } catch (OutOfTable outOfTable) {

            } catch (NoCell noCell) {

            }



            return blackPawnMoves2;
        }
    }
}



