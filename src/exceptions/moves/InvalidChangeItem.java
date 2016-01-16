package exceptions.moves;

/**
 * Created by Levon on 1/16/2016, 5:03 PM
 */
public class InvalidChangeItem extends Exception {
    public InvalidChangeItem(){
        super();
    }

    public InvalidChangeItem(String message){
        super(message);
    }
}
