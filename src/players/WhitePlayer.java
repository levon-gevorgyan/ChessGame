package players;

import chessitems.ChessItem;
import chessitems.white.*;


import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Levon on 1/10/2016.
 */
public class WhitePlayer extends Player {
    private SortedMap<String, ChessItem> chessItemsMap=new TreeMap<>();

    public WhitePlayer()
    {
        this.chessItemsMap.put("a1",new WhiteRookA());
        this.chessItemsMap.put("b1",new WhiteKnight());
        this.chessItemsMap.put("c1",new WhiteBishop());
        //this.chessItemsMap.put("d1",new WhiteQueen());
        this.chessItemsMap.put("e1",new WhiteKing());
        //this.chessItemsMap.put("f1",new WhiteBishop());
        this.chessItemsMap.put("g1",new WhiteKnight());
        this.chessItemsMap.put("h1",new WhiteRookH());
        this.chessItemsMap.put("a2",new WhitePawn());
        this.chessItemsMap.put("b2",new WhitePawn());
        this.chessItemsMap.put("c2",new WhitePawn());
        //this.chessItemsMap.put("d2",new WhitePawn());
        //this.chessItemsMap.put("e2",new WhitePawn());
        //this.chessItemsMap.put("f2",new WhitePawn());
        this.chessItemsMap.put("g2",new WhitePawn());
        this.chessItemsMap.put("h2",new WhitePawn());

        /*//Default locations
        this.chessItemsMap.put("a1",new WhiteRookA());
        this.chessItemsMap.put("b1",new WhiteKnight());
        this.chessItemsMap.put("c1",new WhiteBishop());
        this.chessItemsMap.put("d1",new WhiteQueen());
        this.chessItemsMap.put("e1",new WhiteKing());
        this.chessItemsMap.put("f1",new WhiteBishop());
        this.chessItemsMap.put("g1",new WhiteKnight());
        this.chessItemsMap.put("h1",new WhiteRookH());
        this.chessItemsMap.put("a2",new WhitePawn());
        this.chessItemsMap.put("b2",new WhitePawn());
        this.chessItemsMap.put("c2",new WhitePawn());
        this.chessItemsMap.put("d2",new WhitePawn());
        this.chessItemsMap.put("e2",new WhitePawn());
        this.chessItemsMap.put("f2",new WhitePawn());
        this.chessItemsMap.put("g2",new WhitePawn());
        this.chessItemsMap.put("h2",new WhitePawn());
        */

    }


    @Override
    public SortedMap<String, ChessItem> getChessItemsMap() {
        return this.chessItemsMap;
    }

    @Override
    public void setChessItemsMap(SortedMap<String, ChessItem> chessItemsMap) {
        this.chessItemsMap = new TreeMap<String, ChessItem>(chessItemsMap) {
        };
    }
}
