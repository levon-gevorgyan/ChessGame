package api.moves.available.black.moves;


import api.chessboard.ChessBoard;
import api.chessitems.WhiteItem;
import api.chessboard.cells.Cell;
import api.exceptions.cell.NoCell;
import api.exceptions.moves.NoAvailableCells;
import api.exceptions.table.OutOfTable;
import api.moves.available.moves.RookMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class BlackRookMoves extends RookMoves {
    private ArrayList<Cell> blackRookMoves;
    public BlackRookMoves(Cell cell, ChessBoard ChessBoard){

        try {
            ArrayList<Cell> blackRookMoves = new ArrayList<>();


            ArrayList<Cell> up = rookMovesUp(cell, ChessBoard);
            ArrayList<Cell> down = rookMovesDown(cell, ChessBoard);
            ArrayList<Cell> left = rookMovesLeft(cell, ChessBoard);
            ArrayList<Cell> right = rookMovesRight(cell, ChessBoard);

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
    @Override
    public ArrayList<Cell> getMoves() throws NoAvailableCells {
        if(blackRookMoves.size()>0){
            return this.blackRookMoves;
        }
        else
            throw new NoAvailableCells();

    }


}
