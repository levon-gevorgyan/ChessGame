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
public abstract class BishopMoves extends AvailableMoves {

    public ArrayList<Cell> bishopMovesDiagLeftUp(Cell cell, ChessBoard chessBoard) {
        ArrayList<Cell> bishopMovesDiagLeftUp = new ArrayList<>();
        try {

            bishopMovesDiagLeftUp.addAll(Move.moveDiagLeftUpUntilNotEmpty(cell, chessBoard));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return bishopMovesDiagLeftUp;

    }

    public ArrayList<Cell> bishopMovesDiagLeftDown(Cell cell, ChessBoard chessBoard) {
        ArrayList<Cell> bishopMovesDiagLeftDown = new ArrayList<>();
        try {


            bishopMovesDiagLeftDown.addAll(Move.moveDiagLeftDownUntilNotEmpty(cell, chessBoard));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return bishopMovesDiagLeftDown;

    }

    public ArrayList<Cell> bishopMovesDiagRightUp(Cell cell, ChessBoard chessBoard) {
        ArrayList<Cell> bishopMovesDiagRightUp = new ArrayList<>();
        try {


            bishopMovesDiagRightUp.addAll(Move.moveDiagRightUpUntilNotEmpty(cell, chessBoard));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return bishopMovesDiagRightUp;

    }

    public ArrayList<Cell> bishopMovesDiagRightDown(Cell cell, ChessBoard chessBoard) {
        ArrayList<Cell> bishopMovesDiagRightDown = new ArrayList<>();
        try {


            bishopMovesDiagRightDown.addAll(Move.moveDiagRightDownUntilNotEmpty(cell, chessBoard));

        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return bishopMovesDiagRightDown;

    }

}
