package chapter11.stockmonitor

import org.springframework.http.*
import org.springframework.web.client.RestTemplate

/**
 * A very simple stock monitor class that polls a REST endpoint for a specific price quote.
 * It matches the stock's ask price against a list of users (modelled as just "alerts") who want to be
 * notified if thr price reaches a certain threshold, and notifies them by invoking another endpoint.
 */
class StockMonitor {
    def restTemplate = new RestTemplate()
    def alerts = [] as Set<StockPriceAlert>
    def hostname;

    StockMonitor(hostname) {
        this.hostname = hostname
    }

    public void pollMarket() {
        def headers = new HttpHeaders()
        headers.setAccept([MediaType.APPLICATION_JSON])

        HttpEntity<Price> entity = new HttpEntity<>(headers)
        ResponseEntity<Price> response = restTemplate.exchange("http://${hostname}/quotes?s=XYZ",
                HttpMethod.GET, entity, Price.class)
        alerts.findAll({ it.symbol == response.getBody().symbol && it.askPrice >= response.getBody().ask })
                .forEach {notify(it)}
    }

    void add(ContactInformation contactInformation, String stockSymbol, double askPrice) {
        alerts << new StockPriceAlert(contactInformation, stockSymbol, askPrice)
    }

    void notify(StockPriceAlert alert) {
        restTemplate.postForObject("http://${hostname}/alert", new Notification(alert.contactInformation,
                alert.symbol + " is cheap enough"), String.class)
    }
}
