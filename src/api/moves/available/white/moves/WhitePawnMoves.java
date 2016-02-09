package api.moves.available.white.moves;

import api.chessboard.ChessBoard;
import api.chessitems.BlackItem;
import api.chessitems.empty.Empty;
import api.chessboard.cells.Cell;
import api.exceptions.moves.NoAvailableCells;
import api.moves.available.moves.PawnMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 13/01/16.
 */
public class WhitePawnMoves extends PawnMoves {
    private ArrayList<Cell> whitePawnMoves;

    public WhitePawnMoves(Cell cell, ChessBoard ChessBoard) {
        ArrayList<Cell> whitePawnMoves = new ArrayList<>();

        if (getWhitePawnMove(cell, ChessBoard).size() > 0) {
            if (getWhitePawnMove(cell, ChessBoard).get(0).getChessItem() instanceof Empty) {
                whitePawnMoves.add(getWhitePawnMove(cell, ChessBoard).get(0));
            }
        }
        if (getWhitePawnMove2(cell, ChessBoard).size() > 0) {
            if (getWhitePawnMove2(cell, ChessBoard).get(0).getChessItem() instanceof Empty) {
                whitePawnMoves.add(getWhitePawnMove2(cell, ChessBoard).get(0));
            }
        }
        if (getWhitePawnEatMoves(cell, ChessBoard).size() > 0) {
            for (Cell eaten : getWhitePawnEatMoves(cell, ChessBoard)) {
                if (eaten.getChessItem() instanceof BlackItem) {
                    whitePawnMoves.add(eaten);
                }
            }


            this.whitePawnMoves = whitePawnMoves;
        }
    }
    @Override
    public ArrayList<Cell> getMoves() throws NoAvailableCells

    {
        if(whitePawnMoves.size()>0) {
            return this.whitePawnMoves;
        }
        else
            throw new NoAvailableCells();
    }
}
