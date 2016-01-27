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

    public SortedMap<String, ChessItem> getAllChessItems() {
        return allChessItems;
    }

    private SortedMap<String,ChessItem> allChessItems=new TreeMap<>();

    public SortedMap<String, Integer> getGridCells() {
        return gridCells;
    }

    public SortedMap<String, Integer> getWhiteGridCells() {
        return whiteGridCells;
    }

    public SortedMap<String, Integer> getBlackGridCells() {
        return blackGridCells;
    }

    public ArrayList<Integer> getWhiteOnlyGridCells() {
        return whiteOnlyGridCells;
    }

    public ArrayList<Integer> getBlackGridOnlyCells() {
        return blackGridOnlyCells;
    }

    private SortedMap<String,Integer> gridCells=new TreeMap<>();
    private SortedMap<String,Integer> whiteGridCells=new TreeMap<>();
    private SortedMap<String,Integer> blackGridCells=new TreeMap<>();
    private ArrayList<Integer> whiteOnlyGridCells=new ArrayList<>();
    private ArrayList<Integer> blackGridOnlyCells=new ArrayList<>();

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
        this.gridCells=setGridCells(this.allChessItems);
        this.whiteGridCells=setGridCells(this.whiteChessItems);
        this.blackGridCells=setGridCells(this.blackChessItems);
        this.whiteOnlyGridCells=setOnlyGridCells(this.whiteGridCells,this.gridCells);
        this.blackGridOnlyCells=setOnlyGridCells(this.blackGridCells,this.gridCells);

    }

    private SortedMap<String, Integer> setGridCells(SortedMap<String, ChessItem> save) {
        SortedMap<String,Integer> gridCells=new TreeMap<>();
        int k=0;
        for(SortedMap.Entry<String, ChessItem> pair:save.entrySet()){
            gridCells.put(pair.getKey(), k);

            k++;
        }
        return gridCells;
    }
    private ArrayList<Integer> setOnlyGridCells(SortedMap<String, Integer> player,SortedMap<String,Integer> gridCells) {
        ArrayList<Integer> list=new ArrayList<>();
        for(SortedMap.Entry<String, Integer> pair:player.entrySet()){
            for(SortedMap.Entry<String, Integer> pair1:gridCells.entrySet()){
                if(pair.getKey().equals(pair1.getKey())){
                    list.add(pair1.getValue());
                    break;
                }
            }
        }
        return list;
    }
    public SortedMap<String, ChessItem> getWhiteChessItems() {
        return whiteChessItems;
    }

    public SortedMap<String, ChessItem> getBlackChessItems() {
        return blackChessItems;
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
