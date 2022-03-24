public enum Messages
{
    // todo: change to static constants in ScrabbleGame
    DEFAULT(""),
    NOT_A_WORD("Not a valid word."),
    INSUFFICIENT_TILES("Word cannot be formed from current tiles."),
    IS_A_WORD("Success!");

    public final String label;

    private Messages(String label) {
        this.label = label;
    }
}
