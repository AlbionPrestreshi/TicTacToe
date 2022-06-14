public class Player {
    private final char symbol;

    public Player(final char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public String toString() {
        return "" + symbol;
    }

}

