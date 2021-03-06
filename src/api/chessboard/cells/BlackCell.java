package api.chessboard.cells;

import api.chessitems.ChessItem;
import api.chessitems.empty.Empty;
import api.chessboard.cells.color.BlackC;


/**
 * Created by Levon on 1/10/2016.
 */
public class BlackCell extends Cell implements BlackC{

    public BlackCell(char x,int y,ChessItem chessItem)
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
