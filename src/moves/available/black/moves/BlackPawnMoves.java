package moves.available.black.moves;

import chessitems.WhiteItem;
import chessitems.empty.Empty;
import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.moves.NoAvailableCells;
import moves.available.moves.PawnMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class BlackPawnMoves extends PawnMoves {
    private ArrayList<Cell> blackPawnMoves;

    public BlackPawnMoves(Cell cell, Table Table) {
        ArrayList<Cell> blackPawnMoves = new ArrayList<>();

        if (getBlackPawnMove(cell, Table).size() > 0) {
            if (getBlackPawnMove(cell, Table).get(0).getChessItem() instanceof Empty) {
                blackPawnMoves.add(getBlackPawnMove(cell, Table).get(0));
            }
        }
        if (getBlackPawnMove2(cell, Table).size() > 0) {
            if (getBlackPawnMove2(cell, Table).get(0).getChessItem() instanceof Empty) {
                blackPawnMoves.add(getBlackPawnMove2(cell, Table).get(0));
            }
        }
        if (getBlackPawnEatMoves(cell, Table).size() > 0) {
            for (Cell eaten : getBlackPawnEatMoves(cell, Table)) {
                if (eaten.getChessItem() instanceof WhiteItem) {
                    blackPawnMoves.add(eaten);
                }
            }


            this.blackPawnMoves = blackPawnMoves;
        }
    }
    @Override
    public ArrayList<Cell> getMoves() throws NoAvailableCells

    {
        if(blackPawnMoves.size()>0){
            return this.blackPawnMoves;
        }
        else
            throw new NoAvailableCells();
    }
}
