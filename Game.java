import java.util.ArrayList;

/*Game class
*behind the scenes game management
*holds scores, players, decks, etc
*/

public class Game {
    private static int playerCount;
    private static ArrayList<Integer> playerScores = new ArrayList<>();
    private static int round;
    private static String[] playerNames = new String[playerCount];

    /**
     * Creates hand for each player
     * playerHands is the Array which stores each player's hand in the game
     * each item in the array is one player's hand, stored in an ArraList<Card> object
     */
    ArrayList<Card>[] playerHands = new ArrayList[playerCount];
    for(int i = 0; i<playerHands.length; i++){
        playerHands[i] = new ArrayList<Card>(7);
    }

    /* getters and setters */
    public static int setPlayerCount(int playerCount) {
        Game.playerCount = playerCount;
        return playerCount;
    }

    public static int getPlayerCount() {
        return playerCount;
    }

    public static void setPlayerNames(int index, String name) {
        Game.playerNames[index] = name;
    }.
}
