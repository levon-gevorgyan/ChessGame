package chessitems.black;

import colors.Black;

/**
 * Created by Levon on 1/16/2016.
 */
public class BlackRookH extends BlackRook {
    private static int count=0;

    public BlackRookH(){
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
