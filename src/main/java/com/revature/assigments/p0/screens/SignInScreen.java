package com.revature.assigments.p0.screens;

import com.revature.assigments.p0.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;

public class SignInScreen extends Screen{

    //private UserDAO userDao = new UserDAO();
    private BufferedReader consoleReader;
    private UserService userService;

    public SignInScreen(BufferedReader consoleReader, UserService userService) {
        super("SignInScreen","/signIn");
        this.consoleReader = consoleReader;
        this.userService = userService;
    }

    @Override
    public void render() {

        try{
            System.out.println("      << Sign In your Account>>      ");
            System.out.println("-------------------------------------");

            System.out.print("First name: ");
            firstName = consoleReader.readLine();


        }catch(IOException e){

            e.printStackTrace(); // This is exception for readline method
        }


    }
}
