package com.revature.project0.daos;

import com.revature.project0.models.AppUser;
import com.revature.project0.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    /**
     * Saves AppUser data to SQL table.
     *
     * @param newUser
     */
    public void save(AppUser newUser){
        //TODO: make this actually do something
        System.out.println("UserDAO save() method is under construction!");
    }

    //TODO: make sure this function works as intended
    public AppUser findUserByUsernameAndPassword(String username, String password){
        AppUser user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from banking.users where username = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            //this while loop should only loop once
            //TODO: update this when finished with RegisterScreen
            while (rs.next()) {
                user = new AppUser();
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                //user.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

}
