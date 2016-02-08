package api.moves.available.moves;

import api.chessboard.ChessBoard;
import api.chessboard.cells.Cell;
import api.exceptions.cell.NoCell;
import api.exceptions.table.OutOfTable;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public abstract class KnightMoves extends AvailableMoves {

    public ArrayList<Cell> getKnightMoves(Cell cell, ChessBoard ChessBoard)
    {
        ArrayList<Cell> knightMoves=new ArrayList<>();
        try {
            knightMoves.add(ChessBoard.upUpLeft(cell));
            
        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            knightMoves.add(ChessBoard.upUpRight(cell));
        } catch (OutOfTable outOfTable) {
            
        } catch (NoCell noCell) {
            
        }
        try {
            knightMoves.add(ChessBoard.downDownLeft(cell));
        } catch (OutOfTable outOfTable) {
            
        } catch (NoCell noCell) {
            
        }
        try {
            knightMoves.add(ChessBoard.downDownRight(cell));
        } catch (OutOfTable outOfTable) {
            
        } catch (NoCell noCell) {
            
        }
        try {
            knightMoves.add(ChessBoard.leftLeftUp(cell));
        } catch (OutOfTable outOfTable) {
            
        } catch (NoCell noCell) {
            
        }
        try {
            knightMoves.add(ChessBoard.leftLeftDown(cell));
        } catch (OutOfTable outOfTable) {
            
        } catch (NoCell noCell) {
            
        }
        try {
            knightMoves.add(ChessBoard.rightRightUp(cell));
        } catch (OutOfTable outOfTable) {
            
        } catch (NoCell noCell) {
            
        }
        try {
            knightMoves.add(ChessBoard.rightRightDown(cell));
        } catch (OutOfTable outOfTable) {
            
        } catch (NoCell noCell) {
            
        }
        return knightMoves;
    }



}
