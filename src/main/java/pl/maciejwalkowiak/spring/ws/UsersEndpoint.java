package pl.maciejwalkowiak.spring.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pl.maciejwalkowiak.springws.demo.GetUserRequest;
import pl.maciejwalkowiak.springws.demo.GetUserResponse;
import pl.maciejwalkowiak.springws.demo.User;

@Endpoint
public class UsersEndpoint {
    private static final String NAMESPACE_URI = "http://maciejwalkowiak.pl/springws/demo";

    private DateTimeService dateTimeService;

    @Autowired
    public UsersEndpoint(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        User user = new User();
        user.setReputation(100);
        user.setUsername(dateTimeService.currentTime());

        GetUserResponse response = new GetUserResponse();
        response.getUsers().add(user);

        return response;
    }
}
