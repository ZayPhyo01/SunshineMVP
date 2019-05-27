package com.example.sunshine;

import org.junit.Test;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    @Test
    public void getTime() {
        Date date = Calendar.getInstance().getTime();
        date.setHours(0);
        System.out.println(date.getHours());
    }

}
