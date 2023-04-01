package Cards;
import src.*;

public class WildDraw4 extends Card {
    /**
     * Constructor
     * @param cardColor enum type, color of the card
     */
    public WildDraw4() {
        super(Colors.WILD, "Wild Draw 4");
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

        for (int i = 0; i < 4; i++) {
            Gameplay.getPlayers()[nextPlayer].getPlayerHand()
                    .add(Gameplay.getDeckInstance().drawCard(Gameplay.getDeckInstance().playablePile, 0));
        }

        //skip player
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
        return "Wild Draw 4";
    }
}
