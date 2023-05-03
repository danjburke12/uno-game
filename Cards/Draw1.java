package Cards;

import src.*;

//this class is used for drawing one card when the player doesn't have a playable card (although it can be used at any time)
public class Draw1 extends Card {
    public Draw1() {
        super(Colors.WILD, "DRAW A CARD");
    }

    @Override
    public int doAction(int currentPlayer) {
        Main.getPlayers()[currentPlayer].getPlayerHand()
            .add(Main.getDeckInstance().drawCard(Main.getDeckInstance().playablePile, 0));
        // return next player to play
        int nextPlayer;
        if (Main.getGameDirection()) {
            nextPlayer = (currentPlayer + 1) >= Main.getMainGame().getPlayerCount() ? 0 : ++currentPlayer;
        } else {
            nextPlayer = currentPlayer == 0 ? Main.getMainGame().getPlayerCount() - 1 : --currentPlayer;
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
