package com.sample.jackson.util;

import java.time.LocalDate;
import java.time.Month;

public class CommonUtil {

    public static LocalDate convertToDate(int year, Month month, int data) {
        return LocalDate.of(year, month, data);
    }

}
