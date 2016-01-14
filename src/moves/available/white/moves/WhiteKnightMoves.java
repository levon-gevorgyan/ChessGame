package moves.available.white.moves;

import chessitems.BlackItem;
import chessitems.empty.Empty;
import chesstable.cells.Cell;
import moves.available.moves.KnightMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class WhiteKnightMoves extends KnightMoves{

    private ArrayList<Cell> whiteKnightMoves;

    public WhiteKnightMoves(Cell cell)
    {
        ArrayList<Cell> whiteKnightMoves=new ArrayList<>();
        for (Cell knightMove:getKnightMoves(cell))
        {
            if (knightMove.getChessItem() instanceof Empty || cell.getChessItem() instanceof BlackItem)
            {
                whiteKnightMoves.add(knightMove);
            }

        }
        this.whiteKnightMoves=whiteKnightMoves;
    }

    public ArrayList<Cell> getWhiteKnightMoves()
    {
        return this.whiteKnightMoves;
    }
}
