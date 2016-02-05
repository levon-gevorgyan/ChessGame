package api.moves.available.black.moves;


import api.chessitems.WhiteItem;
import api.chesstable.Table;
import api.chesstable.cells.Cell;
import api.exceptions.cell.NoCell;
import api.exceptions.moves.NoAvailableCells;
import api.exceptions.table.OutOfTable;

import api.moves.available.moves.BishopMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public class BlackBishopMoves extends BishopMoves {
    private ArrayList<Cell> blackBishopMoves;
    public BlackBishopMoves(Cell cell,Table Table)  {

        try {
            ArrayList<Cell> blackBishopMoves = new ArrayList<>();


            ArrayList<Cell> leftUp = bishopMovesDiagLeftUp(cell,Table);
            ArrayList<Cell> leftDown = bishopMovesDiagLeftDown(cell,Table);
            ArrayList<Cell> rightUp = bishopMovesDiagRightUp(cell,Table);
            ArrayList<Cell> rightDown = bishopMovesDiagRightDown(cell,Table);

            Cell lastLeftUpCell = cell;
            if (leftUp.size() > 0) {
                lastLeftUpCell = leftUp.get(leftUp.size() - 1);
                try {
                    if (Table.diagonalLeftUpCell(lastLeftUpCell).getChessItem() instanceof WhiteItem) {
                        leftUp.add(Table.diagonalLeftUpCell(lastLeftUpCell));
                    }
                } catch (NoCell noCell) {

                }

            }
            else {
                try {
                    if (Table.diagonalLeftUpCell(lastLeftUpCell).getChessItem() instanceof WhiteItem) {
                        leftUp.add(Table.diagonalLeftUpCell(lastLeftUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastLeftDownCell = cell;
            if (leftDown.size() > 0) {
                lastLeftDownCell = leftDown.get(leftDown.size() - 1);
                try {
                    if (Table.diagonalLeftDownCell(lastLeftDownCell).getChessItem() instanceof WhiteItem) {
                        leftDown.add(Table.diagonalLeftDownCell(lastLeftDownCell));
                    }
                } catch (NoCell noCell) {

                }

            }
            else {
                try {
                    if (Table.diagonalLeftDownCell(lastLeftDownCell).getChessItem() instanceof WhiteItem) {
                        leftDown.add(Table.diagonalLeftDownCell(lastLeftDownCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastRightUpCell = cell;
            if (rightUp.size() > 0) {
                lastRightUpCell = rightUp.get(rightUp.size() - 1);
                try {
                    if (Table.diagonalRightUpCell(lastRightUpCell).getChessItem() instanceof WhiteItem) {
                        rightUp.add(Table.diagonalRightUpCell(lastRightUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            else {
                try {
                    if (Table.diagonalRightUpCell(lastRightUpCell).getChessItem() instanceof WhiteItem) {
                        rightUp.add(Table.diagonalRightUpCell(lastRightUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastRightDownCell = cell;
            if (rightDown.size() > 0) {
                lastRightDownCell = rightDown.get(rightDown.size() - 1);
                try {
                    if (Table.diagonalRightDownCell(lastRightDownCell).getChessItem() instanceof WhiteItem) {
                        rightDown.add(Table.diagonalRightDownCell(lastRightDownCell));


                    }
                } catch (NoCell noCell) {

                }
            }
            else {
                try {
                    if (Table.diagonalRightDownCell(lastRightDownCell).getChessItem() instanceof WhiteItem) {
                        rightDown.add(Table.diagonalRightDownCell(lastRightDownCell));
                    }
                } catch (NoCell noCell) {

                }
            }


            if (leftUp.size()>0)
            {
                blackBishopMoves.addAll(leftUp);
            }
            if (leftDown.size()>0)
            {
                blackBishopMoves.addAll(leftDown);
            }
            if (rightUp.size()>0)
            {
                blackBishopMoves.addAll(rightUp);
            }
            if (rightDown.size()>0)
            {
                blackBishopMoves.addAll(rightDown);
            }





            this.blackBishopMoves = blackBishopMoves;
        } catch (OutOfTable outOfTable) {

        }

    }
    @Override
    public ArrayList<Cell> getMoves() throws NoAvailableCells {
        if(blackBishopMoves.size()>0) {
            return this.blackBishopMoves;
        }
        else
            throw new NoAvailableCells();
    }


}
