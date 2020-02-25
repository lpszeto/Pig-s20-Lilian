package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    PigGameState pGS;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        pGS = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) { return (pGS.getPlayerID()== playerIdx)? true:false; }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if(action instanceof PigHoldAction){
            if(pGS.getPlayerID() == 0){
                pGS.setPlayer0Score(pGS.getRunningTotal()+pGS.getPlayer0Score());
            }
            else{
                pGS.setPlayer1Score(pGS.getRunningTotal()+pGS.getPlayer1Score());
            }
            if(players.length>1)
                pGS.setPlayerID(1-pGS.getPlayerID());
            pGS.setRunningTotal(0);
            return true;
        }
        if(action instanceof PigRollAction){
            Random r = new Random();
            int die = r.nextInt(6)+1;
            pGS.setDice(die);
            if(die == 1){
                pGS.setRunningTotal(0);
                if(players.length>1)
                    pGS.setPlayerID(1-pGS.getPlayerID());
            }
            else {
                pGS.setRunningTotal(pGS.getRunningTotal()+ die);
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        GameState gs = pGS;
        p.sendInfo(gs);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {

            if (pGS.getPlayer0Score() >= 50) {
                return "Player: " + playerNames[0] + " Score: " + pGS.getPlayer0Score() + " ";
            }


            if (pGS.getPlayer1Score() >= 50) {
                return "Player: " + playerNames[1] + " Score: " + pGS.getPlayer1Score() + " ";
            }

        return null;
    }

}// class PigLocalGame
