package by.academy.homework6;

import java.io.Serial;
import java.io.Serializable;

class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 01010L;

    private String userName;

    private String userSurname;

    private short age;

    public User(String userName, String userSurname, short age) {
        super();
        this.userName = userName;
        this.userSurname = userSurname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "userName = '" + userName + '\'' +
               ", userSurname = '" + userSurname + '\'' +
               ", age = " + age;
    }

    //region prop
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }
    //endregion
}
