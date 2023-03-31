package Cards;
import src.*;

public abstract class Card {
    /* abstract class card
     * all card types are subclasses of this class
     */

    private Colors color; // color of card (RED, GREEN, BLUE, YELLOW, WILD)
    private String title;

    /**
     * Constructor
     * 
     * @param cardColor enum type, color of the card
     */
    public Card(Colors cardColor, String title) {
        this.color = cardColor;
        this.title = title;
    }

    public Colors getColor() {
        return color;
    }

    public String getTitle() {
        return title;
    }

    /**
     * Performs the designated/neccessary action(s) for a card
     * 
     * @param currentPlayer current player
     * @return next player
     */
    public abstract int doAction(int currentPlayer);

    /**
     * toString method
     * @return Card title formatted as: Title (Color)
     */
    @Override
    public String toString() {
        return "" + getTitle() +" (" +getColor().toString() + ")";

    }
}
