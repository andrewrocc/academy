package by.academy.homework3.services;

public class BelarusPhoneValidator implements Validator {

    public boolean validate(String phone_number) {
        String PATTERN_BLRS_NUMBER = "^((\\+375))([\\- ]\\(?\\d{2}\\)?[\\- ]?)?[\\d\\- ]{7,9}$";
        return phone_number.matches(PATTERN_BLRS_NUMBER);
    }
}
