package by.academy.homework3.services;

import java.util.regex.Pattern;

public class AmericanPhoneValidator implements Validator {

    private static final Pattern PATTERN_AMERICAN_NUMBER = Pattern.compile("^(\\+1{1,3}( )?)((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");

    @Override
    public Pattern getPattern() {
        return PATTERN_AMERICAN_NUMBER;
    }
}
