package com.github.francoisdorval.asteroidapi.unit;

import com.github.francoisdorval.asteroidapi.util.DateUtil;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class DateUtilTest {

    @Test
    public void test_Yesterday_has_Correct_year(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String s = DateUtil.yesterdayAsString();
        assertThat(s).startsWith(year+"toto");
    }
}
