package moves;

import exceptions.moves.InvalidMoveString;
import moves.BlackMove;

/**
 * Created by Levon on 17.01.2016.
 */
public class TestBlackMove extends BlackMove {
    public TestBlackMove(String string) throws InvalidMoveString {
        super(string);
    }
    public TestBlackMove(String from,String to)
    {
        this.from=from;
        this.to=to;
    }
}