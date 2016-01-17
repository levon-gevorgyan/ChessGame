package moves;

import chessitems.ChessItem;
import chessitems.black.*;
import chessitems.empty.Empty;
import chessitems.WhiteItem;
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
import moves.available.black.moves.*;
import play.Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by Levon on 1/11/2016.
 */
public class BlackMove extends Move implements Letters {

    boolean isCompleted=false;
    //Black Rooks Moves Count
    public static int countA8=0;
    public static int countH8=0;
    public static int countE8=0;
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

    @Override
    public boolean move(Table table, Map<String, ChessItem> whitePlayerItems, Map<String, ChessItem> blackPlayerItems)
            throws PlayerSameChessItem, EmptySourceCell, InvalidSource, NoCell, InvalidMove, NoAvailableCells, IOException {



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
                for (SortedMap.Entry<String, Cell> cell:table.getAllCells().entrySet())
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

        if (table.getAllCells().get(from).getChessItem() instanceof Empty) {
            throw new EmptySourceCell(); //Empty Source
        }else if(table.getAllCells().get(from).getChessItem() instanceof WhiteItem)
        {
                throw new InvalidSource(); //Invalid Source
            }
        else {

            for (SortedMap.Entry<String, Cell> cell : table.getAllCells().entrySet()) {
                if (cell.getKey().equals(to)) {
                    if (isTargetCell && isTargetString) {
                        if (table.getAllCells().get(to).getChessItem() instanceof Empty) {
                            isEmpty = true;
                            isBlackItem = false;
                            break;
                        }
                    }
                }
            }
            for (SortedMap.Entry<String, Cell> cell : table.getAllCells().entrySet()) {
                if (cell.getKey().equals(to)) {
                    if (isTargetCell && isTargetString) {
                        if (table.getAllCells().get(to).getChessItem() instanceof WhiteItem) {
                            isBlackItem = false;
                            isWhiteItem = true;
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
                    if(cellFrom.getChessItem() instanceof BlackBishop){
                        availableCells=new BlackBishopMoves(cellFrom).getBlackBishopMoves();
                    }
                    else if (cellFrom.getChessItem() instanceof BlackKing){
                        availableCells=new BlackKingMoves(cellFrom).getBlackKingMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackKnight){
                        availableCells=new BlackKnightMoves(cellFrom).getBlackKnightMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackPawn){
                        availableCells=new BlackPawnMoves(cellFrom).getBlackPawnMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackQueen){
                        availableCells=new BlackQueenMoves(cellFrom).getBlackQueenMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackRook){
                        availableCells=new BlackRookMoves(cellFrom).getBlackRookMoves();

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
                                        if (cellTo.equals(table.getCell(C, 8))) {
                                            if(getLeftCastlingStatus())
                                            {
                                                cellFrom.setChessItem(chessItemTo);
                                                cellTo.setChessItem(chessItemFrom);

                                                String rookCellFrom = "a8";
                                                String rookCellTo = "d8";
                                                ChessItem rookItemFrom = table.getCell(A, 8).getChessItem();
                                                ChessItem rookItemTo = table.getCell(D, 8).getChessItem();

                                                table.getCell(A, 8).setChessItem(rookItemTo);
                                                table.getCell(D, 8).setChessItem(rookItemFrom);

                                                blackPlayerItems.put(to, chessItemFrom);
                                                blackPlayerItems.remove(from);
                                                blackPlayerItems.put(rookCellTo, rookItemFrom);
                                                blackPlayerItems.remove(rookCellFrom);
                                                available = true;
                                                castlingHasDone=true;
                                                isCompleted=true;
                                            }
                                        }
                                        else if (cellTo.equals(table.getCell(G, 8))) {
                                            if (getRightCastlingStatus()) {
                                                cellFrom.setChessItem(chessItemTo);
                                                cellTo.setChessItem(chessItemFrom);

                                                String rookCellFrom = "h8";
                                                String rookCellTo = "f8";
                                                ChessItem rookItemFrom = table.getCell(H, 8).getChessItem();
                                                ChessItem rookItemTo = table.getCell(F, 8).getChessItem();

                                                table.getCell(H, 8).setChessItem(rookItemTo);
                                                table.getCell(F, 8).setChessItem(rookItemFrom);

                                                blackPlayerItems.put(to, chessItemFrom);
                                                blackPlayerItems.remove(from);
                                                blackPlayerItems.put(rookCellTo, rookItemFrom);
                                                blackPlayerItems.remove(rookCellFrom);
                                                available = true;
                                                castlingHasDone = true;
                                                isCompleted=true;
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
                doPawnChangeBlack(blackPlayerItems, cellTo);//do Castling
                isCompleted=true;

            }
            if (isWhiteItem) {

                ChessItem chessItemFrom = table.getAllCells().get(from).getChessItem();
                ChessItem chessItemEmpty = new Empty();

                Cell cellFrom = table.getAllCells().get(from);
                Cell cellTo = table.getAllCells().get(to);

                //Get available cells of source <--Begin-->
                ArrayList<Cell> availableCells=new ArrayList<>();

                try {
                    //Conditions
                    if(cellFrom.getChessItem() instanceof BlackBishop){
                        availableCells=new BlackBishopMoves(cellFrom).getBlackBishopMoves();
                    }
                    else if (cellFrom.getChessItem() instanceof BlackKing){
                        availableCells=new BlackKingMoves(cellFrom).getBlackKingMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackKnight){
                        availableCells=new BlackKnightMoves(cellFrom).getBlackKnightMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackPawn){
                        availableCells=new BlackPawnMoves(cellFrom).getBlackPawnMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackQueen){
                        availableCells=new BlackQueenMoves(cellFrom).getBlackQueenMoves();

                    }
                    else if (cellFrom.getChessItem() instanceof BlackRook){
                        availableCells=new BlackRookMoves(cellFrom).getBlackRookMoves();

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
                                    if(cellFrom.equals(Game.TABLE.getCell(A,8)))
                                    {
                                        countA8++;
                                    }
                                    if(cellFrom.equals(Game.TABLE.getCell(H,8)))
                                    {
                                        countH8++;
                                    }

                                }
                                if (cellFrom.getChessItem() instanceof BlackKing){
                                    if(cellFrom.equals(Game.TABLE.getCell(E,8)))
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


                doPawnChangeBlack(blackPlayerItems, cellTo);//do Castling

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
