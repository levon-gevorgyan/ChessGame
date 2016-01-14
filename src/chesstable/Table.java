package chesstable;

import chessitems.empty.Empty;

import chesstable.cells.*;
import exceptions.cell.NoCell;
import exceptions.table.OutOfTable;


import java.util.*;

/**
 * Created by Levon on 1/9/2016.
 */
public class Table  implements Letters,Numbers{

    private SortedMap<String,Cell> cells=new TreeMap<String,Cell>();

    public static ArrayList<ArrayList<Cell>> rows=new ArrayList<>();
    public static ArrayList<ArrayList<Cell>> columns=new ArrayList<>();

    private   Map<Cell,ArrayList<Cell>> relativeCellsStraight;
    private   Map<Cell,ArrayList<Cell>> relativeCellsKnight;

    public Table()
    {
        makeTable();
        setRows();
        setColumns();
    }



    public static ArrayList<Cell> nextRow(Cell cell) throws OutOfTable {


        for (int j=0;j<8;j++)
        {

            try {
                for (int i=0;i<8;i++)
                {

                    if(rows.get(j).get(i).equals(cell))

                    {
                        ArrayList<Cell> k=rows.get(j+1);
                        return k;

                    }


                }
            }
            catch (IndexOutOfBoundsException e)
            {
                //System.out.println(OutOfTable.invalidNextRow());
                throw new OutOfTable();


            }
        }
        return null;
    }

    public static ArrayList<Cell> previousRow(Cell cell) throws OutOfTable {


        for (int j=0;j<8;j++)
        {

            try {
                for (int i=0;i<8;i++)
                {

                    if(rows.get(j).get(i).equals(cell))

                    {
                        ArrayList<Cell> k=rows.get(j-1);
                        return k;

                    }


                }
            }
            catch (IndexOutOfBoundsException e)
            {
                //System.out.println(OutOfTable.invalidPreviousRow());
                throw new OutOfTable();
            }
        }
        return null;
    }

public static ArrayList<Cell> nextColumn(Cell cell) throws OutOfTable {


        for (int j=0;j<8;j++)
        {

            try {
                for (int i=0;i<8;i++)
                {

                    if(columns.get(j).get(i).equals(cell))

                    {
                        ArrayList<Cell> k=columns.get(j+1);
                        return k;

                    }


                }
            }
            catch (IndexOutOfBoundsException e)
            {
                //System.out.println(OutOfTable.invalidNextColumn());
                throw new OutOfTable();
            }
        }
        return null;
    }

    public static ArrayList<Cell> previousColumn(Cell cell) throws OutOfTable {


        for (int j=0;j<8;j++)
        {

            try {
                for (int i=0;i<8;i++)
                {

                    if(columns.get(j).get(i).equals(cell))

                    {
                        ArrayList<Cell> k=columns.get(j-1);
                        return k;

                    }


                }
            }
            catch (IndexOutOfBoundsException e)
            {
                //System.out.println(OutOfTable.invalidPreviousColumn());
                throw new OutOfTable();
            }
        }
        return null;
    }

