package com.revature.assigments.p0.screens;

import com.revature.assigments.p0.models.AppUser;
import com.revature.assigments.p0.util.ScreenRouter;

import java.io.BufferedReader;

public class SignUpScreen extends Screen{

    private BufferedReader consoleReader;
    private ScreenRouter router;

    public SignUpScreen(String name, String route) {
        super("SignUpScreen","/signUpScreen");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    @Override
    public void render() {

        String firstName;
        String lastName;
        String email;
        String username;
        String password;

            System.out.println("    << Sign Up for a New Account>>   ");
            System.out.println("-------------------------------------");

            System.out.print("First name: ");
            firstName = consoleReader.readLine();

            System.out.print("Last name: ");
            lastName = consoleReader.readLine();

            System.out.print("Email: ");
            email = consoleReader.readLine();

            System.out.print("Username: ");
            username = consoleReader.readLine();

            System.out.print("Password: ");
            password = consoleReader.readLine();

            AppUser newUser = new AppUser(firstName,lastName,email,username,password);

            this.render();



    }
}
