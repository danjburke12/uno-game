package src;
import java.util.ArrayList;

import Cards.Card;

public class Player {
    // create player hand, start with 7 cards
    private ArrayList<Card> playerHand = new ArrayList<>(7);
    private String name;
    private boolean hasDeclaredUNO = false;

    // constructor
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

    public boolean getHasDeclaredUNO() {
        return hasDeclaredUNO;
    }

    public boolean setHasDeclaredUno(boolean declaredUNO) {
        this.hasDeclaredUNO = declaredUNO;
        return hasDeclaredUNO;
    }
}
