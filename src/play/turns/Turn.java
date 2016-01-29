package play.turns;

import chesstable.Table;
import colors.Colors;
import exceptions.game.CastlingDone;
import exceptions.game.CheckIsOpen;
import exceptions.game.Mate;
import javafx.scene.control.TextArea;
import play.SaveState;
import players.BlackPlayer;
import players.WhitePlayer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by levon.gevorgyan on 27/01/16.
 */
public abstract class Turn implements Colors{
    public abstract void doMove(String s, Table table, WhitePlayer whitePlayer, BlackPlayer blackPlayer,
                                ArrayList<SaveState> saveStateArrayList, SaveState previousState,TextArea status) throws IOException, Mate, CheckIsOpen, CastlingDone;

}
