package api.moves.available.moves;

import api.chesstable.Table;
import api.chesstable.cells.Cell;
import api.exceptions.cell.NoCell;
import api.exceptions.table.OutOfTable;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public abstract class KingMoves extends AvailableMoves {
    protected ArrayList<Cell> getKingMoves(Cell cell, Table Table)
    {
        ArrayList<Cell> kingMoves=new ArrayList<>();

        try {
            kingMoves.add(Table.upCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            kingMoves.add(Table.downCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            kingMoves.add(Table.leftCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            kingMoves.add(Table.rightCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            kingMoves.add(Table.diagonalRightDownCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            kingMoves.add(Table.diagonalLeftDownCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            kingMoves.add(Table.diagonalLeftUpCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            kingMoves.add(Table.diagonalRightUpCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }


        return kingMoves;
    }


}
