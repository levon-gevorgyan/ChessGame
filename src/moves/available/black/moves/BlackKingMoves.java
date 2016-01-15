package moves.available.black.moves;

import chessitems.WhiteItem;
import chessitems.empty.Empty;
import chesstable.cells.Cell;
import chesstable.cells.Letters;
import exceptions.moves.NoAvailableCells;
import moves.BlackMove;
import moves.available.moves.KingMoves;
import play.Game;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public class BlackKingMoves extends KingMoves implements Letters{
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
        if(Game.TABLE.getCell(B,8).getChessItem() instanceof Empty
                && Game.TABLE.getCell(C,8).getChessItem() instanceof Empty
                && Game.TABLE.getCell(D,8).getChessItem() instanceof Empty)
        {
            if(BlackMove.getLeftCastlingStatus())
            {
                blackKingMoves.add(Game.TABLE.getCell(C,8));
            }
        }
        if(Game.TABLE.getCell(F,8).getChessItem() instanceof Empty
                && Game.TABLE.getCell(G,8).getChessItem() instanceof Empty)
        {
            if(BlackMove.getRightCastlingStatus())
            {
                blackKingMoves.add(Game.TABLE.getCell(G,8));
            }
        }

        this.blackKingMoves=blackKingMoves;
    }

    public ArrayList<Cell> getBlackKingMoves() throws NoAvailableCells {
        if(blackKingMoves.size()>0){
            return this.blackKingMoves;
        }
        else
            throw new NoAvailableCells();
    }

}
