package exceptions.chessitem;

/**
 * Created by Levon on 1/10/2016.
 */
public class SameChessItem extends Exception {
    public SameChessItem(){
        super();
    }

    public SameChessItem(String message){
        super(message);
    }
}
