package moves;

import chessitems.BlackItem;
import chessitems.ChessItem;
import chessitems.empty.Empty;
import chessitems.white.*;
import chesstable.Table;
import chesstable.cells.Cell;
import chesstable.cells.Letters;
import exceptions.cell.EmptySourceCell;
import exceptions.cell.NoCell;
import exceptions.chessitem.PlayerSameChessItem;
import exceptions.moves.InvalidMove;
import exceptions.moves.InvalidMoveString;
import exceptions.cell.InvalidSource;
import exceptions.moves.NoAvailableCells;
import moves.available.white.moves.*;
import play.Game;
import players.BlackPlayer;
import players.WhitePlayer;

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
    public boolean move(Table table, WhitePlayer whitePlayer, BlackPlayer blackPlayer)
            throws PlayerSameChessItem, EmptySourceCell, InvalidSource, NoCell, InvalidMove, NoAvailableCells, IOException {
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
                for (SortedMap.Entry<String, Cell> cell:table.getCells().entrySet())
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

        if (table.getCells().get(from).getChessItem() instanceof Empty) {
            throw new EmptySourceCell(); //Empty Source
        }else if(table.getCells().get(from).getChessItem() instanceof BlackItem)
            {
                throw new InvalidSource(); //Invalid Source
            }
        else {

            for (SortedMap.Entry<String, Cell> cell : table.getCells().entrySet()) {
                if (cell.getKey().equals(to)) {
                    if (isTargetCell && isTargetString) {
                        if (table.getCells().get(to).getChessItem() instanceof Empty) {
                            isEmpty = true;
                            isWhiteItem = false;
                            break;
                        }
                    }
                }
            }
            for (SortedMap.Entry<String, Cell> cell : table.getCells().entrySet()) {
                if (cell.getKey().equals(to)) {
                    if (isTargetCell && isTargetString) {
                        if (table.getCells().get(to).getChessItem() instanceof BlackItem) {
                            isBlackItem = true;
                            isWhiteItem = false;
                            break;
                        }
                    }
                }
            }
            if (isEmpty) {

                ChessItem chessItemFrom = table.getCells().get(from).getChessItem();
                ChessItem chessItemTo = table.getCells().get(to).getChessItem();

                Cell cellFrom = table.getCells().get(from);
                Cell cellTo = table.getCells().get(to);

                //Get available cells of source <--Begin-->
                ArrayList<Cell> availableCells=new ArrayList<>();


                    //Conditions
                    if(cellFrom.getChessItem() instanceof WhiteBishop){
                        availableCells=new WhiteBishopMoves(cellFrom,table).getWhiteBishopMoves();
                    }
                    else if (cellFrom.getChessItem() instanceof WhiteKing){
                        availableCells=new WhiteKingMoves(cellFrom,table).getWhiteKingMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteKnight){
                        availableCells=new WhiteKnightMoves(cellFrom,table).getWhiteKnightMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhitePawn){
                        availableCells=new WhitePawnMoves(cellFrom,table).getWhitePawnMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteQueen){
                        availableCells=new WhiteQueenMoves(cellFrom,table).getWhiteQueenMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteRook){
                        availableCells=new WhiteRookMoves(cellFrom,table).getWhiteRookMoves();

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
                                        if (cellTo.equals(table.getCell(C, 1))) {
                                            if(getLeftCastlingStatus())
                                            {
                                                cellFrom.setChessItem(chessItemTo);
                                                cellTo.setChessItem(chessItemFrom);

                                                String rookCellFrom = "a1";
                                                String rookCellTo = "d1";
                                                ChessItem rookItemFrom = table.getCell(A, 1).getChessItem();
                                                ChessItem rookItemTo = table.getCell(D, 1).getChessItem();

                                                table.getCell(A, 1).setChessItem(rookItemTo);
                                                table.getCell(D, 1).setChessItem(rookItemFrom);

                                                whitePlayerItems.put(to, chessItemFrom);
                                                whitePlayerItems.remove(from);
                                                whitePlayerItems.put(rookCellTo, rookItemFrom);
                                                whitePlayerItems.remove(rookCellFrom);
                                                available = true;
                                                castlingHasDone=true;
                                                isCompleted=true;
                                            }
                                        }
                                        else if (cellTo.equals(table.getCell(G, 1))) {
                                            if (getRightCastlingStatus()) {
                                                cellFrom.setChessItem(chessItemTo);
                                                cellTo.setChessItem(chessItemFrom);

                                                String rookCellFrom = "h1";
                                                String rookCellTo = "f1";
                                                ChessItem rookItemFrom = table.getCell(H, 1).getChessItem();
                                                ChessItem rookItemTo = table.getCell(F, 1).getChessItem();

                                                table.getCell(H, 1).setChessItem(rookItemTo);
                                                table.getCell(F, 1).setChessItem(rookItemFrom);

                                                whitePlayerItems.put(to, chessItemFrom);
                                                whitePlayerItems.remove(from);
                                                whitePlayerItems.put(rookCellTo, rookItemFrom);
                                                whitePlayerItems.remove(rookCellFrom);
                                                available = true;
                                                castlingHasDone = true;
                                                isCompleted=true;
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
                doPawnChangeWhite(whitePlayerItems,cellTo,table);//do Castling
                isCompleted=true;

            }
            if (isBlackItem) {

                ChessItem chessItemFrom = table.getCells().get(from).getChessItem();
                ChessItem chessItemEmpty = new Empty();

                Cell cellFrom = table.getCells().get(from);
                Cell cellTo = table.getCells().get(to);

                //Get available cells of source <--Begin-->
                ArrayList<Cell> availableCells=new ArrayList<>();

                try {
                    //Conditions
                    if(cellFrom.getChessItem() instanceof WhiteBishop){
                        availableCells=new WhiteBishopMoves(cellFrom,table).getWhiteBishopMoves();
                    }
                    else if (cellFrom.getChessItem() instanceof WhiteKing){
                        availableCells=new WhiteKingMoves(cellFrom,table).getWhiteKingMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteKnight){
                        availableCells=new WhiteKnightMoves(cellFrom,table).getWhiteKnightMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhitePawn){
                        availableCells=new WhitePawnMoves(cellFrom,table).getWhitePawnMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteQueen){
                        availableCells=new WhiteQueenMoves(cellFrom,table).getWhiteQueenMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteRook){
                        availableCells=new WhiteRookMoves(cellFrom,table).getWhiteRookMoves();

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
                                    if(cellFrom.equals(table.getCell(A,1)))
                                    {
                                        countA1++;
                                    }
                                    if(cellFrom.equals(table.getCell(H,1)))
                                    {
                                        countH1++;
                                    }

                                }
                                if (cellFrom.getChessItem() instanceof WhiteKing){
                                    if(cellFrom.equals(table.getCell(E,1)))
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


                doPawnChangeWhite(whitePlayerItems,cellTo,table);//do Castling

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
