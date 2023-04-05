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
    static boolean gameDirection = true;
    static int lowestPossibleIndex = 1; //either 1 or 0 (0 if uno can be declared)
    static int highestPossibleIndex = 7;
    static Player currentPlayer;


    public static void main(String[] args) {
        // display gameplay and get user confirmation
        if (displayRules()) {
            // System.out.println("Happy playing!");
            // run game setup
            gameSetup();

            // setup player scores
            playerScores = new int[mainGame.getPlayerCount()];

            // display first card
            int x = 0;
            Card tempCard;
            do {
                // draw card from main pile, place in discard pile (face up)
                deckInstance.discardPile.add(deckInstance.drawCard(deckInstance.playablePile, 0));
                tempCard = deckInstance.discardPile.get(x);
                x++;
            } while (tempCard.getColor() == Colors.WILD); // ensures first card is not a wild card
            System.out.println("**The first card is a " + tempCard.toString() + ".**");

            // play game
            playRound(tempCard);
        } else {
            System.out.println("Goodbye");
        }
    }

    public static void playRound(Card tempCard) {
        // loop through each player
        currentPlayer = players[0];
        while (!hasWinner) {
            getBorderValues(currentPlayer);
            // display cards that can be played
            System.out.println("" + currentPlayer.getName() + ", please pick the number of a card to play: ");
            for (int c = lowestPossibleIndex; c < highestPossibleIndex; c++) {
                // display card
                System.out.print(" * [" + c + "] " + currentPlayer.getPlayerHand().get(c).toString());
            }
            // return line
            System.out.println();

            /* get card chosen and check validity */
            Scanner sc = new Scanner(System.in);
            int chosenCardIndex;

            //check validity





            do {
            chosenCardIndex = sc.nextInt();
            if (getBorderValues(currentPlayer, chosenCardIndex))
                System.out.println();

            }while (getBorderValues(currentPlayer, chosenCardIndex));                    

                
                
                    System.out.println("That is not an option, please choose a number between 0-"
                        + (players[currentPlayer.getArrayPosition()].getPlayerHand().size() - 1));
                    //check to see if number is in deck
                //check to see if matches in number/title/action or color
            // move on, check if card played was a skip, +2 etc
            if (chosenCardIndex != 0) {
                //TODO: check if card can be played (is valid)
                
                //take card from player's hand, add to discard pile
                deckInstance.discardPile.add(0, deckInstance.drawCard(players[currentPlayer.getArrayPosition()].getPlayerHand(), chosenCardIndex));
                
                /** run card operation, assign next player
                 * .doAction runs card's actions (draws 2, skips, reverses, plays etc.)
                 * returns next player, assigns to currentPlayer
                 */
                currentPlayer = players[deckInstance.discardPile.get(0).doAction(currentPlayer.getArrayPosition())];

            }else {
                //TODO: add support for DECLARE UNO option
            }
        }
    }

    /**
     * displays the rules and requires user confirmation
     * 
     * @return boolean indicating if user has accepted rules
     */
    public static boolean displayRules() {
        // display rules
        System.out.println("****************");
        System.out.println("Welcome to UNO! Here are the rules:");
        System.out.println(
                "*Every player starts with seven cards. \n*There are two piles: a draw pile and a discard pile.");
        System.out.println(
                "*Your goal is to get rid of all your cards by playing one card at a time in the discard pile. \n*You can play a card if it matches the previously played card in either color, number, or action.");
        System.out.println("*When you are at one card left, shout \"UNO!\", otherwise you must draw another card.");
        // create Scanner object
        Scanner userInput = new Scanner(System.in);
        System.out.println("****************");
        //ask user if they accept rules
        System.out.println("Do you accept these rules?");
        System.out.println("Type any key (+ enter) to continue or 'QUIT' to exit the game");

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
        // add cards to pile
        deckInstance.playablePile = deckInstance.initializeDeck();
        // shuffle deck
        deckInstance.shuffle(deckInstance.playablePile);

        // get number of players
        do {
            Scanner userInput = new Scanner(System.in);
            System.out.println("How many people will be playing? (2-10 allowed): ");
            // get user input
            inputVal = userInput.nextInt();
            mainGame.setPlayerCount(inputVal);
            players = new Player[mainGame.getPlayerCount()];
        } while (inputVal < 2 || inputVal > 10);

        // create players and deal
        for (int i = 0; i < mainGame.getPlayerCount(); i++) {
            // create card hand for player
            ArrayList<Card> tempHand = new ArrayList<>();

            /*
             * add "shout UNO" card to deck
             * this card always stays in deck
             * can only be played when one card (two counting this one) are left
             */
            tempHand.add(new DeclareUno());

            // fill hand with 7 cards
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

    /**
     * 
     * @return Validity state
     * @param index number input by user
     * @param currentCard card to be played on (on top of deck)
     */
    public static Validity checkValidity(int index, Card currentCard) {
        Validity validityState;
        //check to see if index entered is a valid choice
        if (index >= lowestPossibleIndex && index <= highestPossibleIndex){
            validityState = Validity.VALIDINPUT;

            //if is valid, check to see if compatable with card (number/title/color)
            if ((players[currentPlayer.getArrayPosition()].getPlayerHand().get(index).getColor() == currentCard.getColor()) || players[currentPlayer.getArrayPosition()].getPlayerHand().get(index).getTitle() == currentCard.getTitle()) {
                validityState = Validity.COMPATABLE;
            }
        }


        return validityState;
    }

    public static void getBorderValues(Player currentPlayer) {
        highestPossibleIndex = currentPlayer.getPlayerHand().size(); //stores the number of cards in the hand
        lowestPossibleIndex = currentPlayer.getPlayerHand().size() == 1 ? 0 : 1; //stores one if uno cannot be declared, 0 if it can (lets DECLARE UNO be displayed)
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

    public static boolean getGameDirection() {
        return gameDirection;
    }

    public static boolean toggleGameDirection() {
        gameDirection = !gameDirection;
        return gameDirection;
    }

    enum Validity {
        COMPATABLE, //number chosen is valid and card is playable
        VALIDINPUT, //number chosen is valid, but card cannot be played
        INVALID //invalid choice
    }
}
