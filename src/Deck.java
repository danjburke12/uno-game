package src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Cards.*;

public class Deck {
    public static final int NUMBER_OF_WILD_CARDS = 4;
    public static final int NUMBER_OF_DRAW2_CARDS = 8;
    public static final int NUMBER_OF_WILDDRAW4_CARDS = 4;
    public static final int NUMBER_OF_SKIP_CARDS = 8;
    public static final int NUMBER_OF_REVERSE_CARDS = 8;
    public static final int TOTAL_NUMBER_OF_CARDS = 100;

    // 4 x Zero cards, 8 x 1-9 cards

    public ArrayList<Card> discardPile = new ArrayList<>(); // cards discarded after play
    public ArrayList<Card> playablePile = new ArrayList<>(TOTAL_NUMBER_OF_CARDS); // pile to draw from

    // constructor - creates new deck instance
    public Deck() {
    }

    /**
     * Draw Card Method
     * Handles drawing a card, and utlilizing discard pile if neccessary
     * 
     * @param deck  deck from which to draw
     * @param index index in pile ArrayList from which to draw
     * @return card drawn
     */
    public Card drawCard(ArrayList<Card> pile, int index) {
        if (pile.size() > 0) {
            return pile.remove(index);
        } else {
            // move discard pile into playable pile
            discardPile = shuffle(discardPile);
            int size = discardPile.size();
            for (int i = 0; i < discardPile.size(); i++) {
                pile.set(i, discardPile.remove(size - i));
            }
            // draw
            return pile.get(index);
        }
    }

    // initialize deck: add neccessary cards
    public ArrayList<Card> initializeDeck() {
        //create temporary deck
        ArrayList<Card> deck = new ArrayList<>();
        Colors[] tempColors = {Colors.RED, Colors.YELLOW, Colors.GREEN, Colors.BLUE};

        // create zero cards
        for (Colors c : tempColors) {
            deck.add(new NumberCard(c, "0"));
        }

        //create one cards
        for (int i = 0; i < 2; i++){
            for (Colors c : tempColors) {
                deck.add(new NumberCard(c, "1"));
            }
        }

        //create two cards
        for (int i = 0; i < 2; i++){
            for (Colors c : tempColors) {
                deck.add(new NumberCard(c, "2"));
            }
        }

        //create three cards
        for (int i = 0; i < 2; i++){
            for (Colors c : tempColors) {
                deck.add(new NumberCard(c, "3"));
            }
        }    
        
        //create four cards
        for (int i = 0; i < 2; i++){
            for (Colors c : tempColors) {
                deck.add(new NumberCard(c, "4"));
            }
        } 

        //create five cards
        for (int i = 0; i < 2; i++){
            for (Colors c : tempColors) {
                deck.add(new NumberCard(c, "5"));
            }
        } 

        //create six cards
        for (int i = 0; i < 2; i++){
            for (Colors c : tempColors) {
                deck.add(new NumberCard(c, "6"));
            }
        } 

        //create seven cards
        for (int i = 0; i < 2; i++){
            for (Colors c : tempColors) {
                deck.add(new NumberCard(c, "7"));
            }
        } 

        //create eight cards
        for (int i = 0; i < 2; i++){
            for (Colors c : tempColors) {
                deck.add(new NumberCard(c, "8"));
            }
        } 

        //create nine cards
        for (int i = 0; i < 2; i++){
            for (Colors c : tempColors) {
                deck.add(new NumberCard(c, "9"));
            }
        } 

        //create skip cards
        for (int i = 0; i < (NUMBER_OF_SKIP_CARDS / 4); i++){
            for (Colors c : tempColors) {
                deck.add(new SkipCard(c));
            }
        } 

        //TODO: Create reverse cards

        //create draw2 cards
        for (int i = 0; i < (NUMBER_OF_DRAW2_CARDS / 4); i++){
            for (Colors c : tempColors) {
                deck.add(new Draw2(c));
            }
        }

        //create wild cards
        for (int i = 0; i < 4; i++) {
            deck.add(new WildCard());
        }

        //create wild draw4 cards
        for (int i = 0; i < 4; i++) {
            deck.add(new WildDraw4());
        }
    
        return deck;
    }

    /**
     * Shuffle method
     * 
     * @param deckToBeShuffled deck to be shuffled
     * @return shuffled deck sorted randomnly
     */
    public ArrayList<Card> shuffle(ArrayList<Card> deckToBeShuffled) {
        // create Random object
        Random rn = new Random();
        // create empty array to put shuffled deck into
        Card[] shuffledDeck = new Card[deckToBeShuffled.size()];
        for (int i = 0; i < deckToBeShuffled.size(); i++) {
            int index = rn.nextInt(deckToBeShuffled.size());
            // fill spot with card if empty
            while (shuffledDeck[index] == null) {
                // remove card from deck, add to shuffled deck
                shuffledDeck[index] = deckToBeShuffled.remove(0);
                rn.nextInt(shuffledDeck.length);
            }
        }
        return new ArrayList<Card>(Arrays.asList(shuffledDeck));
    }

    // getters
    public ArrayList<Card> getDiscardPile() {
        return discardPile;
    }

    public ArrayList<Card> getPlayablePile() {
        return playablePile;
    }

    //setters
    public void setPlayablePile(ArrayList<Card> playablePile) {
        this.playablePile = playablePile;
    }

    public void setDiscardPile(ArrayList<Card> discardPile) {
        this.discardPile = discardPile;
    }
}
