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

    /**
     * Skips next player
     * 
     * @param currentPlayer : takes in current player
     * @return return player 2 players from current player
     */

    @Override
    public int doAction(int currentPlayer) {
        // set next player, if this is last player, return to player one
        int nextPlayer;
        if (Gameplay.getGameDirection()) {
            nextPlayer = (currentPlayer + 1) >= Gameplay.getMainGame().getPlayerCount() ? 0 : ++currentPlayer;
        } else {
            nextPlayer = currentPlayer == 0 ? Gameplay.getMainGame().getPlayerCount() - 1 : currentPlayer--;
        }
        //skip player
        if (Gameplay.getGameDirection()) {
            nextPlayer = (currentPlayer + 1) >= Gameplay.getMainGame().getPlayerCount() ? 0 : ++currentPlayer;
        }else{
            nextPlayer = currentPlayer == 0 ? Gameplay.getMainGame().getPlayerCount()-1 : --currentPlayer;
        }

        // return next player to play
        return nextPlayer;
    }
}
