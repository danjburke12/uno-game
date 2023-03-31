package src;
import java.util.ArrayList;
import java.util.Scanner;

import Cards.*;

public class Gameplay {
    static Game mainGame = new Game();
    static Player[] players;
    static int[] playerScores;
    static Deck deckInstance = new Deck();
    static boolean hasWinner = false;

    public static void main(String[] args) {
        // display gameplay and get user confirmation
        if (displayRules()) {
            //System.out.println("Happy playing!");
            // run game setup
            gameSetup();

            // setup player scores
            playerScores = new int[mainGame.getPlayerCount()];

            // display first card
            int x = 0;
            Card tempCard;
            do {
                //draw card from main pile, place in discard pile (face up)
                deckInstance.discardPile.add(deckInstance.drawCard(deckInstance.playablePile, 0));
                tempCard = deckInstance.discardPile.get(x);
                x++;
            } while (tempCard.getColor() == Colors.WILD); //ensures first card is not a wild card
            System.out.println("**The first card is a " + tempCard.toString() + ".**");

            // play game
            playRound();
        } else {
            System.out.println("Goodbye");
        }
    }

    public static void playRound() {
        //loop through each player
        Player currentPlayer = players[0];
        while (!hasWinner) {
            //display cards that can be played
            System.out.println("" +currentPlayer.getName() +", please pick the number of a card to play (0 to declare UNO): ");
            for (int c = 0; c < players[currentPlayer.getArrayPosition()].getPlayerHand().size(); c++) {
                //display card
                System.out.println("Playerhand " +players[currentPlayer.getArrayPosition()].getPlayerHand().size());
                System.out.print(" * [" +c +"] " +currentPlayer.getPlayerHand().get(c).toString());
                
            }
            //return line
            System.out.println();
            //check if card chosen is valid
            //move on, check if card played was a skip, +2 etc
        }
    }

    /**
     * displays the rules and requires user confirmation
     * 
     * @return boolean indicating if user has accepted rules
     */
    public static boolean displayRules() {
        // display rules
        System.out.println("Welcome to UNO! Here are the rules:");
        System.out.println(
                "*Every player starts with seven cards. \n*There are two piles: a draw pile and a discard pile.");
        System.out.println(
                "*Your goal is to get rid of all your cards by playing one card at a time in the discard pile. \n*You can play a card if it matches the previously played card in either color, number, or action.");
        System.out.println("*When you are at one card left, shout \"UNO!\", otherwise you must draw another card."); // TODO: Daniel needs to pick which way we are doing UNO

        // create Scanner object
        Scanner userInput = new Scanner(System.in);
        System.out.println("Do you accept these rules?");
        System.out.println("Type any key to continue or 'QUIT' to exit the game");  

        // check for user input
        String input = userInput.next();
        if (input.equals("QUIT")) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * Runs game setup
     * Gets number of players, player names, creates hands etc
     */
    public static void gameSetup() {
        int inputVal;
        // create discard and playing pile
        deckInstance = new Deck();
        //add cards to pile
        deckInstance.playablePile = deckInstance.initializeDeck();
        //shuffle deck
        deckInstance.shuffle(deckInstance.playablePile);
        
        System.out.println("DEBUG: Printing playable pile");
        for (Card c : deckInstance.getPlayablePile()) {
            System.out.println(c);
        }

        // get number of players
        do {
            Scanner userInput = new Scanner(System.in);
            System.out.println("How many people will be playing? (2-10 allowed): ");
            //get user input
            inputVal = userInput.nextInt();
            mainGame.setPlayerCount(inputVal);
            players = new Player[mainGame.getPlayerCount()];
        } while (inputVal < 2 || inputVal > 10);

        // create players and deal
        for (int i = 0; i < mainGame.getPlayerCount(); i++) {
            // create card hand for player
            ArrayList<Card> tempHand = new ArrayList<>();
            
            /*add "shout UNO" card to deck
            * this card always stays in deck
            * can only be played when one card (two counting this one) are left
            */
            tempHand.add(new DeclareUno());

            //fill hand with 7 cards
            for (int j = 1; j < 8; j++) {
                tempHand.add(deckInstance.drawCard(deckInstance.playablePile, 0));
            }

            Scanner userInput = new Scanner(System.in);
            // get name of player
            System.out.println("Please enter player " + (i + 1) + "'s name: ");
            // create new player instance
            players[i] = new Player(userInput.next(), tempHand, i);
        }
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
