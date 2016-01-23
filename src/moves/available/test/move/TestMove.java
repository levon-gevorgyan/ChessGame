package moves.available.test.move;

/**
 * Created by Levon on 1/23/2016, 7:08 PM
 */
public abstract class TestMove {
    protected String chessItem;
    protected String source;
    protected String destination;

    public String getChessItem() {
        return chessItem;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
    public String toString(){
        return
                chessItem+source+" -> "+destination;
    }
}
