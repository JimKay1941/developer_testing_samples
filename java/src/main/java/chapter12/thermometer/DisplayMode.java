package chapter12.thermometer;

public enum DisplayMode {
    CELSIUS("C"), FAHRENHEIT("F");

    private String symbol;

    DisplayMode(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
