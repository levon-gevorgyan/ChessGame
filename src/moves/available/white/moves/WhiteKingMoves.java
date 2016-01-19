package moves.available.white.moves;

import chessitems.BlackItem;
import chessitems.empty.Empty;
import chesstable.Table;
import chesstable.cells.Cell;
import chesstable.cells.Letters;
import exceptions.moves.NoAvailableCells;
import moves.WhiteMove;
import moves.available.moves.KingMoves;
import play.Game;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public class WhiteKingMoves extends KingMoves implements Letters {
    private ArrayList<Cell> whiteKingMoves;

    public WhiteKingMoves(Cell cell, Table Table)
    {
        ArrayList<Cell> whiteKingMoves=new ArrayList<>();
        for (Cell kingMove:getKingMoves(cell, Table))
        {
            if (kingMove.getChessItem() instanceof Empty || cell.getChessItem() instanceof BlackItem)
            {
                whiteKingMoves.add(kingMove);
            }

        }
        if(Table.getCell(B, 1).getChessItem() instanceof Empty
                && Table.getCell(C,1).getChessItem() instanceof Empty
                && Table.getCell(D,1).getChessItem() instanceof Empty)
        {
            if(WhiteMove.getLeftCastlingStatus())
            {
                whiteKingMoves.add(Table.getCell(C,1));
            }
        }
        if(Table.getCell(F,1).getChessItem() instanceof Empty
                && Table.getCell(G,1).getChessItem() instanceof Empty)
        {
            if(WhiteMove.getRightCastlingStatus())
            {
                whiteKingMoves.add(Table.getCell(G,1));
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
