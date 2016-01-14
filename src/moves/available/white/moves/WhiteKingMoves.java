package moves.available.white.moves;

import chessitems.BlackItem;
import chessitems.empty.Empty;
import chesstable.cells.Cell;
import exceptions.moves.NoAvailableCells;
import moves.available.moves.KingMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public class WhiteKingMoves extends KingMoves {
    private ArrayList<Cell> whiteKingMoves;

    public WhiteKingMoves(Cell cell)
    {
        ArrayList<Cell> whiteKingMoves=new ArrayList<>();
        for (Cell kingMove:getKingMoves(cell))
        {
            if (kingMove.getChessItem() instanceof Empty || cell.getChessItem() instanceof BlackItem)
            {
                whiteKingMoves.add(kingMove);
            }

        }
        this.whiteKingMoves=whiteKingMoves;
    }

    public ArrayList<Cell> getWhiteKingMoves() throws NoAvailableCells {
        if(whiteKingMoves.size()>0) {
            return this.whiteKingMoves;
        }
        else
            throw new NoAvailableCells();
    }


}
