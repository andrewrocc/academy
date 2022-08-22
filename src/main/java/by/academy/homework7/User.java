package by.academy.homework7;

import java.time.LocalDate;

class User extends Person {

    //region fields
    private String login = "no set name";

    private String password = "no set password";

    public String email = "no set email";
    //endregion

    public User() { }

    public User(String firstName, String lastName, short age, LocalDate birthDate, String login,
                String password, String email) {
        super(firstName, lastName, age, birthDate);
        this.login = login;
        this.password = password;
        this.email = email;
    }

    private void printUserInfo() {
        System.out.println(getFirstName() + "\n" + getLastName()
                            + "\n" + getAge() + "\n" + getBirthDate()
                            + "\n" + getLogin() + "\n" + getEmail() + "\n" +
                password.replaceAll(password, "*".repeat(password.length())));
    }

    //region prop
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

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
