package moves.available.black.moves;

import chessitems.WhiteItem;
import chessitems.black.BlackKnight;
import chessitems.empty.Empty;
import chesstable.cells.Cell;
import moves.available.moves.KnightMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class BlackKnightMoves extends KnightMoves{
    private ArrayList<Cell> blackKnightMoves;

    public BlackKnightMoves(Cell cell)
    {
        ArrayList<Cell> blackKnightMoves=new ArrayList<>();
        for (Cell knightMove:getKnightMoves(cell))
        {
            if (knightMove.getChessItem() instanceof Empty || cell.getChessItem() instanceof WhiteItem)
            {
                blackKnightMoves.add(knightMove);
            }

        }
        this.blackKnightMoves=blackKnightMoves;
    }

    public ArrayList<Cell> getBlackKnightMoves()
    {
        return this.blackKnightMoves;
    }
}
