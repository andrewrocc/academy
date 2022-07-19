package by.academy.homework3.services;

public class EmailValidator implements Validator {

    @Override
    public boolean validate(String email) {
        String PATTERN_EMAIL = "^(?=.{6,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(PATTERN_EMAIL);
    }
}
