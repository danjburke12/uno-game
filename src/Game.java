package src;

import java.util.ArrayList;

public class Game {
    private int playerCount;
    private ArrayList<Integer> playerScores = new ArrayList<>();
    private int round;
    private boolean gameFlowDirection = true; // true = positive direction, false = opposite (negative) direction

    //rules to be displayed
    private static String rulePrintout = new String("****************\nWelcome to UNO! Here are the rules:\n*Every player starts with seven cards. \n*There are two piles: a draw pile and a discard pile.\n*Your goal is to get rid of all your cards by playing one card at a time in the discard pile. \n*You can play a card if it matches the previously played card in either color, number, or action.\n*When you are at one card left, shout \"UNO!\\n*If you forget and another player catches you, you must draw a card.\n*(To do this, the next player will select *[0] 'UNO' Violation*.)\n****************\nDo you accept these rules?\nType any key (+ enter) to continue or 'QUIT' to exit the game");

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

    public static String getRulePrintout() {
        return rulePrintout;
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
