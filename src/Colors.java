package src;

public enum Colors {
    //color enum instances
    RED("Red", Colors.ANSI_RED),
    BLUE("Blue", Colors.ANSI_BLUE),
    GREEN("Green", Colors.ANSI_GREEN),
    YELLOW("Yellow", Colors.ANSI_YELLOW),
    WILD("Wild", Colors.ANSI_CYAN);

    //enum values
    private final String label;
    private final String textColor;

    /* START TERMINAL COLOR CONSTANTS */
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    /* END TERMINAL COLOR CONSTANTS */

    private Colors(String label, String textColor) {
        this.label = label;
        this.textColor = textColor;
    }

    @Override
    public String toString() {
        return label;
    }

    public String getTextColor() {
        return textColor;
    }

    public static String getAnsiReset() {
        return ANSI_RESET;
    }

    public static String getAnsiPurple() {
        return ANSI_PURPLE;
    }
}