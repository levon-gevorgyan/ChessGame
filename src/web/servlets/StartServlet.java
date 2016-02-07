package web.servlets;


import api.chesstable.Table;
import api.chesstable.cells.Cell;
import api.players.BlackPlayer;
import api.players.WhitePlayer;
import api.turns.UITurn;
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
 * Created by Levon on 2/6/2016, 5:02 PM
 */
@WebServlet(name = "StartServlet",urlPatterns = "/start")
public class StartServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SortedMap<String, Cell> cells = null;
        ArrayList<ArrayList<Cell>> rows = null;
        ArrayList<ArrayList<Cell>> columns = null;
        WhitePlayer whitePlayer = new WhitePlayer();
        BlackPlayer blackPlayer = new BlackPlayer();

        //Creating table
        Table board = new Table(cells, rows, columns, whitePlayer, blackPlayer);
        board.setAllItems(whitePlayer, blackPlayer);
        board.toString();

        String responseCells= WebMethods.parseBoardToJSON(board);


        /*responseCells=responseCells.substring(0,responseCells.length()-1);
        responseCells+="}";
        System.out.println(responseCells);*/
        /*for(String i:responseCells){
            System.out.println(i);
        }*/

        response.setContentType("text/html");
        response.getWriter().write(responseCells);

    }

}
