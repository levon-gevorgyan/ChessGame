package api.moves.available.black.moves;


import api.chessitems.WhiteItem;
import api.chessboard.ChessBoard;
import api.chessboard.cells.Cell;
import api.exceptions.cell.NoCell;
import api.exceptions.moves.NoAvailableCells;
import api.exceptions.table.OutOfTable;
import api.moves.available.moves.QueenMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class BlackQueenMoves extends QueenMoves {
    private ArrayList<Cell> blackQueenMoves;

    public BlackQueenMoves(Cell cell, ChessBoard ChessBoard) {
        try {
            ArrayList<Cell> blackQueenMoves = new ArrayList<>();


            ArrayList<Cell> leftUp = queenMovesDiagLeftUp(cell, ChessBoard);
            ArrayList<Cell> leftDown = queenMovesDiagLeftDown(cell, ChessBoard);
            ArrayList<Cell> rightUp = queenMovesDiagRightUp(cell, ChessBoard);
            ArrayList<Cell> rightDown = queenMovesDiagRightDown(cell, ChessBoard);

            Cell lastLeftUpCell = cell;
            if (leftUp.size() > 0) {
                lastLeftUpCell = leftUp.get(leftUp.size() - 1);
                try {
                    if (ChessBoard.diagonalLeftUpCell(lastLeftUpCell).getChessItem() instanceof WhiteItem) {
                        leftUp.add(ChessBoard.diagonalLeftUpCell(lastLeftUpCell));
                    }
                } catch (NoCell noCell) {

                }

            } else {
                try {
                    if (ChessBoard.diagonalLeftUpCell(lastLeftUpCell).getChessItem() instanceof WhiteItem) {
                        leftUp.add(ChessBoard.diagonalLeftUpCell(lastLeftUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastLeftDownCell = cell;
            if (leftDown.size() > 0) {
                lastLeftDownCell = leftDown.get(leftDown.size() - 1);
                try {
                    if (ChessBoard.diagonalLeftDownCell(lastLeftDownCell).getChessItem() instanceof WhiteItem) {
                        leftDown.add(ChessBoard.diagonalLeftDownCell(lastLeftDownCell));
                    }
                } catch (NoCell noCell) {

                }

            } else {
                try {
                    if (ChessBoard.diagonalLeftDownCell(lastLeftDownCell).getChessItem() instanceof WhiteItem) {
                        leftDown.add(ChessBoard.diagonalLeftDownCell(lastLeftDownCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastRightUpCell = cell;
            if (rightUp.size() > 0) {
                lastRightUpCell = rightUp.get(rightUp.size() - 1);
                try {
                    if (ChessBoard.diagonalRightUpCell(lastRightUpCell).getChessItem() instanceof WhiteItem) {
                        rightUp.add(ChessBoard.diagonalRightUpCell(lastRightUpCell));
                    }
                } catch (NoCell noCell) {

                }
            } else {
                try {
                    if (ChessBoard.diagonalRightUpCell(lastRightUpCell).getChessItem() instanceof WhiteItem) {
                        rightUp.add(ChessBoard.diagonalRightUpCell(lastRightUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastRightDownCell = cell;
            if (rightDown.size() > 0) {
                lastRightDownCell = rightDown.get(rightDown.size() - 1);
                try {
                    if (ChessBoard.diagonalRightDownCell(lastRightDownCell).getChessItem() instanceof WhiteItem) {
                        rightDown.add(ChessBoard.diagonalRightDownCell(lastRightDownCell));


                    }
                } catch (NoCell noCell) {

                }
            } else {
                try {
                    if (ChessBoard.diagonalRightDownCell(lastRightDownCell).getChessItem() instanceof WhiteItem) {
                        rightDown.add(ChessBoard.diagonalRightDownCell(lastRightDownCell));
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

            ArrayList<Cell> up = queenMovesUp(cell, ChessBoard);
            ArrayList<Cell> down = queenMovesDown(cell, ChessBoard);
            ArrayList<Cell> left = queenMovesLeft(cell, ChessBoard);
            ArrayList<Cell> right = queenMovesRight(cell, ChessBoard);

            Cell lastLeftCell = cell;
            if (left.size() > 0) {
                lastLeftCell = left.get(left.size() - 1);
                try {
                    if (ChessBoard.leftCell(lastLeftCell).getChessItem() instanceof WhiteItem) {
                        left.add(ChessBoard.leftCell(lastLeftCell));
                    }
                } catch (NoCell noCell) {

                }

            }
            else {
                try {
                    if (ChessBoard.leftCell(lastLeftCell).getChessItem() instanceof WhiteItem) {
                        left.add(ChessBoard.leftCell(lastLeftCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastRightCell = cell;
            if (right.size() > 0) {
                lastRightCell = right.get(right.size() - 1);
                try {
                    if (ChessBoard.rightCell(lastRightCell).getChessItem() instanceof WhiteItem) {
                        right.add(ChessBoard.rightCell(lastRightCell));
                    }
                } catch (NoCell noCell) {

                }

            }
            else {
                try {
                    if (ChessBoard.rightCell(lastRightCell).getChessItem() instanceof WhiteItem) {
                        right.add(ChessBoard.rightCell(lastRightCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastUpCell = cell;
            if (up.size() > 0) {
                lastUpCell = up.get(up.size() - 1);
                try {
                    if (ChessBoard.upCell(lastUpCell).getChessItem() instanceof WhiteItem) {
                        up.add(ChessBoard.upCell(lastUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            else {
                try {
                    if (ChessBoard.upCell(lastUpCell).getChessItem() instanceof WhiteItem) {
                        up.add(ChessBoard.upCell(lastUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastDownCell = cell;
            if (down.size() > 0) {
                lastDownCell = down.get(down.size() - 1);
                try {
                    if (ChessBoard.downCell(lastDownCell).getChessItem() instanceof WhiteItem) {
                        down.add(ChessBoard.downCell(lastDownCell));


                    }
                } catch (NoCell noCell) {

                }
            }
            else {
                try {
                    if (ChessBoard.downCell(lastDownCell).getChessItem() instanceof WhiteItem) {
                        down.add(ChessBoard.downCell(lastDownCell));
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
    @Override
    public ArrayList<Cell> getMoves() throws NoAvailableCells {
        if(blackQueenMoves.size()>0){
            return this.blackQueenMoves;
        }
        else
            throw new NoAvailableCells();

    }
}
