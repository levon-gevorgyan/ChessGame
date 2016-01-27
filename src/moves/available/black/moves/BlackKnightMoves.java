package moves.available.black.moves;

import chessitems.WhiteItem;
import chessitems.black.BlackKnight;
import chessitems.empty.Empty;
import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.moves.NoAvailableCells;
import moves.available.moves.KnightMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class BlackKnightMoves extends KnightMoves{
    private ArrayList<Cell> blackKnightMoves;

    public BlackKnightMoves(Cell cell, Table Table)
    {
        ArrayList<Cell> blackKnightMoves=new ArrayList<>();
        for (Cell knightMove:getKnightMoves(cell, Table))
        {
            if(knightMove.getChessItem() instanceof Empty || cell.getChessItem() instanceof WhiteItem)
            {
                blackKnightMoves.add(knightMove);
            }

        }
        this.blackKnightMoves=blackKnightMoves;
    }
    @Override
    public ArrayList<Cell> getMoves() throws NoAvailableCells {
        if(blackKnightMoves.size()>0) {
            return this.blackKnightMoves;
        }
        else
            throw new NoAvailableCells();
    }
}
