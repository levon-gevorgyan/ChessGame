package exceptions.moves;

/**
 * Created by Levon on 1/10/2016.
 */
public class WrongLetter extends Exception {
    public WrongLetter(){
        super();
    }

    public WrongLetter(String message){
        super(message);
    }
}
