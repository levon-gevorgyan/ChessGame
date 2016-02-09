package api.moves;

import api.chessboard.ChessBoard;
import api.chessitems.BlackItem;
import api.chessitems.ChessItem;
import api.chessitems.WhiteItem;
import api.chessitems.black.*;
import api.chessitems.empty.Empty;
import api.chessitems.white.*;
import api.chessboard.cells.Cell;

import api.colors.Colors;

import api.exceptions.cell.EmptySourceCell;
import api.exceptions.cell.InvalidSource;
import api.exceptions.cell.NoCell;
import api.exceptions.cell.NotEmptyCell;
import api.exceptions.chessitem.PlayerSameChessItem;
import api.exceptions.game.CastlingDone;
import api.exceptions.game.ChangePawn;
import api.exceptions.moves.*;
import api.exceptions.table.OutOfTable;
import api.letsnums.LetsNums;

import api.moves.available.black.moves.*;
import api.moves.available.white.moves.*;
import api.players.BlackPlayer;
import api.players.WhitePlayer;
import ui.window.alerts.ChangePawnBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Levon on 1/11/2016.
 */
public abstract class Move implements Colors{
    protected String string;
    protected String from;
    protected String to;
    
    
    public abstract boolean move(ChessBoard chessBoard, WhitePlayer whitePlayer, BlackPlayer blackPlayer)
            throws PlayerSameChessItem, EmptySourceCell, InvalidSource, OutOfTable, NoCell, InvalidMove, NoAvailableCells, IOException, CastlingDone, ChangePawn;

