package by.academy.homework3.model;

import by.academy.homework3.services.BelarusPhoneValidator;
import by.academy.homework3.services.EmailValidator;

import java.util.Objects;

public class User {

    //region fields
    private String userName;

    private double userMoney;
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
    //endregion

    //region validate methods (email & phone)
    private boolean validatePhone(String phone) {
        BelarusPhoneValidator phoneValidator = new BelarusPhoneValidator();
        return phoneValidator.validate(phone);
    }

    private boolean validateEmail(String email) {
        EmailValidator emailValidator = new EmailValidator();
        return emailValidator.validate(email);
    }
    //endregion

    public User(String userName, double userMoney) {
        this.userName = userName;
        this.userMoney = userMoney;
    }

    //region Overrides
    @Override
    public String toString() {
        return "User {" +
                "userName = '" + userName + '\'' +
                ", userMoney = " + userMoney +
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
