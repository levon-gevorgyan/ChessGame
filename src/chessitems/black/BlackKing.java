package chessitems.black;

import chessitems.BlackItem;
import chessitems.ChessItem;
import colors.Black;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * Created by Levon on 1/9/2016.
 */
public class BlackKing extends BlackItem {
    private static int count=0;

    public BlackKing(){
        setCount(getCount()+1);
    }


    public static int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count=count;

    }
    public static ImagePattern getUI(){
        return new ImagePattern(new Image("/ui/window/main/images/items/BlackKing.png"));
    }

    @Override
    public String toString() {
        return Black.KING;
    }
}
