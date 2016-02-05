package api.moves.available.moves;

import api.chesstable.Table;
import api.chesstable.cells.Cell;
import api.exceptions.cell.NoCell;
import api.exceptions.cell.NotEmptyCell;
import api.exceptions.table.OutOfTable;
import api.moves.Move;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public abstract class QueenMoves extends AvailableMoves {

    public ArrayList<Cell> queenMovesDiagLeftUp(Cell cell, Table Table) {
        ArrayList<Cell> queenMovesDiagLeftUp = new ArrayList<>();
        try {

            queenMovesDiagLeftUp.addAll(Move.moveDiagLeftUpUntilNotEmpty(cell,Table));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesDiagLeftUp;

    }

    public ArrayList<Cell> queenMovesDiagLeftDown(Cell cell, Table Table) {
        ArrayList<Cell> queenMovesDiagLeftDown = new ArrayList<>();
        try {


            queenMovesDiagLeftDown.addAll(Move.moveDiagLeftDownUntilNotEmpty(cell,Table));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesDiagLeftDown;

    }

    public ArrayList<Cell> queenMovesDiagRightUp(Cell cell, Table Table) {
        ArrayList<Cell> queenMovesDiagRightUp = new ArrayList<>();
        try {


            queenMovesDiagRightUp.addAll(Move.moveDiagRightUpUntilNotEmpty(cell,Table));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesDiagRightUp;

    }

    public ArrayList<Cell> queenMovesDiagRightDown(Cell cell, Table Table) {
        ArrayList<Cell> queenMovesDiagRightDown = new ArrayList<>();
        try {


            queenMovesDiagRightDown.addAll(Move.moveDiagRightDownUntilNotEmpty(cell,Table));

        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesDiagRightDown;

    }
    public ArrayList<Cell> queenMovesLeft(Cell cell, Table Table) {
        ArrayList<Cell> queenMovesLeft = new ArrayList<>();
        try {

            queenMovesLeft.addAll(Move.moveLeftUntilNotEmpty(cell,Table));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesLeft;

    }

    public ArrayList<Cell> queenMovesRight(Cell cell, Table Table) {
        ArrayList<Cell> queenMovesRight = new ArrayList<>();
        try {


            queenMovesRight.addAll(Move.moveRightUntilNotEmpty(cell,Table));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesRight;

    }

    public ArrayList<Cell> queenMovesUp(Cell cell, Table Table) {
        ArrayList<Cell> queenMovesUp = new ArrayList<>();
        try {


            queenMovesUp.addAll(Move.moveUpUntilNotEmpty(cell,Table));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesUp;

    }

    public ArrayList<Cell> queenMovesDown(Cell cell, Table Table) {
        ArrayList<Cell> queenMovesDown = new ArrayList<>();
        try {


            queenMovesDown.addAll(Move.moveDownUntilNotEmpty(cell,Table));

        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return queenMovesDown;

    }

}
