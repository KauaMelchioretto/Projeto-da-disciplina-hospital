package org.example.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatter {
    public static final DateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
    public static final DateTimeFormatter dateTimeParser = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static Date formatStringToDate(String dateString) {
        try {
            return dateParser.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static LocalDateTime formatStringToDateTime(String dateTimeString) {
        return OffsetDateTime.parse(dateTimeString, isoFormatter);
    }

    public static String formatDateToString(Date date) {
        return dateParser.format(date);
    }
}
