package chessitems.white;

import chessitems.ChessItem;
import chessitems.WhiteItem;
import colors.White;

/**
 * Created by Levon on 1/9/2016.
 */
public class WhiteKnight extends WhiteItem {
    private static int count=0;

    public WhiteKnight(){
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
        return White.KNIGHT;
    }
}
