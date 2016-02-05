package api.moves.available.black.moves;

import api.chessitems.WhiteItem;
import api.chessitems.empty.Empty;
import api.chesstable.Table;
import api.chesstable.cells.Cell;
import api.chesstable.cells.Letters;
import api.exceptions.moves.NoAvailableCells;
import api.moves.BlackMove;
import api.moves.available.moves.KingMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public class BlackKingMoves extends KingMoves implements Letters{
    private ArrayList<Cell> blackKingMoves;

    public BlackKingMoves(Cell cell, Table Table)
    {
        ArrayList<Cell> blackKingMoves=new ArrayList<>();
        for (Cell kingMove:getKingMoves(cell,Table))
        {
            if (kingMove.getChessItem() instanceof Empty || kingMove.getChessItem() instanceof WhiteItem)
            {
                blackKingMoves.add(kingMove);
            }

        }
        if(Table.getCell(B,8).getChessItem() instanceof Empty
                && Table.getCell(C,8).getChessItem() instanceof Empty
                && Table.getCell(D,8).getChessItem() instanceof Empty)
        {
            if(BlackMove.getLeftCastlingStatus())
            {
                blackKingMoves.add(Table.getCell(C,8));
            }
        }
        if(Table.getCell(F,8).getChessItem() instanceof Empty
                && Table.getCell(G,8).getChessItem() instanceof Empty)
        {
            if(BlackMove.getRightCastlingStatus())
            {
                blackKingMoves.add(Table.getCell(G,8));
            }
        }

        this.blackKingMoves=blackKingMoves;
    }
    @Override
    public ArrayList<Cell> getMoves() throws NoAvailableCells {
        if(blackKingMoves.size()>0){
            return this.blackKingMoves;
        }
        else
            throw new NoAvailableCells();
    }
    public BlackKingMoves(Cell cell, Table Table,boolean isCheck)
    {
        ArrayList<Cell> blackKingMoves = new ArrayList<>();
        if(isCheck) {

            for (Cell kingMove : getKingMoves(cell, Table)) {
                if (kingMove.getChessItem() instanceof Empty || kingMove.getChessItem() instanceof WhiteItem) {
                    blackKingMoves.add(kingMove);
                }
            }
        }
        if(!isCheck){
            for (Cell kingMove:getKingMoves(cell,Table))
            {
                if (kingMove.getChessItem() instanceof Empty || kingMove.getChessItem() instanceof WhiteItem)
                {
                    blackKingMoves.add(kingMove);
                }

            }
            if(Table.getCell(B,8).getChessItem() instanceof Empty
                    && Table.getCell(C,8).getChessItem() instanceof Empty
                    && Table.getCell(D,8).getChessItem() instanceof Empty)
            {
                if(BlackMove.getLeftCastlingStatus())
                {
                    blackKingMoves.add(Table.getCell(C,8));
                }
            }
            if(Table.getCell(F,8).getChessItem() instanceof Empty
                    && Table.getCell(G,8).getChessItem() instanceof Empty)
            {
                if(BlackMove.getRightCastlingStatus())
                {
                    blackKingMoves.add(Table.getCell(G,8));
                }
            }
        }


        this.blackKingMoves=blackKingMoves;
    }

}
