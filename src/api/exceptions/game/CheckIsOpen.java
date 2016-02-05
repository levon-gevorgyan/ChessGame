package api.exceptions.game;

/**
 * Created by levon.gevorgyan on 29/01/16.
 */
public class CheckIsOpen extends Exception {
    public CheckIsOpen(){
        super();
    }

    public CheckIsOpen(String message){
        super(message);
    }
}
