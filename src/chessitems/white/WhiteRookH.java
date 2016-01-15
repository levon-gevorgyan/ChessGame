package chessitems.white;

import colors.White;

/**
 * Created by Levon on 1/16/2016.
 */
public class WhiteRookH extends WhiteRook {
    private static int count=0;

    public WhiteRookH(){
        setCount(getCount()+1);
    }


    public static int getCount() {
        return count;
    }




    @Override
    public String toString() {
        return White.ROOK;
    }
}
