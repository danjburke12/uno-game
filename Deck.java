import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public static final int NUMBER_OF_WILD_CARDS = 4;
    public static final int NUMBER_OF_DRAW2_CARDS = 8;
    public static final int NUMBER_OF_DRAW4_CARDS = 4;
    public static final int NUMBER_OF_SKIP_CARDS = 8;
    public static final int TOTAL_NUMBER_OF_CARDS = 100;
    // 4 x Zero cards, 8 x 1-9 cards

    ArrayList<Card> discardPile = new ArrayList<>(); // cards discarded after play
    ArrayList<Card> playablePile = new ArrayList<>(TOTAL_NUMBER_OF_CARDS); // pile to draw from

    // constructor - creates new deck instance
    public Deck() {
        // add cards to playableDeck
        initializeDeck(playablePile);
        
    }

    /**
     * Draw Card Method
     * Handles drawing a card, and utlilizing discard pile if neccessary
     * @param deck deck from which to draw
     * @param index index in pile ArrayList from which to draw
     * @return card drawn
     */
    public Card drawCard(ArrayList<Card> pile, int index) {
        if (pile.size() > 0) {
            return pile.get(index);
        }else{
            //move discard pile into playable pile
            discardPile = shuffle(discardPile); 
            int size = discardPile.size();
            for (int i = 0; i < discardPile.size(); i++) {
                pile.set(i, discardPile.remove(size - i));
            }
            //draw
            return pile.get(index);
        }
    }


    // initialize deck: add neccessary cards
    public static void initializeDeck(ArrayList<Card> deck) {
        // create zero cards
        deck.add(new Card(0, Colors.RED));
        deck.add(new Card(0, Colors.YELLOW));
        deck.add(new Card(0, Colors.GREEN));
        deck.add(new Card(0, Colors.BLUE));
        // create one cards
        deck.add(new Card(1, Colors.RED));
        deck.add(new Card(1, Colors.YELLOW));
        deck.add(new Card(1, Colors.GREEN));
        deck.add(new Card(1, Colors.BLUE));
        deck.add(new Card(1, Colors.RED));
        deck.add(new Card(1, Colors.YELLOW));
        deck.add(new Card(1, Colors.GREEN));
        deck.add(new Card(1, Colors.BLUE));
        // create two cards
        deck.add(new Card(2, Colors.RED));
        deck.add(new Card(2, Colors.YELLOW));
        deck.add(new Card(2, Colors.GREEN));
        deck.add(new Card(2, Colors.BLUE));
        deck.add(new Card(2, Colors.RED));
        deck.add(new Card(2, Colors.YELLOW));
        deck.add(new Card(2, Colors.GREEN));
        deck.add(new Card(2, Colors.BLUE));
        // create three cards
        deck.add(new Card(3, Colors.RED));
        deck.add(new Card(3, Colors.YELLOW));
        deck.add(new Card(3, Colors.GREEN));
        deck.add(new Card(3, Colors.BLUE));
        deck.add(new Card(3, Colors.RED));
        deck.add(new Card(3, Colors.YELLOW));
        deck.add(new Card(3, Colors.GREEN));
        deck.add(new Card(3, Colors.BLUE));
        // create four cards
        deck.add(new Card(4, Colors.RED));
        deck.add(new Card(4, Colors.YELLOW));
        deck.add(new Card(4, Colors.GREEN));
        deck.add(new Card(4, Colors.BLUE));
        deck.add(new Card(4, Colors.RED));
        deck.add(new Card(4, Colors.YELLOW));
        deck.add(new Card(4, Colors.GREEN));
        deck.add(new Card(4, Colors.BLUE));
        // create five cards
        deck.add(new Card(5, Colors.RED));
        deck.add(new Card(5, Colors.YELLOW));
        deck.add(new Card(5, Colors.GREEN));
        deck.add(new Card(5, Colors.BLUE));
        deck.add(new Card(5, Colors.RED));
        deck.add(new Card(5, Colors.YELLOW));
        deck.add(new Card(5, Colors.GREEN));
        deck.add(new Card(5, Colors.BLUE));
        // create six cards
        deck.add(new Card(6, Colors.RED));
        deck.add(new Card(6, Colors.YELLOW));
        deck.add(new Card(6, Colors.GREEN));
        deck.add(new Card(6, Colors.BLUE));
        deck.add(new Card(6, Colors.RED));
        deck.add(new Card(6, Colors.YELLOW));
        deck.add(new Card(6, Colors.GREEN));
        deck.add(new Card(6, Colors.BLUE));
        // create seven cards
        deck.add(new Card(7, Colors.RED));
        deck.add(new Card(7, Colors.YELLOW));
        deck.add(new Card(7, Colors.GREEN));
        deck.add(new Card(7, Colors.BLUE));
        deck.add(new Card(7, Colors.RED));
        deck.add(new Card(7, Colors.YELLOW));
        deck.add(new Card(7, Colors.GREEN));
        deck.add(new Card(7, Colors.BLUE));
        // create eight cards
        deck.add(new Card(8, Colors.RED));
        deck.add(new Card(8, Colors.YELLOW));
        deck.add(new Card(8, Colors.GREEN));
        deck.add(new Card(8, Colors.BLUE));
        deck.add(new Card(8, Colors.RED));
        deck.add(new Card(8, Colors.YELLOW));
        deck.add(new Card(8, Colors.GREEN));
        deck.add(new Card(8, Colors.BLUE));
        // create nine cards
        deck.add(new Card(9, Colors.RED));
        deck.add(new Card(9, Colors.YELLOW));
        deck.add(new Card(9, Colors.GREEN));
        deck.add(new Card(9, Colors.BLUE));
        deck.add(new Card(9, Colors.RED));
        deck.add(new Card(9, Colors.YELLOW));
        deck.add(new Card(9, Colors.GREEN));
        deck.add(new Card(9, Colors.BLUE));
        // create wild cards
        for (int i = 0; i < NUMBER_OF_WILD_CARDS; i++) {
            deck.add(new Card(10, Colors.WILD));
        }
        // create skip cards
        deck.add(new Card(11, Colors.RED));
        deck.add(new Card(11, Colors.YELLOW));
        deck.add(new Card(11, Colors.GREEN));
        deck.add(new Card(11, Colors.BLUE));
        deck.add(new Card(11, Colors.RED));
        deck.add(new Card(11, Colors.YELLOW));
        deck.add(new Card(11, Colors.GREEN));
        deck.add(new Card(11, Colors.BLUE));
        // create Draw 2 cards
        deck.add(new Card(12, Colors.RED));
        deck.add(new Card(12, Colors.YELLOW));
        deck.add(new Card(12, Colors.GREEN));
        deck.add(new Card(12, Colors.BLUE));
        deck.add(new Card(12, Colors.RED));
        deck.add(new Card(12, Colors.YELLOW));
        deck.add(new Card(12, Colors.GREEN));
        deck.add(new Card(12, Colors.BLUE));
        // create Draw 4 cards
        deck.add(new Card(13, Colors.RED));
        deck.add(new Card(13, Colors.YELLOW));
        deck.add(new Card(13, Colors.GREEN));
        deck.add(new Card(13, Colors.BLUE));
    }

    /**
     * Shuffle method
     * @param deckToBeShuffled deck to be shuffled
     * @return shuffled deck sorted randomnly
     */
    public static ArrayList<Card> shuffle(ArrayList<Card> deckToBeShuffled) {
        //create Random object
        Random rn = new Random();
        //create empty array to put shuffled deck into
        ArrayList<Card> shuffledDeck = new ArrayList<>(deckToBeShuffled.size());
        for (int i = 0; i < shuffledDeck.size(); i++) {
            int index = rn.nextInt(shuffledDeck.size());
            //fill spot with card if empty
            while (shuffledDeck.get(index) == null) {
                //remove card from deck, add to shuffled deck
                shuffledDeck.set(index, deckToBeShuffled.remove(0));
                rn.nextInt(shuffledDeck.size());
            }
        }
        return shuffledDeck;
	} 

    // getters
    public ArrayList<Card> getDiscardPile() {
        return discardPile;
    }

    public ArrayList<Card> getPlayableDeck() {
        return playablePile;
    }
}
