package com.revature.project0.screens;

import com.revature.project0.daos.UserDAO;
import com.revature.project0.util.ScreenRouter;

import java.io.BufferedReader;

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
        System.out.println("Login screen under construction");
    }

    //TODO: implement this in place of render() when ready
    public void renderv2(){

    }

}
