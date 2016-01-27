package moves.available.white.moves;


import chessitems.BlackItem;
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
public class WhiteQueenMoves extends QueenMoves {
    private ArrayList<Cell> whiteQueenMoves;

    public WhiteQueenMoves(Cell cell, Table Table) {
        try {
            ArrayList<Cell> whiteQueenMoves = new ArrayList<>();


            ArrayList<Cell> leftUp = queenMovesDiagLeftUp(cell, Table);
            ArrayList<Cell> leftDown = queenMovesDiagLeftDown(cell, Table);
            ArrayList<Cell> rightUp = queenMovesDiagRightUp(cell, Table);
            ArrayList<Cell> rightDown = queenMovesDiagRightDown(cell, Table);

            Cell lastLeftUpCell = cell;
            if (leftUp.size() > 0) {
                lastLeftUpCell = leftUp.get(leftUp.size() - 1);
                try {
                    if (Table.diagonalLeftUpCell(lastLeftUpCell).getChessItem() instanceof BlackItem) {
                        leftUp.add(Table.diagonalLeftUpCell(lastLeftUpCell));
                    }
                } catch (NoCell noCell) {

                }

            } else {
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

            } else {
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
            } else {
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
            } else {
                try {
                    if (Table.diagonalRightDownCell(lastRightDownCell).getChessItem() instanceof BlackItem) {
                        rightDown.add(Table.diagonalRightDownCell(lastRightDownCell));
                    }
                } catch (NoCell noCell) {

                }
            }


            if (leftUp.size() > 0) {
                whiteQueenMoves.addAll(leftUp);
            }
            if (leftDown.size() > 0) {
                whiteQueenMoves.addAll(leftDown);
            }
            if (rightUp.size() > 0) {
                whiteQueenMoves.addAll(rightUp);
            }
            if (rightDown.size() > 0) {
                whiteQueenMoves.addAll(rightDown);
            }

            ArrayList<Cell> up = queenMovesUp(cell, Table);
            ArrayList<Cell> down = queenMovesDown(cell, Table);
            ArrayList<Cell> left = queenMovesLeft(cell, Table);
            ArrayList<Cell> right = queenMovesRight(cell, Table);

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
                whiteQueenMoves.addAll(up);
            }
            if (down.size()>0)
            {
                whiteQueenMoves.addAll(down);
            }
            if (right.size()>0)
            {
                whiteQueenMoves.addAll(right);
            }
            if (left.size()>0)
            {
                whiteQueenMoves.addAll(left);
            }



            this.whiteQueenMoves = whiteQueenMoves;
        } catch (OutOfTable outOfTable) {

        }

    }
    @Override
    public ArrayList<Cell> getMoves() throws NoAvailableCells {
        if (whiteQueenMoves.size()>0)
        {
            return this.whiteQueenMoves;
        }
        else
            throw new NoAvailableCells();

    }
}

