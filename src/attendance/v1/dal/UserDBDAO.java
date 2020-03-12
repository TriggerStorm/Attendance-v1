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

    public UserDBDAO() {
        dbc = new DBConnection();
    }
        
   
    public List<User> getAllUsers() throws SQLException{
        List<User> allUsers = new ArrayList(); //get a list to store the values.
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT * FROM USERS;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) //While you have something in the results
            {
                int userKey = rs.getInt("UserId");
                String userName = rs.getString("UserName");
                String password = rs.getString("Password");
                String email = rs.getString("Email");
                int phoneNr = rs.getInt("Phonenr");
                String address = rs.getString("Address");
                int postCode = rs.getInt("PostCode");
                String city = rs.getString("City");
                String teacher = rs.getString("Teacher");
                String userIMG =  rs.getString("userIMG");
               allUsers.add(new User(userKey, userName, password, email, phoneNr, address, postCode, city, teacher, userIMG)); 
            }    
        }
        return allUsers;
    }
        
    
    public User getUser(int userKey) throws SQLException {
        List<User> allUsers = getAllUsers();
        User user;
        for (int i = 0; i < allUsers.size(); i++) {
            user = allUsers.get(i);
            int testKey = user.getUserKey();
            if (testKey == userKey)  {
            return user;
            }
        }
        return null;  // User does not exist
    }
}
