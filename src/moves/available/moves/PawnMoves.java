package moves.available.moves;

import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.cell.NoCell;
import exceptions.table.OutOfTable;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public abstract class PawnMoves extends AvailableMoves {

    //White Pawn
    protected ArrayList<Cell> getWhitePawnMove(Cell cell) {
        ArrayList<Cell> whitePawnMove = new ArrayList<>();
        try {
            whitePawnMove.add(Table.upCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }
        return whitePawnMove;
    }

    protected ArrayList<Cell> getWhitePawnEatMoves(Cell cell) {
        ArrayList<Cell> whitePawnEatMoves = new ArrayList<>();
        {
            try {
                whitePawnEatMoves.add(Table.diagonalLeftUpCell(cell));

            } catch (OutOfTable outOfTable) {

            } catch (NoCell noCell) {

            }
            try {
                whitePawnEatMoves.add(Table.diagonalRightUpCell(cell));

            } catch (OutOfTable outOfTable) {

            } catch (NoCell noCell) {

            }


            return whitePawnEatMoves;
        }
    }

    protected ArrayList<Cell> getWhitePawnMove2(Cell cell) {
        ArrayList<Cell> whitePawnMoves2 = new ArrayList<>();
        {
            try {

                boolean isAllowed=false;
                for (Cell theCell:Table.rows.get(1)) {
                    if (theCell.equals(cell))
                    {
                        isAllowed=true;
                        break;
                    }
                }
                if(isAllowed) {
                    cell=Table.upCell(cell);

                    whitePawnMoves2.add(Table.upCell(cell));
                }


            } catch (OutOfTable outOfTable) {

            } catch (NoCell noCell) {

            }



            return whitePawnMoves2;
        }
    }


    //Black Pawn
    protected ArrayList<Cell> getBlackPawnMove (Cell cell){
        ArrayList<Cell> blackPawnMove = new ArrayList<>();
        try {
            blackPawnMove.add(Table.downCell(cell));

        } catch (OutOfTable outOfTable) {

        } catch (NoCell noCell) {

        }
        return blackPawnMove;
    }

    protected ArrayList<Cell> getBlackPawnEatMoves (Cell cell){
        ArrayList<Cell> blackPawnEatMoves = new ArrayList<>();
        {
            try {
                blackPawnEatMoves.add(Table.diagonalLeftDownCell(cell));

            } catch (OutOfTable outOfTable) {

            } catch (NoCell noCell) {

            }
            try {
                blackPawnEatMoves.add(Table.diagonalRightDownCell(cell));

            } catch (OutOfTable outOfTable) {

            } catch (NoCell noCell) {

            }


            return blackPawnEatMoves;
        }


    }

    protected ArrayList<Cell> getBlackPawnMove2(Cell cell) {
        ArrayList<Cell> blackPawnMoves2 = new ArrayList<>();
        {
            try {

                boolean isAllowed=false;
                for (Cell theCell:Table.rows.get(6)) {
                    if (theCell.equals(cell))
                    {
                        isAllowed=true;
                    }
                }
                if(isAllowed) {
                    cell=Table.downCell(cell);
                    blackPawnMoves2.add(Table.downCell(cell));
                }


            } catch (OutOfTable outOfTable) {

            } catch (NoCell noCell) {

            }



            return blackPawnMoves2;
        }
    }
}



