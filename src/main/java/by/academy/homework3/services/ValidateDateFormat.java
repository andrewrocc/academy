package by.academy.homework3.services;

public class ValidateDateFormat {

    public static final String DATE_PATTERN_FORMAT1 = "(0[1-9]|1\\d|2\\d|3[0-1]|[1-9])/(0[1-9]|1[0-2]|[1-9])/(\\d{4})";

    public static final String DATE_PATTERN_FORMAT2 = "(0[1-9]|1\\d|2\\d|3[0-1]|[1-9])-(0[1-9]|1[0-2]|[1-9])-(\\d{4})";

    public boolean isValidateDate(String date) {
//        String dateFormat = String.format("%td-%tm-%tY", date, date, date);
        boolean res_opt1 = date.matches(DATE_PATTERN_FORMAT1);
        boolean res_opt2 = date.matches(DATE_PATTERN_FORMAT2);
        return (res_opt1 || res_opt2);
    }
}
