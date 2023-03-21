public class Card {
    public final int NUMBER_OF_WILD_CARDS = 4;
    public final int NUMBER_OF_EACH_DIGIT_CARDS = 8;
    public final int NUMBER_OF_ZERO_CARDS = 4;
    public final int NUMBER_OF_DRAW2_CARDS = 8;
    public final int NUMBER_OF_DRAW4_CARDS = 4;
    public final int NUMBER_OF_SKIP_CARDS = 8;

    private int value; // number on card (0-9, 10 = wild, 11 = skip, 12 = draw 2, 13 = draw 4)
    private Colors color; // color of card (red, green, blue, yellow, wild)

    public Card(Colors color, int value, ) {
        
    }

    public enum Colors {
        red,
        blue,
        green,
        yellow,
        wild
    }

}
