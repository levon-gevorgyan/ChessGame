package api.moves.available.white.moves;

import api.chessitems.BlackItem;
import api.chessitems.empty.Empty;
import api.chesstable.Table;
import api.chesstable.cells.Cell;
import api.exceptions.moves.NoAvailableCells;
import api.moves.available.moves.KnightMoves;

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
    @Override
    public ArrayList<Cell> getMoves() throws NoAvailableCells {
        if(whiteKnightMoves.size()>0) {
            return this.whiteKnightMoves;
        }
        else
            throw new NoAvailableCells();
    }
}
