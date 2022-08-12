package by.academy.homework3.services;

import java.util.regex.Pattern;

public class BelarusPhoneValidator implements Validator {

    private static final Pattern PATTERN_BLRS_NUMBER = Pattern.compile("^((\\+375))([\\- ]\\(?\\d{2}\\)?[\\- ]?)?[\\d\\- ]{7,9}$");

    @Override
    public Pattern getPattern() {
        return PATTERN_BLRS_NUMBER;
    }
}
