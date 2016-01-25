package chessitems.empty;

import chessitems.ChessItem;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * Created by Levon on 1/10/2016.
 */
public class Empty extends ChessItem {
    public static ImagePattern getUI(){
        return new ImagePattern(new Image("/ui/window/main/images/items/Empty.png"));
    }

    @Override
    public String toString() {
        return "";
    }
}
