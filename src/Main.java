package src;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import Cards.*;

public class Main {
    static Game mainGame = new Game();
    static Player[] players;
    static int[] playerScores;
    static Deck deckInstance = new Deck();
    static boolean hasWinner = false;
    static boolean gameDirection = true;
    static int highestPossibleIndex = 7;
    static Player currentPlayer;
    static Card nextCard;
    static Card tempCard;

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
            do {
                // draw card from main pile, place in discard pile (face up)
                deckInstance.discardPile.add(deckInstance.drawCard(deckInstance.playablePile, 0));
                nextCard = deckInstance.discardPile.get(x);
                x++;
            } while (nextCard.getColor() == Colors.WILD || nextCard.getTitle() == "Skip"
                    || nextCard.getTitle() == "Reverse" || nextCard.getTitle() == "Draw 2"); // ensures first card is not a wild card
            System.out.println("**The first card is a " +nextCard.getColor().getTextColor() + nextCard.toString() +Colors.getAnsiReset() +"**");

            // play game
            playRound(nextCard);

            //display winner once game is over
            gameOver(currentPlayer);
        } else {
            System.out.println("Goodbye");
        }
    }

    public static void playRound(Card nextCard) {
        // loop through each player
        currentPlayer = players[0];
        while (!hasWinner) {
            getBorderValues(currentPlayer);
            // display cards that can be played

            if (nextCard.getTitle().contains("Wild")) {
                System.out.println("" + currentPlayer.getName() + ", please pick the number of a card to play [ must be " +nextCard.getColor().getTextColor() +nextCard.getColor().toString() +Colors.getAnsiReset() +" ]: ");
            } else {
                System.out.println(currentPlayer.getName() + ", please pick a card that matches " +nextCard.getColor().getTextColor() + nextCard.toString() +Colors.getAnsiReset() + ".");
            }

            for (int c = 0; c < highestPossibleIndex; c++) {
                // display card
                System.out.print("[" + c + "] " +currentPlayer.getPlayerHand().get(c).getColor().getTextColor() + currentPlayer.getPlayerHand().get(c).toString() +Colors.getAnsiReset()  +" ");
            }

            // return line
            System.out.println();

            /* get card chosen and check validity */
            Scanner sc = new Scanner(System.in);
            int chosenCardIndex = 1; // default value
            boolean go = true; //value for determining if input is invalid

            // check validity
            while (go) {
                chosenCardIndex = sc.nextInt();
                switch (checkValidity(chosenCardIndex, nextCard)) {
                    // if matches and can be played
                    case COMPATABLE:
                        tempCard = players[currentPlayer.getArrayPosition()].getPlayerHand().get(chosenCardIndex); //checks if card is draw, if it is, don't change nextCard
                        if (tempCard.getTitle() != "DRAW A CARD" && tempCard.getTitle() != "Forgot 'UNO'") {
                            nextCard = tempCard;
                            //if card chosen is not draw 1 or uno violation
                            System.out.println("**" + currentPlayer.getName() + " chose " +nextCard.getColor().getTextColor() + nextCard.toString() +Colors.getAnsiReset() + ".**");
                        }else{
                            //if card chosen is draw one or uno violation
                            System.out.println("**" + currentPlayer.getName() + " chose " +tempCard.getColor().getTextColor() + tempCard.toString() +Colors.getAnsiReset() + ".**");
                        }
                        
                        go = false;
                        break;

                    // if card cannot be played (doesn't match in color/title etc)
                    case VALIDINPUT:
                        System.out.println("That card cannot be played.");
                        if (nextCard.getTitle().contains("Wild")) {
                            System.out.println("Please pick a card that is " +nextCard.getColor().getTextColor() + nextCard.getColor().toString() +Colors.getAnsiReset() + ".");
                        } else {
                            System.out.println("Please pick a card that is either a " + nextCard.getTitle()
                                + " or is a " +nextCard.getColor().getTextColor() +nextCard.getColor().toString() +Colors.getAnsiReset() + ".");
                        }
                        go = true;
                        break;

                    // if card number is not an option
                    case INVALID:
                        System.out.println("" + currentPlayer.getName() + ", that's not a valid choice.");
                        System.out.println("Please pick a number between 0 & "
                                + highestPossibleIndex + ":");
                        go = true;
                        break;
                }
            }

            // take card from user, add to pile
            switch (tempCard.getTitle()) {
                case "Forgot 'UNO'":
                    // run process without discarding
                    currentPlayer = players[tempCard.doAction(currentPlayer.getArrayPosition())];
                    break;

                case "DRAW A CARD":
                    // run process witthout discarding
                    currentPlayer = players[tempCard.doAction(currentPlayer.getArrayPosition())];
                    break;

                default:
                    // run card action and discard card
                    Main.getDeckInstance().getDiscardPile().add(0,
                            players[currentPlayer.getArrayPosition()].getPlayerHand().remove(chosenCardIndex));

                    //check if this player wins
                    if (players[currentPlayer.getArrayPosition()].getPlayerHand().size() <= 2) {
                        hasWinner = true;
                    }else{
                        // get next player
                        currentPlayer = players[Main.getDeckInstance().getDiscardPile().get(0)
                                .doAction(currentPlayer.getArrayPosition())];

                        //set any wild card back to WILD
                        Card firstIndex = Main.getDeckInstance().getDiscardPile().get(1);
                        if (firstIndex.getTitle().contains("Wild")) {
                            firstIndex.setColor(Colors.WILD);
                        }
                        break;
                    }

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
        String rules = ""; //rules to display, read from file


        try {
            File rulesFile = new File("Rules.txt");  //file to containt rules to read from
            FileWriter fileWriter = new FileWriter(rulesFile); //FileWriter to add rules to file
            Scanner fileReader = new Scanner(rulesFile); //scanner to read from file

            //write rules to file
            fileWriter.write(Game.getRulePrintout());
            fileWriter.close();

            //read rules from file
            while (fileReader.hasNextLine()) {
                rules += fileReader.nextLine();
                rules += "\n";
            }

            //close reader
            fileReader.close();

        }catch (IOException e) {
            System.out.println("There was an error in writing/reading the file.");
            e.printStackTrace();
        }

        //print rules
        System.out.print(rules);

        // check for user input
        Scanner userInput = new Scanner(System.in);
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
             * add "forgot UNO" card to deck
             * this card always stays in deck
             * is played as a first card, then player picks another to play
             */
            tempHand.add(0, new ForgotUNO());
            /**
             * add DRAW A CARD card to deck
             * this card also always stays in deck
             * can be played at any point,
             * also used when player forgets to shout UNO
             */
            tempHand.add(1, new Draw1());

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

    public static void gameOver(Player winningPlayer) {
        //announce that the game is over
        System.out.println("********** GAME OVER **********");
        System.out.println("*****🎉🎉🎉 " +currentPlayer.getName() +" Wins! 🎉🎉🎉*****");
        //give each player's hand details
        for (int i = 0; i < mainGame.getPlayerCount(); i++) {
            if (i != currentPlayer.getArrayPosition()) {    //don't display the winner
                System.out.println("** " +players[i].getName() +" had " +(players[i].getPlayerHand().size()-2) +" cards left over. **");
            }
        }

        System.out.println("🥳 Congratulations " +currentPlayer.getName() +"! Thanks for playing, we hope you had fun!");
        System.out.println("To continue playing, please run the program again.");

    }

    /**
     * 
     * @return Validity state
     * @param index       number input by user
     * @param currentCard card to be played on (on top of deck)
     */
    public static Validity checkValidity(int index, Card currentCard) {
        Validity validityState;
        // check to see if index entered is a valid choice
        if (index >= 0 && index <= highestPossibleIndex) {
            validityState = Validity.VALIDINPUT;

            // if is valid, check to see if compatable with card (number/title/color)
            if ((players[currentPlayer.getArrayPosition()].getPlayerHand().get(index)
                    .getColor() == (currentCard.getColor())
                    || (players[currentPlayer.getArrayPosition()].getPlayerHand().get(index).getColor() == Colors.WILD))
                    || players[currentPlayer.getArrayPosition()].getPlayerHand().get(index).getTitle() == currentCard
                            .getTitle()) {
                validityState = Validity.COMPATABLE;
            }
        } else {
            validityState = Validity.INVALID;
        }

        return validityState;
    }

    public static void getBorderValues(Player currentPlayer) {
        highestPossibleIndex = currentPlayer.getPlayerHand().size(); // stores the number of cards in the hand
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
        COMPATABLE, // number chosen is valid and card is playable
        VALIDINPUT, // number chosen is valid, but card cannot be played
        INVALID, // invalid choice
    }
}
