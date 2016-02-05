package api.exceptions.cell;

/**
 * Created by Levon on 1/10/2016.
 */
public class InvalidSource extends Exception {
    public InvalidSource(){
        super();
    }

    public InvalidSource(String message){
        super(message);
    }
}
