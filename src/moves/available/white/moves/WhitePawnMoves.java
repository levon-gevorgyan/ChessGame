package moves.available.white.moves;

import chessitems.BlackItem;
import chessitems.empty.Empty;
import chesstable.cells.Cell;
import exceptions.moves.NoAvailableCells;
import moves.available.moves.PawnMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class WhitePawnMoves extends PawnMoves {
    private ArrayList<Cell> whitePawnMoves;

    public WhitePawnMoves(Cell cell) {
        ArrayList<Cell> whitePawnMoves = new ArrayList<>();

        if (getWhitePawnMove(cell).size() > 0) {
            if (getWhitePawnMove(cell).get(0).getChessItem() instanceof Empty) {
                whitePawnMoves.add(getWhitePawnMove(cell).get(0));
            }
        }
        if (getWhitePawnMove2(cell).size() > 0) {
            if (getWhitePawnMove2(cell).get(0).getChessItem() instanceof Empty) {
                whitePawnMoves.add(getWhitePawnMove2(cell).get(0));
            }
        }
        if (getWhitePawnEatMoves(cell).size() > 0) {
            for (Cell eaten : getWhitePawnEatMoves(cell)) {
                if (eaten.getChessItem() instanceof BlackItem) {
                    whitePawnMoves.add(eaten);
                }
            }


            this.whitePawnMoves = whitePawnMoves;
        }
    }

    public ArrayList<Cell> getWhitePawnMoves() throws NoAvailableCells

    {
        if(whitePawnMoves.size()>0) {
            return this.whitePawnMoves;
        }
        else
            throw new NoAvailableCells();
    }
}
