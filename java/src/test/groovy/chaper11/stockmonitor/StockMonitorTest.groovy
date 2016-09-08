package chaper11.stockmonitor

import chapter11.stockmonitor.ContactInformation
import chapter11.stockmonitor.StockMonitor
import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import spock.lang.Specification

import static com.github.tomakehurst.wiremock.client.WireMock.*

/**
 * This test uses the stubbing functionality of WireMock to create an
 * endpoint /quotes that will provide the a fictitious stock's (XYZ) price.
 * It then uses WireMock's interaction verification to ensure that another
 * endpoint /alert is invoked and that the monitoring user is notified.
 *
 * In retrospect, I feel that this test's setup is too complicated. A small improvement
 * would be to introduce setup section.
 */
class StockMonitorTest extends Specification {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule()

    def "Notify by email when a monitored stock reaches threshold"() {

        final double askPriceThreshold = 20.6;
        final String monitoredStock = "XYZ";

        given:
        def notificationReceiver = new ContactInformation(
                phoneNumber: '+1 202-555-0165',
                email: 'stockfan@test.local')

        stubFor(post(urlMatching("/.*"))
                .willReturn(aResponse().withStatus(200)));

        stubFor(get(urlPathEqualTo("/quotes"))
                .withHeader("Accept", equalTo("application/json"))
                .withQueryParam("s", equalTo(monitoredStock))
                .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("{\"symbol\": \"XYZ\", \"bid\": 20.2, "
                + "\"ask\": 20.6}")))
        and:
        def testedStockMonitor = new StockMonitor("localhost:8080")
        testedStockMonitor.add(notificationReceiver, monitoredStock,
                askPriceThreshold)

        when:
        testedStockMonitor.pollMarket()

        then:
        verify(postRequestedFor(urlEqualTo("/alert"))
                .withRequestBody(containing("stockfan@test.local"))
                .withRequestBody(containing(monitoredStock
                + " is cheap enough")))

    }
}
