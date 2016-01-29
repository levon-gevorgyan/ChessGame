package moves.available.white.moves;

import chessitems.BlackItem;
import chessitems.empty.Empty;
import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.moves.NoAvailableCells;
import moves.available.moves.KnightMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class WhiteKnightMoves extends KnightMoves{

    private ArrayList<Cell> whiteKnightMoves;

    public WhiteKnightMoves(Cell cell, Table Table)
    {
        ArrayList<Cell> whiteKnightMoves=new ArrayList<>();
        for (Cell knightMove:getKnightMoves(cell,Table))
        {
            if (knightMove.getChessItem() instanceof Empty || knightMove.getChessItem() instanceof BlackItem)
            {
                whiteKnightMoves.add(knightMove);
            }

        }
        this.whiteKnightMoves=whiteKnightMoves;
    }

    public ArrayList<Cell> getWhiteKnightMoves() throws NoAvailableCells {
        if(whiteKnightMoves.size()>0) {
            return this.whiteKnightMoves;
        }
        else
            throw new NoAvailableCells();
    }
}
