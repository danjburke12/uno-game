package Cards;

import src.*;

//this class is used for drawing one card when the player doesn't have a playable card (although it can be used at any time)
public class Draw1 extends Card {
    public Draw1() {
        super(Colors.WILD, "DRAW A CARD");
    }

    @Override
    public int doAction(int currentPlayer) {
        Gameplay.getPlayers()[currentPlayer].getPlayerHand()
            .add(Gameplay.getDeckInstance().drawCard(Gameplay.getDeckInstance().playablePile, 0));
        // return next player to play
        int nextPlayer;
        if (Gameplay.getGameDirection()) {
            nextPlayer = (currentPlayer + 1) >= Gameplay.getMainGame().getPlayerCount() ? 0 : ++currentPlayer;
        } else {
            nextPlayer = currentPlayer == 0 ? Gameplay.getMainGame().getPlayerCount() - 1 : --currentPlayer;
        }
        return nextPlayer;
    }

    /**
     * toString method
     * Displays SHOUT UNO
     * 
     * @return formatted String for card
     */
    @Override
    public String toString() {
        return "Draw Card";
    }
    
}
