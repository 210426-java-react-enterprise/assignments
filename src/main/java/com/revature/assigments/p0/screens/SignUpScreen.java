package com.revature.assigments.p0.screens;

import com.revature.assigments.p0.models.AppUser;
import com.revature.assigments.p0.services.UserService;
import com.revature.assigments.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class SignUpScreen extends Screen{

    //private UserDAO userDao = new UserDAO();
    private BufferedReader consoleReader;
    private UserService userService;

    public SignUpScreen(BufferedReader consoleReader, UserService userService) {
        super("SignUpScreen","/signUp");
        this.consoleReader = consoleReader;
        this.userService = userService;
    }

    @Override
    public void render() {

        String firstName;
        String lastName;
        String email;
        String username;
        String password;

        try{
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
            userService.signUp(newUser);

            this.render();

        }catch(IOException e){
            e.printStackTrace(); // This is exception for readline method
        }



    }
}
