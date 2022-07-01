package by.academy.homework3.services;

public class AmericanPhoneValidator implements Validator {

    private final String PATTERN_AMERICAN_NUMBER = "^(\\+1{1,3}( )?)((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$";

    public boolean validate(String phone_number) {
        return Validator.validate(phone_number, PATTERN_AMERICAN_NUMBER);
    }
}
