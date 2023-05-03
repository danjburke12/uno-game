package Cards;

import java.util.ArrayList;
import java.util.Scanner;

import src.Colors;
import src.Main;
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
        ArrayList<Player> choosablePlayers = new ArrayList<>(); //list of players that can be selected from

        System.out.println("Select which player must draw a card: ");
        //print names for players to choose from
        for (int i = 0; i < Main.getMainGame().getPlayerCount(); i++) {
            if (i != currentPlayer) { 
                //don't display the winner
                Player p = Main.getPlayers()[i];
                System.out.print("[" +(i+1) +"] " +p.getName() +" ");
                choosablePlayers.add(p);
            }
        }
        
        System.out.println("\n Please select a number: ");
        selection = sc.nextInt(); //get selection
        
        //if option chosen is invalid...
        while (selection < 1 || selection > (Main.getMainGame().getPlayerCount())) {
            System.out.println("Invalid option. Please choose a number between 1 - " +Main.getMainGame().getPlayerCount() +": ");
            selection = sc.nextInt();
        }

        //add one card to chosen player's deck
        Player p = Main.getPlayers()[selection-1];
        System.out.println("DEBUG: Player chosen is " +p.getName());

        Main.getPlayers()[p.getArrayPosition()].getPlayerHand().add(Main.getDeckInstance().drawCard(Main.getDeckInstance().getPlayablePile(), 0));
        
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



