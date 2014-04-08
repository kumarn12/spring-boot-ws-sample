package pl.maciejwalkowiak.spring.ws;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

@Configuration
@ImportResource("ws-context.xml")
public class WebServiceConfig {
    @Bean(name = "ws")
    public ServletRegistrationBean messageDispatcherServlet(@Lazy WebApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet(applicationContext);
        servlet.setTransformWsdlLocations(true);
        servlet.setTransformSchemaLocations(true);

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "/ws/*");

        return servletRegistrationBean;
    }
}
