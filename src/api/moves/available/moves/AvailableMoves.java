package api.moves.available.moves;

import api.chessboard.cells.Cell;
import api.exceptions.moves.NoAvailableCells;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public abstract class AvailableMoves {
    public abstract ArrayList<Cell> getMoves() throws NoAvailableCells;


}
