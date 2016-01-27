package moves.available.moves;

import chesstable.cells.Cell;
import exceptions.moves.NoAvailableCells;

import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 12/01/16.
 */
public abstract class AvailableMoves {
    public abstract ArrayList<Cell> getMoves() throws NoAvailableCells;


}
