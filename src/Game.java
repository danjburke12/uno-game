package src;
import java.util.ArrayList;

public class Game {
    private int playerCount;
    private ArrayList<Integer> playerScores = new ArrayList<>();
    private int round;

    /* getters and setters */
    /**
     * 
     * @param playerCount
     * @return player
     */
    public int setPlayerCount(int playerCount) {
        playerCount = playerCount;
        return playerCount;
    }

    public int getPlayerCount() {
        return playerCount;
    }
}
