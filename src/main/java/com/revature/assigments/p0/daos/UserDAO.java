package com.revature.assigments.p0.daos;

import com.revature.assigments.p0.models.AppUser;
import com.revature.assigments.p0.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class to handle the User related SQL statements and accesses to the DB
 */

public class UserDAO {

    public void save(AppUser newUser){
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sqlInsertUser = "insert into p0_canaima.users(username, password, first_name, last_name, email) values (?,?,?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(sqlInsertUser, new String[] {"user_id"});
            pstmt.setString(1, newUser.getUsername());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setString(3,newUser.getFirstName());
            pstmt.setString(4, newUser.getLastName());
            pstmt.setString(5, newUser.getEmail());
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted !=0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    newUser.setId(rs.getInt("user_id"));
                }
            }

        }catch(SQLException throwables){
            throwables.printStackTrace();
        }


    }

}
