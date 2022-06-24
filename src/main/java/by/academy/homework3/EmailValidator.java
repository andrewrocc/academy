package by.academy.homework3;

class EmailValidator implements Validator {

    private final String PATTERN_EMAIL = "^(?=.{6,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public boolean validate(String email) {
        return email.matches(PATTERN_EMAIL);
    }
}
