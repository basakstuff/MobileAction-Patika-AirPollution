package com.air.pollution.util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DateUtil {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static String localDateToString(LocalDate date) {
        if (Objects.isNull(date)) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);

        return sdf.format(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }


    public static String unixDateToFormattedDate(Integer unixDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        Instant instant = Instant.ofEpochSecond(unixDate);
        return sdf.format(Date.from(instant));
    }

    public static Integer dateToUnixDate(Date date) {
        return Math.toIntExact(date.getTime() / 1000);
    }

    public static Integer stringDateToUnixDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        try {
            return Math.toIntExact(sdf.parse(date).getTime() / 1000);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date stringDateToDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<String> logDates(List<LocalDate> dates) {
        List<String> days = new ArrayList<>();

        String tempStart = "";
        String tempEnd = "";
        for (int i = 0; i < dates.size(); i++) {

            if ("".equals(tempStart)) {
                tempStart = dates.get(i).format(DateTimeFormatter.ofPattern(YYYY_MM_DD));
            }
            if ((i + 1) < dates.size() && dates.get(i).plusDays(1).equals(dates.get(i + 1))) {
                tempEnd = dates.get(i + 1).format(DateTimeFormatter.ofPattern(YYYY_MM_DD));
            } else {
                if (StringUtils.isEmpty(tempStart) && StringUtils.isEmpty(tempEnd)) {
                    continue;
                }
                if (tempEnd.equals("")) {
                    tempEnd = tempStart;
                }
                days.add(tempStart + " - " + tempEnd);
                tempStart = "";
                tempEnd = "";
            }
            if (1 + i > dates.size()) {
                if (tempEnd.equals("")) {
                    tempEnd = tempStart;
                }
                days.add(tempStart + " - " + tempEnd);
                break;
            }

        }
        return days;
    }

    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }


    public static List<LocalDate> datesFromToDate(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD);
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        List<LocalDate> dates = new ArrayList<>();
        while (!start.equals(end)) {
            dates.add(start);
            start = start.plusDays(1);
        }
        dates.add(end);
        return dates;
    }


    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    public static LocalDate addDay(LocalDate localDate, int date) {
        return localDate.plusDays(date);
    }

    public static LocalDate minusDay(LocalDate localDate, int date) {
        return localDate.minusDays(date);
    }

}
