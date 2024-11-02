package com.dduongdev.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static Pattern pattern = null;
    private static Matcher matcher = null;

    public static boolean isYOE(double yoe) {
        return (yoe > 0.0 && yoe < 100.0);
    }

    public static boolean isBirthdate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.BIRTHDATE_PATTERN);
        try {
            LocalDate.parse(date, formatter);
            return true;
        }
        catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isPhone(String phone) {
        pattern = Pattern.compile(Constants.PHONE_PATTERN);
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean isEmail(String email) {
        pattern = Pattern.compile(Constants.EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
