package pl.maciejwalkowiak.spring.ws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {
    @Autowired
    @Qualifier("ws")
    private ServletRegistrationBean messageDispatcherServletRegistrationBean;

    @Test
    public void should_register_message_dispatcher_servlet() {
        assertThat(messageDispatcherServletRegistrationBean).isNotNull();
    }
}
