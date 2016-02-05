package api.moves.available.moves;

import api.chesstable.Table;
import api.chesstable.cells.Cell;
import api.exceptions.cell.NoCell;
import api.exceptions.table.OutOfTable;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public abstract class KnightMoves extends AvailableMoves {

    public ArrayList<Cell> getKnightMoves(Cell cell, Table Table)
    {
        ArrayList<Cell> knightMoves=new ArrayList<>();
        try {
            knightMoves.add(Table.upUpLeft(cell));
            
        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }

        try {
            knightMoves.add(Table.upUpRight(cell));
        } catch (OutOfTable outOfTable) {
            
        } catch (NoCell noCell) {
            
        }
        try {
            knightMoves.add(Table.downDownLeft(cell));
        } catch (OutOfTable outOfTable) {
            
        } catch (NoCell noCell) {
            
        }
        try {
            knightMoves.add(Table.downDownRight(cell));
        } catch (OutOfTable outOfTable) {
            
        } catch (NoCell noCell) {
            
        }
        try {
            knightMoves.add(Table.leftLeftUp(cell));
        } catch (OutOfTable outOfTable) {
            
        } catch (NoCell noCell) {
            
        }
        try {
            knightMoves.add(Table.leftLeftDown(cell));
        } catch (OutOfTable outOfTable) {
            
        } catch (NoCell noCell) {
            
        }
        try {
            knightMoves.add(Table.rightRightUp(cell));
        } catch (OutOfTable outOfTable) {
            
        } catch (NoCell noCell) {
            
        }
        try {
            knightMoves.add(Table.rightRightDown(cell));
        } catch (OutOfTable outOfTable) {
            
        } catch (NoCell noCell) {
            
        }
        return knightMoves;
    }



}
