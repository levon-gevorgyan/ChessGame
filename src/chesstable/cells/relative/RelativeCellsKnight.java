package chesstable.cells.relative;

import chesstable.cells.Cell;

import java.util.ArrayList;

/**
 * Created by Levon on 1/10/2016.
 */
public class RelativeCellsKnight {
    private ArrayList<Cell> relativeCells2=new ArrayList<Cell>();
    public RelativeCellsKnight(Cell cell1, Cell cell2)
    {
        relativeCells2.add(cell1);
        relativeCells2.add(cell2);

    }
    public RelativeCellsKnight(Cell cell1, Cell cell2, Cell cell3)
    {
        relativeCells2.add(cell1);
        relativeCells2.add(cell2);
        relativeCells2.add(cell3);
    }
    public RelativeCellsKnight(Cell cell1, Cell cell2, Cell cell3, Cell cell4)
    {
        relativeCells2.add(cell1);
        relativeCells2.add(cell2);
        relativeCells2.add(cell3);
        relativeCells2.add(cell4);

    }

    public RelativeCellsKnight(Cell cell1, Cell cell2, Cell cell3, Cell cell4, Cell cell5,
                        Cell cell6)
    {
        relativeCells2.add(cell1);
        relativeCells2.add(cell2);
        relativeCells2.add(cell3);
        relativeCells2.add(cell4);
        relativeCells2.add(cell5);
        relativeCells2.add(cell6);


    }
    public RelativeCellsKnight(Cell cell1, Cell cell2, Cell cell3, Cell cell4, Cell cell5,
                        Cell cell6, Cell cell7, Cell cell8)
    {
        relativeCells2.add(cell1);
        relativeCells2.add(cell2);
        relativeCells2.add(cell3);
        relativeCells2.add(cell4);
        relativeCells2.add(cell5);
        relativeCells2.add(cell6);
        relativeCells2.add(cell7);
        relativeCells2.add(cell8);

    }

    public ArrayList<Cell> getRelativeCells2()
    {
        return relativeCells2;
    }
}
