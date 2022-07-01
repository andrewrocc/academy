package by.academy.homework3.services;

public class EmailValidator implements Validator {

    private final String PATTERN_EMAIL = "^(?=.{6,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public boolean validate(String email) {
        return Validator.validate(email, PATTERN_EMAIL);
    }
}
