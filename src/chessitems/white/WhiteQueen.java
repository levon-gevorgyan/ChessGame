package chessitems.white;

import chessitems.ChessItem;
import chessitems.WhiteItem;
import colors.White;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import ui.window.main.MyImage;

/**
 * Created by Levon on 1/9/2016.
 */
public class WhiteQueen extends WhiteItem {
    private static int count=0;

    public WhiteQueen(){
        setCount(getCount()+1);
    }


    public static int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count=count;

    }
    public static ImagePattern getUI(){
        return new ImagePattern(new MyImage("/ui/window/main/images/items/WhiteQueen.png"));
    }
    public static String getImageString(){
        return "/ui/window/main/images/items/WhiteQueen.png";
    }

    @Override
    public String toString() {
        return White.QUEEN;
    }
}
