package org.example.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static final DateTimeFormatter dateParser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter dateTimeParser = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static LocalDate formatStringToLocalDate(String value) {
        return LocalDate.parse(value, dateParser);
    }

    public static LocalDateTime formatStringToLocalDateTime(String value) {
        return LocalDateTime.parse(value, dateTimeParser);
    }

    public static <T>String formatDateToString(T value){
        if(value instanceof LocalDate){
            return dateParser.format((LocalDate) value);
        }
        if(value instanceof LocalDateTime){
            return dateTimeParser.format((LocalDateTime) value);
        }
        throw new IllegalArgumentException("Valor de data inválido");
    }
}
