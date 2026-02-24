package org.example.javacore.utils;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    public DateUtils() {
    }
    public static final String DATE_TIME_FORMAT_DD_MM_YYYY = "dd-MM-yyyy";

    public static String convertDateToString(Date date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .format(formatter);

    }

    public static String convertDateToString(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
