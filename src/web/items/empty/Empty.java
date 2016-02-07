package web.items.empty;

import api.chessitems.ChessItem;

/**
 * Created by Levon on 2/7/2016, 6:33 PM
 */
public class Empty extends api.chessitems.empty.Empty {
    public static String toJSON(ChessItem item){
        return "Empty";
    }
}
