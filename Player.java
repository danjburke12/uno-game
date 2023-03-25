import java.util.ArrayList;

public class Player {
    //create player hand, start with 7 cards
    private ArrayList<Card> playerHand = new ArrayList<>(7);
    private String name;

    //constructor
    public Player(String name, ArrayList<Card> startingHand) {
        this.name = name;
        playerHand = startingHand;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }
}
