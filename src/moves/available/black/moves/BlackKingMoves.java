package moves.available.black.moves;

import chessitems.WhiteItem;
import chessitems.empty.Empty;
import chesstable.cells.Cell;
import moves.available.moves.BishopMoves;
import moves.available.moves.KingMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public class BlackKingMoves extends KingMoves {
    private ArrayList<Cell> blackKingMoves;

    public BlackKingMoves(Cell cell)
    {
        ArrayList<Cell> blackKingMoves=new ArrayList<>();
        for (Cell kingMove:getKingMoves(cell))
        {
            if (kingMove.getChessItem() instanceof Empty || cell.getChessItem() instanceof WhiteItem)
            {
                blackKingMoves.add(kingMove);
            }

        }
        this.blackKingMoves=blackKingMoves;
    }

    public ArrayList<Cell> getBlackKingMoves()
    {
        return this.blackKingMoves;
    }

}
