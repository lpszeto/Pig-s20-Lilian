package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class PigGameState extends GameState {
    private int playerID, player0Score,player1Score, dice, runningTotal;

    public PigGameState(){
        super();
    }
    public PigGameState(int playerID, int player0, int player1, int dice, int runningTotal){
        this.playerID = playerID;
        player0Score = player0;
        player1Score = player1;
        this.dice = dice;
        this.runningTotal = runningTotal;
    }
    public int getPlayerID(){ return  playerID; }
    public int getPlayer0Score(){return player0Score;}
    public int getPlayer1Score(){return player1Score;}
    public int getDice(){return dice;}
    public int getRunningTotal() { return runningTotal; }
    public void setPlayerID(int playerID){this.playerID = playerID;}
    public void setPlayer0Score(int player0Score){this.player0Score = player0Score;}
    public void setPlayer1Score(int player1Score){this.player1Score=player1Score;}
    public void setDice(int dice) { this.dice = dice; }
    public void setRunningTotal(int runningTotal) { this.runningTotal = runningTotal; }
}
