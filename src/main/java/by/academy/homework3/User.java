package by.academy.homework3;

class User {

    private String userName;

    private String dateOfBirth;

    private String phone;

    private String email;

    //region prop
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (validatePhone(phone)) {
            this.phone = phone;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (validateEmail(email)) {
            this.email = email;
        }
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

    public User(String userName, String dateOfBirth, String phone, String email) {
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;

        if (validatePhone(phone)) {
            this.phone = phone;
        } else {
            System.out.println("Incorrect birthday.");
        }

        if (validateEmail(email)) {
            this.email = email;
        } else {
            System.out.println("Incorrect email");
        }
    }

    @Override
    public String toString() {
        return "User { " +
                "userName= '" + userName + '\'' +
                ", dateOfBirth= " + dateOfBirth +
                ", phone= '" + phone + '\'' +
                ", email= '" + email + '\'' +
                " }";
    }

}
