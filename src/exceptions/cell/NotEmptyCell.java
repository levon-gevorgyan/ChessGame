package exceptions.cell;

/**
 * Created by Levon on 1/10/2016.
 */
public class NotEmptyCell extends Exception {
    public NotEmptyCell(){
        super();
    }

    public NotEmptyCell(String message){
        super(message);
    }
}
