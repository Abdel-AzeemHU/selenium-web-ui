package com.qabot;

import com.github.javafaker.Faker;
import com.qabot.utils.DataFaker;
import org.testng.annotations.Test;

import java.util.Map;


public class FakerTest extends MasterTest {
    @Test
    void testFaker() {
        DataFaker dataFaker = DataFaker.getInstance();
        Faker faker = dataFaker.getRandom();
        Map<DataFaker.SomeDate,Integer> date = dataFaker.getBirthDateForAgeBetween(10,40);
        System.out.println("Random birthdate for someone aged between 10 to 40");
        System.out.println("Day: " + date.get(DataFaker.SomeDate.DAY));
        System.out.println("Month: " + date.get(DataFaker.SomeDate.MONTH) );
        System.out.println("Year: " + date.get(DataFaker.SomeDate.YEAR) );

        System.out.println("Date in the future");
        Map<DataFaker.SomeDate,Integer> futureDate = dataFaker.randomFutureDate();
        System.out.println("Day: " + futureDate.get(DataFaker.SomeDate.DAY));
        System.out.println("Month: " + futureDate.get(DataFaker.SomeDate.MONTH));
        System.out.println("Year: " + futureDate.get(DataFaker.SomeDate.YEAR));

        System.out.println("Random names");
        System.out.println( faker.name().fullName() );
        System.out.println( faker.name().fullName() );
        System.out.println( faker.name().fullName() );

        System.out.println("Random birthdate for someone aged between 15 to 30");
        date = dataFaker.getBirthDateForAgeBetween(15,30);
        System.out.println("Day: " + date.get(DataFaker.SomeDate.DAY));
        System.out.println("Month: " + date.get(DataFaker.SomeDate.MONTH) );
        System.out.println("Year: " + date.get(DataFaker.SomeDate.YEAR) );
    }
}
