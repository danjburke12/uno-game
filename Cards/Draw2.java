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
        // set next player, if this is last player, return to player one
        int nextPlayer = currentPlayer >= Gameplay.getMainGame().getPlayerCount() ? 0 : currentPlayer++;
        for (int i = 0; i < 2; i++) {
            Gameplay.getPlayers()[nextPlayer].getPlayerHand()
                    .add(Gameplay.getDeckInstance().drawCard(Gameplay.getDeckInstance().playablePile, 0));
        }

        // return next player to play
        return nextPlayer >= Gameplay.getMainGame().getPlayerCount() ? 0 : currentPlayer++;
    }
}
