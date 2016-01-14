package moves;

import chessitems.ChessItem;
import chessitems.black.BlackBishop;
import chessitems.empty.Empty;
import chessitems.WhiteItem;
import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.cell.EmptySourceCell;
import exceptions.cell.NoCell;
import exceptions.moves.InvalidMoveString;
import exceptions.cell.InvalidSource;
import exceptions.chessitem.SameChessItem;
import exceptions.table.OutOfTable;
import moves.available.black.moves.*;
import moves.available.moves.AvailableMoves;

import java.util.Map;
import java.util.SortedMap;

/**
 * Created by Levon on 1/11/2016.
 */
public class BlackMove extends Move {
    public static boolean isBlackItem;
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
    public void move(Table table, Map<String, ChessItem> whitePlayerItems, Map<String, ChessItem> blackPlayerItems)
            throws SameChessItem, EmptySourceCell, InvalidSource, OutOfTable, NoCell {
        String from=this.from;
        String to=this.to;


        boolean isTargetString=false;
        boolean isTargetCell=false;
        boolean isEmpty=false;
        boolean isBlackItem=true;
        boolean isWhiteItem=false;

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
            throw new EmptySourceCell();
        }else if(table.getAllCells().get(from).getChessItem() instanceof WhiteItem)
        {
            throw new InvalidSource();
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

                /*for (Cell x:new BlackKingMoves(cellFrom).getBlackKingMoves())
                {
                    System.out.println(x);
                }*/

                cellFrom.setChessItem(chessItemTo);
                cellTo.setChessItem(chessItemFrom);

                blackPlayerItems.put(to, chessItemFrom);
                blackPlayerItems.remove(from);


            }
            if (isWhiteItem) {

                ChessItem chessItemFrom = table.getAllCells().get(from).getChessItem();
                ChessItem chessItemEmpty = new Empty();

                Cell cellFrom = table.getAllCells().get(from);
                Cell cellTo = table.getAllCells().get(to);







                cellFrom.setChessItem(chessItemEmpty);
                cellTo.setChessItem(chessItemFrom);

                blackPlayerItems.put(to, chessItemFrom);
                blackPlayerItems.remove(from);

                whitePlayerItems.remove(to);

            }
            if (isBlackItem) {
                throw new SameChessItem();
            }
        }


    }
}
