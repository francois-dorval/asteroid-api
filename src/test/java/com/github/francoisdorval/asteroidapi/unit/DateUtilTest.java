package com.github.francoisdorval.asteroidapi.unit;

import com.github.francoisdorval.asteroidapi.util.DateUtil;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class DateUtilTest {

    @Test
    public void testYesterday(){
        int year = Calendar.getInstance().get(Calendar.YEAR);

        String s = DateUtil.yesterdayAsString();
    }
}
