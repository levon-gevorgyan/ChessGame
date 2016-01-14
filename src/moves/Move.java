package moves;

import chessitems.ChessItem;
import chessitems.empty.Empty;
import chesstable.Table;
import chesstable.cells.Cell;
import exceptions.cell.EmptySourceCell;
import exceptions.cell.InvalidSource;
import exceptions.cell.NoCell;
import exceptions.cell.NotEmptyCell;
import exceptions.chessitem.SameChessItem;
import exceptions.moves.InvalidMoveString;
import exceptions.moves.WrongLetter;
import exceptions.moves.WrongNumber;
import exceptions.table.OutOfTable;
import letsnums.LetsNums;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Levon on 1/11/2016.
 */
public abstract class Move {
    protected String string;
    protected String from;
    protected String to;
    
    
    public abstract void move(Table table,Map<String, ChessItem> whitePlayerItems,Map<String, ChessItem> blackPlayerItems)
            throws SameChessItem, EmptySourceCell, InvalidSource, OutOfTable, NoCell;

    public static ArrayList<Cell> moveUpUntilNotEmpty(Cell cell) throws OutOfTable, NoCell, NotEmptyCell {
        
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

    public static ArrayList<Cell>  moveDownUntilNotEmpty(Cell cell) throws OutOfTable, NoCell, NotEmptyCell {
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

    public static ArrayList<Cell>  moveLeftUntilNotEmpty(Cell cell) throws OutOfTable, NoCell, NotEmptyCell {
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

    public static ArrayList<Cell>  moveRightUntilNotEmpty(Cell cell) throws OutOfTable, NoCell, NotEmptyCell {
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

    public static ArrayList<Cell>  moveDiagLeftUpUntilNotEmpty(Cell cell) throws OutOfTable, NoCell, NotEmptyCell {
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

    public static ArrayList<Cell>  moveDiagLeftDownUntilNotEmpty(Cell cell) throws OutOfTable, NoCell, NotEmptyCell {
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

    public static ArrayList<Cell>  moveDiagRightUpUntilNotEmpty(Cell cell) throws OutOfTable, NoCell, NotEmptyCell {
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

    public static ArrayList<Cell>  moveDiagRightDownUntilNotEmpty(Cell cell) throws OutOfTable, NoCell, NotEmptyCell {
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
                                            System.out.println("Wrong Number: 2");
                                        }

                                    }
                                } catch (WrongLetter wrongLetter) {
                                    System.out.println("Wrong Letter: 2");
                                }

                            }
                        } catch (WrongNumber wrongNumber) {
                            System.out.println("Wrong Number: 1");
                        }
                    }
                } catch (WrongLetter wrongLetter) {
                    System.out.println("Wrong symbol is: Letter: 1");
                }
            }
            else {
                throw new InvalidMoveString();
            }

            /*if(stringToChar.length==2)
            {
                try {
                    if (LetsNums.isLetter(stringToChar[0]))
                    {
                        try {
                            if (LetsNums.isNumber(stringToChar[1]))
                            {
                                isValidString=true;
                            }
                        } catch (WrongNumber wrongNumber) {
                            wrongNumber.printStackTrace();
                        }
                    }
                } catch (WrongLetter wrongLetter) {
                    wrongLetter.printStackTrace();
                }
            }
            else
                throw new InvalidMoveString();*/



        if (isValidString){

            return true;
        }
        else
            throw new InvalidMoveString();


    }
}
