package exceptions.cell;

/**
 * Created by Levon on 1/10/2016.
 */
public class EmptySourceCell extends Exception {
    public EmptySourceCell(){
        super();
    }

    public EmptySourceCell(String message){
        super(message);
    }
    public String toString(){
        return "Source is Empty";
    }
}
