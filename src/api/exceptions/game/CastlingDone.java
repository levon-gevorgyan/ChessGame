package api.exceptions.game;

/**
 * Created by levon.gevorgyan on 29/01/16.
 */
public class CastlingDone extends Exception{
    public CastlingDone(){
        super();
    }

    public CastlingDone(String message){
        super(message);
    }
}
