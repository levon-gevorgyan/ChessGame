package play.turns;

import chesstable.Table;
import colors.Colors;
import exceptions.game.Mate;
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
                                ArrayList<SaveState> saveStateArrayList, SaveState previousState, boolean nextTurn) throws IOException, Mate;

}
