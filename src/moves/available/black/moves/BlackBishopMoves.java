package moves.available.black.moves;

import chessitems.BlackItem;
import chessitems.WhiteItem;
import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.cell.NoCell;
import exceptions.table.OutOfTable;
import moves.available.moves.AvailableMoves;
import moves.available.moves.BishopMoves;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public class BlackBishopMoves extends BishopMoves {
    private ArrayList<Cell> blackBishopMoves;
    public BlackBishopMoves(Cell cell) throws OutOfTable, NoCell {

        ArrayList<Cell> blackBishopMoves=new ArrayList<>();



        ArrayList<Cell> leftUp=BishopMovesDiagLeftUp(cell);
        ArrayList<Cell> leftDown=BishopMovesDiagLeftDown(cell);
        ArrayList<Cell> rightUp=BishopMovesDiagRightUp(cell);
        ArrayList<Cell> rightDown=BishopMovesDiagRightDown(cell);
                
        Cell lastLeftUpCell=leftUp.get(leftUp.size() - 1);
        Cell lastLeftDownCell=leftDown.get(leftDown.size() - 1);
        Cell lastRightUpCell=rightUp.get(rightUp.size()-1);
        Cell lastRightDownCell=rightDown.get(rightDown.size()-1);
        
        if (Table.diagonalLeftUpCell(lastLeftUpCell).getChessItem()instanceof WhiteItem){
            leftUp.add(lastLeftUpCell);            
        }
        if (Table.diagonalLeftDownCell(lastLeftDownCell).getChessItem()instanceof WhiteItem){
            leftDown.add(lastLeftDownCell);            
        }
        if (Table.diagonalRightUpCell(lastRightUpCell).getChessItem()instanceof WhiteItem){
            rightUp.add(lastRightUpCell);            
        }
        if (Table.diagonalRightDownCell(lastRightDownCell).getChessItem()instanceof WhiteItem){
            rightDown.add(lastRightDownCell);            
        }
        blackBishopMoves.addAll(leftUp);
        blackBishopMoves.addAll(leftDown);
        blackBishopMoves.addAll(rightUp);
        blackBishopMoves.addAll(rightDown);
        this.blackBishopMoves=blackBishopMoves;

    }
    public ArrayList<Cell> getBlackBishopMoves()
    {
        return this.blackBishopMoves;
    }


}
