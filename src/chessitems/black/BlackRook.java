package chessitems.black;

import chessitems.BlackItem;
import chessitems.ChessItem;
import colors.Black;

/**
 * Created by Levon on 1/9/2016.
 */
public class BlackRook extends BlackItem {
    private static int count=0;

    public BlackRook(){
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
        return Black.ROOK;
    }
}
