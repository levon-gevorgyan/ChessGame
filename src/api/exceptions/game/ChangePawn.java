package api.exceptions.game;

import api.colors.Colors;

/**
 * Created by Levon on 1/29/2016, 9:25 PM
 */
public class ChangePawn extends Exception implements Colors{
    public ChangePawn(){
        super();
    }

    public ChangePawn(String message){
        super(message);
    }

    private String item;

    public String getItem() {
        return item;
    }

    public ChangePawn (String player,String item){
        if(player.equals(WHITE)){
            if(item.equals("queen")){
                this.item="/ui/window/main/images/items/WhiteQueen.png";
            }
            if(item.equals("bishop")){
                this.item="/ui/window/main/images/items/WhiteBishop.png";
            }
            if(item.equals("rook")){
                this.item="/ui/window/main/images/items/WhiteRook.png";
            }
            if(item.equals("knight")){
                this.item="/ui/window/main/images/items/WhiteKnight.png";
            }
        }
        if(player.equals(BLACK)){
            if(item.equals("queen")){
                this.item="/ui/window/main/images/items/BlackQueen.png";
            }
            if(item.equals("bishop")){
                this.item="/ui/window/main/images/items/BlackBishop.png";
            }
            if(item.equals("rook")){
                this.item="/ui/window/main/images/items/BlackRook.png";
            }
            if(item.equals("knight")){
                this.item="/ui/window/main/images/items/BlackKnight.png";
            }
        }


    }
}
