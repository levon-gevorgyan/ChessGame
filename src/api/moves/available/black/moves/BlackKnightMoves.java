package api.moves.available.black.moves;

import api.chessboard.ChessBoard;
import api.chessitems.WhiteItem;
import api.chessitems.empty.Empty;
import api.chessboard.cells.Cell;
import api.exceptions.moves.NoAvailableCells;
import api.moves.available.moves.KnightMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class BlackKnightMoves extends KnightMoves{
    private ArrayList<Cell> blackKnightMoves;

    public BlackKnightMoves(Cell cell, ChessBoard ChessBoard)
    {
        ArrayList<Cell> blackKnightMoves=new ArrayList<>();
        for (Cell knightMove:getKnightMoves(cell, ChessBoard))
        {
            if(knightMove.getChessItem() instanceof Empty || knightMove.getChessItem() instanceof WhiteItem)
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
