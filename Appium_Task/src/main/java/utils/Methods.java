package utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Methods {

    private static final DateTimeFormatter FORMATTER_12H = DateTimeFormatter.ofPattern("hh:mm a");


    public String getNowTimeFormat12(){
        LocalTime now = LocalTime.now().withMinute(0).withSecond(0).withNano(0);
        String hour12 = now.format(FORMATTER_12H);
        return hour12;
    }

    public String getNowTimeFormat24(){
        LocalTime now = LocalTime.now().withMinute(0).withSecond(0).withNano(0);
        String hour24 = now.format(DateTimeFormatter.ofPattern("HH:mm"));
        return hour24;

    }
}
