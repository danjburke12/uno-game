package Cards;

import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;
import javax.swing.TransferHandler.TransferSupport;

import src.Colors;
import src.Gameplay;
import src.Player;

public class ForgotUNO extends Card{
    public ForgotUNO() {
        super(Colors.WILD, "Forgot 'UNO'");
    }

    @Override
    public int doAction(int currentPlayer) {
        //determine which player needs another card
        Scanner sc = new Scanner(System.in);
        int selection;
        int usablePlayerCount = Gameplay.getMainGame().getPlayerCount() - 1;
        ArrayList<Integer> playerIndexes = new ArrayList<>(usablePlayerCount);
        for (int i = 0; i < Gameplay.getMainGame().getPlayerCount(); i++) {
            System.out.println("DEBUG i = " +i);
            if (i != currentPlayer) { //don't display the current player
                playerIndexes.add(i);
            }
        }

        System.out.println("Select which player must draw a card: ");
        //print names
        for (int i = 0; i <= playerIndexes.size(); i++) {
            System.out.print("[" +(i+1) +"] " +Gameplay.getPlayers()[playerIndexes.get(i)].getName() +" ");
        }
        System.out.println("\n Please select a number: ");
        selection = sc.nextInt(); //get selection
        
        //if option chosen is invalid...
        while (selection < 1 || selection > (usablePlayerCount)) {
            System.out.println("Invalid option. Please choose a number between 1 - " +usablePlayerCount +": ");
            selection = sc.nextInt();
        }

        //add one card to chosen player's deck
        int x = playerIndexes.get(selection);
        Gameplay.getPlayers()[x].getPlayerHand().add(Gameplay.getDeckInstance().drawCard(Gameplay.getDeckInstance().getPlayablePile(), 0));
        
        //current player stays the same, so they can now play a card
        return currentPlayer;
    }  

    /**
     * toString method
     * Displays SHOUT UNO
     * @return formatted String for card
     */
    @Override
    public String toString() {
        return "'UNO' Violation";
    }
}



