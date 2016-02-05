package api.exceptions.moves;

/**
 * Created by Levon on 1/10/2016.
 */
public class WrongNumber extends Exception {
    public WrongNumber(){
        super();
    }

    public WrongNumber(String message){
        super(message);
    }
}
