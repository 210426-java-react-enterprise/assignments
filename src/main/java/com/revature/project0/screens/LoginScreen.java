package com.revature.project0.screens;

import com.revature.project0.daos.UserDAO;
import com.revature.project0.models.AppUser;
import com.revature.project0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class LoginScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private UserDAO userDAO = new UserDAO();//TODO: clean this ugly thing

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("LoginScreen", "/login");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    public void render() {
        System.out.println("Login to your account!");
        System.out.println("+-------------------------+");

        String username;
        String password;

        try {
            System.out.println("Enter username: ");
            username = consoleReader.readLine();

            System.out.println("Enter password: ");
            password = consoleReader.readLine();

            System.out.println("Locating user...");
            AppUser test = userDAO.findUserByUsernameAndPassword(username, password);

            if(test.getPassword().equals(password) && test.getUsername().equals(username)) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

        } catch (NullPointerException e) {
            System.out.println("User not found!");
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
