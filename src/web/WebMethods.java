package web;

import api.chessitems.BlackItem;
import api.chessitems.ChessItem;
import api.chessboard.ChessBoard;
import api.chessboard.cells.Cell;
import api.chessboard.cells.WhiteCell;
import api.chessitems.WhiteItem;
import api.colors.Colors;
import api.turns.UITurn;
import com.google.gson.Gson;
import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import web.game.Room;
import web.items.black.*;
import web.items.empty.Empty;
import web.items.white.WhiteBishop;
import web.items.white.WhiteKing;
import web.items.white.WhiteKnight;
import web.items.white.WhitePawn;
import web.items.white.WhiteQueen;
import web.items.white.WhiteRook;
import web.items.white.WhiteRookA;
import web.socket.JsonSocketMessage;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * Created by Levon on 2/7/2016, 6:54 PM
 */
public class WebMethods implements Colors{

    //Methods related to Web Socket
    public static String sessionToString(Session session){
        return (session!=null) ? session.getRemoteAddress().getHostName()+":"+session.getRemoteAddress().getPort():"NULL";
    }
    public static Room getCurrentRoom(Session session,ArrayList<Room> rooms){
        for (Room room:rooms){
            if(sessionToString(session).equals(sessionToString(room.getWhite()))||
                    sessionToString(session).equals(sessionToString(room.getBlack())))
                return room;
        }
        return null;
    }

    public static String roomsToJSON(ArrayList<Room> roomArrayList){
        ArrayList<String> arrayList=new ArrayList<>();
        for (Room room:roomArrayList){
            arrayList.add(String.valueOf(room.getCountOnlinePlayers()));
        }
        return new Gson().toJson(arrayList);
    }

    public static JsonSocketMessage getJsonSocketMessage(String jsonMessage){
        System.out.println(jsonMessage);
        JSONObject jsonObject=new JSONObject(jsonMessage);
        String  id=jsonObject.getString("id");
        try {
            String  msg=jsonObject.getString("msg");
            return new JsonSocketMessage(id,msg);
        }catch (JSONException e){
            JSONArray msg=jsonObject.getJSONArray("msg");
            return new JsonSocketMessage(id,msg);
        }


    }




    //Methods related to JSON
    public static SortedMap<String, ChessItem> playerItems(SortedMap<String, Cell> allCells,String color){

        SortedMap<String, ChessItem> playerItems = new TreeMap<>();

        if(color.equals(WHITE)){
            for (SortedMap.Entry<String,Cell> pair:allCells.entrySet()){
                if(pair.getValue().getChessItem() instanceof WhiteItem)
                    playerItems.put(pair.getKey(),pair.getValue().getChessItem());
            }
        }
        if(color.equals(BLACK)){
            for (SortedMap.Entry<String,Cell> pair:allCells.entrySet()){
                if(pair.getValue().getChessItem() instanceof BlackItem)
                    playerItems.put(pair.getKey(),pair.getValue().getChessItem());
            }
        }

        return playerItems;
    }
    public static SortedMap<String, Cell> cells(JSONArray jsonBoard){
        SortedMap<String, Cell> cells = new TreeMap<>();
        for (int i = 0; i < jsonBoard.length(); i++) {
            JSONObject object = jsonBoard.getJSONObject(i);
            /*System.out.println(object.getString("cell"));
            System.out.println(object.getString("item"));
            System.out.println(object.getString("img"));*/
            cells.put(object.getString("cell"),
                    new WhiteCell(object.getString("cell").toCharArray()[0],
                            Integer.parseInt(String.valueOf(object.getString("cell").toCharArray()[1])),
                            WebMethods.getChessItemFromJsonString(object.getString("item"))));
        }
        return cells;
    }

    public static String parseBoardToJSON(ChessBoard chessBoard){
        String s="{\"board\":[";
        for(SortedMap.Entry<String,Cell> pair: chessBoard.getCells().entrySet()){
            s+=
                    "{\"cell\":\""+pair.getKey()+
                            "\",\"item\":\""+getJsonString(pair.getValue().getChessItem())+
                            "\",\"img\":\""+UITurn.getImageString(pair.getValue().getChessItem())+"\"},";
        }
        s=s.substring(0,s.length()-1);
        //s+="],\"status\":[{\"mate\":\"false\",\"check\":\"false\"}]}";
        System.out.println(s);
        return s;
    }


    public static ChessItem getChessItemFromJsonString(String jsonString){
        if(jsonString.equals("Empty"))
            return new api.chessitems.empty.Empty();
        if(jsonString.equals("WRook"))
            return new api.chessitems.white.WhiteRook();
        if(jsonString.equals("WRookH"))
            return new api.chessitems.white.WhiteRookH();
        if(jsonString.equals("WRookA"))
            return new api.chessitems.white.WhiteRookA();
        if(jsonString.equals("WKing"))
            return new api.chessitems.white.WhiteKing();
        if(jsonString.equals("WQueen"))
            return new api.chessitems.white.WhiteQueen();
        if(jsonString.equals("WPawn"))
            return new api.chessitems.white.WhitePawn();
        if(jsonString.equals("WBishop"))
            return new api.chessitems.white.WhiteBishop();
        if(jsonString.equals("WKnight"))
            return new api.chessitems.white.WhiteKnight();
        if(jsonString.equals("BRook"))
            return new api.chessitems.black.BlackRook();
        if(jsonString.equals("BRookH"))
            return new api.chessitems.black.BlackRookH();
        if(jsonString.equals("BRookA"))
            return new api.chessitems.black.BlackRookA();
        if(jsonString.equals("BKing"))
            return new api.chessitems.black.BlackKing();
        if(jsonString.equals("BQueen"))
            return new api.chessitems.black.BlackQueen();
        if(jsonString.equals("BPawn"))
            return new api.chessitems.black.BlackPawn();
        if(jsonString.equals("BBishop"))
            return new api.chessitems.black.BlackBishop();
        if(jsonString.equals("BKnight"))
            return new api.chessitems.black.BlackKnight();

        return null;
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
            return WhiteRookA.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.white.WhiteRookH)
            return web.items.white.WhiteRookH.toJSON(chessItem);
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
            return BlackRookA.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.black.BlackRookH)
            return BlackRookH.toJSON(chessItem);
        if(chessItem instanceof api.chessitems.black.BlackRook)
            return BlackRook.toJSON(chessItem);
        return null;
    }
}
