public enum Color {
    RED("Red"),
    BLUE("Blue"),
    GREEN("Green"),
    YELLOW("Yellow"),
    WILD("Wild");

    private final String label;

    private Color(String label) {
        this.label = label;
    }
}