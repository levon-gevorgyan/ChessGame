package ui.window.main;

import api.chessitems.ChessItem;
import api.chessitems.black.*;
import api.chessitems.white.*;

/**
 * Created by Levon on 1/26/2016, 11:19 PM
 */
public class BoardItemUI {
    private String string;
    private ChessItem chessItem;
    private String imageString;



    public BoardItemUI(String string, ChessItem chessItem, String imageString) {
        this.string = string;
        this.chessItem = chessItem;
        this.imageString = imageString;
    }

    public String  getImageString(ChessItem chessItem){
        if(chessItem instanceof WhiteBishop)
            return WhiteBishop.getImageString();
        if(chessItem instanceof WhiteKing)
            return WhiteKing.getImageString();
        if(chessItem instanceof WhiteKnight)
            return WhiteKnight.getImageString();
        if(chessItem instanceof WhitePawn)
            return WhitePawn.getImageString();
        if(chessItem instanceof WhiteQueen)
            return WhiteQueen.getImageString();
        if(chessItem instanceof WhiteRookA)
            return WhiteRook.getImageString();
        if(chessItem instanceof WhiteRookH)
            return WhiteRook.getImageString();
        if(chessItem instanceof BlackBishop)
            return BlackBishop.getImageString();
        if(chessItem instanceof BlackKing)
            return BlackKing.getImageString();
        if(chessItem instanceof BlackKnight)
            return BlackKnight.getImageString();
        if(chessItem instanceof BlackPawn)
            return BlackPawn.getImageString();
        if(chessItem instanceof BlackQueen)
            return BlackQueen.getImageString();
        if(chessItem instanceof BlackRookA)
            return BlackRook.getImageString();
        if(chessItem instanceof BlackRookH)
            return BlackRook.getImageString();
        return null;
    }

    public String getString() {
        return string;
    }

    public ChessItem getChessItem() {
        return chessItem;
    }

    public String getImageString() {
        return imageString;
    }
}
