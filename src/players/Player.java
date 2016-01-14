package players;

import chessitems.ChessItem;
import chesstable.Table;
import chesstable.cells.Cell;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Levon on 1/10/2016.
 */
public abstract class Player {
    public abstract Map<String, ChessItem> getChessItemsMap();


}
