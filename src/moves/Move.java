package moves;

import chessitems.BlackItem;
import chessitems.ChessItem;
import chessitems.WhiteItem;
import chessitems.black.*;
import chessitems.empty.Empty;
import chessitems.white.*;
import chesstable.Table;
import chesstable.cells.Cell;

import colors.Colors;

import exceptions.cell.EmptySourceCell;
import exceptions.cell.InvalidSource;
import exceptions.cell.NoCell;
import exceptions.cell.NotEmptyCell;
import exceptions.chessitem.PlayerSameChessItem;
import exceptions.moves.*;
import exceptions.table.OutOfTable;
import letsnums.LetsNums;

import moves.available.black.moves.*;
import moves.available.white.moves.*;
import play.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Levon on 1/11/2016.
 */
public abstract class Move implements Colors{
    protected String string;
    protected String from;
    protected String to;
    
    
    public abstract boolean move(Table table,Map<String, ChessItem> whitePlayerItems,Map<String, ChessItem> blackPlayerItems)
            throws PlayerSameChessItem, EmptySourceCell, InvalidSource, OutOfTable, NoCell, InvalidMove, NoAvailableCells, IOException;

    public static boolean isInAllItemsOfAvailableCellListWhite(Cell kingCell, Map<String, ChessItem> playerItems, Table table)
    {
        //Get available cells of source <--Begin-->
        ArrayList<Cell> allAvailableCells=new ArrayList<>();

        for(Map.Entry<String, ChessItem> pair:playerItems.entrySet())
        {
       
            //Conditions
            try {
                if(pair.getValue() instanceof WhiteBishop){
                    allAvailableCells.addAll(new WhiteBishopMoves(table.getCellByString(pair.getKey()), table).getWhiteBishopMoves());
                }
            } catch (NoAvailableCells noAvailableCells) {
                
            }
            if (pair.getValue() instanceof WhiteKing){
                try {
                    allAvailableCells.addAll(new WhiteKingMoves(table.getCellByString(pair.getKey()),table).getWhiteKingMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof WhiteKnight){
                try {
                    allAvailableCells.addAll(new WhiteKnightMoves(table.getCellByString(pair.getKey()),table).getWhiteKnightMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof WhitePawn){
                try {
                    allAvailableCells.addAll(new WhitePawnMoves(table.getCellByString(pair.getKey()),table).getWhitePawnMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof WhiteQueen){
                try {
                    allAvailableCells.addAll(new WhiteQueenMoves(table.getCellByString(pair.getKey()), table).getWhiteQueenMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof WhiteRook){
                try {
                    allAvailableCells.addAll(new WhiteRookMoves(table.getCellByString(pair.getKey()), table).getWhiteRookMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                } catch (NoCell noCell) {
                   
                }

            }
            
        }
        if(allAvailableCells.size()==0){
            return false;

        }
        else 
        {
            for(Cell cell:allAvailableCells)
            {
                if(cell.getChessItem().equals(kingCell.getChessItem()))
                    return true;
            }
            
        }
        return false;
         
    }
    public static boolean isInAllItemsOfAvailableCellListBlack(Cell kingCell, Map<String, ChessItem> playerItems, Table table)
    {
        //Get available cells of source <--Begin-->
        ArrayList<Cell> allAvailableCells=new ArrayList<>();

        for(Map.Entry<String, ChessItem> pair:playerItems.entrySet())
        {
       
            //Conditions
            try {
                if(pair.getValue() instanceof BlackBishop){
                    allAvailableCells.addAll(new BlackBishopMoves(table.getCellByString(pair.getKey()),table).getBlackBishopMoves());
                }
            } catch (NoAvailableCells noAvailableCells) {
                
            }
            if (pair.getValue() instanceof BlackKing){
                try {
                    allAvailableCells.addAll(new BlackKingMoves(table.getCellByString(pair.getKey()),table).getBlackKingMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof BlackKnight){
                try {
                    allAvailableCells.addAll(new BlackKnightMoves(table.getCellByString(pair.getKey()),table).getBlackKnightMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof BlackPawn){
                try {
                    allAvailableCells.addAll(new BlackPawnMoves(table.getCellByString(pair.getKey()),table).getBlackPawnMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof BlackQueen){
                try {
                    allAvailableCells.addAll(new BlackQueenMoves(table.getCellByString(pair.getKey()),table).getBlackQueenMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof BlackRook){
                try {
                    allAvailableCells.addAll(new BlackRookMoves(table.getCellByString(pair.getKey()), table).getBlackRookMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                } catch (NoCell noCell) {
                   
                }

            }
            
        }
        if(allAvailableCells.size()==0){
            return false;

        }
        else 
        {
            for(Cell cell:allAvailableCells)
            {
                if(cell.getChessItem().equals(kingCell.getChessItem()))
                    return true;
            }
            
        }
        return false;
         
    }

    //Checks if Row 8 has Pawn
    protected boolean pawnChangeWhite(ChessItem pawn,Table Table)
    {
        if(pawn instanceof WhitePawn)
        {
            for(Cell cell : Table.getRows().get(7))
            {
                if(cell.getChessItem().equals(pawn))
                {
                    return true;
                }
            }
        }
        return false;

    }

    //Checks if Row 1 has Pawn
    protected boolean pawnChangeBlack(ChessItem pawn,Table Table)
    {
        if(pawn instanceof BlackPawn)
        {
            for(Cell cell : Table.getRows().get(0))
            {
                if(cell.getChessItem().equals(pawn))
                {
                    return true;
                }
            }
        }
        return false;
    }

    //Change White Pawn
    protected void doPawnChangeWhite(Map<String, ChessItem> whitePlayerItems,Cell cell, Table Table) throws IOException {
        if(pawnChangeWhite(cell.getChessItem(),Table)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            boolean isDone = false;
            String string;

            while (!isDone) {
                System.out.println("Choose one of following white items:");
                System.out.println("queen");
                System.out.println("rook");
                System.out.println("bishop");
                System.out.println("knight");
                System.out.print("Your decision is: ");
                string = reader.readLine();

                try {
                    WhiteItem newPawn = whitePawnChangeTo(string);
                    whitePlayerItems.put(cell.toString(), newPawn);
                    cell.setChessItem(newPawn);
                    isDone = true;
                } catch (InvalidChangeItem invalidChangeItem) {
                    System.out.print("Wrong White Item. Try again: ");
                }
            }
        }
    }

    //Change Black Pawn
    protected void doPawnChangeBlack(Map<String, ChessItem> blackPlayerItems,Cell cell,Table Table) throws IOException {
        if(pawnChangeBlack(cell.getChessItem(),Table)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            boolean isDone = false;
            String string;

            while (!isDone) {
                System.out.println("Choose one of following black items:");
                System.out.println("queen");
                System.out.println("rook");
                System.out.println("bishop");
                System.out.println("knight");
                System.out.print("Your decision is: ");
                string = reader.readLine();

                try {
                    BlackItem newPawn = blackPawnChangeTo(string);
                    blackPlayerItems.put(cell.toString(), newPawn);
                    cell.setChessItem(newPawn);
                    isDone = true;
                } catch (InvalidChangeItem invalidChangeItem) {
                    System.out.print("Wrong White Item. Try again: ");
                }
            }
        }

    }

    protected WhiteItem whitePawnChangeTo(String item) throws InvalidChangeItem {
        if (item.equals("queen"))
            return new WhiteQueen();
        if (item.equals("rook"))
            return new WhiteRook();
        if (item.equals("bishop"))
            return new WhiteBishop();
        if (item.equals("knight"))
            return new WhiteKnight();
        throw new InvalidChangeItem();
    }
    protected BlackItem blackPawnChangeTo(String item) throws InvalidChangeItem {
        if (item.equals("queen"))
            return new BlackQueen();
        if (item.equals("rook"))
            return new BlackRook();
        if (item.equals("bishop"))
            return new BlackBishop();
        if (item.equals("knight"))
            return new BlackKnight();
        throw new InvalidChangeItem();
    }



    //Moving to Direction Until Empty Cell is Met
    //<--BEGIN-->

    public static ArrayList<Cell> moveUpUntilNotEmpty(Cell cell,Table Table) throws OutOfTable, NoCell, NotEmptyCell {

        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (Table.upCell(cell).getChessItem() instanceof Empty)
                {
                    
                    cell=Table.upCell(cell);
                    list.add(cell);
                }
                return list;
            }
            catch (NoCell noCell)
            {


            }
        }
        else
            throw new  NotEmptyCell();
        return list;
    }

    public static  ArrayList<Cell>  moveDownUntilNotEmpty(Cell cell,Table Table) throws OutOfTable, NoCell, NotEmptyCell {
        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (Table.downCell(cell).getChessItem() instanceof Empty)
                {
                    cell=Table.downCell(cell);
                    list.add(cell);
                }
                return list;
            }
            catch (NoCell noCell)
            {


            }
        }
        else
            throw new  NotEmptyCell();
        return list;
    }

    public static  ArrayList<Cell>  moveLeftUntilNotEmpty(Cell cell,Table Table) throws OutOfTable, NoCell, NotEmptyCell {
        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (Table.leftCell(cell).getChessItem() instanceof Empty)
                {
                    cell=Table.leftCell(cell);
                    list.add(cell);
                }
                return list;
            }
            catch (NoCell noCell)
            {


            }
        }
        else
            throw new  NotEmptyCell();
        return list;
    }

    public static  ArrayList<Cell>  moveRightUntilNotEmpty(Cell cell,Table Table) throws OutOfTable, NoCell, NotEmptyCell {
        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (Table.rightCell(cell).getChessItem() instanceof Empty)
                {
                    cell=Table.rightCell(cell);
                    list.add(cell);

                }
                return list;
            }
            catch (NoCell noCell)
            {


            }
        }
        else
            throw new  NotEmptyCell();
        return list;
    }

    public static   ArrayList<Cell>  moveDiagLeftUpUntilNotEmpty(Cell cell,Table Table) throws OutOfTable, NoCell, NotEmptyCell {
        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (Table.diagonalLeftUpCell(cell).getChessItem() instanceof Empty)
                {
                    cell=Table.diagonalLeftUpCell(cell);
                    list.add(cell);
                }
                return list;
            }
            catch (NoCell noCell)
            {


            }
        }
        else
            throw new  NotEmptyCell();
        return list;
    }

    public static   ArrayList<Cell>  moveDiagLeftDownUntilNotEmpty(Cell cell,Table Table) throws OutOfTable, NoCell, NotEmptyCell {
        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (Table.diagonalLeftDownCell(cell).getChessItem() instanceof Empty)
                {
                    cell=Table.diagonalLeftDownCell(cell);
                    list.add(cell);
                }
                return list;
            }
            catch (NoCell noCell)
            {


            }
        }
        else
            throw new  NotEmptyCell();

        return list;
    }

    public static   ArrayList<Cell>  moveDiagRightUpUntilNotEmpty(Cell cell,Table Table) throws OutOfTable, NoCell, NotEmptyCell {
        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (Table.diagonalRightUpCell(cell).getChessItem() instanceof Empty)
                {
                    cell=Table.diagonalRightUpCell(cell);
                    list.add(cell);
                }
                return list;
            }
            catch (NoCell noCell)
            {


            }
        }
        else
            throw new  NotEmptyCell();
        return list;
    }

    public static   ArrayList<Cell>  moveDiagRightDownUntilNotEmpty(Cell cell,Table Table) throws OutOfTable, NoCell, NotEmptyCell {
        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (Table.diagonalRightDownCell(cell).getChessItem() instanceof Empty)
                {
                    cell=Table.diagonalRightDownCell(cell);
                    list.add(cell);
                }
                return list;
            }
            catch (NoCell noCell)
            {


            }
        }
        else
            throw new  NotEmptyCell();
        return list;
    }
    //Moving to Direction Until Empty Cell is Met
    //<--END-->


    public boolean isValidString(String s) throws InvalidMoveString {
        boolean isValidString=false;
        char[] stringToChar=s.toCharArray();

            if(stringToChar.length==4)
            {
                try {
                    if (LetsNums.isLetter(stringToChar[0]))
                    {
                        try {
                            if (LetsNums.isNumber(stringToChar[1]))
                            {
                                try {
                                    if (LetsNums.isLetter(stringToChar[2])) {
                                        try {
                                            if (LetsNums.isNumber(stringToChar[3]))
                                            {
                                                isValidString=true;
                                            }
                                        } catch (WrongNumber wrongNumber) {
                                            System.out.println("Source is Wrong");
                                        }

                                    }
                                } catch (WrongLetter wrongLetter) {
                                    System.out.println("Source is Wrong");
                                }

                            }
                        } catch (WrongNumber wrongNumber) {
                            System.out.println("Target is Wrong");
                        }
                    }
                } catch (WrongLetter wrongLetter) {
                    System.out.println("Target is Wrong");
                }
            }
            else {
                throw new InvalidMoveString();
            }


        if (isValidString){

            return true;
        }
        else
            throw new InvalidMoveString();


    }
}
