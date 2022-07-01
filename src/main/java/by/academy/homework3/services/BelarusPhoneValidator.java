package by.academy.homework3.services;

public class BelarusPhoneValidator implements Validator {

    private final String PATTERN_BLRS_NUMBER = "^((\\+375))([\\- ]\\(?\\d{2}\\)?[\\- ]?)?[\\d\\- ]{7,9}$";

    public boolean validate(String phone_number) {
        return Validator.validate(phone_number, PATTERN_BLRS_NUMBER);
    }
}
