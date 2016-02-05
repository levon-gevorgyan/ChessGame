package api.exceptions.moves;

/**
 * Created by Levon on 1/10/2016.
 */
public class NoAvailableCells extends Exception {
    public NoAvailableCells(){
        super();
    }

    public NoAvailableCells(String message){
        super(message);
    }
}
