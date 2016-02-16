package web.servlets;

import api.chessboard.ChessBoard;
import api.chessboard.cells.Cell;
import api.colors.Colors;
import api.exceptions.game.*;
import api.exceptions.moves.InvalidMoveString;
import api.moves.WhiteMove;
import api.players.BlackPlayer;
import api.players.WhitePlayer;
import org.json.JSONArray;
import org.json.JSONObject;
import web.WebMethods;
import web.game.Status;
import web.turns.BlackTurnWeb;
import web.turns.WhiteTurnWeb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.SortedMap;

/**
 * Created by levon.gevorgyan on 09/02/16.
 */
@WebServlet(name = "DragDroppedServlet",urlPatterns = "drop")
public class DragDroppedServlet extends HttpServlet implements Colors{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String board = request.getParameter("board");
        String move = request.getParameter("move");
        String turn = request.getParameter("turn");
        String castlingDoneW=request.getParameter("castling_done_w");
        String castlingDoneB=request.getParameter("castling_done_b");
        Status status=new Status(turn,castlingDoneW,castlingDoneB);

        //Parse JSON board to ChessBoard object
        SortedMap<String, Cell> cells;
        JSONObject obj = new JSONObject(board);
        JSONArray jsonBoard = obj.getJSONArray("board");
        cells= WebMethods.cells(jsonBoard);
        WhitePlayer whitePlayer=new WhitePlayer();
        whitePlayer.setChessItemsMap(WebMethods.playerItems(cells, WHITE));
        BlackPlayer blackPlayer=new BlackPlayer();
        blackPlayer.setChessItemsMap(WebMethods.playerItems(cells, BLACK));
        ChessBoard chessBoard=new ChessBoard(cells,null,null,whitePlayer,blackPlayer);
        chessBoard.setAllItems(whitePlayer,blackPlayer);
        String responseCells;
        if(turn.equals("W")){
            try {
                new WhiteTurnWeb().doMove(move,chessBoard,whitePlayer,blackPlayer);
                responseCells= WebMethods.parseBoardToJSON(chessBoard)+status.toJson();
                response.setContentType("text/html");
                response.getWriter().write(responseCells);
            } catch (Mate mate) {
                status.setMate(BLACK);
                responseCells= WebMethods.parseBoardToJSON(chessBoard)+status.toJson();
                response.setContentType("text/html");
                response.getWriter().write(responseCells);
            } catch (CheckIsOpen checkIsOpen) {
                status.setCheckOpen("true");
                responseCells= WebMethods.parseBoardToJSON(chessBoard)+status.toJson();
                response.setContentType("text/html");
                response.getWriter().write(responseCells);

            } catch (CastlingDone castlingDone) {

            } catch (ChangePawn changePawn) {

            } catch (Check check) {
                status.setCheck(BLACK);
                responseCells= WebMethods.parseBoardToJSON(chessBoard)+status.toJson();
                response.setContentType("text/html");
                response.getWriter().write(responseCells);
            }
        }
        if(turn.equals("B")){
            try {
                new BlackTurnWeb().doMove(move,chessBoard,whitePlayer,blackPlayer);
                responseCells= WebMethods.parseBoardToJSON(chessBoard)+status.toJson();
                response.setContentType("text/html");
                response.getWriter().write(responseCells);
            } catch (Mate mate) {
                status.setMate(WHITE);
                responseCells= WebMethods.parseBoardToJSON(chessBoard)+status.toJson();
                response.setContentType("text/html");
                response.getWriter().write(responseCells);
            } catch (CheckIsOpen checkIsOpen) {
                status.setCheckOpen("true");
                responseCells= WebMethods.parseBoardToJSON(chessBoard)+status.toJson();
                response.setContentType("text/html");
                response.getWriter().write(responseCells);
            } catch (CastlingDone castlingDone) {

            } catch (ChangePawn changePawn) {

            } catch (Check check) {
                status.setCheck(WHITE);
                responseCells= WebMethods.parseBoardToJSON(chessBoard)+status.toJson();
                response.setContentType("text/html");
                response.getWriter().write(responseCells);
            }

        }

    }
}
