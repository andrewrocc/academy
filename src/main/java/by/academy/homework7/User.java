package by.academy.homework7;

import java.time.LocalDate;
import java.util.Objects;

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
        System.out.println("[ " + getFirstName() + ", " + getLastName()
                            + ", " + getAge() + ", " + getBirthDate()
                            + ", " + getLogin() + ", " + getEmail() + ", " +
                password.replaceAll(password, "*".repeat(password.length())) + " ]");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!Objects.equals(login, user.login)) return false;
        if (!Objects.equals(password, user.password)) return false;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
