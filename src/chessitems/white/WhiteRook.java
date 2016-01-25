package chessitems.white;

import chessitems.ChessItem;
import chessitems.WhiteItem;
import colors.White;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * Created by Levon on 1/9/2016.
 */
public class WhiteRook extends WhiteItem {
    private static int count=0;

    public WhiteRook(){
        setCount(getCount()+1);
    }


    public static int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count=count;

    }

    public static ImagePattern getUI(){
        return new ImagePattern(new Image("/ui/window/main/images/items/WhiteRook.png"));
    }

    @Override
    public String toString() {
        return White.ROOK;
    }
}
