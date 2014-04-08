package pl.maciejwalkowiak.spring.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {
    private DateTimeService dateTimeService;

    @Autowired
    public TimeController(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @RequestMapping("/time")
    public String time() {
        return dateTimeService.currentTime();
    }
}