package api.exceptions.cell;

/**
 * Created by Levon on 1/10/2016.
 */
public class InvalidTarget extends Exception {
    public InvalidTarget(){
        super();
    }

    public InvalidTarget(String message){
        super(message);
    }
}
