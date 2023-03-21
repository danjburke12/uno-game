import java.util.ArrayList;
public class Deck {
    public final int NUMBER_OF_WILD_CARDS = 4;
    public final int NUMBER_OF_EACH_DIGIT_CARDS = 8;
    public final int NUMBER_OF_ZERO_CARDS = 4;
    public final int NUMBER_OF_DRAW2_CARDS = 8;
    public final int NUMBER_OF_DRAW4_CARDS = 4;
    public final int NUMBER_OF_SKIP_CARDS = 8;


    ArrayList<Card> discardPile = new ArrayList<>(); //cards discarded after play
    ArrayList<Card> playableDeck = new ArrayList<>(); //pile to draw from

}
