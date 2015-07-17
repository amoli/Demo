package demo.hello

import demo.DemoApplication
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification
import spock.lang.Unroll;

/**
 * Created by e058811 on 7/15/2015.
 */
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = DemoApplication.class)
@WebAppConfiguration
@IntegrationTest
public class GreetingControllerSpec extends Specification {

    @Value('${local.server.port}')
    int port;

    RestTemplate restTemplate = new RestTemplate();

    void "testing Spock works"() {
        expect:
        true
    }

    @Unroll
    void "should return greeting"() {
        expect:
        restTemplate.getForObject("http://localhost:$port/greeting?name=$n", Greeting.class) == greeting

        where:
        n  || greeting
        "Amoli" || new Greeting(1L, "Hello, Amoli!")
        "there" || new Greeting(2L, "Hello, there!")
        "" ||  new Greeting(3L, "Hello, World!")

    }


}
