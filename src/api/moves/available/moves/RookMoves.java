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
public abstract class RookMoves extends AvailableMoves {
    public ArrayList<Cell> rookMovesLeft(Cell cell, Table Table) {
        ArrayList<Cell> rookMovesLeft = new ArrayList<>();
        try {

            rookMovesLeft.addAll(Move.moveLeftUntilNotEmpty(cell,Table));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return rookMovesLeft;

    }

    public ArrayList<Cell> rookMovesRight(Cell cell, Table Table) {
        ArrayList<Cell> rookMovesRight = new ArrayList<>();
        try {


            rookMovesRight.addAll(Move.moveRightUntilNotEmpty(cell,Table));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return rookMovesRight;

    }

    public ArrayList<Cell> rookMovesUp(Cell cell, Table Table) {
        ArrayList<Cell> rookMovesUp = new ArrayList<>();
        try {


            rookMovesUp.addAll(Move.moveUpUntilNotEmpty(cell,Table));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return rookMovesUp;

    }

    public ArrayList<Cell> rookMovesDown(Cell cell, Table Table) {
        ArrayList<Cell> rookMovesDown = new ArrayList<>();
        try {


            rookMovesDown.addAll(Move.moveDownUntilNotEmpty(cell,Table));

        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return rookMovesDown;

    }



}
