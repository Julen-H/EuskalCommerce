package com.talde1.commerceapp.Converter;

import androidx.room.TypeConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Converters {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @TypeConverter
    public static String localDateTimeStr(LocalDateTime date){
        return date == null ? null : date.toString();
    }

    @TypeConverter
    public static LocalDateTime strLocalDateTime(String date){
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        return localDateTime;
    }
}

