package src;
public enum Colors {
    RED("Red", TerminalColors.ANSI_RED),
    BLUE("Blue", TerminalColors.ANSI_BLUE),
    GREEN("Green", TerminalColors.ANSI_GREEN),
    YELLOW("Yellow", TerminalColors.ANSI_YELLOW),
    WILD("Wild", TerminalColors.ANSI_CYAN);

    private final String label;
    private final String textColor;

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
}