package chesstable.cells;

import chessitems.ChessItem;

import java.util.ArrayList;

/**
 * Created by Levon on 1/9/2016.
 */
public abstract class Cell {
    public abstract String line1();
    public abstract String line2();

    protected char x;
    protected int y;
    protected ChessItem chessItem;

    public char getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }
    public ChessItem getChessItem()
    {
        return this.chessItem;
    }
    public void setChessItem(ChessItem chessItem)
    {
        this.chessItem=chessItem;
    }

    public static void getAvailableCellsList(ArrayList<Cell> list)
    {
        if(list.size()>0){
            for(Cell cell : list)
            {
                System.out.print(cell.toString()+" | ");
            }
        }
        else
            System.out.println("No Available Moves");
    }

    public String toString() {
        return Character.toString(this.x)+y;
    }

}
