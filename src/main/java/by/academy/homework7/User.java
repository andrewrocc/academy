package by.academy.homework7;

import java.time.LocalDate;

class User extends Person {

    //region fields
    private String login = "no set user name";

    private String password = "null admin";

    private String email = "null email";
    //endregion

    public User() { super(); }

    public User(String firstName, String lastName, short age, LocalDate birthDate, String login,
                String password, String email) {
        super(firstName, lastName, age, birthDate);
        this.login = login;
        this.password = password;
        this.email = email;
    }

    private void printUserInfo() {
        System.out.println(getFirstName() + " " + getLastName()
                            + " " + getAge() + " " + getBirthDate()
                            + " " + this.login + " " + this.email +
                password.replaceAll(password, "*".repeat(password.length())));
    }

    //region prop
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //endregion
}
