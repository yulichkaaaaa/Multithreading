package com.yuliana.multithreading.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    private static final String CORRECT_ELLIPSE_DATA = "^([1-9]|10)$";

    public static boolean isCorrectShip(String input) {
        Pattern pattern = Pattern.compile(CORRECT_ELLIPSE_DATA);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
