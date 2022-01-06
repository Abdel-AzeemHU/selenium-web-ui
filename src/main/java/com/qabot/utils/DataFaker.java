package com.qabot.utils;

import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DataFaker {
    private static DataFaker me = null;
    private final Faker faker = new Faker();
    Calendar calendar = new GregorianCalendar();

    private DataFaker() { }
    public static DataFaker getInstance() {
        if (me == null) {
            me = new DataFaker();
        }
        return me;
    }

    public Faker getRandom() {
        return faker;
    }

    public Map<SomeDate, Integer> getBirthDateForAgeBetween(int min, int max) {
        Date date = faker.date().birthday(min, max);
        calendar.setTime(date);
        return Map.of(
                SomeDate.DAY, calendar.get(Calendar.DAY_OF_MONTH),
                SomeDate.MONTH, calendar.get(Calendar.MONTH)+1,
                SomeDate.YEAR, calendar.get(Calendar.YEAR)
        );
    }

    public Map<SomeDate, Integer> randomFutureDate() {
        Date date = faker.date().future(60, 4, TimeUnit.DAYS);
        calendar.setTime(date);
        return Map.of(
                SomeDate.DAY, calendar.get(Calendar.DAY_OF_MONTH),
                SomeDate.MONTH, calendar.get(Calendar.MONTH)+1,
                SomeDate.YEAR, calendar.get(Calendar.YEAR)
        );
    }

    public enum SomeDate {
        DAY, MONTH, YEAR
    }
}