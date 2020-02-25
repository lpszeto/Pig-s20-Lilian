package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.utilities.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if(info instanceof PigGameState) {
            //PigGameState pigGameState = (PigGameState)info;
            if (((PigGameState) info).getPlayerID()== super.playerNum) {
                Random r = new Random();
                int randInt = r.nextInt(2);
                if (randInt == 0) {
                    game.sendAction(new PigHoldAction(this));
                } else {
                    game.sendAction(new PigRollAction(this));
                }
            }
        }
    }//receiveInfo

}
