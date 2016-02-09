package web.items.black;

import api.chessitems.ChessItem;

/**
 * Created by Levon on 2/7/2016, 6:30 PM
 */
public class BlackPawn extends api.chessitems.black.BlackPawn{
    public static String toJSON(ChessItem item){
        return "BPawn";
    }
}
