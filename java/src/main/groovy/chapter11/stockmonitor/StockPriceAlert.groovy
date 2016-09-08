package chapter11.stockmonitor

/**
 * Binds a user's contact information to a symbol and an ask price so that a notification
 * can be sent out.
 */
class StockPriceAlert {
    ContactInformation contactInformation
    String symbol
    double askPrice

    StockPriceAlert(ContactInformation contactInformation, String symbol, double askPrice) {
        this.contactInformation = contactInformation
        this.symbol = symbol
        this.askPrice = askPrice
    }
}
