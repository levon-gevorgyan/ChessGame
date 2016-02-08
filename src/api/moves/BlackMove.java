package api.moves;

import api.chessboard.ChessBoard;
import api.chessitems.ChessItem;
import api.chessitems.black.*;
import api.chessitems.empty.Empty;
import api.chessitems.WhiteItem;
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
import api.moves.available.black.moves.*;
import api.players.BlackPlayer;
import api.players.WhitePlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by Levon on 1/11/2016.
 */
public class BlackMove extends Move implements Letters {

    boolean isCompleted=false;
    //Black Rooks and King Moves Count
    private static int countA8=0;
    private static int countH8=0;
    private static int countE8=0;
    private boolean castlingHasDone=false;

    protected static boolean playerRookA8=true;
    protected static boolean playerRookH8=true;
    protected static boolean playerKingE8=true;

    public BlackMove() {
    }

    //Get castling status
    public static boolean getLeftCastlingStatus()
    {
        if (countE8==0&&countA8==0)
            return true;
        else
            return false;
    }
    public static boolean getRightCastlingStatus()
    {
        if (countH8==0&&countE8==0)
            return true;
        else
            return false;
    }


    public BlackMove(String string) throws InvalidMoveString {
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

    public BlackMove(String from,String to)
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
        boolean isBlackItem=true; //checks whether target cell contains BlackItem or not
        boolean isWhiteItem=false; //checks whether target cell contains WhiteItem or not
        boolean isAvailableTarget=false;

        for (Map.Entry<String,ChessItem> item:blackPlayerItems.entrySet())
        {
            if(from.equals(item.getKey()))
            {
                for (SortedMap.Entry<String, Cell> cell: chessBoard.getCells().entrySet())
                {
                    if(cell.getKey().equals(to))
                    {
                        isTargetString=true;
                        if (cell.getValue().getChessItem() instanceof Empty || cell.getValue().getChessItem() instanceof WhiteItem)
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
        }else if(chessBoard.getCells().get(from).getChessItem() instanceof WhiteItem)
        {
                throw new InvalidSource(); //Invalid Source
            }
        else {

            for (SortedMap.Entry<String, Cell> cell : chessBoard.getCells().entrySet()) {
                if (cell.getKey().equals(to)) {
                    if (isTargetCell && isTargetString) {
                        if (chessBoard.getCells().get(to).getChessItem() instanceof Empty) {
                            isEmpty = true;
                            isBlackItem = false;
                            break;
                        }
                    }
                }
            }
            for (SortedMap.Entry<String, Cell> cell : chessBoard.getCells().entrySet()) {
                if (cell.getKey().equals(to)) {
                    if (isTargetCell && isTargetString) {
                        if (chessBoard.getCells().get(to).getChessItem() instanceof WhiteItem) {
                            isBlackItem = false;
                            isWhiteItem = true;
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
                    if(cellFrom.getChessItem() instanceof BlackBishop){
                        availableCells=new BlackBishopMoves(cellFrom, chessBoard).getMoves();
                    }
                    else if (cellFrom.getChessItem() instanceof BlackKing){
                        availableCells=new BlackKingMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackKnight){
                        availableCells=new BlackKnightMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackPawn){
                        availableCells=new BlackPawnMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackQueen){
                        availableCells=new BlackQueenMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackRook){
                        availableCells=new BlackRookMoves(cellFrom, chessBoard).getMoves();

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
                                    if(cellFrom.getChessItem() instanceof BlackKing)
                                    {
                                        if (cellTo.equals(chessBoard.getCell(C, 8))) {
                                            if(getLeftCastlingStatus())
                                            {
                                                cellFrom.setChessItem(chessItemTo);
                                                cellTo.setChessItem(chessItemFrom);

                                                String rookCellFrom = "a8";
                                                String rookCellTo = "d8";
                                                ChessItem rookItemFrom = chessBoard.getCell(A, 8).getChessItem();
                                                ChessItem rookItemTo = chessBoard.getCell(D, 8).getChessItem();

                                                chessBoard.getCell(A, 8).setChessItem(rookItemTo);
                                                chessBoard.getCell(D, 8).setChessItem(rookItemFrom);

                                                blackPlayerItems.put(to, chessItemFrom);
                                                blackPlayerItems.remove(from);
                                                blackPlayerItems.put(rookCellTo, rookItemFrom);
                                                blackPlayerItems.remove(rookCellFrom);
                                                available = true;
                                                castlingHasDone=true;
                                                isCompleted=true;
                                                throw new CastlingDone();
                                            }
                                        }
                                        else if (cellTo.equals(chessBoard.getCell(G, 8))) {
                                            if (getRightCastlingStatus()) {
                                                cellFrom.setChessItem(chessItemTo);
                                                cellTo.setChessItem(chessItemFrom);

                                                String rookCellFrom = "h8";
                                                String rookCellTo = "f8";
                                                ChessItem rookItemFrom = chessBoard.getCell(H, 8).getChessItem();
                                                ChessItem rookItemTo = chessBoard.getCell(F, 8).getChessItem();

                                                chessBoard.getCell(H, 8).setChessItem(rookItemTo);
                                                chessBoard.getCell(F, 8).setChessItem(rookItemFrom);

                                                blackPlayerItems.put(to, chessItemFrom);
                                                blackPlayerItems.remove(from);
                                                blackPlayerItems.put(rookCellTo, rookItemFrom);
                                                blackPlayerItems.remove(rookCellFrom);
                                                available = true;
                                                castlingHasDone = true;
                                                isCompleted=true;
                                                throw new CastlingDone();
                                            }
                                        }
                                        else {
                                            cellFrom.setChessItem(chessItemTo);
                                            cellTo.setChessItem(chessItemFrom);

                                            blackPlayerItems.put(to, chessItemFrom);
                                            blackPlayerItems.remove(from);
                                            available = true;
                                            castlingHasDone=true;
                                            countE8++;
                                            playerKingE8=false;
                                            isCompleted=true;
                                        }

                                    }
                                    else {
                                        //check White Castling
                                        if (cellFrom.getChessItem() instanceof BlackRookA && playerRookA8) {
                                            countA8++;
                                            playerRookA8=false;
                                            //System.out.println(countA8);
                                        }
                                        if (cellFrom.getChessItem() instanceof BlackRookH && playerRookH8) {
                                            countH8++;
                                            playerRookH8=false;
                                            System.out.println(countH8);
                                        }
                                        if (cellFrom.getChessItem() instanceof BlackKing && playerKingE8) {
                                            countE8++;
                                            playerKingE8=false;
                                            //System.out.println(countE8);
                                        }
                                        cellFrom.setChessItem(chessItemTo);
                                        cellTo.setChessItem(chessItemFrom);

                                        blackPlayerItems.put(to, chessItemFrom);
                                        blackPlayerItems.remove(from);
                                        available = true;
                                        isCompleted=true;

                                    }



                                }
                                //do
                                if(castlingHasDone) //if castling has been already done
                                {
                                    cellFrom.setChessItem(chessItemTo);
                                    cellTo.setChessItem(chessItemFrom);

                                    blackPlayerItems.put(to, chessItemFrom);
                                    blackPlayerItems.remove(from);
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
                doPawnChangeBlack(blackPlayerItems, cellTo, chessBoard);//do Pawn ChangeBlack
                isCompleted=true;

            }
            if (isWhiteItem) {

                ChessItem chessItemFrom = chessBoard.getCells().get(from).getChessItem();
                ChessItem chessItemEmpty = new Empty();

                Cell cellFrom = chessBoard.getCells().get(from);
                Cell cellTo = chessBoard.getCells().get(to);

                //Get available cells of source <--Begin-->
                ArrayList<Cell> availableCells=new ArrayList<>();

                try {
                    //Conditions
                    if(cellFrom.getChessItem() instanceof BlackBishop){
                        availableCells=new BlackBishopMoves(cellFrom, chessBoard).getMoves();
                    }
                    else if (cellFrom.getChessItem() instanceof BlackKing){
                        availableCells=new BlackKingMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackKnight){
                        availableCells=new BlackKnightMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackPawn){
                        availableCells=new BlackPawnMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackQueen){
                        availableCells=new BlackQueenMoves(cellFrom, chessBoard).getMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackRook){
                        availableCells=new BlackRookMoves(cellFrom, chessBoard).getMoves();

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
                                //check Black Castling
                                if (cellFrom.getChessItem() instanceof BlackRook){
                                    if(cellFrom.equals(chessBoard.getCell(A, 8)))
                                    {
                                        countA8++;
                                    }
                                    if(cellFrom.equals(chessBoard.getCell(H,8)))
                                    {
                                        countH8++;
                                    }

                                }
                                if (cellFrom.getChessItem() instanceof BlackKing){
                                    if(cellFrom.equals(chessBoard.getCell(E,8)))
                                    {
                                        countE8++;
                                    }

                                }
                                //do
                                cellFrom.setChessItem(chessItemEmpty);
                                cellTo.setChessItem(chessItemFrom);

                                blackPlayerItems.put(to, chessItemFrom);
                                blackPlayerItems.remove(from);

                                whitePlayerItems.remove(to);
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


                doPawnChangeBlack(blackPlayerItems, cellTo, chessBoard);//do Castling

            }
            if (isBlackItem) {
                throw new PlayerSameChessItem();
            }
        }

        if(isCompleted)
            return true;
        else
            return false;

    }

}
