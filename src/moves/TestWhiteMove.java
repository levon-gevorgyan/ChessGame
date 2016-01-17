package moves;

import exceptions.moves.InvalidMoveString;

/**
 * Created by Levon on 17.01.2016.
 */
public class TestWhiteMove extends WhiteMove {
    public TestWhiteMove(String string) throws InvalidMoveString {
        super(string);
    }
    public TestWhiteMove(String from,String to)
    {
        this.from=from;
        this.to=to;
    }
}
