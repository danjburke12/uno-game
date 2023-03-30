package Cards;
import src.*;

public class SkipCard extends Card {
    /**
     * Constructor
     * 
     * @param cardColor enum type, color of the card
     */
    public SkipCard(Colors color) {
        super(color, "Skip");
    }

    @Override
    public int doAction(int currentPlayer) {
        // set next player, if this is last player, return to player one
        int nextPlayer = currentPlayer >= Gameplay.getMainGame().getPlayerCount() ? 0 : currentPlayer++;

        // return next player to play
        return (nextPlayer >= Gameplay.getMainGame().getPlayerCount() ? 0 : currentPlayer++);
    }

    @Override
    public String toString() {
        return "Wild";
    }
}
