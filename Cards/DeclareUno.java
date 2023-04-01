package Cards;

import src.Colors;
import src.Gameplay;

public class DeclareUno extends Card{
    public DeclareUno() {
        super(Colors.WILD, "SHOUT UNO");
    }

    @Override
    public int doAction(int currentPlayer) {
        Gameplay.getPlayers()[currentPlayer].setHasDeclaredUno(true);
        System.out.println("UNO!" +currentPlayer +" only has one card left!");
     
        // return next player to play
        int nextPlayer;
        if (Gameplay.getGameDirection()) {
            nextPlayer = currentPlayer >= Gameplay.getMainGame().getPlayerCount() ? 0 : currentPlayer++;
        }else{
            nextPlayer = currentPlayer == 0 ? Gameplay.getMainGame().getPlayerCount()-1 : currentPlayer--;
        }
        return nextPlayer;
    }  

    /**
     * toString method
     * Displays SHOUT UNO
     * @return formatted String for card
     */
    @Override
    public String toString() {
        return "SHOUT UNO";
    }
}



