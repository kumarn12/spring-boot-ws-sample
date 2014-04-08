package pl.maciejwalkowiak.spring.ws;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateTimeService {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public String currentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        return sdf.format(new Date());
    }
}
