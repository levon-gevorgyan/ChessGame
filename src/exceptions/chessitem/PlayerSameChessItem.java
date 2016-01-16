package exceptions.chessitem;

/**
 * Created by Levon on 1/10/2016.
 */
public class PlayerSameChessItem extends Exception {
    public PlayerSameChessItem(){
        super();
    }

    public PlayerSameChessItem(String message){
        super(message);
    }
}
