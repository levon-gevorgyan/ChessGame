package exceptions.game;

import colors.Colors;

/**
 * Created by Levon on 1/22/2016, 11:43 PM
 */
public class Mate extends Exception implements Colors {
    public Mate(){
        super();
    }

    @Override
    public String getMessage() {
        return message;
    }

    private String message;

    public Mate(String message){
        this.message=message;
        if(message.equals(WHITE))
        {
            System.out.println("Check-Mate to White");
        }
        if(message.equals(BLACK))
        {
            System.out.println("Check-Mate to Black");
        }
    }

    public String getBoxMessage(String message){

        if(message.equals(WHITE))
        {
            return "Check-Mate to White";
        }
        if(message.equals(BLACK))
        {
            return "Check-Mate to Black";
        }
        return null;
    }


 }


