package web.servlets;


import api.chessboard.ChessBoard;
import api.chessboard.cells.Cell;
import api.chessitems.black.*;
import api.chessitems.white.*;
import api.colors.Colors;
import api.exceptions.moves.NoAvailableCells;
import api.moves.available.black.moves.*;
import api.moves.available.white.moves.*;
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
 * Created by Levon on 2/8/2016, 8:17 PM
 */
@WebServlet(name = "DragStartServlet",urlPatterns = "/on-drag-start")
public class DragStartServlet extends HttpServlet implements Colors {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String board = request.getParameter("board");
        String source=request.getParameter("src");
        SortedMap<String, Cell> cells;
        JSONObject obj = new JSONObject(board);
        JSONArray jsonBoard = obj.getJSONArray("board");
        cells=WebMethods.cells(jsonBoard);
        WhitePlayer whitePlayer=new WhitePlayer();
        whitePlayer.setChessItemsMap(WebMethods.playerItems(cells, WHITE));
        BlackPlayer blackPlayer=new BlackPlayer();
        blackPlayer.setChessItemsMap(WebMethods.playerItems(cells, BLACK));
        //System.out.println(cells);
        ChessBoard chessBoard=new ChessBoard(cells,null,null,whitePlayer,blackPlayer);
        chessBoard.setAllItems(whitePlayer,blackPlayer);
        ArrayList<Cell> cellArrayList = new ArrayList<>();
        if (chessBoard.getCellByString(source).getChessItem() instanceof WhiteKing) {
            try {
                cellArrayList = new WhiteKingMoves(chessBoard.getCellByString(source), chessBoard, false).getMoves();
            } catch (NoAvailableCells noAvailableCells) {
                //noAvailableCells.printStackTrace();
            }
        }
        if (chessBoard.getCellByString(source).getChessItem() instanceof WhiteQueen) {
            try {
                cellArrayList = new WhiteQueenMoves(chessBoard.getCellByString(source), chessBoard).getMoves();
            } catch (NoAvailableCells noAvailableCells) {
                //noAvailableCells.printStackTrace();
            }
        }
        if (chessBoard.getCellByString(source).getChessItem() instanceof WhiteBishop) {
            try {
                cellArrayList = new WhiteBishopMoves(chessBoard.getCellByString(source), chessBoard).getMoves();
            } catch (NoAvailableCells noAvailableCells) {
                //noAvailableCells.printStackTrace();
            }
        }
        if (chessBoard.getCellByString(source).getChessItem() instanceof WhiteKnight) {
            try {
                cellArrayList = new WhiteKnightMoves(chessBoard.getCellByString(source), chessBoard).getMoves();
                    /*for (SortedMap.Entry<String,Cell> pair:chessBoard.getCells().entrySet()){
                        System.out.print(pair.getKey() +" "+pair.getValue().getChessItem()+"\n");
                    }
                    System.out.println(source);
                    System.out.println(cellArrayList);*/
            } catch (NoAvailableCells noAvailableCells) {
                //noAvailableCells.printStackTrace();
            }
        }
        if (chessBoard.getCellByString(source).getChessItem() instanceof WhitePawn) {
            try {
                cellArrayList = new WhitePawnMoves(chessBoard.getCellByString(source), chessBoard).getMoves();
            } catch (NoAvailableCells noAvailableCells) {
                //noAvailableCells.printStackTrace();
            }
        }
        if (chessBoard.getCellByString(source).getChessItem() instanceof WhiteRook) {
            try {
                cellArrayList = new WhiteRookMoves(chessBoard.getCellByString(source), chessBoard).getMoves();
            } catch (NoAvailableCells noAvailableCells) {
                //noAvailableCells.printStackTrace();
            }
        }
        if (chessBoard.getCellByString(source).getChessItem() instanceof BlackKing) {
            try {
                cellArrayList = new BlackKingMoves(chessBoard.getCellByString(source), chessBoard, false).getMoves();
            } catch (NoAvailableCells noAvailableCells) {
                //noAvailableCells.printStackTrace();
            }
        }

        if (chessBoard.getCellByString(source).getChessItem() instanceof BlackQueen) {
            try {
                cellArrayList = new BlackQueenMoves(chessBoard.getCellByString(source), chessBoard).getMoves();
            } catch (NoAvailableCells noAvailableCells) {
                //noAvailableCells.printStackTrace();
            }
        }
        if (chessBoard.getCellByString(source).getChessItem() instanceof BlackBishop) {
            try {
                cellArrayList = new BlackBishopMoves(chessBoard.getCellByString(source), chessBoard).getMoves();
            } catch (NoAvailableCells noAvailableCells) {
                //noAvailableCells.printStackTrace();
            }
        }
        if (chessBoard.getCellByString(source).getChessItem() instanceof BlackKnight) {
            try {
                cellArrayList = new BlackKnightMoves(chessBoard.getCellByString(source), chessBoard).getMoves();
            } catch (NoAvailableCells noAvailableCells) {
                //noAvailableCells.printStackTrace();
            }
        }
        if (chessBoard.getCellByString(source).getChessItem() instanceof BlackPawn) {
            try {
                cellArrayList = new BlackPawnMoves(chessBoard.getCellByString(source), chessBoard).getMoves();
            } catch (NoAvailableCells noAvailableCells) {
                //noAvailableCells.printStackTrace();
            }
        }
        if (chessBoard.getCellByString(source).getChessItem() instanceof BlackRook) {
            try {
                cellArrayList = new BlackRookMoves(chessBoard.getCellByString(source), chessBoard).getMoves();
            } catch (NoAvailableCells noAvailableCells) {
                //noAvailableCells.printStackTrace();
            }
        }

        ArrayList<String> availableCells=new ArrayList<>();
        for(Cell cell:cellArrayList)
        {
            availableCells.add(cell.toString());
        }
        String json = new Gson().toJson(availableCells );
        System.out.println(json);
        response.setContentType("text/html");
        response.getWriter().write(json);


    }
}
