package play;

import chessitems.ChessItem;
import chessitems.black.BlackKing;
import chessitems.white.WhiteKing;
import chesstable.cells.Cell;
import chesstable.Table;
import chesstable.cells.Letters;

import colors.Colors;
import exceptions.cell.EmptySourceCell;
import exceptions.cell.InvalidSource;
import exceptions.cell.NoCell;
import exceptions.chessitem.PlayerSameChessItem;
import exceptions.game.Check;
import exceptions.moves.InvalidMove;
import exceptions.moves.InvalidMoveString;
import exceptions.moves.NoAvailableCells;
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
public class Game implements Letters, Colors{

    public static Table TABLE;

    public static Cell getCellByString(String string)
    {
        char[] s=string.toCharArray();
        return TABLE.getCell(s[0],Character.getNumericValue(s[1]));
    }


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



        //TESTING PART----->Begin
        /*new BlackMove(s).move(table, whitePlayerItems, blackPlayerItems);
        setAllItems(table, whitePlayerItems, blackPlayerItems);*/

        //TESTING PART----->End

        //Start play.Game
        String s = "";

        while (!s.equals("exit"))
        {

            while (!s.equals("exit")) //White player's turn
            {
                boolean nextToBlack;
                nextToBlack=false;

                System.out.print("White player's turn: ");
                s=reader.readLine();
                try {
                    new WhiteMove(s).move(table, whitePlayerItems, blackPlayerItems);

                    nextToBlack=true;
                } catch (PlayerSameChessItem playerSameChessItem) {
                    System.out.println("Source & Target are the same");

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
                    //is Check or not
                    Cell kingCell=getOpponentKingCell(BLACK,whitePlayerItems,blackPlayerItems);
                    if(Move.isInAllItemsOFAvailableCellListWhite(kingCell, whitePlayerItems))
                    {
                        try {
                            throw new Check();
                        } catch (Check check) {
                            System.out.println("Check to Black Army");
                        }
                    }

                    break;
                }
                setAllItems(table, whitePlayerItems, blackPlayerItems);
            }
            while (!s.equals("exit")) //Black player's turn
            {
                boolean nextToWhite;
                nextToWhite=false;
                System.out.print("Black player's turn: ");
                s=reader.readLine();
                try {
                    new BlackMove(s).move(table, whitePlayerItems, blackPlayerItems);
                    nextToWhite=true;
                } catch (PlayerSameChessItem sameChessItem) {
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
                    //is Check or not
                    Cell kingCell=getOpponentKingCell(WHITE,whitePlayerItems,blackPlayerItems);
                    if(Move.isInAllItemsOFAvailableCellListBlack(kingCell, blackPlayerItems))
                    {
                        try {
                            throw new Check();
                        } catch (Check check) {
                            System.out.println("Check to White Army");
                        }

                    }
                    break;
                }
                table.toString();
            }

        }
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
    //get Opponent's King's location
    private static Cell getOpponentKingCell(String playerColor, Map<String, ChessItem> whitePlayer, Map<String, ChessItem> blackPlayer)
    {
        if(playerColor.equals(BLACK))
        {
            for(Map.Entry<String,ChessItem> pair:blackPlayer.entrySet())
            {
                if(pair.getValue() instanceof BlackKing)
                    return Game.getCellByString(pair.getKey());
            }
        }
        if(playerColor.equals(WHITE))
        {
            for(Map.Entry<String,ChessItem> pair:whitePlayer.entrySet())
            {
                if(pair.getValue() instanceof WhiteKing)
                    return Game.getCellByString(pair.getKey());
            }
        }
        return null;
    }



}

