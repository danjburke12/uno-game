package Cards;
import src.*;

public class ReverseCard extends Card{
    /**
     * Constructor
     * @param cardColor enum type, color of the card
     */
    public ReverseCard(Colors color) {
        super(color, "Reverse");
    }

    /**
     * Flips order of gameplay
     * @param currentPlayer : takes in current player
     * @return return player 2 players from current player
     */

    @Override
    public int doAction(int currentPlayer) {
        //switch game direction
        Main.toggleGameDirection();
        int nextPlayer;

        // set next player, if this is last player, return to player one
        if (Main.getGameDirection()) {
            nextPlayer = (currentPlayer + 1) >= Main.getMainGame().getPlayerCount() ? 0 : ++currentPlayer;
        }else{
            nextPlayer = currentPlayer == 0 ? Main.getMainGame().getPlayerCount()-1 : --currentPlayer;
        }
        // return next player to play
        return (nextPlayer);
    }
}
