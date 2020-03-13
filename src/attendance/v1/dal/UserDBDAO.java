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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
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
    
    
     public User addNewUserToDB(String userName, String password, String email, int phoneNr, String address, int postCode, String city, String teacher, String userIMG) { 
        String sql = "INSERT INTO Users(userName, password, email, phoneNr, address, postCode, city, teacher, userIMG) VALUES (?,?,?,?,?,?,?,?,?)";
        User newUser = new User(postCode, userName, password, email, phoneNr, address, postCode, city, teacher, userIMG);
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, userName);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setInt(4, phoneNr);
            stmt.setString(5, address);
            stmt.setInt(6, postCode);
            stmt.setString(7, city);
            stmt.setString(8, teacher);
            stmt.setString(9, userIMG);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    newUser.setUserKey((int) generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                } 
                return newUser;
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(UserDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     
      public User editUser (User userToEdit, String userName, String password, String email, int phoneNr, String address, int postCode, String city, String teacher, String userIMG) { 
        try (//Get a connection to the database.
            Connection con = dbc.getConnection()) {
            //Create a prepared statement.
            String sql = "UPDATE Users SET userName = ?, password = ?, email = ?, phoneNr = ? , address = ? , postCode = ? , city = ? , teacher = ?, userIMG = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            //Set parameter values.
           pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setInt(4, phoneNr);
            pstmt.setString(5, address);
            pstmt.setInt(6, postCode);
            pstmt.setString(7, city);
            pstmt.setString(8, teacher);
            pstmt.setString(9, userIMG);
            //Execute SQL query.
            pstmt.executeUpdate();
            userToEdit.setUserName(userName);
            userToEdit.setPassword(password);   
            userToEdit.setEmail(email);
            userToEdit.setPhoneNr(phoneNr);
            userToEdit.setAddress(address);
            userToEdit.setPostCode(postCode);
            userToEdit.setCity(city);
            userToEdit.setTeacher(teacher);
            userToEdit.setUserIMG(userIMG);
            return userToEdit;
        } catch (SQLServerException ex) {
            Logger.getLogger(UserDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

       
      public void removeUserFromDB(User userToDelete) {
        String stat = "DELETE FROM Users WHERE id =?";      // USE ID HERE??????
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(stat);
            stmt.setInt(1,userToDelete.getUserKey());                      // IS THIS 0 ??
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Exception " + ex);
        }
    }
      
      
}
