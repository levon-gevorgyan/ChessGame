package web.items.white;

import api.chessitems.ChessItem;

/**
 * Created by Levon on 2/7/2016, 6:36 PM
 */
public class WhitePawn extends api.chessitems.white.WhitePawn {
    public static String toJSON(ChessItem item){
        return "WPawn";
    }
}
