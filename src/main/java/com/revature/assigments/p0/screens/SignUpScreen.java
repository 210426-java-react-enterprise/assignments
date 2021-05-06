package com.revature.assigments.p0.screens;

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

        System.out.println("-------------------------------------");
        System.out.println("    << Sign Up for a New Account>>   ");
        System.out.println("-------------------------------------");


    }
}
