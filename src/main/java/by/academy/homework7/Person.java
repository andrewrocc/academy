package by.academy.homework7;

import java.time.LocalDate;

class Person {

    //region fields
    private String firstName;

    private String lastName;

    private short age;

    private LocalDate birthDate;
    //endregion

    public Person() { super(); }

    public Person(String firstName, String lastName, short age, LocalDate birthDate) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
    }

    //region prop
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    //endregion
}
