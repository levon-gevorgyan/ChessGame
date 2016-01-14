package chesstable.cells;

import chessitems.ChessItem;

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

    public String toString() {
        return Character.toString(this.x)+y;
    }

}
