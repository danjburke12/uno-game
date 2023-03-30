package src;

import java.util.ArrayList;

public class Game {
    private int playerCount;
    private ArrayList<Integer> playerScores = new ArrayList<>();
    private int round;
    private boolean gameFlowDirection = true; // true = positive direction, false = opposite (negative) direction

    /* getters and setters */
    /**
     * 
     * @param playerCount
     * @return player
     */
    public int setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
        return playerCount;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getRound() {
        return round;
    }

    public ArrayList<Integer> getPlayerScores() {
        return playerScores;
    }

    // switch game flow (used with reverse card)
    public boolean toggleGameFlowDirection() {
        gameFlowDirection = !gameFlowDirection;
        return gameFlowDirection;
    }

    // get game flow
    public boolean getGameFlowDirection() {
        return gameFlowDirection;
    }
}
