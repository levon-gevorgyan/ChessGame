package moves.available.moves;

import chesstable.cells.Cell;
import exceptions.cell.NoCell;
import exceptions.cell.NotEmptyCell;
import exceptions.table.OutOfTable;
import moves.Move;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public class QueenMoves extends AvailableMoves {

    public ArrayList<Cell> queenMovesDiagLeftUp(Cell cell) {
        ArrayList<Cell> queenMovesDiagLeftUp = new ArrayList<>();
        try {

            queenMovesDiagLeftUp.addAll(Move.moveDiagLeftUpUntilNotEmpty(cell));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesDiagLeftUp;

    }

    public ArrayList<Cell> queenMovesDiagLeftDown(Cell cell) {
        ArrayList<Cell> queenMovesDiagLeftDown = new ArrayList<>();
        try {


            queenMovesDiagLeftDown.addAll(Move.moveDiagLeftDownUntilNotEmpty(cell));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesDiagLeftDown;

    }

    public ArrayList<Cell> queenMovesDiagRightUp(Cell cell) {
        ArrayList<Cell> queenMovesDiagRightUp = new ArrayList<>();
        try {


            queenMovesDiagRightUp.addAll(Move.moveDiagRightUpUntilNotEmpty(cell));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesDiagRightUp;

    }

    public ArrayList<Cell> queenMovesDiagRightDown(Cell cell) {
        ArrayList<Cell> queenMovesDiagRightDown = new ArrayList<>();
        try {


            queenMovesDiagRightDown.addAll(Move.moveDiagRightDownUntilNotEmpty(cell));

        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesDiagRightDown;

    }
    public ArrayList<Cell> queenMovesLeft(Cell cell) {
        ArrayList<Cell> queenMovesLeft = new ArrayList<>();
        try {

            queenMovesLeft.addAll(Move.moveLeftUntilNotEmpty(cell));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesLeft;

    }

    public ArrayList<Cell> queenMovesRight(Cell cell) {
        ArrayList<Cell> queenMovesRight = new ArrayList<>();
        try {


            queenMovesRight.addAll(Move.moveRightUntilNotEmpty(cell));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesRight;

    }

    public ArrayList<Cell> queenMovesUp(Cell cell) {
        ArrayList<Cell> queenMovesUp = new ArrayList<>();
        try {


            queenMovesUp.addAll(Move.moveUpUntilNotEmpty(cell));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesUp;

    }

    public ArrayList<Cell> queenMovesDown(Cell cell) {
        ArrayList<Cell> queenMovesDown = new ArrayList<>();
        try {


            queenMovesDown.addAll(Move.moveDownUntilNotEmpty(cell));

        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesDown;

    }

}
