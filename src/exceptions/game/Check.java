package exceptions.game;

/**
 * Created by Levon on 1/17/2016, 12:40 AM
 */
public class Check extends Exception {
    public Check(){
        super();
    }

    public Check(String message){
        super(message);
    }
}
