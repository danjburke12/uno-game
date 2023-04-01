package Cards;
import src.*;

public class WildCard extends Card {
    /**
     * Constructor
     * 
     * @param cardColor enum type, color of the card
     */
    public WildCard() {
        super(Colors.WILD, "Wild");
    }

    @Override
    public int doAction(int currentPlayer) {
        // set next player, if this is last player, return to player one
        int nextPlayer;
        if (Gameplay.getGameDirection()) {
            nextPlayer = currentPlayer >= Gameplay.getMainGame().getPlayerCount() ? 0 : currentPlayer++;
        }else{
            nextPlayer = currentPlayer == 0 ? Gameplay.getMainGame().getPlayerCount()-1 : currentPlayer--;
        }
        // return next player to play
        return nextPlayer;
    }

    @Override
    public String toString() {
        return "Wild";
    }
}
