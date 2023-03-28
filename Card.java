public abstract class Card {

    private Colors color = Colors.valueOf(null); // color of card (RED, GREEN, BLUE, YELLOW, WILD)
    private String title;

    /**
     * Constructor
     * 
     * @param cardColor enum type, color of the card
     */
    public Card(Colors cardColor) {
        color = cardColor;
    }

    public Colors getColor() {
        return color;
    }

    public String getTitle() {
        return title;
    }

    public abstract int doAction(int currentPlayer);
}
