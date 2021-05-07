package com.revature.project0;

//import java.util.Formatter;//used to format doubles to only have 2 decimals

import com.revature.project0.models.Account;
import com.revature.project0.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        //String name = "Thomas";
        double balance = 50.55;
        //Formatter twoDecimals = new Formatter();//format doubles to 2 decimals
        //twoDecimals.format("%.2f", balance);

        //Account myAccount = new Account()

        /*create AppState which will control screen/console, moving between:
        * Main Menu / Welcome Screen
        * Register Screen (create account)
        * Login Screen (login to account)
        * Account Screen (deposit/withdraw funds, view balance)
         */

        Account myAccount1 = new Account("Thomas", "password", balance);
        Account myAccount2 = new Account("Gex", "password", balance);
        Account myAccount3 = new Account("Ditto", "password", balance);
        Account myAccount4 = new Account("Mimic", "password", balance);
        Account myAccount5 = new Account("Copy", "password", balance);

        LinkedList myList = new LinkedList();

        myList.add(myAccount1);
        myList.add(myAccount2);
        myList.add(myAccount3);
        myList.add(myAccount4);
        myList.add(myAccount5);

        Account temp = new Account("t", "t", 50);

        for(int i = 0; i < myList.size(); i++) {
            temp = (Account) myList.get(i);
            System.out.println("Account " + i + ": " + temp.getAccountOwner());
        }


    }

}