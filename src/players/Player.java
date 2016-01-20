package players;

import chessitems.ChessItem;
import chesstable.Table;
import chesstable.cells.Cell;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by Levon on 1/10/2016.
 */
public abstract class Player {
    public abstract SortedMap<String, ChessItem> getChessItemsMap();
    public abstract void setChessItemsMap(SortedMap<String, ChessItem> chessItemsMap);


}
