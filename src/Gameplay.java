package src;
import java.util.ArrayList;
import java.util.Scanner;

import Cards.*;

public class Gameplay {
    static Game mainGame = new Game();
    static Player[] players;
    static int[] playerScores;
    static Deck deckInstance;

    public static void main(String[] args) {
        // display gameplay and get user confirmation
        if (displayRules()) {
            System.out.println("Happy playing!");
            // run game setup
            gameSetup();

            // setup player scores
            playerScores = new int[mainGame.getPlayerCount()];

            // display first card
            Card tempCard = deckInstance.discardPile.set(0, deckInstance.drawCard(deckInstance.playablePile, 0));
            System.out.println("The first card is a " + tempCard.toString() + ".");

            // play game
            playRound();
        } else {
            System.out.println("Goodbye");
        }
    }

    public static void playRound() {
        //loop through each player
        for ()
            //display cards that can be played
            //check if card chosen is valid
            //move on, check if card played was a skip, +2 etc
    }

    /**
     * displays the rules and requires user confirmation
     * 
     * @return boolean indicating if user has accepted rules
     */
    public static boolean displayRules() {
        // display rules
        System.out.println("Welcome to UNO! Here are the rules!");
        System.out.println(
                "Every player starts with seven cards. \nThere are two piles: a draw pile and a discard pile.");
        System.out.println(
                "Your goal is to get rid of all your cards by playing one card at a time in the discard pile. \nYou can play a card if it matches the previously played card in either color, number, or action.");
        System.out.println("When you are at one card left, you need to shout \"UNO!\"."); // TODO: Daniel needs to pick which way we are doing UNO

        // create Scanner object
        Scanner userInput = new Scanner(System.in);
        System.out.println("Do you accept these rules?");
        System.out.println("Press any key to continue or type 'QUIT' to exit the game");

        // check for user input
        String input = userInput.next();
        userInput.close();
        if (input.equals("QUIT")) {
            return false;
        } else {
            return true;
        }

    }

    public static void gameSetup() {
        int input;
        Scanner userInput = new Scanner(System.in);

        // create discard and playing pile
        deckInstance = new Deck();
        deckInstance.initializeDeck(deckInstance.playablePile);
        //shuffle deck
        deckInstance.setPlayablePile(deckInstance.shuffle(deckInstance.getPlayableDeck()));

        // get number of players
        do {
            System.out.println("How many people will be playing? (2-10 allowed): ");
            input = userInput.nextInt();
            mainGame.setPlayerCount(input);
            players = new Player[mainGame.getPlayerCount()];
        } while (input < 2 || input > 10);

        // create players and deal
        for (int i = 0; i < mainGame.getPlayerCount(); i++) {
            // create card hand for player
            ArrayList<Card> tempHand = new ArrayList<>(7);
            
            /*add "shout UNO" card to deck
            * this card always stays in deck
            * can only be played when one card (two counting this one) are left
            */
            tempHand.set(0, new DeclareUno());

            //fill hand with 7 cards
            for (int j = 1; j < 8; j++) {
                tempHand.set(j, deckInstance.drawCard(deckInstance.playablePile, 0));
            }

            // get name of player
            System.out.println("Please enter player " + (i + 1) + "'s name: ");
            // create new player instance
            players[i] = new Player(userInput.next(), tempHand);
        }
        userInput.close();
    }

    /* getters */
    public static Game getMainGame() {
        return mainGame;
    }
    public static Deck getDeckInstance() {
        return deckInstance;
    }
    public static int[] getPlayerScores() {
        return playerScores;
    }
    public static Player[] getPlayers() {
        return players;
    }
}
