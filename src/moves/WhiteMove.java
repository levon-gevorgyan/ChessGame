package moves;

import chessitems.BlackItem;
import chessitems.ChessItem;
import chessitems.empty.Empty;
import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.cell.EmptySourceCell;
import exceptions.cell.NoCell;
import exceptions.moves.InvalidMoveString;
import exceptions.cell.InvalidSource;
import exceptions.chessitem.SameChessItem;
import moves.available.moves.AvailableMoves;
import moves.available.white.moves.*;

import java.util.Map;
import java.util.SortedMap;

/**
 * Created by Levon on 1/11/2016.
 */
public class WhiteMove extends Move {

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
            throws SameChessItem, EmptySourceCell, InvalidSource, NoCell {
        String from=this.from;
        String to=this.to;


        boolean isTargetString=false;
        boolean isTargetCell=false;
        boolean isEmpty=false;
        boolean isBlackItem=false;
        boolean isWhiteItem=true;

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
            throw new EmptySourceCell();
        }else if(table.getAllCells().get(from).getChessItem() instanceof BlackItem)
            {
                throw new InvalidSource();
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

                /*for (Cell x:new WhitePawnMoves(cellFrom).getWhitePawnMoves())
                {
                    System.out.println(x);
                }*/

                cellFrom.setChessItem(chessItemTo);
                cellTo.setChessItem(chessItemFrom);

                whitePlayerItems.put(to, chessItemFrom);
                whitePlayerItems.remove(from);


            }
            if (isBlackItem) {
                ChessItem chessItemFrom = table.getAllCells().get(from).getChessItem();
                ChessItem chessItemEmpty = new Empty();

                Cell cellFrom = table.getAllCells().get(from);
                Cell cellTo = table.getAllCells().get(to);

                cellFrom.setChessItem(chessItemEmpty);
                cellTo.setChessItem(chessItemFrom);

                whitePlayerItems.put(to, chessItemFrom);
                whitePlayerItems.remove(from);

                blackPlayerItems.remove(to);

            }
            if (isWhiteItem) {
                throw new SameChessItem();
            }
        }


    }
}
