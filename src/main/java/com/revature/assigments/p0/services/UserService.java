package com.revature.assigments.p0.services;

import com.revature.assigments.p0.daos.UserDAO;
import com.revature.assigments.p0.models.AppUser;
import com.revature.assigments.p0.exceptions.invalidRequestedException;
import com.revature.assigments.p0.exceptions.ResourcesPersistanceException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Class that contains all my business logic for USER data validation
 */
public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public void signUp(AppUser newUser) throws invalidRequestedException, ResourcesPersistanceException{
        //Insert my business logic validations
        if(!isUserValid(newUser)){
            throw new invalidRequestedException("Invalid new user data provided!");
        }
        userDAO.save(newUser);
    }

    //Method to validate the data from the user with the requirements from the users' table from my DB
    public boolean isUserValid(AppUser user){
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty() || user.getFirstName().trim().length() > 25) return false;
        if (user.getLastName() == null || user.getLastName().trim().isEmpty() || user.getLastName().trim().length() > 25) return false;
        if (user.getEmail() == null || user.getEmail().trim().isEmpty() || user.getEmail().trim().length() > 256 || !(isEmailValid(user.getEmail())))return false;
        if (user.getUsername() == null || user.getUsername().trim().isEmpty() || user.getUsername().trim().length() > 25) return false;
        if (user.getPassword() == null || user.getPassword().trim().isEmpty() || user.getPassword().trim().length() > 256) return false;

        return true;
    }

    public boolean isEmailValid(String email){
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

}
