package com.revature.assigments.p0.screens;

import com.revature.assigments.p0.services.UserService;

import java.io.BufferedReader;

public class TransactionScreen extends Screen{

    private BufferedReader consoleReader;
    private UserService userService;

    public TransactionScreen(BufferedReader consoleReader, UserService userService) {
        super("TransactionScreen","/transaction");
        this.consoleReader = consoleReader;
        this.userService = userService;
    }


    @Override
    public void render() {

    }
}
