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
        // return next player, if this is last player, return to start of order
        int nextPlayer;

        if (Gameplay.getGameDirection()) {
            nextPlayer = (currentPlayer + 1) >= Gameplay.getMainGame().getPlayerCount() ? 0 : ++currentPlayer;
        }else{
            nextPlayer = currentPlayer == 0 ? Gameplay.getMainGame().getPlayerCount()-1 : --currentPlayer;
        }
        return nextPlayer;
    }
}
