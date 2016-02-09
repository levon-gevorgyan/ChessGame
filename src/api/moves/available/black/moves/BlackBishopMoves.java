package api.moves.available.black.moves;


import api.chessboard.ChessBoard;
import api.chessitems.WhiteItem;
import api.chessboard.cells.Cell;
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
    public BlackBishopMoves(Cell cell,ChessBoard ChessBoard)  {

        try {
            ArrayList<Cell> blackBishopMoves = new ArrayList<>();


            ArrayList<Cell> leftUp = bishopMovesDiagLeftUp(cell, ChessBoard);
            ArrayList<Cell> leftDown = bishopMovesDiagLeftDown(cell, ChessBoard);
            ArrayList<Cell> rightUp = bishopMovesDiagRightUp(cell, ChessBoard);
            ArrayList<Cell> rightDown = bishopMovesDiagRightDown(cell, ChessBoard);

            Cell lastLeftUpCell = cell;
            if (leftUp.size() > 0) {
                lastLeftUpCell = leftUp.get(leftUp.size() - 1);
                try {
                    if (ChessBoard.diagonalLeftUpCell(lastLeftUpCell).getChessItem() instanceof WhiteItem) {
                        leftUp.add(ChessBoard.diagonalLeftUpCell(lastLeftUpCell));
                    }
                } catch (NoCell noCell) {

                }

            }
            else {
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

            }
            else {
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
            }
            else {
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
            }
            else {
                try {
                    if (ChessBoard.diagonalRightDownCell(lastRightDownCell).getChessItem() instanceof WhiteItem) {
                        rightDown.add(ChessBoard.diagonalRightDownCell(lastRightDownCell));
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
