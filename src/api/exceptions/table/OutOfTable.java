package api.exceptions.table;

/**
 * Created by Levon on 1/10/2016.
 */
public class OutOfTable extends Exception {
    public OutOfTable(){
        super();
    }

    public OutOfTable(String message){
        super(message);

    }

    /*public static String invalidNextRow()
    {
        return "Invalid Next Row";
    }
    public static String invalidPreviousRow()
    {
        return "Invalid Previous Row";
    }
    public static String invalidNextColumn()
    {
        return "Invalid Next Column";
    }
    public static String invalidPreviousColumn()
    {
        return "Invalid Previous Column";
    }*/

    /*public String toString(){
        return "is Out of ChessBoard";
    }*/
}
