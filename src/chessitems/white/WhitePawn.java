package chessitems.white;

import chessitems.ChessItem;
import chessitems.WhiteItem;
import chesstable.Table;
import colors.White;

/**
 * Created by Levon on 1/9/2016.
 */
public class WhitePawn extends WhiteItem {
    private static int count=0;


    public WhitePawn(){
        setCount(getCount()+1);
    }


    public static int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count=count;

    }

    @Override
    public String toString() {
        return White.PAWN;
    }
}
