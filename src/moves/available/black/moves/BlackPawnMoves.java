package moves.available.black.moves;

import chessitems.WhiteItem;
import chessitems.empty.Empty;
import chesstable.cells.Cell;
import exceptions.moves.NoAvailableCells;
import moves.available.moves.PawnMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class BlackPawnMoves extends PawnMoves {
    private ArrayList<Cell> blackPawnMoves;

    public BlackPawnMoves(Cell cell) {
        ArrayList<Cell> blackPawnMoves = new ArrayList<>();

        if (getBlackPawnMove(cell).size() > 0) {
            if (getBlackPawnMove(cell).get(0).getChessItem() instanceof Empty) {
                blackPawnMoves.add(getBlackPawnMove(cell).get(0));
            }
        }
        if (getBlackPawnEatMoves(cell).size() > 0) {
            for (Cell eaten : getBlackPawnEatMoves(cell)) {
                if (eaten.getChessItem() instanceof WhiteItem) {
                    blackPawnMoves.add(eaten);
                }
            }


            this.blackPawnMoves = blackPawnMoves;
        }
    }

    public ArrayList<Cell> getBlackPawnMoves() throws NoAvailableCells

    {
        if(blackPawnMoves.size()>0){
            return this.blackPawnMoves;
        }
        else
            throw new NoAvailableCells();


    }
}

