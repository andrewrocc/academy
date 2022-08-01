package by.academy.homework3.model;

import by.academy.homework3.services.BelarusPhoneValidator;
import by.academy.homework3.services.EmailValidator;
import by.academy.homework3.services.ValidateDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class User {

    //region fields
    private String userName;

    private double userMoney;

    private LocalDate dateOfBirth;

    private String userEmail;

    private String userPhone;
    //endregion

    //region prop
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(double userMoney) {
        this.userMoney = userMoney;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    //endregion

    /**
     * <p>This class has private constructor because some parameters need to be checked
     *
     * @param dateOfBirth checkable value
     * @param userEmail   checkable value
     * @param userPhone   checkable value<p>
     */
    public User(String userName, double userMoney, LocalDate dateOfBirth, String userEmail, String userPhone) {
        this.userName = userName;
        this.userMoney = userMoney;
        this.dateOfBirth = dateOfBirth;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    /**
     * <p>This method checks the values and then creates a valid instance of the class
     *
     * @param dateOfBirth checkable value
     * @param userEmail   checkable value
     * @param userPhone   checkable value
     */
    public static User isValidDataFormat(String userName, double userMoney, String dateOfBirth, String userEmail, String userPhone) {       //LocalDate
        var isValidUserDate = new ValidateDateFormat().isValidateDate(dateOfBirth);
        var isValidUserEmail = new EmailValidator().validate(userEmail);
        var isValidUserPhone = new BelarusPhoneValidator().validate(userPhone);
        LocalDate dateParse = null;

        String[] dateFormatPatterns = {"dd-MM-yyyy", "dd-M-yyyy", "d-MM-yyyy", "d-M-yyyy",
                                        "dd/MM/yyyy", "dd/M/yyyy", "d/MM/yyyy", "d/M/yyyy"};

        for (int i = 0; i < dateFormatPatterns.length; i++) {
            if (dateParse == null) {
                try {
                    dateParse = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern(dateFormatPatterns[i]));
                } catch (DateTimeException ex) { }
            }
        }

        return (isValidUserDate & isValidUserEmail & isValidUserPhone) ? new User(userName, userMoney, dateParse, userEmail, userPhone) : null;
    }

    //region Overrides
    @Override
    public String toString() {
        return "User {" +
                "userName = '" + userName + '\'' +
                ", userMoney = " + userMoney +
                ", dateOfBirth = " + dateOfBirth +
                ", userEmail = " + userEmail +
                ", userPhone = " + userPhone +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Double.compare(user.userMoney, userMoney) == 0 && Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userMoney);
    }
    //endregion
}
