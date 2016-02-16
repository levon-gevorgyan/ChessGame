package api.moves;

import api.chessboard.ChessBoard;
import api.chessitems.BlackItem;
import api.chessitems.ChessItem;
import api.chessitems.empty.Empty;
import api.chessitems.white.*;
import api.chessboard.cells.Cell;
import api.chessboard.cells.Letters;
import api.exceptions.cell.EmptySourceCell;
import api.exceptions.cell.NoCell;
import api.exceptions.chessitem.PlayerSameChessItem;
import api.exceptions.game.CastlingDone;
import api.exceptions.game.ChangePawn;
import api.exceptions.moves.InvalidMove;
import api.exceptions.moves.InvalidMoveString;
import api.exceptions.cell.InvalidSource;
import api.exceptions.moves.NoAvailableCells;
import api.moves.available.white.moves.*;
import api.players.BlackPlayer;
import api.players.WhitePlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;

//Created by Levon on 1/11/2016.


public class WhiteMove extends Move implements Letters{

    boolean isCompleted=false;
    //White Rooks and King Moves Count
    private static int countA1=0;
    private static int countH1=0;
    private static int countE1=0;
    private boolean castlingHasDone=false;

    private static boolean playerRookA1=true;
    private static boolean playerRookH1=true;
    private static boolean playerKingE1=true;

    public void setCastlingHasDone(boolean castlingHasDone) {
        this.castlingHasDone = castlingHasDone;
    }

    public WhiteMove() {
    }

    //Get castling status
    public static boolean getLeftCastlingStatus()
    {
        if (countE1==0&&countA1==0)
            return true;
        else
            return false;
    }
    public static boolean getRightCastlingStatus()
    {
        if (countH1==0&&countE1==0)
            return true;
        else
            return false;
    }


    public WhiteMove(String string) throws InvalidMoveString {
        if(isValidString(string))
        {
            this.string=string;
            this.from=Character.toString(string.toCharArray()[0])+Character.toString(string.toCharArray()[1]);
            this.to=Character.toString(string.toCharArray()[2])+Character.toString(string.toCharArray()[3]);
        }
        if(from.equals(to))
        {
            throw new InvalidMoveString("Source & Target are the same");
        }
    }

    public WhiteMove(String from,String to)
    {
        this.from=from;
        this.to=to;
    }

