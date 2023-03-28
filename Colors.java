public enum Colors {
    RED("Red"),
    BLUE("Blue"),
    GREEN("Green"),
    YELLOW("Yellow"),
    WILD("Wild");

    private final String label;

    private Colors(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}