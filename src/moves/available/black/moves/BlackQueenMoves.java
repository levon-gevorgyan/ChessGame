package moves.available.black.moves;


import chessitems.WhiteItem;
import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.cell.NoCell;
import exceptions.moves.NoAvailableCells;
import exceptions.table.OutOfTable;
import moves.available.moves.QueenMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class BlackQueenMoves extends QueenMoves {
    private ArrayList<Cell> blackQueenMoves;

    public BlackQueenMoves(Cell cell) {
        try {
            ArrayList<Cell> blackQueenMoves = new ArrayList<>();


            ArrayList<Cell> leftUp = queenMovesDiagLeftUp(cell);
            ArrayList<Cell> leftDown = queenMovesDiagLeftDown(cell);
            ArrayList<Cell> rightUp = queenMovesDiagRightUp(cell);
            ArrayList<Cell> rightDown = queenMovesDiagRightDown(cell);

            Cell lastLeftUpCell = cell;
            if (leftUp.size() > 0) {
                lastLeftUpCell = leftUp.get(leftUp.size() - 1);
                try {
                    if (Table.diagonalLeftUpCell(lastLeftUpCell).getChessItem() instanceof WhiteItem) {
                        leftUp.add(Table.diagonalLeftUpCell(lastLeftUpCell));
                    }
                } catch (NoCell noCell) {

                }

            } else {
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

            } else {
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
            } else {
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
            } else {
                try {
                    if (Table.diagonalRightDownCell(lastRightDownCell).getChessItem() instanceof WhiteItem) {
                        rightDown.add(Table.diagonalRightDownCell(lastRightDownCell));
                    }
                } catch (NoCell noCell) {

                }
            }


            if (leftUp.size() > 0) {
                blackQueenMoves.addAll(leftUp);
            }
            if (leftDown.size() > 0) {
                blackQueenMoves.addAll(leftDown);
            }
            if (rightUp.size() > 0) {
                blackQueenMoves.addAll(rightUp);
            }
            if (rightDown.size() > 0) {
                blackQueenMoves.addAll(rightDown);
            }

            ArrayList<Cell> up = queenMovesUp(cell);
            ArrayList<Cell> down = queenMovesDown(cell);
            ArrayList<Cell> left = queenMovesLeft(cell);
            ArrayList<Cell> right = queenMovesRight(cell);

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
                blackQueenMoves.addAll(up);
            }
            if (down.size()>0)
            {
                blackQueenMoves.addAll(down);
            }
            if (right.size()>0)
            {
                blackQueenMoves.addAll(right);
            }
            if (left.size()>0)
            {
                blackQueenMoves.addAll(left);
            }



            this.blackQueenMoves = blackQueenMoves;
        } catch (OutOfTable outOfTable) {

        }

    }
    public ArrayList<Cell> getBlackQueenMoves() throws NoAvailableCells {
        if(blackQueenMoves.size()>0){
            return this.blackQueenMoves;
        }
        else
            throw new NoAvailableCells();

    }
}