    public static boolean isInAllItemsOfAvailableCellListWhite(Cell kingCell, Map<String, ChessItem> playerItems, ChessBoard chessBoard)
    {
        //Get available cells of source <--Begin-->
        ArrayList<Cell> allAvailableCells=new ArrayList<>();

        for(Map.Entry<String, ChessItem> pair:playerItems.entrySet())
        {
       
            //Conditions
            try {
                if(pair.getValue() instanceof WhiteBishop){
                    allAvailableCells.addAll(new WhiteBishopMoves(chessBoard.getCellByString(pair.getKey()), chessBoard).getMoves());
                }
            } catch (NoAvailableCells noAvailableCells) {
                
            }
            if (pair.getValue() instanceof WhiteKing){
                try {
                    allAvailableCells.addAll(new WhiteKingMoves(chessBoard.getCellByString(pair.getKey()), chessBoard).getMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof WhiteKnight){
                try {
                    allAvailableCells.addAll(new WhiteKnightMoves(chessBoard.getCellByString(pair.getKey()), chessBoard).getMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof WhitePawn){
                try {
                    allAvailableCells.addAll(new WhitePawnMoves(chessBoard.getCellByString(pair.getKey()), chessBoard).getMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof WhiteQueen){
                try {
                    allAvailableCells.addAll(new WhiteQueenMoves(chessBoard.getCellByString(pair.getKey()), chessBoard).getMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof WhiteRook){
                try {
                    allAvailableCells.addAll(new WhiteRookMoves(chessBoard.getCellByString(pair.getKey()), chessBoard).getMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
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
    public static boolean isInAllItemsOfAvailableCellListBlack(Cell kingCell, Map<String, ChessItem> playerItems, ChessBoard chessBoard)
    {
        //Get available cells of source <--Begin-->
        ArrayList<Cell> allAvailableCells=new ArrayList<>();

        for(Map.Entry<String, ChessItem> pair:playerItems.entrySet())
        {
       
            //Conditions
            try {
                if(pair.getValue() instanceof BlackBishop){
                    allAvailableCells.addAll(new BlackBishopMoves(chessBoard.getCellByString(pair.getKey()), chessBoard).getMoves());
                }
            } catch (NoAvailableCells noAvailableCells) {
                
            }
            if (pair.getValue() instanceof BlackKing){
                try {
                    allAvailableCells.addAll(new BlackKingMoves(chessBoard.getCellByString(pair.getKey()), chessBoard).getMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof BlackKnight){
                try {
                    allAvailableCells.addAll(new BlackKnightMoves(chessBoard.getCellByString(pair.getKey()), chessBoard).getMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof BlackPawn){
                try {
                    allAvailableCells.addAll(new BlackPawnMoves(chessBoard.getCellByString(pair.getKey()), chessBoard).getMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof BlackQueen){
                try {
                    allAvailableCells.addAll(new BlackQueenMoves(chessBoard.getCellByString(pair.getKey()), chessBoard).getMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
                }

            }
            if (pair.getValue() instanceof BlackRook){
                try {
                    allAvailableCells.addAll(new BlackRookMoves(chessBoard.getCellByString(pair.getKey()), chessBoard).getMoves());
                } catch (NoAvailableCells noAvailableCells) {
                    
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
    protected boolean pawnChangeWhite(ChessItem pawn,ChessBoard ChessBoard)
    {
        if(pawn instanceof WhitePawn)
        {
            for(Cell cell : ChessBoard.getRows().get(7))
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
    protected boolean pawnChangeBlack(ChessItem pawn,ChessBoard ChessBoard)
    {
        if(pawn instanceof BlackPawn)
        {
            for(Cell cell : ChessBoard.getRows().get(0))
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
    protected void doPawnChangeWhite(Map<String, ChessItem> whitePlayerItems,Cell cell, ChessBoard ChessBoard) throws IOException, ChangePawn {
        if(pawnChangeWhite(cell.getChessItem(), ChessBoard)) {

            boolean isDone = false;
            String string = null;

            while (!isDone) {
                System.out.println("Choose one of following white items:");
                System.out.println("queen");
                System.out.println("rook");
                System.out.println("bishop");
                System.out.println("knight");
                System.out.print("Your decision is: ");
                string = ChangePawnBox.display(WHITE);
                System.out.println(string);

                try {
                    WhiteItem newPawn = whitePawnChangeTo(string);
                    whitePlayerItems.put(cell.toString(), newPawn);
                    cell.setChessItem(newPawn);
                    isDone = true;
                    throw new ChangePawn(WHITE,string);
                } catch (InvalidChangeItem invalidChangeItem) {
                    System.out.print("Wrong White Item. Try again: ");
                }
            }
        }
    }

    //Change Black Pawn
    protected void doPawnChangeBlack(Map<String, ChessItem> blackPlayerItems,Cell cell,ChessBoard ChessBoard) throws IOException, ChangePawn {
        if(pawnChangeBlack(cell.getChessItem(), ChessBoard)) {

            boolean isDone = false;
            String string;

            while (!isDone) {
                System.out.println("Choose one of following black items:");
                System.out.println("queen");
                System.out.println("rook");
                System.out.println("bishop");
                System.out.println("knight");
                System.out.print("Your decision is: ");
                string = ChangePawnBox.display(BLACK);
                System.out.println(string);

                try {
                    BlackItem newPawn = blackPawnChangeTo(string);
                    blackPlayerItems.put(cell.toString(), newPawn);
                    cell.setChessItem(newPawn);
                    isDone = true;
                    throw new ChangePawn(BLACK,string);
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

    public static ArrayList<Cell> moveUpUntilNotEmpty(Cell cell,ChessBoard ChessBoard) throws OutOfTable, NoCell, NotEmptyCell {

        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (ChessBoard.upCell(cell).getChessItem() instanceof Empty)
                {
                    
                    cell= ChessBoard.upCell(cell);
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

    public static  ArrayList<Cell>  moveDownUntilNotEmpty(Cell cell,ChessBoard ChessBoard) throws OutOfTable, NoCell, NotEmptyCell {
        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (ChessBoard.downCell(cell).getChessItem() instanceof Empty)
                {
                    cell= ChessBoard.downCell(cell);
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

    public static  ArrayList<Cell>  moveLeftUntilNotEmpty(Cell cell,ChessBoard ChessBoard) throws OutOfTable, NoCell, NotEmptyCell {
        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (ChessBoard.leftCell(cell).getChessItem() instanceof Empty)
                {
                    cell= ChessBoard.leftCell(cell);
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

    public static  ArrayList<Cell>  moveRightUntilNotEmpty(Cell cell,ChessBoard ChessBoard) throws OutOfTable, NoCell, NotEmptyCell {
        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (ChessBoard.rightCell(cell).getChessItem() instanceof Empty)
                {
                    cell= ChessBoard.rightCell(cell);
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

    public static   ArrayList<Cell>  moveDiagLeftUpUntilNotEmpty(Cell cell,ChessBoard ChessBoard) throws OutOfTable, NoCell, NotEmptyCell {
        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (ChessBoard.diagonalLeftUpCell(cell).getChessItem() instanceof Empty)
                {
                    cell= ChessBoard.diagonalLeftUpCell(cell);
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

    public static   ArrayList<Cell>  moveDiagLeftDownUntilNotEmpty(Cell cell,ChessBoard ChessBoard) throws OutOfTable, NoCell, NotEmptyCell {
        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (ChessBoard.diagonalLeftDownCell(cell).getChessItem() instanceof Empty)
                {
                    cell= ChessBoard.diagonalLeftDownCell(cell);
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

    public static   ArrayList<Cell>  moveDiagRightUpUntilNotEmpty(Cell cell,ChessBoard ChessBoard) throws OutOfTable, NoCell, NotEmptyCell {
        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (ChessBoard.diagonalRightUpCell(cell).getChessItem() instanceof Empty)
                {
                    cell= ChessBoard.diagonalRightUpCell(cell);
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

    public static   ArrayList<Cell>  moveDiagRightDownUntilNotEmpty(Cell cell,ChessBoard ChessBoard) throws OutOfTable, NoCell, NotEmptyCell {
        ArrayList<Cell> list=new ArrayList<>();

        if (!(cell.getChessItem() instanceof Empty))
        {
            try {
                while (ChessBoard.diagonalRightDownCell(cell).getChessItem() instanceof Empty)
                {
                    cell= ChessBoard.diagonalRightDownCell(cell);
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
