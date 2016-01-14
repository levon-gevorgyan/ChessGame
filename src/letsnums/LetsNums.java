package letsnums;

import chesstable.cells.Letters;
import chesstable.cells.Numbers;

import exceptions.moves.WrongLetter;
import exceptions.moves.WrongNumber;

/**
 * Created by Levon on 1/11/2016.
 */
public abstract class LetsNums implements Letters,Numbers{
    public static boolean isNumber(char x) throws WrongNumber {
        boolean a=false;
        for (int i=1;i<=8;i++)
        {
            if (x==NumberList[i])
            {
                a= true;
            }

        }
        if(a)
        {
            return true;
        }
        else
            throw new WrongNumber();
    }
    public static boolean isLetter(char x) throws WrongLetter {
        boolean a=false;
        for (int i=1;i<=8;i++)
        {
            if (x==LetterList[i])
            {
                a= true;
            }

        }
        if(a)
        {
            return true;
        }
        else
            throw new WrongLetter();
    }

}
