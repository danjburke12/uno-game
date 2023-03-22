import java.util.ArrayList;

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

    // initialize deck: add neccessary cards
    public void initializeDeck(ArrayList<Card> deck) {
        // create zero cards
        deck.add(new Card(0, Color.RED));
        deck.add(new Card(0, Color.YELLOW));
        deck.add(new Card(0, Color.GREEN));
        deck.add(new Card(0, Color.BLUE));
        // create one cards
        deck.add(new Card(1, Color.RED));
        deck.add(new Card(1, Color.YELLOW));
        deck.add(new Card(1, Color.GREEN));
        deck.add(new Card(1, Color.BLUE));
        deck.add(new Card(1, Color.RED));
        deck.add(new Card(1, Color.YELLOW));
        deck.add(new Card(1, Color.GREEN));
        deck.add(new Card(1, Color.BLUE));
        // create two cards
        deck.add(new Card(2, Color.RED));
        deck.add(new Card(2, Color.YELLOW));
        deck.add(new Card(2, Color.GREEN));
        deck.add(new Card(2, Color.BLUE));
        deck.add(new Card(2, Color.RED));
        deck.add(new Card(2, Color.YELLOW));
        deck.add(new Card(2, Color.GREEN));
        deck.add(new Card(2, Color.BLUE));
        // create three cards
        deck.add(new Card(3, Color.RED));
        deck.add(new Card(3, Color.YELLOW));
        deck.add(new Card(3, Color.GREEN));
        deck.add(new Card(3, Color.BLUE));
        deck.add(new Card(3, Color.RED));
        deck.add(new Card(3, Color.YELLOW));
        deck.add(new Card(3, Color.GREEN));
        deck.add(new Card(3, Color.BLUE));
        // create four cards
        deck.add(new Card(4, Color.RED));
        deck.add(new Card(4, Color.YELLOW));
        deck.add(new Card(4, Color.GREEN));
        deck.add(new Card(4, Color.BLUE));
        deck.add(new Card(4, Color.RED));
        deck.add(new Card(4, Color.YELLOW));
        deck.add(new Card(4, Color.GREEN));
        deck.add(new Card(4, Color.BLUE));
        // create five cards
        deck.add(new Card(5, Color.RED));
        deck.add(new Card(5, Color.YELLOW));
        deck.add(new Card(5, Color.GREEN));
        deck.add(new Card(5, Color.BLUE));
        deck.add(new Card(5, Color.RED));
        deck.add(new Card(5, Color.YELLOW));
        deck.add(new Card(5, Color.GREEN));
        deck.add(new Card(5, Color.BLUE));
        // create six cards
        deck.add(new Card(6, Color.RED));
        deck.add(new Card(6, Color.YELLOW));
        deck.add(new Card(6, Color.GREEN));
        deck.add(new Card(6, Color.BLUE));
        deck.add(new Card(6, Color.RED));
        deck.add(new Card(6, Color.YELLOW));
        deck.add(new Card(6, Color.GREEN));
        deck.add(new Card(6, Color.BLUE));
        // create seven cards
        deck.add(new Card(7, Color.RED));
        deck.add(new Card(7, Color.YELLOW));
        deck.add(new Card(7, Color.GREEN));
        deck.add(new Card(7, Color.BLUE));
        deck.add(new Card(7, Color.RED));
        deck.add(new Card(7, Color.YELLOW));
        deck.add(new Card(7, Color.GREEN));
        deck.add(new Card(7, Color.BLUE));
        // create eight cards
        deck.add(new Card(8, Color.RED));
        deck.add(new Card(8, Color.YELLOW));
        deck.add(new Card(8, Color.GREEN));
        deck.add(new Card(8, Color.BLUE));
        deck.add(new Card(8, Color.RED));
        deck.add(new Card(8, Color.YELLOW));
        deck.add(new Card(8, Color.GREEN));
        deck.add(new Card(8, Color.BLUE));
        // create nine cards
        deck.add(new Card(9, Color.RED));
        deck.add(new Card(9, Color.YELLOW));
        deck.add(new Card(9, Color.GREEN));
        deck.add(new Card(9, Color.BLUE));
        deck.add(new Card(9, Color.RED));
        deck.add(new Card(9, Color.YELLOW));
        deck.add(new Card(9, Color.GREEN));
        deck.add(new Card(9, Color.BLUE));
        // create wild cards
        for (int i = 0; i < NUMBER_OF_WILD_CARDS; i++) {
            deck.add(new Card(10, Color.WILD));
        }
        // create skip cards
        deck.add(new Card(11, Color.RED));
        deck.add(new Card(11, Color.YELLOW));
        deck.add(new Card(11, Color.GREEN));
        deck.add(new Card(11, Color.BLUE));
        deck.add(new Card(11, Color.RED));
        deck.add(new Card(11, Color.YELLOW));
        deck.add(new Card(11, Color.GREEN));
        deck.add(new Card(11, Color.BLUE));
        // create Draw 2 cards
        deck.add(new Card(12, Color.RED));
        deck.add(new Card(12, Color.YELLOW));
        deck.add(new Card(12, Color.GREEN));
        deck.add(new Card(12, Color.BLUE));
        deck.add(new Card(12, Color.RED));
        deck.add(new Card(12, Color.YELLOW));
        deck.add(new Card(12, Color.GREEN));
        deck.add(new Card(12, Color.BLUE));
        // create Draw 4 cards
        deck.add(new Card(13, Color.RED));
        deck.add(new Card(13, Color.YELLOW));
        deck.add(new Card(13, Color.GREEN));
        deck.add(new Card(13, Color.BLUE));
    }

    /**
     * Shuffle method
     * @param deck deck to be shuffled
     * @return shuffled deck sorted randomnly
     */
    public static ArrayList<Card> shuffleDeck(ArrayList<Card> deck) {
        ArrayList<Card> shuffledDeck = new ArrayList<>();
        //TODO: add method to shuffle deck

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
