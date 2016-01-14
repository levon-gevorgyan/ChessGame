package moves.available.moves;

import chessitems.BlackItem;
import chessitems.ChessItem;
import chessitems.WhiteItem;
import chesstable.Table;
import chesstable.cells.Cell;
import colors.Black;
import exceptions.cell.NoCell;
import exceptions.cell.NotEmptyCell;
import exceptions.table.OutOfTable;
import moves.Move;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public abstract class BishopMoves extends AvailableMoves {



    public ArrayList<Cell> BishopMovesDiagLeftUp(Cell cell) {
        ArrayList<Cell> bishopMovesDiagLeftUp = new ArrayList<>();
        try {

            bishopMovesDiagLeftUp.addAll(Move.moveDiagLeftUpUntilNotEmpty(cell));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return bishopMovesDiagLeftUp;

    }

    public ArrayList<Cell> BishopMovesDiagLeftDown(Cell cell) {
        ArrayList<Cell> bishopMovesDiagLeftDown = new ArrayList<>();
        try {


            bishopMovesDiagLeftDown.addAll(Move.moveDiagLeftDownUntilNotEmpty(cell));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return bishopMovesDiagLeftDown;

    }

    public ArrayList<Cell> BishopMovesDiagRightUp(Cell cell) {
        ArrayList<Cell> bishopMovesDiagRightUp = new ArrayList<>();
        try {


            bishopMovesDiagRightUp.addAll(Move.moveDiagRightUpUntilNotEmpty(cell));


        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return bishopMovesDiagRightUp;

    }

    public ArrayList<Cell> BishopMovesDiagRightDown(Cell cell) {
        ArrayList<Cell> bishopMovesDiagRightDown = new ArrayList<>();
        try {


            bishopMovesDiagRightDown.addAll(Move.moveDiagRightDownUntilNotEmpty(cell));

        } catch (NoCell noCell) {

        } catch (NotEmptyCell notEmptyCell) {

        } catch (OutOfTable outOfTable) {

        }
        return bishopMovesDiagRightDown;

    }







}
