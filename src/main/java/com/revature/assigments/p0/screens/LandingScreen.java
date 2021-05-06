package com.revature.assigments.p0.screens;

import java.io.BufferedReader;
import com.revature.assigments.p0.util.ScreenRouter;

/**
 * Class to render the landing bank screen
 *
 */

public class LandingScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;

    public LandingScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("LandingScreen","/landingscrenn");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    @Override
    public void render() {
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println("      Welcome to CANAIMA BANK");
        System.out.println("-------------------------------------");
        System.out.println("1.-Sign Up");
        System.out.println("2.-Sign In");
        System.out.println("3.-Exit Application");

        try{
            System.out.println(">> ");
            String userSelection = consoleReader.readLine();

            switch (userSelection){
                case "1": //Sign Up
                    System.out.println("Navigating >>>> Sign Up Screen");
                    router.navigate("/signup");
                    break;
                case "2": //Sign In

                    break;
                case "3": // Exit App

                    break;
                default:
                    System.out.println("Invalid Selection!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
