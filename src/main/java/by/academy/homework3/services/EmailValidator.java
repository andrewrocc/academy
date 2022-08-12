package by.academy.homework3.services;

import java.util.regex.Pattern;

public class EmailValidator implements Validator {

    private static final Pattern PATTERN_EMAIL = Pattern.compile("^(?=.{6,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

    @Override
    public Pattern getPattern() {
        return PATTERN_EMAIL;
    }
}
