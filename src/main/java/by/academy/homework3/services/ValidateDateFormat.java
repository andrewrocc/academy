package by.academy.homework3.services;

import java.time.LocalDate;

public class ValidateDateFormat {

    public static final String DATE_PATTERN_FORMAT1 = "(0[1-9]|1\\d|2\\d|3[0-1]|[1-9])/(0[1-9]|1[0-2]|[1-9])/(\\d{4})";

    public static final String DATE_PATTERN_FORMAT2 = "(0[1-9]|1\\d|2\\d|3[0-1]|[1-9])-(0[1-9]|1[0-2]|[1-9])-(\\d{4})";

    public boolean isValidateDate(LocalDate date) {
//        System.out.print("Enter the date format(dd/mm/yyyy) or (dd-mm-yyyy): ");
//        String date = scan.nextLine();
        String dateFormat = String.format("%td-%tm-%tY", date, date, date);
        boolean res_opt1 = dateFormat.matches(DATE_PATTERN_FORMAT1);
        boolean res_opt2 = dateFormat.matches(DATE_PATTERN_FORMAT2);
        return (res_opt1 || res_opt2);
    }
}
