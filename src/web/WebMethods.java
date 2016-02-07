package web;

import api.chessitems.ChessItem;
import api.chesstable.Table;
import api.chesstable.cells.Cell;
import api.turns.UITurn;
import web.items.black.*;
import web.items.empty.Empty;
import web.items.white.*;

import java.util.SortedMap;


/**
 * Created by Levon on 2/7/2016, 6:54 PM
 */
public class WebMethods {
    public static String parseBoardToJSON(Table board){
        String s="[";
        for(SortedMap.Entry<String,Cell> pair:board.getCells().entrySet()){
            s+=
                    "{\"cell\":\""+pair.getKey()+
                    "\",\"item\":\""+getJsonString(pair.getValue().getChessItem())+
                    "\",\"img\":\""+UITurn.getImageString(pair.getValue().getChessItem())+"\"},";
        }
        s=s.substring(0,s.length()-1);
        s+="]";
        System.out.println(s);
        return s;
    }

    public static String getJsonString(ChessItem chessItem){
        if (chessItem instanceof api.chessitems.empty.Empty)
            return Empty.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.white.WhiteBishop)
            return WhiteBishop.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.white.WhiteKing)
            return WhiteKing.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.white.WhiteKnight)
            return WhiteKnight.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.white.WhitePawn)
            return WhitePawn.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.white.WhiteQueen)
            return WhiteQueen.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.white.WhiteRookA)
            return WhiteRook.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.white.WhiteRookH)
            return WhiteRook.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.white.WhiteRook)
            return WhiteRook.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.black.BlackBishop)
            return BlackBishop.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.black.BlackKing)
            return BlackKing.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.black.BlackKnight)
            return BlackKnight.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.black.BlackPawn)
            return BlackPawn.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.black.BlackQueen)
            return BlackQueen.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.black.BlackRookA)
            return BlackRook.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.black.BlackRookH)
            return BlackRook.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.black.BlackRook)
            return BlackRook.toJSON(chessItem);
        return null;
    }
}
