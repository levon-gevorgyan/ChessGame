package moves.available.white.moves;

import chessitems.BlackItem;
import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.cell.NoCell;
import exceptions.moves.NoAvailableCells;
import exceptions.table.OutOfTable;
import moves.available.moves.BishopMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public class WhiteBishopMoves extends BishopMoves {
    private ArrayList<Cell> whiteBishopMoves;
    public WhiteBishopMoves(Cell cell)  {

        try {
            ArrayList<Cell> whiteBishopMoves = new ArrayList<>();


            ArrayList<Cell> leftUp = bishopMovesDiagLeftUp(cell);
            ArrayList<Cell> leftDown = bishopMovesDiagLeftDown(cell);
            ArrayList<Cell> rightUp = bishopMovesDiagRightUp(cell);
            ArrayList<Cell> rightDown = bishopMovesDiagRightDown(cell);

            Cell lastLeftUpCell = cell;
            if (leftUp.size() > 0) {
                lastLeftUpCell = leftUp.get(leftUp.size() - 1);
                try {
                    if (Table.diagonalLeftUpCell(lastLeftUpCell).getChessItem() instanceof BlackItem) {
                        leftUp.add(Table.diagonalLeftUpCell(lastLeftUpCell));
                    }
                } catch (NoCell noCell) {

                }

            }
            else {
                try {
                    if (Table.diagonalLeftUpCell(lastLeftUpCell).getChessItem() instanceof BlackItem) {
                        leftUp.add(Table.diagonalLeftUpCell(lastLeftUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastLeftDownCell = cell;
            if (leftDown.size() > 0) {
                lastLeftDownCell = leftDown.get(leftDown.size() - 1);
                try {
                    if (Table.diagonalLeftDownCell(lastLeftDownCell).getChessItem() instanceof BlackItem) {
                        leftDown.add(Table.diagonalLeftDownCell(lastLeftDownCell));
                    }
                } catch (NoCell noCell) {

                }

            }
            else {
                try {
                    if (Table.diagonalLeftDownCell(lastLeftDownCell).getChessItem() instanceof BlackItem) {
                        leftDown.add(Table.diagonalLeftDownCell(lastLeftDownCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastRightUpCell = cell;
            if (rightUp.size() > 0) {
                lastRightUpCell = rightUp.get(rightUp.size() - 1);
                try {
                    if (Table.diagonalRightUpCell(lastRightUpCell).getChessItem() instanceof BlackItem) {
                        rightUp.add(Table.diagonalRightUpCell(lastRightUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            else {
                try {
                    if (Table.diagonalRightUpCell(lastRightUpCell).getChessItem() instanceof BlackItem) {
                        rightUp.add(Table.diagonalRightUpCell(lastRightUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastRightDownCell = cell;
            if (rightDown.size() > 0) {
                lastRightDownCell = rightDown.get(rightDown.size() - 1);
                try {
                    if (Table.diagonalRightDownCell(lastRightDownCell).getChessItem() instanceof BlackItem) {
                        rightDown.add(Table.diagonalRightDownCell(lastRightDownCell));


                    }
                } catch (NoCell noCell) {

                }
            }
            else {
                try {
                    if (Table.diagonalRightDownCell(lastRightDownCell).getChessItem() instanceof BlackItem) {
                        rightDown.add(Table.diagonalRightDownCell(lastRightDownCell));
                    }
                } catch (NoCell noCell) {

                }
            }




            if (leftUp.size()>0)
            {
                whiteBishopMoves.addAll(leftUp);
            }
            if (leftDown.size()>0)
            {
                whiteBishopMoves.addAll(leftDown);
            }
            if (rightUp.size()>0)
            {
                whiteBishopMoves.addAll(rightUp);
            }
            if (rightDown.size()>0)
            {
                whiteBishopMoves.addAll(rightDown);
            }





            this.whiteBishopMoves = whiteBishopMoves;
        } catch (OutOfTable outOfTable) {

        }

    }
    public ArrayList<Cell> getWhiteBishopMoves() throws NoAvailableCells {
        if(whiteBishopMoves.size()>0) {
            return this.whiteBishopMoves;
        }
        else
        {
            throw new NoAvailableCells();
        }
    }


}
