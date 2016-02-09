package api.chessitems.white;

import api.chessitems.WhiteItem;
import api.colors.White;
import javafx.scene.paint.ImagePattern;
import ui.window.main.MyImage;

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
        return new ImagePattern(new MyImage("/ui/window/main/images/items/WhiteBishop.png"));
    }
    public static String getImageString(){
        return "images/items/WhiteBishop.png";
    }

    @Override
    public String toString() {
        return BISHOP;
    }
}
