package Cards;
import src.*;

public class NumberCard extends Card {
    int value;
    /**
     * Constructor
     * @param cardColor enum type, color of the card
     */
    public NumberCard(Colors cardColor, String title) {
        super(cardColor, title);
    }

    @Override
    public int doAction(int currentPlayer) {
        // return next player to play
        return currentPlayer >= Gameplay.getMainGame().getPlayerCount() ? 0 : currentPlayer++;
    }
}
