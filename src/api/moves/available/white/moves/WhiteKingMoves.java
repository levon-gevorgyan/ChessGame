package api.moves.available.white.moves;

import api.chessitems.BlackItem;
import api.chessitems.empty.Empty;
import api.chessboard.ChessBoard;
import api.chessboard.cells.Cell;
import api.chessboard.cells.Letters;
import api.exceptions.moves.NoAvailableCells;
import api.moves.WhiteMove;
import api.moves.available.moves.KingMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public class WhiteKingMoves extends KingMoves implements Letters {
    private ArrayList<Cell> whiteKingMoves;

    public WhiteKingMoves(Cell cell, ChessBoard ChessBoard)
    {
        ArrayList<Cell> whiteKingMoves=new ArrayList<>();
        for (Cell kingMove:getKingMoves(cell, ChessBoard))
        {
            if (kingMove.getChessItem() instanceof Empty || kingMove.getChessItem() instanceof BlackItem)
            {
                whiteKingMoves.add(kingMove);
            }

        }
        if(ChessBoard.getCell(B, 1).getChessItem() instanceof Empty
                && ChessBoard.getCell(C,1).getChessItem() instanceof Empty
                && ChessBoard.getCell(D,1).getChessItem() instanceof Empty)
        {
            if(WhiteMove.getLeftCastlingStatus())
            {
                whiteKingMoves.add(ChessBoard.getCell(C,1));
            }
        }
        if(ChessBoard.getCell(F,1).getChessItem() instanceof Empty
                && ChessBoard.getCell(G,1).getChessItem() instanceof Empty)
        {
            if(WhiteMove.getRightCastlingStatus())
            {
                whiteKingMoves.add(ChessBoard.getCell(G,1));
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
    public WhiteKingMoves(Cell cell, ChessBoard ChessBoard,boolean isCheck)
    {
        ArrayList<Cell> whiteKingMoves = new ArrayList<>();
        if(isCheck) {

            for (Cell kingMove : getKingMoves(cell, ChessBoard)) {
                if (kingMove.getChessItem() instanceof Empty || kingMove.getChessItem() instanceof BlackItem) {
                    whiteKingMoves.add(kingMove);
                }
            }
        }
        if (!isCheck){
                        for (Cell kingMove:getKingMoves(cell, ChessBoard))
            {
                if (kingMove.getChessItem() instanceof Empty || kingMove.getChessItem() instanceof BlackItem)
                {
                    whiteKingMoves.add(kingMove);
                }

            }
            if(ChessBoard.getCell(B, 1).getChessItem() instanceof Empty
                    && ChessBoard.getCell(C,1).getChessItem() instanceof Empty
                    && ChessBoard.getCell(D,1).getChessItem() instanceof Empty)
            {
                if(WhiteMove.getLeftCastlingStatus())
                {
                    whiteKingMoves.add(ChessBoard.getCell(C,1));
                }
            }
            if(ChessBoard.getCell(F,1).getChessItem() instanceof Empty
                    && ChessBoard.getCell(G,1).getChessItem() instanceof Empty)
            {
                if(WhiteMove.getRightCastlingStatus())
                {
                    whiteKingMoves.add(ChessBoard.getCell(G,1));
                }
            }
        }


        this.whiteKingMoves=whiteKingMoves;
    }

}
