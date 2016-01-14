package exceptions.cell;

/**
 * Created by Levon on 1/10/2016.
 */
public class NoCell extends Exception {
    public NoCell(){
        super();
    }

    public NoCell(String message){
        super(message);
    }
}
