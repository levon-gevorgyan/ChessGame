package chesstable;

import chessitems.ChessItem;
import chessitems.black.BlackKing;
import chessitems.empty.Empty;

import chessitems.white.WhiteKing;
import chesstable.cells.*;
import colors.Colors;
import exceptions.cell.NoCell;
import exceptions.table.OutOfTable;


import java.util.*;

/**
 * Created by Levon on 1/9/2016.
 */
public class Table  implements Letters,Numbers, Colors{

    private SortedMap<String,Cell> cells=new TreeMap<String,Cell>(); //All Cells of the Table

    public ArrayList<ArrayList<Cell>> getRows() {
        return rows;
    }

    public ArrayList<ArrayList<Cell>> getColumns() {
        return columns;
    }

    private ArrayList<ArrayList<Cell>> rows=new ArrayList<>(); //All Rows of the Table
    private ArrayList<ArrayList<Cell>> columns=new ArrayList<>(); //All Columns of the Table

    //Create Table
    public Table()
    {
        makeTable();
        setRows();
        setColumns();

    }

    public void setAllItems(Map<String, ChessItem> whitePlayerItems,Map<String, ChessItem> blackPlayerItems){

        for (SortedMap.Entry<String, Cell> cell : getAllCells().entrySet()) {
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
    }

    public Cell getCellByString(String string)
    {
        char[] s=string.toCharArray();
        return getCell(s[0], Character.getNumericValue(s[1]));
    }

    //Next Row
    public ArrayList<Cell> nextRow(Cell cell) throws OutOfTable {


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

    //Previous Row
    public ArrayList<Cell> previousRow(Cell cell) throws OutOfTable {


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

    //Next Column
    public ArrayList<Cell> nextColumn(Cell cell) throws OutOfTable {


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

    //Previous Column
    public ArrayList<Cell> previousColumn(Cell cell) throws OutOfTable {


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

    //To Left, Right, UP, Down cells
    //<--BEGIN-->
    
    public Cell leftCell(Cell cell) throws OutOfTable, NoCell {
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
    public Cell rightCell(Cell cell) throws OutOfTable, NoCell {
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
    public Cell downCell(Cell cell) throws OutOfTable, NoCell {
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

    public Cell upCell(Cell cell) throws OutOfTable, NoCell {
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

    //To Left, Right, Up, Down cells
    //<--END-->


    //To Left Up, Left Down, Right pP, Right Down cells
    //<--BEGIN-->
    
    public Cell diagonalLeftUpCell(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell left=leftCell(cell);
            return upCell(left);
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public Cell diagonalLeftDownCell(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell left=leftCell(cell);
            return downCell(left);
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public Cell diagonalRightUpCell(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell right=rightCell(cell);
            return upCell(right);
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public Cell diagonalRightDownCell(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell right=rightCell(cell);
            return downCell(right);
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    //To Left Up, Left Down, Right pP, Right Down cells
    //<--End-->


    //To Up Up Left, Up Up Right, Down Down Left, Down Down Right cells
    //<--BEGIN-->
    
    public Cell upUpLeft(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell upUpLeft;
            cell=upCell(cell);
            upUpLeft=diagonalLeftUpCell(cell);
            return upUpLeft;
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public Cell upUpRight(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell upUpRight;
            cell=upCell(cell);
            upUpRight=diagonalRightUpCell(cell);
            return upUpRight;
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public Cell downDownLeft(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell downDownLeft;
            cell=downCell(cell);
            downDownLeft=diagonalLeftDownCell(cell);
            return downDownLeft;
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public Cell downDownRight(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell downDownRight;
            cell=downCell(cell);
            downDownRight=diagonalRightDownCell(cell);
            return downDownRight;
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    //To Up Up Left, Up Up Right, Down Down Left, Down Down Right cells
    //<--END-->

    
    
    //To Left Left Up, Left Left Down, Right Right Up, Right Right Down cells
    //<--BEGIN-->

    public Cell leftLeftUp(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell leftLeftUp;
            cell=leftCell(cell);
            leftLeftUp=diagonalLeftUpCell(cell);
            return leftLeftUp;
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public Cell leftLeftDown(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell leftLeftDown;
            cell=leftCell(cell);
            leftLeftDown=diagonalLeftDownCell(cell);
            return leftLeftDown;
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public Cell rightRightUp(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell rightRightUp;
            cell=rightCell(cell);
            rightRightUp=diagonalRightUpCell(cell);
            return rightRightUp;
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    public Cell rightRightDown(Cell cell) throws OutOfTable, NoCell {
        try {
            Cell rightRightDown;
            cell=rightCell(cell);
            rightRightDown=diagonalRightDownCell(cell);
            return rightRightDown;
        }
        catch (OutOfTable outOfTable)
        {
            throw new NoCell();
        }
    }

    //To Left Left Up, Left Left Down, Right Right Up, Right Right Down cells
    //<--END-->


    //Find the Crossed Cell
    public Cell getCrossedCell(ArrayList<Cell> row,ArrayList<Cell> column)
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

    //Find Cell's Row
    public ArrayList<Cell> getCellRow(Cell cell)
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

    //Find Cell's Column
    public ArrayList<Cell> getCellColumn(Cell cell)
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

    //Set Up the Rows
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

    //Set Up the Columns
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


    //Get Cell by its Coordinates
    public Cell getCell(Character x,int y)
    {
        String id=String.valueOf(x)+y;
        return cells.get(id);
    }

    //Receive All Cells of the Table
    public SortedMap<String,Cell> getAllCells()
    {
        return this.cells;
    }

    public Cell getCell(char x,int y)
    {
        return this.cells.get(Character.toString(x) + y);
    }

    //Get Table on Screen
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

    //Make Table
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

    //get Opponent's King's location
    public Cell getOpponentKingCell(String playerColor, Map<String, ChessItem> whitePlayer, Map<String, ChessItem> blackPlayer,Table table)
    {
        if(playerColor.equals(BLACK))
        {
            for(Map.Entry<String,ChessItem> pair:blackPlayer.entrySet())
            {
                if(pair.getValue() instanceof BlackKing)
                    return table.getCellByString(pair.getKey());
            }
        }
        if(playerColor.equals(WHITE))
        {
            for(Map.Entry<String,ChessItem> pair:whitePlayer.entrySet())
            {
                if(pair.getValue() instanceof WhiteKing)
                    return table.getCellByString(pair.getKey());
            }
        }
        return null;
    }
}
