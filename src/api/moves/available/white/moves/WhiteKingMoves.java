package api.moves.available.white.moves;

import api.chessitems.BlackItem;
import api.chessitems.empty.Empty;
import api.chesstable.Table;
import api.chesstable.cells.Cell;
import api.chesstable.cells.Letters;
import api.exceptions.moves.NoAvailableCells;
import api.moves.WhiteMove;
import api.moves.available.moves.KingMoves;

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
            if (kingMove.getChessItem() instanceof Empty || kingMove.getChessItem() instanceof BlackItem)
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
    @Override
    public ArrayList<Cell> getMoves() throws NoAvailableCells {
        if(whiteKingMoves.size()>0) {
            return this.whiteKingMoves;
        }
        else
            throw new NoAvailableCells();
    }
    public WhiteKingMoves(Cell cell, Table Table,boolean isCheck)
    {
        ArrayList<Cell> whiteKingMoves = new ArrayList<>();
        if(isCheck) {

            for (Cell kingMove : getKingMoves(cell, Table)) {
                if (kingMove.getChessItem() instanceof Empty || kingMove.getChessItem() instanceof BlackItem) {
                    whiteKingMoves.add(kingMove);
                }
            }
        }
        if (!isCheck){
                        for (Cell kingMove:getKingMoves(cell, Table))
            {
                if (kingMove.getChessItem() instanceof Empty || kingMove.getChessItem() instanceof BlackItem)
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
        }


        this.whiteKingMoves=whiteKingMoves;
    }

}
