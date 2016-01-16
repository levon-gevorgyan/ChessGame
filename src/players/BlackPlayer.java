package players;

import chessitems.ChessItem;
import chessitems.black.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Levon on 1/10/2016.
 */
public class BlackPlayer extends Player {
    private Map<String, ChessItem> chessItemsMap=new HashMap<>();;
    public BlackPlayer()
    {
        this.chessItemsMap.put("a8",new BlackRookA());
        this.chessItemsMap.put("b8",new BlackKnight());
        this.chessItemsMap.put("c8",new BlackBishop());
        this.chessItemsMap.put("d8",new BlackQueen());
        this.chessItemsMap.put("e8",new BlackKing());
        this.chessItemsMap.put("f8",new BlackBishop());
        this.chessItemsMap.put("g8",new BlackKnight());
        this.chessItemsMap.put("h8",new BlackRookH());
        this.chessItemsMap.put("a7",new BlackPawn());
        this.chessItemsMap.put("b7",new BlackPawn());
        this.chessItemsMap.put("c7",new BlackPawn());
        this.chessItemsMap.put("d7",new BlackPawn());
        this.chessItemsMap.put("e7",new BlackPawn());
        this.chessItemsMap.put("f7",new BlackPawn());
        this.chessItemsMap.put("g7",new BlackPawn());
        this.chessItemsMap.put("h7",new BlackPawn());

    }


    @Override
    public Map<String, ChessItem> getChessItemsMap() {
        return this.chessItemsMap;
    }


}
