package api.chessboard.cells;

import api.chessitems.ChessItem;
import api.chessitems.empty.Empty;
import api.chessboard.cells.color.WhiteC;

/**
 * Created by Levon on 1/10/2016.
 */
public class WhiteCell extends Cell implements WhiteC{

    public WhiteCell(char x,int y,ChessItem chessItem)
    {
        this.x=x;
        this.y=y;
        this.chessItem=chessItem;
    }



    @Override
    public String line1() {
        if(chessItem instanceof Empty)
        {
            return L1+L1+"|";
        }
        else
        {
            return chessItem.toString()+L1+"|";
        }
    }

    @Override
    public String line2() {
        return L2;
    }
}
