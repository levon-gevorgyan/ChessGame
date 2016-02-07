package servlets;

import api.chessitems.ChessItem;
import api.chesstable.Table;
import api.chesstable.cells.Cell;
import api.players.BlackPlayer;
import api.players.WhitePlayer;
import api.turns.UITurn;
import javafx.scene.shape.Rectangle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by Levon on 2/6/2016, 5:02 PM
 */
@WebServlet(name = "TestCells",urlPatterns = "/test-cells")
public class TestCells extends HttpServlet {
    SortedMap<String, Cell> cells = null;
    ArrayList<ArrayList<Cell>> rows = null;
    ArrayList<ArrayList<Cell>> columns = null;
    WhitePlayer whitePlayer = new WhitePlayer();
    BlackPlayer blackPlayer = new BlackPlayer();

    //Creating table
    Table board = new Table(cells, rows, columns, whitePlayer, blackPlayer);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        board.setAllItems(whitePlayer, blackPlayer);
        board.toString();


        String[] cells = request.getParameterValues("cells[]");
        String responseCells="{";

        for(SortedMap.Entry<String,Cell> pair:board.getCells().entrySet()){
            for(int i=0;i<64;i++){
                if(pair.getKey().equals(cells[i])){
                    responseCells += "\""+cells[i]+"\":\""+UITurn.getImageString(pair.getValue().getChessItem())+"\",";
                    break;
                }
            }
        }
        responseCells=responseCells.substring(0,responseCells.length()-1);
        responseCells+="}";
        System.out.println(responseCells);
        /*for(String i:responseCells){
            System.out.println(i);
        }*/

        response.setContentType("text/html");
        response.getWriter().write(responseCells);

    }

}
