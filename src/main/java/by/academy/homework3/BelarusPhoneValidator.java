package by.academy.homework3;

class BelarusPhoneValidator implements Validator {

    private final String PATTERN_BLRS_NUMBER = "^((\\+375))([\\- ]\\(?\\d{2}\\)?[\\- ]?)?[\\d\\- ]{7,9}$";

    public boolean validate(String phone_number) {
        return phone_number.matches(PATTERN_BLRS_NUMBER);
    }
}
