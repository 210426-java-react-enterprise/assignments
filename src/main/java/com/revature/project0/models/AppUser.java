package com.revature.project0.models;

/*
Can exist independent of an Account, I guess.
"AppUser" better name than "AccountUser" because
technically using an app to login/create an account
 */

public class AppUser {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int id;//primary key for SQL table
    private int accountID;//foreign key for SQL table
    //would this need a password?  Probably not if the account itself requires the password

    public AppUser() {
        super();
    }

    //users normally don't start with an id or accoundID, particularly if registering for first time
    public AppUser(String username, String firstName, String lastName, String email, int age){
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    //just in case they do start with an id
    public AppUser(String username, String firstName, String lastName, String email, int age, int id){
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.id = id;
    }

    //just in case they start with an accountID too
    public AppUser(String username, String firstName, String lastName, String email, int age, int id, int accountID){
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.id = id;
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }


    //for when user's information needs to be conveniently outputted as a string
    //don't do this for id or accountID?
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountUser{");
        sb.append("username='").append(username).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
