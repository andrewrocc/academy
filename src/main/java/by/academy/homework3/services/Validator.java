package by.academy.homework3.services;

import java.util.regex.Pattern;

interface Validator {

    default boolean validate(String message) {
        return getPattern().matcher(message).matches();
    }

    Pattern getPattern();
}
