package api.moves.available.moves;

import api.chessboard.ChessBoard;
import api.chessboard.cells.Cell;
import api.exceptions.cell.NoCell;
import api.exceptions.table.OutOfTable;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public abstract class KingMoves extends AvailableMoves {
    protected ArrayList<Cell> getKingMoves(Cell cell, ChessBoard ChessBoard)
    {
        ArrayList<Cell> kingMoves=new ArrayList<>();

        try {
            kingMoves.add(ChessBoard.upCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            kingMoves.add(ChessBoard.downCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            kingMoves.add(ChessBoard.leftCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            kingMoves.add(ChessBoard.rightCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            kingMoves.add(ChessBoard.diagonalRightDownCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            kingMoves.add(ChessBoard.diagonalLeftDownCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            kingMoves.add(ChessBoard.diagonalLeftUpCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            kingMoves.add(ChessBoard.diagonalRightUpCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }


        return kingMoves;
    }


}
