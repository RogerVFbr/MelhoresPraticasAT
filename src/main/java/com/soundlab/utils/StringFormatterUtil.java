package com.soundlab.utils;

import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class StringFormatterUtil {

    public static String getFormatted(String value, String pattern) {
        try {
            String numericOnly = value.replaceAll("\\D+","");
            MaskFormatter formatter = new MaskFormatter(pattern);
            formatter.setValueContainsLiteralCharacters(false);
            return formatter.valueToString(numericOnly);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
//        System.out.println(value + " " + pattern);
//        String numericOnly = value.replaceAll("\\D+","");
//        return new DecimalFormat(pattern).format(numericOnly);
    }
}
