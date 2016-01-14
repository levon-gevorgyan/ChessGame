package exceptions.moves;

/**
 * Created by Levon on 1/10/2016.
 */
public class InvalidMove extends Exception {
    public InvalidMove(){
        super();
    }

    public InvalidMove(String message){
        super(message);
    }
}
