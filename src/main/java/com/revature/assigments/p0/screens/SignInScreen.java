package com.revature.assigments.p0.screens;

import com.revature.assigments.p0.models.AppUser;
import com.revature.assigments.p0.services.UserService;
import com.revature.assigments.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class SignInScreen extends Screen{

    private BufferedReader consoleReader;
    private UserService userService;
    private ScreenRouter router;

    public SignInScreen(BufferedReader consoleReader, UserService userService) {
        super("SignInScreen","/signIn");
        this.consoleReader = consoleReader;
        this.userService = userService;
    }

    @Override
    public void render() {

        String username;
        String password;


        try{

            System.out.println("            << Sign In >>            ");
            System.out.println("-------------------------------------");

            System.out.print("Username: ");
            username = consoleReader.readLine();

            System.out.print("Passoword: ");
            password = consoleReader.readLine();

            AppUser currentUser = userService.signIn(username,password);
            if (currentUser!= null){
                System.out.println("Login successfull!");
                router.navigate("/transaction");
            }else{
                System.out.println("The email or password is incorrect.");
            }


        }catch(IOException e){

            e.printStackTrace(); // This is exception for readline method
        }


    }
}
