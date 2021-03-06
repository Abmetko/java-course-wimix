package com.javc.date_time;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

public class DateTimeHomeWork {

    private static final String PATTERN_1 = "E, dd MMM yyyy HH:mm:ss";

    private static final String PATTERN_2 = "'Created: 'E MMM dd HH:mm:ss z yyyy";//экранирование 'символов'

    public static String getCurrentTimeInPattern(String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }

    public static String getCurrentTimeInPatternIncreasedInMinutes(String pattern, int minutes) {
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(minutes);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(localDateTime);
    }

    public static String getCurrentTimeInPatternInTimeZone(String pattern, String timeZone) {
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of(timeZone));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(zonedDateTime);
    }

    public static boolean validateDateFormat(String pattern, String dateToValidate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern, Locale.US);//for AM/PM instead of am/pm
        try {
            dateTimeFormatter.parse(dateToValidate);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean validateDateFormat2(String pattern) {
        LocalDateTime date = LocalDateTime.now().minusHours(12);

        try {
            System.out.println(date.format(DateTimeFormatter.ofPattern(pattern)));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(getCurrentTimeInPattern(PATTERN_1));
        System.out.println(getCurrentTimeInPatternIncreasedInMinutes(PATTERN_1, 10));
        System.out.println(getCurrentTimeInPatternInTimeZone(PATTERN_1, "Europe/Berlin"));
        System.out.println(validateDateFormat(PATTERN_2,"Created: Mon Dec 27 21:28:32 MSK 2021"));
        System.out.println(validateDateFormat("'Last edited' MMM dd, yyyy, h:mm a", "Last edited Jan 20, 2022, 4:19 PM"));

//       validateDateFormat2("MMM dd, yyyy, h:mm a");
    }
}