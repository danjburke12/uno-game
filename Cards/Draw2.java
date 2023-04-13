package Cards;

import src.*;

public class Draw2 extends Card {
    /**
     * Constructor
     * 
     * @param cardColor enum type, color of the card
     */
    public Draw2(Colors cardColor) {
        super(cardColor, "Draw 2");
    }

    @Override
    public int doAction(int currentPlayer) {
        // return next player, if this is last player, return to start of order
        int nextPlayer;

        // give next player two cards, then skip
        if (Gameplay.getGameDirection()) {
            nextPlayer = currentPlayer >= Gameplay.getMainGame().getPlayerCount() ? 0 : ++currentPlayer;
        } else {
            nextPlayer = currentPlayer == 0 ? Gameplay.getMainGame().getPlayerCount() - 1 : --currentPlayer;
        }
        for (int i = 0; i < 2; i++) {
            Gameplay.getPlayers()[nextPlayer].getPlayerHand()
                    .add(Gameplay.getDeckInstance().drawCard(Gameplay.getDeckInstance().playablePile, 0));
        }

        // skip, move to next player
        if (Gameplay.getGameDirection()) {
            nextPlayer = (currentPlayer + 1) >= Gameplay.getMainGame().getPlayerCount() ? 0 : ++currentPlayer;
        } else {
            nextPlayer = currentPlayer == 0 ? Gameplay.getMainGame().getPlayerCount() - 1 : --currentPlayer;
        }

        // return next player to play
        return nextPlayer;
    }
}
