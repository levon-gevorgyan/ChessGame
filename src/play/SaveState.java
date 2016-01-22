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

    private SortedMap<String,ChessItem> allChessItems=new TreeMap<>();

    private SortedMap<String, ChessItem> whiteChessItems=new TreeMap<>();;
    private SortedMap<String, ChessItem> blackChessItems=new TreeMap<>();;



    public SaveState(Table table, WhitePlayer whitePlayer, BlackPlayer blackPlayer)
    {

        for (SortedMap.Entry<String,Cell> pair:table.getCells().entrySet())
        {
            this.allChessItems.put(pair.getKey(), pair.getValue().getChessItem());
        }
        this.whiteChessItems =  (SortedMap<String,ChessItem>)((TreeMap<String,ChessItem>) whitePlayer.getChessItemsMap()).clone();
        this.blackChessItems = (SortedMap<String,ChessItem>)((TreeMap<String,ChessItem>) blackPlayer.getChessItemsMap()).clone();

    }

    public void undoHere (Table table, Player whitePlayer, Player blackPlayer) {
        for (SortedMap.Entry<String, Cell> pair : table.getCells().entrySet()) {
            for (SortedMap.Entry<String, ChessItem> pairSave : allChessItems.entrySet()) {
                if (pair.getKey().equals(pairSave.getKey())) {
                    pair.getValue().setChessItem(pairSave.getValue());
                    break;
                }
            }
        }
        whitePlayer.setChessItemsMap(this.whiteChessItems);
        blackPlayer.setChessItemsMap(this.blackChessItems);
    }
}
