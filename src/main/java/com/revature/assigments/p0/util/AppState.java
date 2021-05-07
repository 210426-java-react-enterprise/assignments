package com.revature.assigments.p0.util;

import com.revature.assigments.p0.screens.LandingScreen;
import com.revature.assigments.p0.screens.SignUpScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private boolean appRunning;
    private BufferedReader consoleReader;
    private ScreenRouter router;

    public AppState() {
        System.out.println("Initializing application");

        appRunning = true;
        consoleReader = new BufferedReader(new InputStreamReader(System.in));

        router = new ScreenRouter();
        router.addScreen(new LandingScreen(consoleReader,router))
                .addScreen(new SignUpScreen(consoleReader,router)); // Here I can add more screens

        System.out.println("Application initialized!");
    }

    public boolean isAppRunning() {
        return appRunning;
    }

    public ScreenRouter getRouter() {
        return router;
    }
}

