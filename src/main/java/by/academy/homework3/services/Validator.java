package by.academy.homework3.services;

interface Validator {

    static boolean validate(String value, String patter) {
        return value.matches(patter);
    }
}
