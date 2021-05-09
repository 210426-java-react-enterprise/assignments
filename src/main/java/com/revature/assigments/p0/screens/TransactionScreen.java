package com.revature.assigments.p0.screens;

import com.revature.assigments.p0.util.ScreenRouter;
import java.io.BufferedReader;
import com.revature.assigments.p0.models.AppUser;

import static com.revature.assigments.p0.Driver.app;


public class TransactionScreen extends Screen{

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private AppUser currentUser;

    public TransactionScreen(BufferedReader consoleReader, ScreenRouter router, AppUser currentUser) {
        super("TransactionScreen","/transaction");
        this.consoleReader = consoleReader;
        this.router = router;
        this.currentUser = currentUser;
    }


    @Override
    public void render() {

        System.out.println("-------------------------------------");
        System.out.println("            CANAIMA BANK"             );
        System.out.println("-------------------------------------");
        System.out.println("1.-Create Account");
        System.out.println("2.-Check Balance");
        System.out.println("3.-Withdraw");
        System.out.println("4.-Transfer");
        System.out.println("5.-Transactions history");
        System.out.println("6.-Exit Application");
            

        try{
            System.out.println(">> ");
            String userSelection = consoleReader.readLine();
            /*
            switch (userSelection){
                case "1": //Sign Up
                    System.out.println("Navigating >>>> Sign Up Screen");
                    router.navigate("/signUp");
                    break;
                case "2": //Sign In
                    System.out.println("Navigating >>>> Sign In Screen");
                    router.navigate("/signIn");
                    break;
                case "3": // Exit App
                    app().setAppRunning(false);
                    break;
                default:
                    System.out.println("Invalid Selection!");
            }
          */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
