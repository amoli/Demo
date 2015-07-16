package demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification;


/**
 * Created by e058811 on 7/16/2015.
 */
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = DemoApplication.class)
@WebAppConfiguration
@IntegrationTest
public class SpringBootIntegrationSpec extends Specification {
    @Autowired
    ApplicationContext context

    def "test context loads"() {
        expect:
        context != null
        context.containsBean("greetingController")
        context.containsBean("demoApplication")
    }
}
