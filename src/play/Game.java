package play;

import chessitems.ChessItem;
import chesstable.cells.Cell;
import chesstable.Table;
import chesstable.cells.Letters;

import exceptions.cell.EmptySourceCell;
import exceptions.cell.InvalidSource;
import exceptions.cell.NoCell;
import exceptions.cell.NotEmptyCell;
import exceptions.chessitem.SameChessItem;
import exceptions.moves.InvalidMove;
import exceptions.moves.InvalidMoveString;
import exceptions.moves.NoAvailableCells;
import exceptions.table.OutOfTable;
import moves.BlackMove;
import moves.Move;
import moves.WhiteMove;

import players.BlackPlayer;
import players.Player;
import players.WhitePlayer;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by Levon on 1/9/2016.
 */
public class Game implements Letters{
    public static Table TABLE;





    public static void main(String[] args)
            throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


        Table table=new Table();
        TABLE=table;
        table.getAllCells();

        Player whitePlayer = new WhitePlayer();
        Player blackPlayer = new BlackPlayer();

        Map<String, ChessItem> whitePlayerItems = whitePlayer.getChessItemsMap();
        Map<String, ChessItem> blackPlayerItems = blackPlayer.getChessItemsMap();

        //MAKING TABLE, DO NOT REMOVE---BEGIN
        setAllItems(table, whitePlayerItems, blackPlayerItems);
        //MAKING TABLE, DO NOT REMOVE---END


        //Start play.Game
        String s = "";
        //try {
        while (!s.equals("exit"))
        {

            while (!s.equals("exit"))
            {
                boolean nextToBlack;
                nextToBlack=false;

                System.out.print("White player's turn: ");
                s=reader.readLine();
                try {
                    new WhiteMove(s).move(table, whitePlayerItems, blackPlayerItems);
                    nextToBlack=true;
                } catch (SameChessItem sameChessItem) {
                    System.out.println("Same chess item");

                } catch (EmptySourceCell emptySourceCell) {
                    System.out.println("Source Cell is empty");

                } catch (InvalidSource invalidSource) {
                    System.out.println("Source is invalid");

                } catch (NoCell noCell) {

                } catch (InvalidMoveString invalidMoveString) {
                    System.out.println("String is invalid");

                } catch (InvalidMove invalidMove) {


                } catch (NoAvailableCells noAvailableCells) {
                    System.out.println("No Available Cells");
                }
                if(nextToBlack)
                {
                    setAllItems(table, whitePlayerItems, blackPlayerItems);
                    break;
                }
                setAllItems(table, whitePlayerItems, blackPlayerItems);
            }
            while (!s.equals("exit"))
            {
                boolean nextToWhite;
                nextToWhite=false;
                System.out.print("Black player's turn: ");
                s=reader.readLine();
                try {
                    new BlackMove(s).move(table, whitePlayerItems, blackPlayerItems);
                    nextToWhite=true;
                } catch (SameChessItem sameChessItem) {
                    System.out.println("Same chess item");

                } catch (EmptySourceCell emptySourceCell) {
                    System.out.println("Source Cell is empty");

                } catch (InvalidSource invalidSource) {
                    System.out.println("Source is invalid");

                } catch (NoCell noCell) {

                } catch (InvalidMoveString invalidMoveString) {
                    System.out.println("String is invalid");

                } catch (InvalidMove invalidMove) {


                } catch (NoAvailableCells noAvailableCells) {
                    System.out.println("No Available Cells");
                }
                if(nextToWhite)
                {
                    setAllItems(table, whitePlayerItems, blackPlayerItems);
                    break;
                }
                table.toString();
            }

        }



            /*new BlackMove("e7c3").move(table, whitePlayerItems, blackPlayerItems);
            setAllItems(table, whitePlayerItems, blackPlayerItems);*/

        /*}
        catch (EmptySourceCell emptySourceCell){
            System.out.println(emptySourceCell.toString());
        }
        catch (SameChessItem sameChessItem){
            System.out.println("Target is your Item");
        } catch (InvalidSource invalidSource) {
            System.out.println("Source is not yours");

        }
        setAllItems(table, whitePlayerItems, blackPlayerItems);*/
       /* new WhiteMove("b2d4").move(table, whitePlayerItems, blackPlayerItems);
        setAllItems(table, whitePlayerItems, blackPlayerItems);*/
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


        //setAllItems(table, whitePlayerItems, blackPlayerItems);
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
