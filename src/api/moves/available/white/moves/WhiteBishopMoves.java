package api.moves.available.white.moves;

import api.chessboard.ChessBoard;
import api.chessitems.BlackItem;
import api.chessboard.cells.Cell;
import api.exceptions.cell.NoCell;
import api.exceptions.moves.NoAvailableCells;
import api.exceptions.table.OutOfTable;
import api.moves.available.moves.BishopMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public class WhiteBishopMoves extends BishopMoves {
    private ArrayList<Cell> whiteBishopMoves;
    public WhiteBishopMoves(Cell cell, ChessBoard ChessBoard)  {

        try {
            ArrayList<Cell> whiteBishopMoves = new ArrayList<>();


            ArrayList<Cell> leftUp = bishopMovesDiagLeftUp(cell, ChessBoard);
            ArrayList<Cell> leftDown = bishopMovesDiagLeftDown(cell, ChessBoard);
            ArrayList<Cell> rightUp = bishopMovesDiagRightUp(cell, ChessBoard);
            ArrayList<Cell> rightDown = bishopMovesDiagRightDown(cell, ChessBoard);

            Cell lastLeftUpCell = cell;
            if (leftUp.size() > 0) {
                lastLeftUpCell = leftUp.get(leftUp.size() - 1);
                try {
                    if (ChessBoard.diagonalLeftUpCell(lastLeftUpCell).getChessItem() instanceof BlackItem) {
                        leftUp.add(ChessBoard.diagonalLeftUpCell(lastLeftUpCell));
                    }
                } catch (NoCell noCell) {

                }

            }
            else {
                try {
                    if (ChessBoard.diagonalLeftUpCell(lastLeftUpCell).getChessItem() instanceof BlackItem) {
                        leftUp.add(ChessBoard.diagonalLeftUpCell(lastLeftUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastLeftDownCell = cell;
            if (leftDown.size() > 0) {
                lastLeftDownCell = leftDown.get(leftDown.size() - 1);
                try {
                    if (ChessBoard.diagonalLeftDownCell(lastLeftDownCell).getChessItem() instanceof BlackItem) {
                        leftDown.add(ChessBoard.diagonalLeftDownCell(lastLeftDownCell));
                    }
                } catch (NoCell noCell) {

                }

            }
            else {
                try {
                    if (ChessBoard.diagonalLeftDownCell(lastLeftDownCell).getChessItem() instanceof BlackItem) {
                        leftDown.add(ChessBoard.diagonalLeftDownCell(lastLeftDownCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastRightUpCell = cell;
            if (rightUp.size() > 0) {
                lastRightUpCell = rightUp.get(rightUp.size() - 1);
                try {
                    if (ChessBoard.diagonalRightUpCell(lastRightUpCell).getChessItem() instanceof BlackItem) {
                        rightUp.add(ChessBoard.diagonalRightUpCell(lastRightUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            else {
                try {
                    if (ChessBoard.diagonalRightUpCell(lastRightUpCell).getChessItem() instanceof BlackItem) {
                        rightUp.add(ChessBoard.diagonalRightUpCell(lastRightUpCell));
                    }
                } catch (NoCell noCell) {

                }
            }
            Cell lastRightDownCell = cell;
            if (rightDown.size() > 0) {
                lastRightDownCell = rightDown.get(rightDown.size() - 1);
                try {
                    if (ChessBoard.diagonalRightDownCell(lastRightDownCell).getChessItem() instanceof BlackItem) {
                        rightDown.add(ChessBoard.diagonalRightDownCell(lastRightDownCell));


                    }
                } catch (NoCell noCell) {

                }
            }
            else {
                try {
                    if (ChessBoard.diagonalRightDownCell(lastRightDownCell).getChessItem() instanceof BlackItem) {
                        rightDown.add(ChessBoard.diagonalRightDownCell(lastRightDownCell));
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
    @Override
    public ArrayList<Cell> getMoves() throws NoAvailableCells {
        if(whiteBishopMoves.size()>0) {
            return this.whiteBishopMoves;
        }
        else
        {
            throw new NoAvailableCells();
        }
    }


}
