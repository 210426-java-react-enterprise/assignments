package com.revature.project0.screens;

import com.revature.project0.util.ScreenRouter;

import java.io.BufferedReader;

public class AccountScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;

    public AccountScreen(BufferedReader consoleReader, ScreenRouter router){
        super("AccountScreen", "/account");
        this.consoleReader = consoleReader;
        this.router = router;
    }


    public void render(){
        System.out.println("AccountScreen under construction!");
    }


}
