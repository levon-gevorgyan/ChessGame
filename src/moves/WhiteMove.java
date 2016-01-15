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
import exceptions.moves.InvalidMove;
import exceptions.moves.InvalidMoveString;
import exceptions.cell.InvalidSource;
import exceptions.chessitem.SameChessItem;
import exceptions.moves.NoAvailableCells;
import moves.available.white.moves.*;
import play.Game;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by Levon on 1/11/2016.
 */
public class WhiteMove extends Move implements Letters{
    //White Rooks Moves Count
    public static int countA1=0;
    public static int countH1=0;
    public static int countE1=0;
    private boolean castlingHasDone=false;

    private static boolean playerRookA1=true;
    private static boolean playerRookH1=true;
    private static boolean playerKingE1=true;

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

    @Override
    public void move(Table table,Map<String, ChessItem> whitePlayerItems,Map<String, ChessItem> blackPlayerItems)
            throws SameChessItem, EmptySourceCell, InvalidSource, NoCell, InvalidMove, NoAvailableCells {
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
                for (SortedMap.Entry<String, Cell> cell:table.getAllCells().entrySet())
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

        if (table.getAllCells().get(from).getChessItem() instanceof Empty) {
            throw new EmptySourceCell(); //Empty Source
        }else if(table.getAllCells().get(from).getChessItem() instanceof BlackItem)
            {
                throw new InvalidSource(); //Invalid Source
            }
        else {

            for (SortedMap.Entry<String, Cell> cell : table.getAllCells().entrySet()) {
                if (cell.getKey().equals(to)) {
                    if (isTargetCell && isTargetString) {
                        if (table.getAllCells().get(to).getChessItem() instanceof Empty) {
                            isEmpty = true;
                            isWhiteItem = false;
                            break;
                        }
                    }
                }
            }
            for (SortedMap.Entry<String, Cell> cell : table.getAllCells().entrySet()) {
                if (cell.getKey().equals(to)) {
                    if (isTargetCell && isTargetString) {
                        if (table.getAllCells().get(to).getChessItem() instanceof BlackItem) {
                            isBlackItem = true;
                            isWhiteItem = false;
                            break;
                        }
                    }
                }
            }
            if (isEmpty) {

                ChessItem chessItemFrom = table.getAllCells().get(from).getChessItem();
                ChessItem chessItemTo = table.getAllCells().get(to).getChessItem();

                Cell cellFrom = table.getAllCells().get(from);
                Cell cellTo = table.getAllCells().get(to);

                //Get available cells of source <--Begin-->
                ArrayList<Cell> availableCells=new ArrayList<>();


                    //Conditions
                    if(cellFrom.getChessItem() instanceof WhiteBishop){
                        availableCells=new WhiteBishopMoves(cellFrom).getWhiteBishopMoves();
                    }
                    else if (cellFrom.getChessItem() instanceof WhiteKing){
                        availableCells=new WhiteKingMoves(cellFrom).getWhiteKingMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteKnight){
                        availableCells=new WhiteKnightMoves(cellFrom).getWhiteKnightMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhitePawn){
                        availableCells=new WhitePawnMoves(cellFrom).getWhitePawnMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteQueen){
                        availableCells=new WhiteQueenMoves(cellFrom).getWhiteQueenMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteRook){
                        availableCells=new WhiteRookMoves(cellFrom).getBlackRookMoves();

                    }
                    else{
                        throw new NoAvailableCells();

                    }


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

            }
            if (isBlackItem) {

                ChessItem chessItemFrom = table.getAllCells().get(from).getChessItem();
                ChessItem chessItemEmpty = new Empty();

                Cell cellFrom = table.getAllCells().get(from);
                Cell cellTo = table.getAllCells().get(to);

                //Get available cells of source <--Begin-->
                ArrayList<Cell> availableCells=new ArrayList<>();

                try {
                    //Conditions
                    if(cellFrom.getChessItem() instanceof WhiteBishop){
                        availableCells=new WhiteBishopMoves(cellFrom).getWhiteBishopMoves();
                    }
                    else if (cellFrom.getChessItem() instanceof WhiteKing){
                        availableCells=new WhiteKingMoves(cellFrom).getWhiteKingMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteKnight){
                        availableCells=new WhiteKnightMoves(cellFrom).getWhiteKnightMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhitePawn){
                        availableCells=new WhitePawnMoves(cellFrom).getWhitePawnMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteQueen){
                        availableCells=new WhiteQueenMoves(cellFrom).getWhiteQueenMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof WhiteRook){
                        availableCells=new WhiteRookMoves(cellFrom).getBlackRookMoves();

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
                                    if(cellFrom.equals(Game.TABLE.getCell(A,1)))
                                    {
                                        countA1++;
                                    }
                                    if(cellFrom.equals(Game.TABLE.getCell(H,1)))
                                    {
                                        countH1++;
                                    }

                                }
                                if (cellFrom.getChessItem() instanceof WhiteKing){
                                    if(cellFrom.equals(Game.TABLE.getCell(E,1)))
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

            }
            if (isWhiteItem) {
                throw new SameChessItem();
            }
        }


    }
}
