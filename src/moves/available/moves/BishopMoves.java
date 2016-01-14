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
public abstract class BishopMoves extends AvailableMoves {

    public ArrayList<Cell> bishopMovesDiagLeftUp(Cell cell) {
        ArrayList<Cell> bishopMovesDiagLeftUp = new ArrayList<>();
        try {

            bishopMovesDiagLeftUp.addAll(Move.moveDiagLeftUpUntilNotEmpty(cell));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return bishopMovesDiagLeftUp;

    }

    public ArrayList<Cell> bishopMovesDiagLeftDown(Cell cell) {
        ArrayList<Cell> bishopMovesDiagLeftDown = new ArrayList<>();
        try {


            bishopMovesDiagLeftDown.addAll(Move.moveDiagLeftDownUntilNotEmpty(cell));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return bishopMovesDiagLeftDown;

    }

    public ArrayList<Cell> bishopMovesDiagRightUp(Cell cell) {
        ArrayList<Cell> bishopMovesDiagRightUp = new ArrayList<>();
        try {


            bishopMovesDiagRightUp.addAll(Move.moveDiagRightUpUntilNotEmpty(cell));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return bishopMovesDiagRightUp;

    }

    public ArrayList<Cell> bishopMovesDiagRightDown(Cell cell) {
        ArrayList<Cell> bishopMovesDiagRightDown = new ArrayList<>();
        try {


            bishopMovesDiagRightDown.addAll(Move.moveDiagRightDownUntilNotEmpty(cell));

        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return bishopMovesDiagRightDown;

    }

}
