package chessitems.white;

import chessitems.ChessItem;
import chessitems.WhiteItem;
import colors.White;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * Created by Levon on 1/9/2016.
 */
public class WhiteBishop extends WhiteItem implements White{
    private static int count=0;

    public WhiteBishop(){
        setCount(getCount()+1);
    }


    public static int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count=count;

    }
    public static ImagePattern getUI(){
        return new ImagePattern(new Image("/ui/window/main/images/items/WhiteBishop.png"));
    }

    @Override
    public String toString() {
        return BISHOP;
    }
}
