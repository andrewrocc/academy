package by.academy.homework3.services;

public class AmericanPhoneValidator implements Validator {

    public boolean validate(String phone_number) {
        String PATTERN_AMERICAN_NUMBER = "^(\\+1{1,3}( )?)((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$";
        return phone_number.matches(PATTERN_AMERICAN_NUMBER);
    }
}
