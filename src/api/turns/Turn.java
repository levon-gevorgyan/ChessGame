package api.turns;

import api.chessboard.ChessBoard;
import api.colors.Colors;
import api.exceptions.game.CastlingDone;
import api.exceptions.game.ChangePawn;
import api.exceptions.game.CheckIsOpen;
import api.exceptions.game.Mate;
import javafx.scene.control.TextArea;
import api.players.BlackPlayer;
import api.players.WhitePlayer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 27/01/16.
 */
public abstract class Turn implements Colors{
    public abstract void doMove(String s, ChessBoard chessBoard, WhitePlayer whitePlayer, BlackPlayer blackPlayer,
                                ArrayList<SaveState> saveStateArrayList, SaveState previousState,TextArea status)
            throws IOException, Mate, CheckIsOpen, CastlingDone, ChangePawn;

}
