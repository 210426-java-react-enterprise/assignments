package com.revature.project0.screens;

import com.revature.project0.daos.UserDAO;
import com.revature.project0.models.AppUser;
import com.revature.project0.util.ScreenRouter;

import java.io.BufferedReader;

public class RegisterScreen extends Screen {

    //TODO: cleanup this gross thing
    private UserDAO userDAO = new UserDAO();
    private BufferedReader consoleReader;
    private ScreenRouter router;

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router){
        super("RegisterScreen", "/register");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    //TODO: make this save inputted information to UserDAO
    public void render() {

        String username;//PK for user, FK for account
        String password;
        String firstName;
        String lastName;
        String email;
        String address;
        String city;
        String state;
        //String phone;
        //int age;
        //String zipcode;
        String accountID;//PK for account, FK for user

        //username and accountID must be unique

        try {
            System.out.println("Register for a new account!");
            System.out.println("+-------------------------+");

            //System.out.print("Age: ");
            //age = consoleReader.readLine();

            //TODO: ensure this is unique, and at least 3 char
            System.out.print("Username: ");
            username = consoleReader.readLine();

            //TODO: ensure at least 7 char, and repeat this to ensure user uses correct password
            System.out.print("Password: ");
            password = consoleReader.readLine();

            //TODO: ensure at least 3 char
            System.out.print("First name: ");
            firstName = consoleReader.readLine();

            //TODO: ensure at least 3 char
            System.out.print("Last name: ");
            lastName = consoleReader.readLine();

            //TODO: ensure at least 1 char before an @ char
            System.out.print("Email: ");
            email = consoleReader.readLine();

            //TODO: ensure first 3 char are digits
            System.out.print("Address: ");
            address = consoleReader.readLine();

            System.out.print("City: ");
            city = consoleReader.readLine();

            //TODO: ensure 2 char
            System.out.print("State (2 letters only): ");
            state = consoleReader.readLine();

            //TODO: ensure 5 digits
            //System.out.print("Zipcode: ");
            //zipcode = consoleReader.readLine();

            //TODO: ensure proper format
            //System.out.print("Phone: ");
            //phone = consoleReader.readLine();

            AppUser newUser = new AppUser(username, firstName, lastName, email,
                    address, city, state/*, zipcode, phone*/);

            System.out.println("Created user: " + newUser.toString());

            userDAO.save(newUser);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
