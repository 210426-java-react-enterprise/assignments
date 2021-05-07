package com.revature.project0.models;

/*
Should this class be abstract, or have an
abstract class or interface to inherit from?

Dependent on AccountUser to exist
*/

public class Account {
    //private int accountID; //unique for sql table entry
    //private String accountName;
    private String accountOwner;//any username
    //private int accountOwnerID; //unique for sql table entry; foreign key
    private String password;//make it at least 5 characters in length
    private double balance;//restrict decimal digits to 2

    public Account(String accountOwner, String password, double balance){
        this.accountOwner = accountOwner;
        this.password = password;
        this.balance = balance;
    }

    /* accountOwner may make this unnecessary
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    */

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    //add constraint to this on sql table that prevents it from falling below 0
    public void withdraw(double amount) {
        this.balance -= amount;
    }
}
