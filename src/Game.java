import chessitems.ChessItem;
import chesstable.cells.Cell;
import chesstable.Table;
import chesstable.cells.Letters;

import exceptions.cell.EmptySourceCell;
import exceptions.cell.InvalidSource;
import exceptions.cell.NoCell;
import exceptions.cell.NotEmptyCell;
import exceptions.chessitem.SameChessItem;
import exceptions.moves.InvalidMoveString;
import exceptions.table.OutOfTable;
import moves.BlackMove;
import moves.Move;
import moves.WhiteMove;

import players.BlackPlayer;
import players.Player;
import players.WhitePlayer;

import java.io.IOException;

import java.util.Map;
import java.util.SortedMap;

/**
 * Created by Levon on 1/9/2016.
 */
public class Game implements Letters{



    public static void main(String[] args)
            throws IOException, InvalidMoveString, EmptySourceCell, OutOfTable, NoCell, InvalidSource, SameChessItem, NotEmptyCell {

        Table table=new Table();
        table.getAllCells();

        Player whitePlayer = new WhitePlayer();
        Player blackPlayer = new BlackPlayer();

        Map<String, ChessItem> whitePlayerItems = whitePlayer.getChessItemsMap();
        Map<String, ChessItem> blackPlayerItems = blackPlayer.getChessItemsMap();

        //MAKING TABLE, DO NOT REMOVE---BEGIN
        setAllItems(table, whitePlayerItems, blackPlayerItems);
        //MAKING TABLE, DO NOT REMOVE---END

        try {
            new WhiteMove("a2d6").move(table, whitePlayerItems, blackPlayerItems);
            setAllItems(table, whitePlayerItems, blackPlayerItems);

        }
        catch (EmptySourceCell emptySourceCell){
            System.out.println(emptySourceCell.toString());
        }
        catch (SameChessItem sameChessItem){
            System.out.println("Target is your Item");
        } catch (InvalidSource invalidSource) {
            System.out.println("Source is not yours");

        }
        setAllItems(table, whitePlayerItems, blackPlayerItems);
        new BlackMove("b7a1").move(table, whitePlayerItems, blackPlayerItems);
        setAllItems(table, whitePlayerItems, blackPlayerItems);
        //ArrayList<Cell> a=Table.previousRow(table.getCell(E,2));


        /*for(Map.Entry<Cell,ArrayList<Cell>> pair: table.getRelativeCellsStraight().entrySet())
        {
            System.out.print(Character.toString(pair.getKey().getX())+pair.getKey().getY()+"-");
            for (Cell cell: pair.getValue())
            {
                System.out.print(Character.toString(cell.getX()) + cell.getY() + ", ");
            }
            System.out.println("\n");
        }*/


        setAllItems(table, whitePlayerItems, blackPlayerItems);
        //Cell C= Move.moveDiagLeftUpUntilNotEmpty(table.getCell(H,2));

        /*for (int i=0;i<8;i++)
        {*/
        //System.out.println(C.toString());
        /*}*/




    }




    private static void setAllItems(Table table,Map<String, ChessItem> whitePlayerItems,Map<String, ChessItem> blackPlayerItems){

        for (SortedMap.Entry<String, Cell> cell : table.getAllCells().entrySet()) {
            for (Map.Entry<String, ChessItem> item : whitePlayerItems.entrySet()) {
                if (cell.getKey().equals(item.getKey())) {
                    cell.getValue().setChessItem(item.getValue());
                }
            }
            for (Map.Entry<String, ChessItem> item : blackPlayerItems.entrySet()) {
                if (cell.getKey().equals(item.getKey())) {
                    cell.getValue().setChessItem(item.getValue());
                }
            }

        }

        table.toString();
    }

}
