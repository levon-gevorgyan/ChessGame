package api.exceptions.moves;

/**
 * Created by Levon on 1/10/2016.
 */
public class InvalidMoveString extends Exception {
    public InvalidMoveString(){
        super();
    }

    public InvalidMoveString(String message){
        super(message);
    }
}
