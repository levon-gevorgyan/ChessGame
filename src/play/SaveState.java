package play;

import chessitems.ChessItem;
import chesstable.Table;
import chesstable.cells.BlackCell;
import chesstable.cells.Cell;
import chesstable.cells.WhiteCell;
import players.BlackPlayer;
import players.Player;
import players.WhitePlayer;


import java.util.*;

//Created by Levon on 17.01.2016.


public class SaveState {

    private SortedMap<String,Cell> cells;

    private ArrayList<ArrayList<Cell>> rows;
    private ArrayList<ArrayList<Cell>> columns;
    private Map<String, ChessItem> whiteItemsMap;
    private Map<String, ChessItem> blackItemsMap;



    public SaveState(Table table, Player whitePlayer, Player blackPlayer)
    {
        this.cells= (SortedMap<String,Cell>)((TreeMap<String,Cell>)table.getCells()).clone();


        this.rows=new ArrayList<ArrayList<Cell>>(table.getRows());
        this.columns=new ArrayList<ArrayList<Cell>>(table.getColumns());
        this.whiteItemsMap=(Map<String, ChessItem>)((HashMap<String, ChessItem>)whitePlayer.getChessItemsMap()).clone();
        this.blackItemsMap=(Map<String, ChessItem>)((HashMap<String, ChessItem>)blackPlayer.getChessItemsMap()).clone();

    }

    public void returnHere (Table table, Player whitePlayer, Player blackPlayer)
    {
        table.setCells(this.cells);
        table.setRows(this.rows);
        table.setColumns(this.columns);
        //whitePlayer.setChessItemsMap(whiteItemsMap);
        //blackPlayer.setChessItemsMap(blackItemsMap);
    }
}
