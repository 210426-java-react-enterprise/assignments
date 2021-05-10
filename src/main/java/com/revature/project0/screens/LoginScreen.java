package com.revature.project0.screens;

import com.revature.project0.daos.AccountDAO;
import com.revature.project0.daos.UserDAO;
import com.revature.project0.models.AppAccount;
import com.revature.project0.models.AppUser;
import com.revature.project0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class LoginScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private UserDAO userDAO = new UserDAO();//TODO: clean this ugly thing
    private AccountDAO accountDAO = new AccountDAO();//TODO: ditto

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("LoginScreen", "/login");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    public void render() {
        System.out.println("Login to your account!");
        System.out.println("+-------------------------+");

        String username = null;
        String password = null;

        AppUser appUser = null;

        try {
            System.out.println("Enter username: ");
            username = consoleReader.readLine();

            System.out.println("Enter password: ");
            password = consoleReader.readLine();

            System.out.println("Locating user...");

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(username == null || password == null){
            System.out.println("User not found!");
            return;
        }

        boolean userFound = false;

        try {
            appUser = userDAO.findUserByUsernameAndPassword(username, password);


            if (appUser.getPassword().equals(password) && appUser.getUsername().equals(username)) {
                System.out.println("User " + appUser.getUsername() + " found!");
                System.out.println("Logging in to account...");

                //if there is an account, move to next portion of login screen (logged on)
                userFound = true;

                //router.navigate("/account");
            } else {
                System.out.println("User not found!");
            }
        } catch (NullPointerException e) {
            //System.out.println("User not found!");
            e.printStackTrace();
        }

        if(userFound) { userAccountScreen(appUser); }


    }


    private void userAccountScreen(AppUser appUser){

        String username = appUser.getUsername();

        //AppAccount accountTest = accountDAO.findAccountByUsernameAndAccountType(username, "checking");

        AppAccount accountTest = accountDAO.findAccountByUsername(username);

        try {
            if (!accountTest.equals(null)) {//with throw the NullPointerExceptCatch if this is false

                //show account options (balance, deposit, withdraw)
                System.out.println("Welcome to your account.  What do you want to do?");

                System.out.println("1) View account balance");
                System.out.println("2) Make a deposit");
                System.out.println("3) Make a withdrawal");

                String userSelection = consoleReader.readLine();

                switch (userSelection) {
                    case "1":
                        System.out.println("Balance is WIP");
                        break;
                    case "2":
                        System.out.println("Deposit is WIP");
                        break;
                    case "3":
                        System.out.println("Withdrawal is WIP");
                        break;
                }
            }
        }catch (NullPointerException e) {//in other words, accountTest.equals(null) is true
            System.out.println("You have no bank account.  Make one!");

            System.out.println("1) Create checking account");
            System.out.println("2) Create savings account");

            String checkOrSave = "checking";//TODO: make it so that this doesn't need to have a default set just in case


            String userSelection;
            try {
                userSelection = consoleReader.readLine();

                switch (userSelection) {
                    case "1":
                        checkOrSave = "checking";
                        break;
                    case "2":
                        checkOrSave = "savings";
                        break;
                }
            }catch (IOException e2){
                e2.printStackTrace();
            }

            accountDAO.createAccount(appUser, checkOrSave);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}