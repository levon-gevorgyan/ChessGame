package api.chessitems.empty;

import api.chessitems.ChessItem;
import javafx.scene.paint.ImagePattern;
import ui.window.main.MyImage;

/**
 * Created by Levon on 1/10/2016.
 */
public class Empty extends ChessItem {
    public static ImagePattern getUI(){
        return new ImagePattern(new MyImage("/ui/window/main/images/items/Empty.png"));
    }
    public static String getImageString(){
        return "/ui/window/main/images/items/Empty.png";
    }
    @Override
    public String toString() {
        return "";
    }
}
