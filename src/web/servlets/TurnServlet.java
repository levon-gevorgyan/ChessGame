package web.servlets;

import api.chessboard.cells.Cell;
import api.chessitems.ChessItem;
import api.colors.Colors;
import api.players.BlackPlayer;
import api.players.WhitePlayer;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import web.WebMethods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedMap;

/**
 * Created by Levon on 2/9/2016, 1:56 AM
 */
@WebServlet(name = "TurnServlet",urlPatterns = "/turn")
public class TurnServlet extends HttpServlet implements Colors{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chessboard=request.getParameter("chessboard");
        String player=request.getParameter("player");
        SortedMap<String, Cell> cells;
        JSONObject obj = new JSONObject(chessboard);
        JSONArray jsonBoard = obj.getJSONArray("board");
        cells= WebMethods.cells(jsonBoard);
        if(player.equals("W")){

            WhitePlayer whitePlayer=new WhitePlayer();
            whitePlayer.setChessItemsMap(WebMethods.playerItems(cells, WHITE));
            ArrayList<String> playerItems=new ArrayList<>();
            for(SortedMap.Entry<String,ChessItem> pair:whitePlayer.getChessItemsMap().entrySet())
            {
                playerItems.add(pair.getKey());
            }
            String json = new Gson().toJson(playerItems );
            response.setContentType("text");
            System.out.println(json);
            response.getWriter().write(json);
        }
        if(player.equals("B")){

            BlackPlayer blackPlayer=new BlackPlayer();
            blackPlayer.setChessItemsMap(WebMethods.playerItems(cells, BLACK));
            ArrayList<String> playerItems=new ArrayList<>();
            for(SortedMap.Entry<String,ChessItem> pair:blackPlayer.getChessItemsMap().entrySet())
            {
                playerItems.add(pair.getKey());
            }
            String json = new Gson().toJson(playerItems );
            response.setContentType("text");
            System.out.println(json);
            response.getWriter().write(json);
        }
    }
}
