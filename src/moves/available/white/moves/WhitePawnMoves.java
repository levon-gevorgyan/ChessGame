package moves.available.white.moves;

import chessitems.BlackItem;
import chessitems.empty.Empty;
import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.moves.NoAvailableCells;
import moves.available.moves.PawnMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class WhitePawnMoves extends PawnMoves {
    private ArrayList<Cell> whitePawnMoves;

    public WhitePawnMoves(Cell cell, Table Table) {
        ArrayList<Cell> whitePawnMoves = new ArrayList<>();

        if (getWhitePawnMove(cell, Table).size() > 0) {
            if (getWhitePawnMove(cell, Table).get(0).getChessItem() instanceof Empty) {
                whitePawnMoves.add(getWhitePawnMove(cell, Table).get(0));
            }
        }
        if (getWhitePawnMove2(cell, Table).size() > 0) {
            if (getWhitePawnMove2(cell, Table).get(0).getChessItem() instanceof Empty) {
                whitePawnMoves.add(getWhitePawnMove2(cell, Table).get(0));
            }
        }
        if (getWhitePawnEatMoves(cell, Table).size() > 0) {
            for (Cell eaten : getWhitePawnEatMoves(cell, Table)) {
                if (eaten.getChessItem() instanceof BlackItem) {
                    whitePawnMoves.add(eaten);
                }
            }


            this.whitePawnMoves = whitePawnMoves;
        }
    }
    @Override
    public ArrayList<Cell> getMoves() throws NoAvailableCells

    {
        if(whitePawnMoves.size()>0) {
            return this.whitePawnMoves;
        }
        else
            throw new NoAvailableCells();
    }
}
