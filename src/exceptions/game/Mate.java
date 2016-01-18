package exceptions.game;

/**
 * Created by Levon on 18.01.2016.
 */
public class Mate extends Exception {
    public Mate(){
        super();
    }

    public Mate(String message){
        super(message);
    }
}
