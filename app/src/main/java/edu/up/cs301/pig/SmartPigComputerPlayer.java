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
public class SmartPigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public SmartPigComputerPlayer(String name) {
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
            if (((PigGameState) info).getPlayerID()== super.playerNum) {
                int score = (playerNum == 0) ? ((PigGameState) info).getPlayer0Score(): ((PigGameState) info).getPlayer1Score();
                int oppScore = (playerNum == 0) ? ((PigGameState) info).getPlayer1Score(): ((PigGameState) info).getPlayer0Score();
                if(((PigGameState) info).getRunningTotal() > 10 || oppScore-(score + ((PigGameState) info).getRunningTotal())<=10){
                    game.sendAction(new PigHoldAction(this));
                }
                else {
                    game.sendAction(new PigRollAction(this));
                }
            }
        }
    }//receiveInfo

}