    @Override
    public boolean move(ChessBoard chessBoard, WhitePlayer whitePlayer, BlackPlayer blackPlayer)
            throws PlayerSameChessItem, EmptySourceCell, InvalidSource, NoCell, InvalidMove, NoAvailableCells, IOException, CastlingDone, ChangePawn {
        Map<String, ChessItem> whitePlayerItems=whitePlayer.getChessItemsMap();
        Map<String, ChessItem> blackPlayerItems=blackPlayer.getChessItemsMap();

        String from=this.from;
        String to=this.to;


        boolean isTargetString=false; //checks whether target exists
        boolean isTargetCell=false; //checks whether target is available
        boolean isEmpty=false; //checks whether target cell contains Empty or not
        boolean isBlackItem=false; //checks whether target cell contains BlackItem or not
        boolean isWhiteItem=true; //checks whether target cell contains WhiteItem or not
        boolean isAvailableTarget=false;

        for (Map.Entry<String,ChessItem> item:whitePlayerItems.entrySet())
        {
            if(from.equals(item.getKey()))
            {
                for (SortedMap.Entry<String, Cell> cell: chessBoard.getCells().entrySet())
                {
                    if(cell.getKey().equals(to))
                    {
                        isTargetString=true;
                        if (cell.getValue().getChessItem() instanceof Empty || cell.getValue().getChessItem() instanceof BlackItem)
                        {
                            isTargetCell=true;
                            break;
                        }
                    }
                }
            }
        }

        if (chessBoard.getCells().get(from).getChessItem() instanceof Empty) {
            throw new EmptySourceCell(); //Empty Source
        }else if(chessBoard.getCells().get(from).getChessItem() instanceof BlackItem)
            {
                throw new InvalidSource(); //Invalid Source
            }
        else {

            for (SortedMap.Entry<String, Cell> cell : chessBoard.getCells().entrySet()) {
                if (cell.getKey().equals(to)) {
                    if (isTargetCell && isTargetString) {
                        if (chessBoard.getCells().get(to).getChessItem() instanceof Empty) {
                            isEmpty = true;
                            isWhiteItem = false;
                            break;
                        }
                    }
                }
            }
            for (SortedMap.Entry<String, Cell> cell : chessBoard.getCells().entrySet()) {
                if (cell.getKey().equals(to)) {
                    if (isTargetCell && isTargetString) {
                        if (chessBoard.getCells().get(to).getChessItem() instanceof BlackItem) {
                            isBlackItem = true;
                            isWhiteItem = false;
                            break;
                        }
                    }
                }
            }
            if (isEmpty) {

                ChessItem chessItemFrom = chessBoard.getCells().get(from).getChessItem();
                ChessItem chessItemTo = chessBoard.getCells().get(to).getChessItem();

                Cell cellFrom = chessBoard.getCells().get(from);
                Cell cellTo = chessBoard.getCells().get(to);

                //Get available cells of source <--Begin-->
                ArrayList<Cell> availableCells=new ArrayList<>();


                    //Conditions
                    if(cellFrom.getChessItem() instanceof WhiteBishop){
                        availableCells=new WhiteBishopMoves(cellFrom, chessBoard).getMoves();
                    }
                    else if (cellFrom.getChessItem() instanceof WhiteKing){
                        availableCells=new WhiteKingMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteKnight){
                        availableCells=new WhiteKnightMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhitePawn){
                        availableCells=new WhitePawnMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteQueen){
                        availableCells=new WhiteQueenMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteRook){
                        availableCells=new WhiteRookMoves(cellFrom, chessBoard).getMoves();

                    }
                    else{
                        throw new NoAvailableCells();

                    }
                //Get available cells of source <--End-->


                isAvailableTarget=true;
                try{
                    if(isAvailableTarget && availableCells.size()>0)
                    {
                        boolean available=false;

                        for(Cell target:availableCells)
                        {
                            if(cellTo.equals(target)){

                                if(!castlingHasDone) //if castling has not been done yet
                                {
                                    if(cellFrom.getChessItem() instanceof WhiteKing)
                                    {
                                        if (cellTo.equals(chessBoard.getCell(C, 1))) {
                                            if(getLeftCastlingStatus())
                                            {
                                                cellFrom.setChessItem(chessItemTo);
                                                cellTo.setChessItem(chessItemFrom);

                                                String rookCellFrom = "a1";
                                                String rookCellTo = "d1";
                                                ChessItem rookItemFrom = chessBoard.getCell(A, 1).getChessItem();
                                                ChessItem rookItemTo = chessBoard.getCell(D, 1).getChessItem();

                                                chessBoard.getCell(A, 1).setChessItem(rookItemTo);
                                                chessBoard.getCell(D, 1).setChessItem(rookItemFrom);

                                                whitePlayerItems.put(to, chessItemFrom);
                                                whitePlayerItems.remove(from);
                                                whitePlayerItems.put(rookCellTo, rookItemFrom);
                                                whitePlayerItems.remove(rookCellFrom);
                                                available = true;
                                                castlingHasDone=true;
                                                isCompleted=true;
                                                throw new CastlingDone();
                                            }
                                        }
                                        else if (cellTo.equals(chessBoard.getCell(G, 1))) {
                                            if (getRightCastlingStatus()) {
                                                cellFrom.setChessItem(chessItemTo);
                                                cellTo.setChessItem(chessItemFrom);

                                                String rookCellFrom = "h1";
                                                String rookCellTo = "f1";
                                                ChessItem rookItemFrom = chessBoard.getCell(H, 1).getChessItem();
                                                ChessItem rookItemTo = chessBoard.getCell(F, 1).getChessItem();

                                                chessBoard.getCell(H, 1).setChessItem(rookItemTo);
                                                chessBoard.getCell(F, 1).setChessItem(rookItemFrom);

                                                whitePlayerItems.put(to, chessItemFrom);
                                                whitePlayerItems.remove(from);
                                                whitePlayerItems.put(rookCellTo, rookItemFrom);
                                                whitePlayerItems.remove(rookCellFrom);
                                                available = true;
                                                castlingHasDone = true;
                                                isCompleted=true;
                                                throw new CastlingDone();

                                            }
                                        }
                                        else {
                                            cellFrom.setChessItem(chessItemTo);
                                            cellTo.setChessItem(chessItemFrom);

                                            whitePlayerItems.put(to, chessItemFrom);
                                            whitePlayerItems.remove(from);
                                            available = true;
                                            castlingHasDone=true;
                                            countE1++;
                                            playerKingE1=false;
                                            isCompleted=true;
                                        }

                                    }
                                    else {
                                        //check White Castling
                                        if (cellFrom.getChessItem() instanceof WhiteRookA && playerRookA1) {
                                            countA1++;
                                            playerRookA1=false;
                                            //System.out.println(countA1);
                                        }
                                        if (cellFrom.getChessItem() instanceof WhiteRookH && playerRookH1) {
                                            countH1++;
                                            playerRookH1=false;
                                            System.out.println(countH1);
                                        }
                                        if (cellFrom.getChessItem() instanceof WhiteKing && playerKingE1) {
                                            countE1++;
                                            playerKingE1=false;
                                            //System.out.println(countE1);
                                        }
                                        cellFrom.setChessItem(chessItemTo);
                                        cellTo.setChessItem(chessItemFrom);

                                        whitePlayerItems.put(to, chessItemFrom);
                                        whitePlayerItems.remove(from);

                                        available = true;
                                        isCompleted=true;

                                    }



                                }
                                //do
                                if(castlingHasDone) //if castling has been already done
                                {
                                    cellFrom.setChessItem(chessItemTo);
                                    cellTo.setChessItem(chessItemFrom);

                                    whitePlayerItems.put(to, chessItemFrom);
                                    whitePlayerItems.remove(from);
                                    available = true;
                                    isCompleted=true;
                                }
                            }

                        }
                        if(!available)
                        {

                            System.out.print("Available cells are: ");
                            Cell.getAvailableCellsList(availableCells);

                            throw new InvalidMove();

                        }

                    }
                    else
                        Cell.getAvailableCellsList(availableCells);
                }
                catch (InvalidMove invalidMove)
                {
                    throw new InvalidMove();
                }
                //Get available cells of source <--End-->
                doPawnChangeWhite(whitePlayerItems,cellTo, chessBoard);//do Castling
                isCompleted=true;

            }
            if (isBlackItem) {

                ChessItem chessItemFrom = chessBoard.getCells().get(from).getChessItem();
                ChessItem chessItemEmpty = new Empty();

                Cell cellFrom = chessBoard.getCells().get(from);
                Cell cellTo = chessBoard.getCells().get(to);

                //Get available cells of source <--Begin-->
                ArrayList<Cell> availableCells=new ArrayList<>();

                try {
                    //Conditions
                    if(cellFrom.getChessItem() instanceof WhiteBishop){
                        availableCells=new WhiteBishopMoves(cellFrom, chessBoard).getMoves();
                    }
                    else if (cellFrom.getChessItem() instanceof WhiteKing){
                        availableCells=new WhiteKingMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteKnight){
                        availableCells=new WhiteKnightMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhitePawn){
                        availableCells=new WhitePawnMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteQueen){
                        availableCells=new WhiteQueenMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteRook){
                        availableCells=new WhiteRookMoves(cellFrom, chessBoard).getMoves();

                    }
                    else{
                        throw new NoAvailableCells();

                    }
                }
                catch (NoAvailableCells noAvailableCells)
                {
                    new NoAvailableCells("Source doesn't have any available cell");
                }


                isAvailableTarget=true;
                try{
                    if(isAvailableTarget && availableCells.size()>0)
                    {
                        boolean available=false;

                        for(Cell target:availableCells)
                        {
                            if(cellTo.equals(target)){
                                //check White Castling
                                if (cellFrom.getChessItem() instanceof WhiteRook){
                                    if(cellFrom.equals(chessBoard.getCell(A,1)))
                                    {
                                        countA1++;
                                    }
                                    if(cellFrom.equals(chessBoard.getCell(H,1)))
                                    {
                                        countH1++;
                                    }

                                }
                                if (cellFrom.getChessItem() instanceof WhiteKing){
                                    if(cellFrom.equals(chessBoard.getCell(E,1)))
                                    {
                                        countE1++;
                                    }

                                }
                                //do
                                cellFrom.setChessItem(chessItemEmpty);
                                cellTo.setChessItem(chessItemFrom);

                                whitePlayerItems.put(to, chessItemFrom);
                                whitePlayerItems.remove(from);

                                blackPlayerItems.remove(to);
                                available=true;
                                isCompleted=true;
                            }

                        }
                        if(!available)
                        {

                            System.out.print("Available cells are: ");
                            Cell.getAvailableCellsList(availableCells);

                            throw new InvalidMove();

                        }

                    }
                    else
                        Cell.getAvailableCellsList(availableCells);
                }
                catch (InvalidMove invalidMove)
                {
                    throw new InvalidMove();
                }


                doPawnChangeWhite(whitePlayerItems,cellTo, chessBoard);//do do Pawn Change

            }
            if (isWhiteItem) {
                throw new PlayerSameChessItem();
            }
        }

        if(isCompleted)
            return true;
        else
            return false;

    }

}
