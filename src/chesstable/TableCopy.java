/*
package chesstable;

import chessitems.empty.Empty;

import chesstable.cells.*;
import chesstable.cells.relative.RelativeCellStraight;
import chesstable.cells.relative.RelativeCellsKnight;


import java.util.*;

*/
/**
 * Created by Levon on 1/9/2016.
 *//*

public class Table  implements Letters,Numbers{
    private SortedMap<String,Cell> cells=new TreeMap<String,Cell>();
    private ArrayList<ArrayList<Cell>> rows=new ArrayList<>();
    private ArrayList<ArrayList<Cell>> columns=new ArrayList<>();
    private SortedMap<Cell,SortedMap<ArrayList<Cell>,ArrayList<Cell>>> cellRowColumn;


    private   Map<Cell,ArrayList<Cell>> relativeCellsStraight;
    private   Map<Cell,ArrayList<Cell>> relativeCellsKnight;

    public Table()
    {
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
*/
/*

        //Setting Relative Cells Straight
        Map<Cell,ArrayList<Cell>> relativeCellsStraight =new HashMap<Cell,ArrayList<Cell>>();
        //A column
        relativeCellsStraight.put(getCell('a',1),new RelativeCellStraight(
                getCell('a',2),getCell('b',1)).getRelativeCells());

        relativeCellsStraight.put(getCell('a',2),new RelativeCellStraight(
                getCell('a',1),getCell('b',2),getCell('a',3)).getRelativeCells());

        relativeCellsStraight.put(getCell('a',3),new RelativeCellStraight(
                getCell('a',2),getCell('b',3),getCell('a',4)).getRelativeCells());

        relativeCellsStraight.put(getCell('a',4),new RelativeCellStraight(
                getCell('a',3),getCell('b',4),getCell('a',5)).getRelativeCells());

        relativeCellsStraight.put(getCell('a',5),new RelativeCellStraight(
                getCell('a',4),getCell('b',5),getCell('a',6)).getRelativeCells());

        relativeCellsStraight.put(getCell('a',6),new RelativeCellStraight(
                getCell('a',5),getCell('b',6),getCell('a',7)).getRelativeCells());

        relativeCellsStraight.put(getCell('a',7),new RelativeCellStraight(
                getCell('a',6),getCell('b',7),getCell('a',8)).getRelativeCells());

        relativeCellsStraight.put(getCell('a',8),new RelativeCellStraight(
                getCell('a',7),getCell('b',8)).getRelativeCells());




        //B Column
        relativeCellsStraight.put(getCell('b',1),new RelativeCellStraight(
                getCell('a',1),getCell('c',1),getCell('c',2),getCell('a',2),getCell('b',2)).getRelativeCells());

        //C Column
        relativeCellsStraight.put(getCell('c',1),new RelativeCellStraight(
                getCell('b',1),getCell('d',1),getCell('d',2),getCell('b',2),getCell('c',2)).getRelativeCells());
        relativeCellsStraight.put(getCell('c',2),new RelativeCellStraight(
                getCell('b',1),getCell('b',2),getCell('b',3),getCell('d',1),getCell('d',2),getCell('d',3),getCell('c',1),getCell('c',3))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('c',3),new RelativeCellStraight(
                getCell('b',4),getCell('b',2),getCell('b',3),getCell('d',4),getCell('d',2),getCell('d',3),getCell('c',2),getCell('c',4))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('c',4),new RelativeCellStraight(
                getCell('b',4),getCell('b',5),getCell('b',3),getCell('d',4),getCell('d',5),getCell('d',3),getCell('c',3),getCell('c',5))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('c',5),new RelativeCellStraight(
                getCell('b',4),getCell('b',5),getCell('b',6),getCell('d',4),getCell('d',5),getCell('d',6),getCell('c',4),getCell('c',6))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('c',6),new RelativeCellStraight(
                getCell('b',7),getCell('b',5),getCell('b',6),getCell('d',7),getCell('d',5),getCell('d',6),getCell('c',5),getCell('c',7))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('c',7),new RelativeCellStraight(
                getCell('b',7),getCell('b',8),getCell('b',6),getCell('d',7),getCell('d',8),getCell('d',6),getCell('c',6),getCell('c',8))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('c',8),new RelativeCellStraight(
                getCell('b',7),getCell('b',8),getCell('d',7),getCell('d',8),getCell('c',7))
                .getRelativeCells());
        //D Column
        relativeCellsStraight.put(getCell('d',1),new RelativeCellStraight(
                getCell('c',1),getCell('e',1),getCell('e',2),getCell('c',2),getCell('d',2)).getRelativeCells());
        relativeCellsStraight.put(getCell('d',2),new RelativeCellStraight(
                getCell('c',1),getCell('c',2),getCell('c',3),getCell('e',1),getCell('e',2),getCell('e',3),getCell('d',1),getCell('d',3))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('d',3),new RelativeCellStraight(
                getCell('c',4),getCell('c',2),getCell('c',3),getCell('e',4),getCell('e',2),getCell('e',3),getCell('d',2),getCell('d',4))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('d',4),new RelativeCellStraight(
                getCell('c',4),getCell('c',5),getCell('c',3),getCell('e',4),getCell('e',5),getCell('e',3),getCell('d',3),getCell('d',5))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('d',5),new RelativeCellStraight(
                getCell('c',4),getCell('c',5),getCell('c',6),getCell('e',4),getCell('e',5),getCell('e',6),getCell('d',4),getCell('d',6))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('d',6),new RelativeCellStraight(
                getCell('c',7),getCell('c',5),getCell('c',6),getCell('e',7),getCell('e',5),getCell('e',6),getCell('d',5),getCell('d',7))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('d',7),new RelativeCellStraight(
                getCell('c',7),getCell('c',8),getCell('c',6),getCell('e',7),getCell('e',8),getCell('e',6),getCell('d',6),getCell('d',8))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('d',8),new RelativeCellStraight(
                getCell('c',7),getCell('c',8),getCell('e',7),getCell('e',8),getCell('d',7))
                .getRelativeCells());
        //E Column
        relativeCellsStraight.put(getCell('e',1),new RelativeCellStraight(
                getCell('d',1),getCell('f',1),getCell('f',2),getCell('d',2),getCell('e',2)).getRelativeCells());
        relativeCellsStraight.put(getCell('e',2),new RelativeCellStraight(
                getCell('d',1),getCell('d',2),getCell('d',3),getCell('f',1),getCell('f',2),getCell('f',3),getCell('e',1),getCell('e',3))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('e',3),new RelativeCellStraight(
                getCell('d',4),getCell('d',2),getCell('d',3),getCell('f',4),getCell('f',2),getCell('f',3),getCell('e',2),getCell('e',4))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('e',4),new RelativeCellStraight(
                getCell('d',4),getCell('d',5),getCell('d',3),getCell('f',4),getCell('f',5),getCell('f',3),getCell('e',3),getCell('e',5))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('e',5),new RelativeCellStraight(
                getCell('d',4),getCell('d',5),getCell('d',6),getCell('f',4),getCell('f',5),getCell('f',6),getCell('e',4),getCell('e',6))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('e',6),new RelativeCellStraight(
                getCell('d',7),getCell('d',5),getCell('d',6),getCell('f',7),getCell('f',5),getCell('f',6),getCell('e',5),getCell('e',7))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('e',7),new RelativeCellStraight(
                getCell('d',7),getCell('d',8),getCell('d',6),getCell('f',7),getCell('f',8),getCell('f',6),getCell('e',6),getCell('e',8))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('e',8),new RelativeCellStraight(
                getCell('d',7),getCell('d',8),getCell('f',7),getCell('f',8),getCell('e',7))
                .getRelativeCells());
        //F Column
        relativeCellsStraight.put(getCell('f',1),new RelativeCellStraight(
                getCell('e',1),getCell('g',1),getCell('g',2),getCell('e',2),getCell('f',2)).getRelativeCells());
        relativeCellsStraight.put(getCell('f',2),new RelativeCellStraight(
                getCell('e',1),getCell('e',2),getCell('e',3),getCell('g',1),getCell('g',2),getCell('g',3),getCell('f',1),getCell('f',3))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('f',3),new RelativeCellStraight(
                getCell('e',4),getCell('e',2),getCell('e',3),getCell('g',4),getCell('g',2),getCell('g',3),getCell('f',2),getCell('f',4))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('f',4),new RelativeCellStraight(
                getCell('e',4),getCell('e',5),getCell('e',3),getCell('g',4),getCell('g',5),getCell('g',3),getCell('f',3),getCell('f',5))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('f',5),new RelativeCellStraight(
                getCell('e',4),getCell('e',5),getCell('e',6),getCell('g',4),getCell('g',5),getCell('g',6),getCell('f',4),getCell('f',6))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('f',6),new RelativeCellStraight(
                getCell('e',7),getCell('e',5),getCell('e',6),getCell('g',7),getCell('g',5),getCell('g',6),getCell('f',5),getCell('f',7))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('f',7),new RelativeCellStraight(
                getCell('e',7),getCell('e',8),getCell('e',6),getCell('g',7),getCell('g',8),getCell('g',6),getCell('f',6),getCell('f',8))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('f',8),new RelativeCellStraight(
                getCell('e',7),getCell('e',8),getCell('g',7),getCell('g',8),getCell('f',7))
                .getRelativeCells());
        //G Column
        relativeCellsStraight.put(getCell('g',1),new RelativeCellStraight(
                getCell('f',1),getCell('h',1),getCell('h',2),getCell('f',2),getCell('g',2)).getRelativeCells());
        relativeCellsStraight.put(getCell('g',2),new RelativeCellStraight(
                getCell('f',1),getCell('f',2),getCell('f',3),getCell('h',1),getCell('h',2),getCell('h',3),getCell('g',1),getCell('g',3))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('g',3),new RelativeCellStraight(
                getCell('f',4),getCell('f',2),getCell('f',3),getCell('h',4),getCell('h',2),getCell('h',3),getCell('g',2),getCell('g',4))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('g',4),new RelativeCellStraight(
                getCell('f',4),getCell('f',5),getCell('f',3),getCell('h',4),getCell('h',5),getCell('h',3),getCell('g',3),getCell('g',5))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('g',5),new RelativeCellStraight(
                getCell('f',4),getCell('f',5),getCell('f',6),getCell('h',4),getCell('h',5),getCell('h',6),getCell('g',4),getCell('g',6))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('g',6),new RelativeCellStraight(
                getCell('f',7),getCell('f',5),getCell('f',6),getCell('h',7),getCell('h',5),getCell('h',6),getCell('g',5),getCell('g',7))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('g',7),new RelativeCellStraight(
                getCell('f',7),getCell('f',8),getCell('f',6),getCell('h',7),getCell('h',8),getCell('h',6),getCell('g',6),getCell('g',8))
                .getRelativeCells());
        relativeCellsStraight.put(getCell('g',8),new RelativeCellStraight(
                getCell('f',7),getCell('f',8),getCell('h',7),getCell('h',8),getCell('g',7))
                .getRelativeCells());
        //H Column
        relativeCellsStraight.put(getCell('h',1),new RelativeCellStraight(
                getCell('h',2),getCell('g',1)).getRelativeCells());

        relativeCellsStraight.put(getCell('h',2),new RelativeCellStraight(
                getCell('h',1),getCell('g',2),getCell('h',3)).getRelativeCells());

        relativeCellsStraight.put(getCell('h',3),new RelativeCellStraight(
                getCell('h',2),getCell('g',3),getCell('h',4)).getRelativeCells());

        relativeCellsStraight.put(getCell('h',4),new RelativeCellStraight(
                getCell('h',3),getCell('g',4),getCell('h',5)).getRelativeCells());

        relativeCellsStraight.put(getCell('h',5),new RelativeCellStraight(
                getCell('h',4),getCell('g',5),getCell('h',6)).getRelativeCells());

        relativeCellsStraight.put(getCell('h',6),new RelativeCellStraight(
                getCell('h',5),getCell('g',6),getCell('h',7)).getRelativeCells());

        relativeCellsStraight.put(getCell('h',7),new RelativeCellStraight(
                getCell('h',6),getCell('g',7),getCell('h',8)).getRelativeCells());

        relativeCellsStraight.put(getCell('h',8),new RelativeCellStraight(
                getCell('h',7),getCell('g',8)).getRelativeCells());

*//*



        //Setting Relative Cells KnightMoves
        Map<Cell,ArrayList<Cell>> relativeCellsMapKnight =new HashMap<Cell,ArrayList<Cell>>();
        //A column
        relativeCellsMapKnight.put(getCell('a',1),new RelativeCellsKnight(
                getCell('b',3),getCell('c',2)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('a',2),new RelativeCellsKnight(
                getCell('b',4),getCell('c',3),getCell('c',1)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('a',3),new RelativeCellsKnight(
                getCell('b',5),getCell('c',4),getCell('c',2),getCell('b',1)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('a',4),new RelativeCellsKnight(
                getCell('b',6),getCell('c',5),getCell('c',3),getCell('b',2)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('a',5),new RelativeCellsKnight(
                getCell('b',7),getCell('c',6),getCell('c',4),getCell('b',3)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('a',6),new RelativeCellsKnight(
                getCell('b',8),getCell('c',7),getCell('c',5),getCell('b',4)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('a',7),new RelativeCellsKnight(
                getCell('c',8),getCell('c',6),getCell('b',5)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('a',8),new RelativeCellsKnight(
                getCell('c',7),getCell('b',6)).getRelativeCells2());
        //B column
        relativeCellsMapKnight.put(getCell('b',1),new RelativeCellsKnight(
                getCell('a',3),getCell('c',3),getCell('d',2)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('b',2),new RelativeCellsKnight(
                getCell('d',1),getCell('d',3),getCell('c',4),getCell('a',4)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('b',3),new RelativeCellsKnight(
                getCell('d',2),getCell('d',4),getCell('c',5),getCell('a',5),getCell('c',1),getCell('a',1)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('b',4),new RelativeCellsKnight(
                getCell('d',3),getCell('d',5),getCell('c',6),getCell('a',6),getCell('c',2),getCell('a',2)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('b',5),new RelativeCellsKnight(
                getCell('d',4),getCell('d',6),getCell('c',7),getCell('a',7),getCell('c',3),getCell('a',3)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('b',6),new RelativeCellsKnight(
                getCell('d',5),getCell('d',7),getCell('c',8),getCell('a',8),getCell('c',4),getCell('a',4)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('b',7),new RelativeCellsKnight(
                getCell('d',6),getCell('d',8),getCell('c',5),getCell('a',5)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('b',8),new RelativeCellsKnight(
                getCell('d',7),getCell('c',6),getCell('a',6)).getRelativeCells2());
        //C column
        relativeCellsMapKnight.put(getCell('c',1),new RelativeCellsKnight(
                getCell('a',2),getCell('b',3),getCell('d',3),getCell('e',2)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('c',2),new RelativeCellsKnight(
                getCell('a',3),getCell('b',4),getCell('d',4),getCell('e',3),getCell('a',1),getCell('e',1)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('c',3),new RelativeCellsKnight(
                getCell('a',4),getCell('b',5),getCell('d',5),getCell('e',4),getCell('a',2),getCell('b',1),getCell('d',1),getCell('e',2))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('c',4),new RelativeCellsKnight(
                getCell('a',5),getCell('b',6),getCell('d',6),getCell('e',5),getCell('a',3),getCell('b',2),getCell('d',2),getCell('e',3))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('c',5),new RelativeCellsKnight(
                getCell('a',6),getCell('b',7),getCell('d',7),getCell('e',6),getCell('a',4),getCell('b',3),getCell('d',3),getCell('e',4))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('c',6),new RelativeCellsKnight(
                getCell('a',7),getCell('b',8),getCell('d',8),getCell('e',7),getCell('a',5),getCell('b',4),getCell('d',4),getCell('e',5))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('c',7),new RelativeCellsKnight(
                getCell('a',8),getCell('e',8),getCell('a',6),getCell('b',5),getCell('d',5),getCell('e',6)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('c',8),new RelativeCellsKnight(
                getCell('a',7),getCell('b',6),getCell('d',6),getCell('e',7)).getRelativeCells2());
        //D column
        relativeCellsMapKnight.put(getCell('d',1),new RelativeCellsKnight(
                getCell('b',2),getCell('c',3),getCell('e',3),getCell('f',2)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('d',2),new RelativeCellsKnight(
                getCell('b',3),getCell('c',4),getCell('e',4),getCell('f',3),getCell('b',1),getCell('f',1)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('d',3),new RelativeCellsKnight(
                getCell('b',4),getCell('c',5),getCell('e',5),getCell('f',4),getCell('b',2),getCell('c',1),getCell('e',1),getCell('f',2))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('d',4),new RelativeCellsKnight(
                getCell('b',5),getCell('c',6),getCell('e',6),getCell('f',5),getCell('b',3),getCell('c',2),getCell('e',2),getCell('f',3))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('d',5),new RelativeCellsKnight(
                getCell('b',6),getCell('c',7),getCell('e',7),getCell('f',6),getCell('b',4),getCell('c',3),getCell('e',3),getCell('f',4))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('d',6),new RelativeCellsKnight(
                getCell('b',7),getCell('c',8),getCell('e',8),getCell('f',7),getCell('b',5),getCell('c',4),getCell('e',4),getCell('f',5))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('d',7),new RelativeCellsKnight(
                getCell('b',8),getCell('f',8),getCell('b',6),getCell('c',5),getCell('e',5),getCell('f',6)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('d',8),new RelativeCellsKnight(
                getCell('b',7),getCell('c',6),getCell('e',6),getCell('f',7)).getRelativeCells2());
        //E column
        relativeCellsMapKnight.put(getCell('e',1),new RelativeCellsKnight(
                getCell('c',2),getCell('d',3),getCell('f',3),getCell('g',2)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('e',2),new RelativeCellsKnight(
                getCell('c',3),getCell('d',4),getCell('f',4),getCell('g',3),getCell('c',1),getCell('g',1)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('e',3),new RelativeCellsKnight(
                getCell('c',4),getCell('d',5),getCell('f',5),getCell('g',4),getCell('c',2),getCell('d',1),getCell('f',1),getCell('g',2))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('e',4),new RelativeCellsKnight(
                getCell('c',5),getCell('d',6),getCell('f',6),getCell('g',5),getCell('c',3),getCell('d',2),getCell('f',2),getCell('g',3))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('e',5),new RelativeCellsKnight(
                getCell('c',6),getCell('d',7),getCell('f',7),getCell('g',6),getCell('c',4),getCell('d',3),getCell('f',3),getCell('g',4))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('e',6),new RelativeCellsKnight(
                getCell('c',7),getCell('d',8),getCell('f',8),getCell('g',7),getCell('c',5),getCell('d',4),getCell('f',4),getCell('g',5))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('e',7),new RelativeCellsKnight(
                getCell('c',8),getCell('g',8),getCell('c',6),getCell('d',5),getCell('f',5),getCell('g',6)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('e',8),new RelativeCellsKnight(
                getCell('c',7),getCell('d',6),getCell('f',6),getCell('g',7)).getRelativeCells2());
        //F column
        relativeCellsMapKnight.put(getCell('f',1),new RelativeCellsKnight(
                getCell('d',2),getCell('e',3),getCell('g',3),getCell('h',2)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('f',2),new RelativeCellsKnight(
                getCell('d',3),getCell('e',4),getCell('g',4),getCell('h',3),getCell('d',1),getCell('h',1)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('f',3),new RelativeCellsKnight(
                getCell('d',4),getCell('e',5),getCell('g',5),getCell('h',4),getCell('d',2),getCell('e',1),getCell('g',1),getCell('h',2))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('f',4),new RelativeCellsKnight(
                getCell('d',5),getCell('e',6),getCell('g',6),getCell('h',5),getCell('d',3),getCell('e',2),getCell('g',2),getCell('h',3))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('f',5),new RelativeCellsKnight(
                getCell('d',6),getCell('e',7),getCell('g',7),getCell('h',6),getCell('d',4),getCell('e',3),getCell('g',3),getCell('h',4))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('f',6),new RelativeCellsKnight(
                getCell('d',7),getCell('e',8),getCell('g',8),getCell('h',7),getCell('d',5),getCell('e',4),getCell('g',4),getCell('h',5))
                .getRelativeCells2());
        relativeCellsMapKnight.put(getCell('f',7),new RelativeCellsKnight(
                getCell('d',8),getCell('h',8),getCell('d',6),getCell('e',5),getCell('g',5),getCell('h',6)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('f',8),new RelativeCellsKnight(
                getCell('d',7),getCell('e',6),getCell('g',6),getCell('h', 7)).getRelativeCells2());
        //G column
        relativeCellsMapKnight.put(getCell('g',1),new RelativeCellsKnight(
                getCell('h',3),getCell('f',3),getCell('e',2)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('g',2),new RelativeCellsKnight(
                getCell('e',1),getCell('e',3),getCell('f',4),getCell('h',4)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('g',3),new RelativeCellsKnight(
                getCell('e',2),getCell('e',4),getCell('f',5),getCell('h',5),getCell('f',1),getCell('h',1)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('g',4),new RelativeCellsKnight(
                getCell('e',3),getCell('e',5),getCell('f',6),getCell('h',6),getCell('f',2),getCell('h',2)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('g',5),new RelativeCellsKnight(
                getCell('e',4),getCell('e',6),getCell('f',7),getCell('h',7),getCell('f',3),getCell('h',3)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('g',6),new RelativeCellsKnight(
                getCell('e',5),getCell('e',7),getCell('f',8),getCell('h',8),getCell('f',4),getCell('h',4)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('g',7),new RelativeCellsKnight(
                getCell('e',6),getCell('e',8),getCell('f',5),getCell('h',5)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('g',8),new RelativeCellsKnight(
                getCell('e',7),getCell('f',6),getCell('h',6)).getRelativeCells2());
        //H column
        relativeCellsMapKnight.put(getCell('h',1),new RelativeCellsKnight(
                getCell('g',3),getCell('f',2)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('h',2),new RelativeCellsKnight(
                getCell('g',4),getCell('f',3),getCell('f',1)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('h',3),new RelativeCellsKnight(
                getCell('g',5),getCell('f',4),getCell('f',2),getCell('g',1)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('h',4),new RelativeCellsKnight(
                getCell('g',6),getCell('f',5),getCell('f',3),getCell('g',2)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('h',5),new RelativeCellsKnight(
                getCell('g',7),getCell('f',6),getCell('f',4),getCell('g',3)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('h',6),new RelativeCellsKnight(
                getCell('g',8),getCell('f',7),getCell('f',5),getCell('g',4)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('h',7),new RelativeCellsKnight(
                getCell('f',8),getCell('f',6),getCell('g',5)).getRelativeCells2());
        relativeCellsMapKnight.put(getCell('h',8),new RelativeCellsKnight(
                getCell('f',7),getCell('g',6)).getRelativeCells2());
        this.relativeCellsStraight = relativeCellsStraight;
        this.relativeCellsKnight = relativeCellsMapKnight;


    }

    private void setRows(){
        ArrayList<ArrayList<Cell>> rows=new ArrayList<>();
        rows.add(null);
        for(int i=1;i<=8;i++)
        {
            ArrayList<Cell> arrayList=new ArrayList<>();
            arrayList.add(null);
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
        columns.add(null);
        for(int i=1;i<=8;i++)
        {
            ArrayList<Cell> arrayList=new ArrayList<>();
            arrayList.add(null);
            for(int j=1;j<=8;j++)
            {
                arrayList.add(getCell(LetterList[i],Character.getNumericValue(NumberList[j])));

            }
            columns.add(arrayList);
        }
        this.columns=columns;

    }
    public ArrayList<Cell> getCellRow(Cell cell)
    {
        ArrayList<ArrayList<Cell>> rows;
        rows=this.rows;
        char x=cell.getX();
        int y=cell.getY();
        for (ArrayList<Cell> item: rows)
        {
            for(int i=1;i<=8;i++)
            {
                if(item.get(i).getX()==x && item.get(i).getY()==y)
                {
                    return item;
                }
            }
        }
        return null;
    }
    public ArrayList<Cell> getCellColumn(Cell cell)
    {
        ArrayList<ArrayList<Cell>> columns;
        columns=this.columns;
        char x=cell.getX();
        int y=cell.getY();
        for (ArrayList<Cell> item: columns)
        {
            for(int i=1;i<=8;i++)
            {
                if(item.get(i).getX()==x && item.get(i).getY()==y)
                {
                    return item;
                }
            }
        }
        return null;
    }

    private void setCellRowsColumns()
    {
        SortedMap<Cell,SortedMap<ArrayList<Cell>,ArrayList<Cell>>> cellRowColumn=new TreeMap<>();

        for(SortedMap.Entry<String,Cell> pair:getAllCells().entrySet())
        {
            ArrayList<Cell> row=getCellRow(pair.getValue());
            ArrayList<Cell> column=getCellColumn(pair.getValue());
            SortedMap<ArrayList<Cell>,ArrayList<Cell>> rowColumn=new TreeMap<>();
            rowColumn.put(row,column);
            cellRowColumn.put(pair.getValue(),rowColumn);



        }
        this.cellRowColumn=cellRowColumn;
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


}
*/
