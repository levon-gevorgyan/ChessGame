package api.moves.available.black.moves;

import api.chessboard.ChessBoard;
import api.chessitems.WhiteItem;
import api.chessitems.empty.Empty;
import api.chessboard.cells.Cell;
import api.chessboard.cells.Letters;
import api.exceptions.moves.NoAvailableCells;
import api.moves.BlackMove;
import api.moves.available.moves.KingMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public class BlackKingMoves extends KingMoves implements Letters{
    private ArrayList<Cell> blackKingMoves;

    public BlackKingMoves(Cell cell, ChessBoard ChessBoard)
    {
        ArrayList<Cell> blackKingMoves=new ArrayList<>();
        for (Cell kingMove:getKingMoves(cell, ChessBoard))
        {
            if (kingMove.getChessItem() instanceof Empty || kingMove.getChessItem() instanceof WhiteItem)
            {
                blackKingMoves.add(kingMove);
            }

        }
        if(ChessBoard.getCell(B,8).getChessItem() instanceof Empty
                && ChessBoard.getCell(C,8).getChessItem() instanceof Empty
                && ChessBoard.getCell(D,8).getChessItem() instanceof Empty)
        {
            if(BlackMove.getLeftCastlingStatus())
            {
                blackKingMoves.add(ChessBoard.getCell(C,8));
            }
        }
        if(ChessBoard.getCell(F,8).getChessItem() instanceof Empty
                && ChessBoard.getCell(G,8).getChessItem() instanceof Empty)
        {
            if(BlackMove.getRightCastlingStatus())
            {
                blackKingMoves.add(ChessBoard.getCell(G,8));
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
    public BlackKingMoves(Cell cell, ChessBoard ChessBoard,boolean isCheck)
    {
        ArrayList<Cell> blackKingMoves = new ArrayList<>();
        if(isCheck) {

            for (Cell kingMove : getKingMoves(cell, ChessBoard)) {
                if (kingMove.getChessItem() instanceof Empty || kingMove.getChessItem() instanceof WhiteItem) {
                    blackKingMoves.add(kingMove);
                }
            }
        }
        if(!isCheck){
            for (Cell kingMove:getKingMoves(cell, ChessBoard))
            {
                if (kingMove.getChessItem() instanceof Empty || kingMove.getChessItem() instanceof WhiteItem)
                {
                    blackKingMoves.add(kingMove);
                }

            }
            if(ChessBoard.getCell(B,8).getChessItem() instanceof Empty
                    && ChessBoard.getCell(C,8).getChessItem() instanceof Empty
                    && ChessBoard.getCell(D,8).getChessItem() instanceof Empty)
            {
                if(BlackMove.getLeftCastlingStatus())
                {
                    blackKingMoves.add(ChessBoard.getCell(C,8));
                }
            }
            if(ChessBoard.getCell(F,8).getChessItem() instanceof Empty
                    && ChessBoard.getCell(G,8).getChessItem() instanceof Empty)
            {
                if(BlackMove.getRightCastlingStatus())
                {
                    blackKingMoves.add(ChessBoard.getCell(G,8));
                }
            }
        }


        this.blackKingMoves=blackKingMoves;
    }

}
