package com.revature.assigments.p0.services;

import com.revature.assigments.p0.daos.UserDAO;
import com.revature.assigments.p0.models.AppUser;
import com.revature.assigments.p0.exceptions.invalidRequestedException;
import com.revature.assigments.p0.exceptions.ResourcesPersistanceException;


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

        userDAO.save(newUser);
    }
}
