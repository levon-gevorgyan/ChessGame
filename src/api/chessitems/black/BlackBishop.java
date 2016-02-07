package api.chessitems.black;

import api.chessitems.BlackItem;
import api.colors.Black;
import javafx.scene.paint.ImagePattern;
import ui.window.main.MyImage;

/**
 * Created by Levon on 1/9/2016.
 */
public class BlackBishop extends BlackItem {

    private static int count=0;


    public BlackBishop(){
        setCount(getCount()+1);
    }


    public static int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count=count;

    }
    public static ImagePattern getUI(){
        return new ImagePattern(new MyImage("/ui/window/main/images/items/BlackBishop.png"));
    }
    public static String getImageString(){
        return "images/items/BlackBishop.png";
    }

    @Override
    public String toString() {
        return Black.BISHOP;
    }
}
