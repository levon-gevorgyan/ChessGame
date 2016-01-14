package moves.available.white.moves;


import chessitems.BlackItem;
import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.cell.NoCell;
import exceptions.table.OutOfTable;
import moves.available.moves.RookMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class WhiteRookMoves extends RookMoves {
    private ArrayList<Cell> whiteRookMoves;
    public WhiteRookMoves(Cell cell) throws NoCell {

        try {
            ArrayList<Cell> whiteRookMoves = new ArrayList<>();


            ArrayList<Cell> up = rookMovesUp(cell);
            ArrayList<Cell> down = rookMovesDown(cell);
            ArrayList<Cell> left = rookMovesLeft(cell);
            ArrayList<Cell> right = rookMovesRight(cell);

            Cell lastLeftCell = cell;
            if (left.size() > 0) {
                lastLeftCell = left.get(left.size() - 1);
                try {
                    if (Table.leftCell(lastLeftCell).getChessItem() instanceof BlackItem) {
                        left.add(Table.leftCell(lastLeftCell));
                    }
                } catch (NoCell noCell) {

                }

            }
            else {
                try {
                    if (Table.leftCell(lastLeftCell).getChessItem() instanceof BlackItem) {
                        left.add(Table.leftCell(lastLeftCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastRightCell = cell;
            if (right.size() > 0) {
                lastRightCell = right.get(right.size() - 1);
                try {
                    if (Table.rightCell(lastRightCell).getChessItem() instanceof BlackItem) {
                        right.add(Table.rightCell(lastRightCell));
                    }
                } catch (NoCell noCell) {

                }

            }
            else {
                try {
                    if (Table.rightCell(lastRightCell).getChessItem() instanceof BlackItem) {
                        right.add(Table.rightCell(lastRightCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastUpCell = cell;
            if (up.size() > 0) {
                lastUpCell = up.get(up.size() - 1);
                try {
                    if (Table.upCell(lastUpCell).getChessItem() instanceof BlackItem) {
                        up.add(Table.upCell(lastUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            else {
                try {
                    if (Table.upCell(lastUpCell).getChessItem() instanceof BlackItem) {
                        up.add(Table.upCell(lastUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastDownCell = cell;
            if (down.size() > 0) {
                lastDownCell = down.get(down.size() - 1);
                try {
                    if (Table.downCell(lastDownCell).getChessItem() instanceof BlackItem) {
                        down.add(Table.downCell(lastDownCell));


                    }
                } catch (NoCell noCell) {

                }
            }
            else {
                try {
                    if (Table.downCell(lastDownCell).getChessItem() instanceof BlackItem) {
                        down.add(Table.downCell(lastDownCell));
                    }
                } catch (NoCell noCell) {

                }
            }

            if (up.size()>0)
            {
                whiteRookMoves.addAll(up);
            }
            if (down.size()>0)
            {
                whiteRookMoves.addAll(down);
            }
            if (right.size()>0)
            {
                whiteRookMoves.addAll(right);
            }
            if (left.size()>0)
            {
                whiteRookMoves.addAll(left);
            }





            this.whiteRookMoves =whiteRookMoves;
        } catch (OutOfTable outOfTable) {

        }

    }
    public ArrayList<Cell> getBlackRookMoves()
    {
        return this.whiteRookMoves;
    }

}
