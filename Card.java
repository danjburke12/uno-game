public class Card {

    private int value; // number on card (0-9, 10 = wild, 11 = skip, 12 = draw 2, 13 = draw 4)
    private Color color = Color.valueOf(null); // color of card (RED, GREEN, BLUE, YELLOW, WILD)
    private String title;

    /**
     * Constructor
     * 
     * @param cardColor enum type, color of the card
     * @param cardID    value of card, method for identifying card
     */
    public Card(int cardID, Color cardColor) {
        value = cardID;
        color = cardColor;

        // assign title to card based on number (certain numbers indicate actions,
        // rather than digit values)
        switch (value) {
            case 10:
                title = "Wild";
                break;
            case 11:
                title = "Skip";
                break;
            case 12:
                title = "Draw 2";
                break;
            case 13:
                title = "Draw 4";
                break;
            default:
                title = "" + value;

        }
    }

    @Override
    public String toString() {
        // displays card information
        return "" + color.toString() + " - " + title;
    }

    /* getters and setters */
    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public String getTitle() {
        return title;
    }
}
