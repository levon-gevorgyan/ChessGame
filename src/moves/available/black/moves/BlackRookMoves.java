package moves.available.black.moves;


import chessitems.WhiteItem;
import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.cell.NoCell;
import exceptions.moves.NoAvailableCells;
import exceptions.table.OutOfTable;
import moves.available.moves.RookMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class BlackRookMoves extends RookMoves {
    private ArrayList<Cell> blackRookMoves;
    public BlackRookMoves(Cell cell, Table Table) throws NoCell {

        try {
            ArrayList<Cell> blackRookMoves = new ArrayList<>();


            ArrayList<Cell> up = rookMovesUp(cell, Table);
            ArrayList<Cell> down = rookMovesDown(cell, Table);
            ArrayList<Cell> left = rookMovesLeft(cell, Table);
            ArrayList<Cell> right = rookMovesRight(cell, Table);

            Cell lastLeftCell = cell;
            if (left.size() > 0) {
                lastLeftCell = left.get(left.size() - 1);
                try {
                    if (Table.leftCell(lastLeftCell).getChessItem() instanceof WhiteItem) {
                        left.add(Table.leftCell(lastLeftCell));
                    }
                } catch (NoCell noCell) {

                }

            }
            else {
                try {
                    if (Table.leftCell(lastLeftCell).getChessItem() instanceof WhiteItem) {
                        left.add(Table.leftCell(lastLeftCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastRightCell = cell;
            if (right.size() > 0) {
                lastRightCell = right.get(right.size() - 1);
                try {
                    if (Table.rightCell(lastRightCell).getChessItem() instanceof WhiteItem) {
                        right.add(Table.rightCell(lastRightCell));
                    }
                } catch (NoCell noCell) {

                }

            }
            else {
                try {
                    if (Table.rightCell(lastRightCell).getChessItem() instanceof WhiteItem) {
                        right.add(Table.rightCell(lastRightCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastUpCell = cell;
            if (up.size() > 0) {
                lastUpCell = up.get(up.size() - 1);
                try {
                    if (Table.upCell(lastUpCell).getChessItem() instanceof WhiteItem) {
                        up.add(Table.upCell(lastUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            else {
                try {
                    if (Table.upCell(lastUpCell).getChessItem() instanceof WhiteItem) {
                        up.add(Table.upCell(lastUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastDownCell = cell;
            if (down.size() > 0) {
                lastDownCell = down.get(down.size() - 1);
                try {
                    if (Table.downCell(lastDownCell).getChessItem() instanceof WhiteItem) {
                        down.add(Table.downCell(lastDownCell));


                    }
                } catch (NoCell noCell) {

                }
            }
            else {
                try {
                    if (Table.downCell(lastDownCell).getChessItem() instanceof WhiteItem) {
                        down.add(Table.downCell(lastDownCell));
                    }
                } catch (NoCell noCell) {

                }
            }

            if (up.size()>0)
            {
                blackRookMoves.addAll(up);
            }
            if (down.size()>0)
            {
                blackRookMoves.addAll(down);
            }
            if (right.size()>0)
            {
                blackRookMoves.addAll(right);
            }
            if (left.size()>0)
            {
                blackRookMoves.addAll(left);
            }





            this.blackRookMoves =blackRookMoves;
        } catch (OutOfTable outOfTable) {

        }

    }
    public ArrayList<Cell> getBlackRookMoves() throws NoAvailableCells {
        if(blackRookMoves.size()>0){
            return this.blackRookMoves;
        }
        else
            throw new NoAvailableCells();

    }


}
