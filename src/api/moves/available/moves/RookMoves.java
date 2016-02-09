package api.moves.available.moves;

import api.chessboard.ChessBoard;
import api.chessboard.cells.Cell;
import api.exceptions.cell.NoCell;
import api.exceptions.cell.NotEmptyCell;
import api.exceptions.table.OutOfTable;
import api.moves.Move;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public abstract class RookMoves extends AvailableMoves {
    public ArrayList<Cell> rookMovesLeft(Cell cell, ChessBoard ChessBoard) {
        ArrayList<Cell> rookMovesLeft = new ArrayList<>();
        try {

            rookMovesLeft.addAll(Move.moveLeftUntilNotEmpty(cell, ChessBoard));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return rookMovesLeft;

    }

    public ArrayList<Cell> rookMovesRight(Cell cell, ChessBoard ChessBoard) {
        ArrayList<Cell> rookMovesRight = new ArrayList<>();
        try {


            rookMovesRight.addAll(Move.moveRightUntilNotEmpty(cell, ChessBoard));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return rookMovesRight;

    }

    public ArrayList<Cell> rookMovesUp(Cell cell, ChessBoard ChessBoard) {
        ArrayList<Cell> rookMovesUp = new ArrayList<>();
        try {


            rookMovesUp.addAll(Move.moveUpUntilNotEmpty(cell, ChessBoard));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return rookMovesUp;

    }

    public ArrayList<Cell> rookMovesDown(Cell cell, ChessBoard ChessBoard) {
        ArrayList<Cell> rookMovesDown = new ArrayList<>();
        try {


            rookMovesDown.addAll(Move.moveDownUntilNotEmpty(cell, ChessBoard));

        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return rookMovesDown;

    }



}
