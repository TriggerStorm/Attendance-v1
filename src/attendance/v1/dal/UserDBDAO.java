/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import attendance.v1.be.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class UserDBDAO {
        private DBConnection dbc;

   
    public List<User> getAllUsers(){
        
        List<User> = new ArrayList(); //get a list to store the values.
        
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT * FROM USERS;";
            
            Statement statement = con.createStatement();
            ResultSet rs = statment.executeQuery(SQLStmt);
            
            while(rs.next()) //While you have something in the results
            {
                //fetch all info
                
                int UserKey = rs.getInt("UserId");
                String UserName = rs.getString("userName");
                String Password = rs.getString("Password");
                String email = rs.getString("Email");
                String address = rs.getString("Address");
                
            }    
        }
    }
        
        
    public User getUser() {
        User user = new User();
       return user; 
    }

   
}