    public static Cell leftCell(Cell cell) throws OutOfTable, NoCell {
        try {
            ArrayList<Cell> leftColumn=previousColumn(cell);
            ArrayList<Cell> sameRow=getCellRow(cell);
            return getCrossedCell(sameRow,leftColumn);
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }
    public static Cell rightCell(Cell cell) throws OutOfTable, NoCell {
        try {
            ArrayList<Cell> rightColumn=nextColumn(cell);
            ArrayList<Cell> sameRow=getCellRow(cell);
            return getCrossedCell(sameRow,rightColumn);
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }
    public static Cell downCell(Cell cell) throws OutOfTable, NoCell {
        try {
            ArrayList<Cell> downRow=previousRow(cell);
            ArrayList<Cell> sameColumn=getCellColumn(cell);
            return getCrossedCell(downRow,sameColumn);
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public static Cell upCell(Cell cell) throws OutOfTable, NoCell {
        try {
            ArrayList<Cell> upRow=nextRow(cell);
            ArrayList<Cell> sameColumn=getCellColumn(cell);
            return getCrossedCell(upRow,sameColumn);
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public static Cell diagonalLeftUpCell(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell left=leftCell(cell);
            return upCell(left);
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public static Cell diagonalLeftDownCell(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell left=leftCell(cell);
            return downCell(left);
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public static Cell diagonalRightUpCell(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell right=rightCell(cell);
            return upCell(right);
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public static Cell diagonalRightDownCell(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell right=rightCell(cell);
            return downCell(right);
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public static Cell getCrossedCell(ArrayList<Cell> row,ArrayList<Cell> column)
    {
        for (int i=0;i<8;i++)
        {
            for (int j=0;j<8;j++)
            {
                if(row.get(i).equals(column.get(j)))
                    return row.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Cell> getCellRow(Cell cell)
    {

        char x=cell.getX();
        int y=cell.getY();
        for (ArrayList<Cell> item: rows)
        {
            for(int i=0;i<8;i++)
            {
                if(item.get(i).getX()==x && item.get(i).getY()==y)
                {
                    return item;
                }
            }
        }
        return null;
    }
    public static ArrayList<Cell> getCellColumn(Cell cell)
    {

        char x=cell.getX();
        int y=cell.getY();
        for (ArrayList<Cell> item: columns)
        {
            for(int i=0;i<8;i++)
            {
                if(item.get(i).getX()==x && item.get(i).getY()==y)
                {
                    return item;
                }
            }
        }
        return null;
    }

    private void setRows(){
        ArrayList<ArrayList<Cell>> rows=new ArrayList<>();

        for(int i=1;i<=8;i++)
        {
            ArrayList<Cell> arrayList=new ArrayList<>();

            for(int j=1;j<=8;j++)
            {
                arrayList.add(getCell(LetterList[j],Character.getNumericValue(NumberList[i])));

            }
            rows.add(arrayList);
        }

        this.rows=rows;
    }
    private void setColumns(){
        ArrayList<ArrayList<Cell>> columns=new ArrayList<>();

        for(int i=1;i<=8;i++)
        {
            ArrayList<Cell> arrayList=new ArrayList<>();

            for(int j=1;j<=8;j++)
            {
                arrayList.add(getCell(LetterList[i],Character.getNumericValue(NumberList[j])));

            }
            columns.add(arrayList);
        }

        this.columns=columns;

    }









    public Cell getCell(Character x,int y)
    {
        String id=String.valueOf(x)+y;
        return cells.get(id);
    }
    public ArrayList<Cell> getRelativeCellsStraightByCell(Cell cell)
    {
        Map<Cell,ArrayList<Cell>> relativeCellsMap=this.relativeCellsStraight;
        return relativeCellsMap.get(cell);
    }
    public ArrayList<Cell> getRelativeCellsKnightByCell(Cell cell)
    {
        Map<Cell,ArrayList<Cell>> relativeCellsMap2=this.relativeCellsKnight;
        return relativeCellsMap2.get(cell);
    }
    public Map<Cell,ArrayList<Cell>> getRelativeCellsStraight()
    {
        return this.relativeCellsStraight;
    }
    public Map<Cell,ArrayList<Cell>> getRelativeCellsKnight()
    {
        return this.relativeCellsKnight;
    }

    public SortedMap<String,Cell> getAllCells()
    {
        return this.cells;
    }

    public Cell getCell(char x,int y)
    {
        return this.cells.get(Character.toString(x) + y);
    }
    public String toString()
    {
        System.out.println("  A  B  C  D  E  F  G  H");
        System.out.println("  __ __ __ __ __ __ __ __");
        for (int i=8;i>=1;i--)
        {
            System.out.print(i + "|");
            for(int j=1;j<=8;j++)
            {
                System.out.print(cells.get(Character.toString(LetterList[j]) + i).line1());
            }
            System.out.print(i+"\n |");
            for(int j=1;j<=8;j++)
            {
                System.out.print(cells.get(Character.toString(LetterList[j]) + i).line2()+ "|");
            }
            System.out.print("\n");
        }
        System.out.println("  A  B  C  D  E  F  G  H");

        return null;
    }
    private void makeTable() {
        for (int i=1;i<=8;i+=2)
        {
            for(int j=1;j<=8;j+=2)
            {
                this.cells.put(Character.toString(LetterList[i]) + j, new BlackCell(LetterList[i], j, new Empty()));
            }
        }
        for (int i=2;i<=8;i+=2)
        {
            for(int j=2;j<=8;j+=2)
            {
                this.cells.put(Character.toString(LetterList[i]) + j, new BlackCell(LetterList[i], j, new Empty()));
            }
        }
        for (int i=1;i<=8;i+=2)
        {
            for(int j=2;j<=8;j+=2)
            {
                this.cells.put(Character.toString(LetterList[i]) + j, new WhiteCell(LetterList[i], j, new Empty()));
            }
        }
        for (int i=2;i<=8;i+=2)
        {
            for(int j=1;j<=8;j+=2)
            {
                this.cells.put(Character.toString(LetterList[i]) + j, new WhiteCell(LetterList[i], j, new Empty()));
            }
        }
        for (SortedMap.Entry<String, Cell> cell : cells.entrySet()) {
            for (int i=1;i<=8;i++)
            {
                for(int j=3;j<=6;j++)
                {
                    if (cell.getKey().equals(Character.toString(LetterList[i]) + j)) {
                        cell.getValue().setChessItem(new Empty());
                    }

                }
            }
        }
    }


}
