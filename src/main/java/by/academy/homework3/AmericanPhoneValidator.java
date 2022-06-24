package by.academy.homework3;

class AmericanPhoneValidator implements Validator {

    private final String PATTERN_AMERICAN_NUMBER = "^(\\+1{1,3}( )?)((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$";

    public boolean validate(String phone_number) {
        return phone_number.matches(PATTERN_AMERICAN_NUMBER);
    }
}
