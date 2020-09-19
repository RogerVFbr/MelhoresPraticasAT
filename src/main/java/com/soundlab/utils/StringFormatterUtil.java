package com.soundlab.utils;

import java.text.DecimalFormat;

public class StringFormatterUtil {

    public static String getFormatted(String value, String pattern) {
        String numericOnly = value.replaceAll("\\D+","");
        return new DecimalFormat(pattern).format(numericOnly);
    }
}
