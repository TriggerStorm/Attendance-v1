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
import attendance.v1.be.LoggedInUser;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import attendance.v1.be.User;
import attendance.v1.be.StudentSubject;
import attendance.v1.be.SubjectsHeld;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public class UserDBDAO {
    public static User loggedInUser;
    private DBConnection dbc;
    StudentSubjectDBDAO studentSubjectDBDao;
    
    public UserDBDAO() {
        loggedInUser = new User(-1,"","","",0,"",0,"", false, "");
        dbc = new DBConnection();
        studentSubjectDBDao = new StudentSubjectDBDAO();
    }
        
   
    public List<User> getAllUsers() throws SQLException{
        List<User> allUsers = new ArrayList(); //get a list to store the values.
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT userKey, userName, password, email, phonenr, address, postCode, city, teacher, userIMG  FROM USERS;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) //While you have something in the results
            {
                int userKey = rs.getInt("userKey");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int phoneNr = rs.getInt("phonenr");
                String address = rs.getString("address");
                int postCode = rs.getInt("postCode");
                String city = rs.getString("city");
                int isteacher = rs.getInt("teacher");
                boolean teacher = false;
                if(isteacher == 1)
                    teacher = true;
                String userIMG =  rs.getString("userIMG");
               allUsers.add(new User(userKey, userName, password, email, phoneNr, address, postCode, city, teacher, userIMG)); 
            }    
        }
        return allUsers;
    }
        
    
    public User getUser(int userKey) throws SQLException {
        User user = null;
        try(Connection con = dbc.getConnection()) {
            String SQLStmt = "SELECT userName, password, email, phonenr, address, postCode, city, teacher, userIMG FROM USERS WHERE userKey ='" + userKey + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) //While you have something in the results
            {
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int phoneNr = rs.getInt("phonenr");
                String address = rs.getString("address");
                int postCode = rs.getInt("postCode");
                String city = rs.getString("city");
                int isteacher = rs.getInt("teacher");
                boolean teacher = false;
                if(isteacher == 1)
                    teacher = true;
                String userIMG =  rs.getString("userIMG");
               user = new User(userKey, userName, password, email, phoneNr, address, postCode, city, teacher, userIMG); 
            }    
        }
        return user;
    }   
 
    
    public User getLoggedInUser(String email) throws SQLException {
        User user = null;
        try(Connection con = dbc.getConnection()) {
            String SQLStmt = "SELECT userKey, userName, password, phonenr, address, postCode, city, teacher, userIMG FROM USERS WHERE email ='" + email + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) //While you have something in the results
            {                
                int userKey = rs.getInt("userKey");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                int phoneNr = rs.getInt("phonenr");
                String address = rs.getString("address");
                int postCode = rs.getInt("postCode");
                String city = rs.getString("city");
                int isteacher = rs.getInt("teacher");
                boolean teacher = false;
                if(isteacher == 1)
                    teacher = true;
                String userIMG =  rs.getString("userIMG");
               user = new User(userKey, userName, password, email, phoneNr, address, postCode, city, teacher, userIMG); 
            }    
        }
        return user;
    }   
 
    
     public User addNewUserToDB(String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher, String userIMG) { 
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
            int isteacher = 0;
            if(teacher == true)
                isteacher =1;
            stmt.setInt(8, isteacher);
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
     
     
    public User editUser (User userToEdit, String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher, String userIMG) { 
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
            int isteacher = 0;
            if(teacher == true)
                isteacher = 1;
            pstmt.setInt(8, isteacher);
            pstmt.setString(9, userIMG);
            pstmt.setInt(10, userToEdit.getUserKey());
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
            stmt.setInt(1,userToDelete.getUserKey());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Exception " + ex);
        }
    }
      
    
    public int checkUserLogin(String email, String password) throws SQLException {  // Why an int???
        User tempLogin = null;
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT userKey, userName, phonenr, address, postCode, city, teacher, userIMG  FROM USERS WHERE email = '"+ email + "' AND password ='" + password + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            if(rs != null) //If there is an entry
            {
                while(rs.next())
                {
                    int userKey = rs.getInt("userKey");
                    String userName = rs.getString("userName");
                    int phoneNr = rs.getInt("phonenr");
                    String address = rs.getString("address");
                    int postCode = rs.getInt("postCode");
                    String city = rs.getString("city");
                    int isteacher = rs.getInt("teacher");
                    boolean teacher = false;
                    if(isteacher == 1)
                        teacher = true;
                    String userIMG =  rs.getString("userIMG");
                    tempLogin = new User(userKey, userName, password, email, phoneNr, address, postCode, city, teacher, userIMG);

                    LoggedInUser lUser = LoggedInUser.getInstance();
                    lUser.setUserKey(tempLogin.getUserKey());
                    lUser.setUserName(tempLogin.getUserName());
                    lUser.setEmail(email);
                    lUser.setPassword(password);
                    lUser.setPhoneNr(tempLogin.getPhoneNr());
                    lUser.setPostCode(tempLogin.getPostCode());
                    lUser.setCity(tempLogin.getCity());
                    lUser.setTeacher(tempLogin.getTeacher());
                    lUser.setUserIMG(tempLogin.getUserIMG());
                    lUser.setAddress(tempLogin.getAddress());
                    if(tempLogin.getTeacher() == true) {
                        return 1; //user and password match = true
                    }
                    else if(tempLogin.getTeacher() == false) {
                        return 2;
                    }
                }
            } else {
                return 0;
            }
        }
        return 4; //this should never happen.
    }
    
    
    public boolean checkIfTeacher(String email) throws SQLException {
    //  Returns true if the user is a teacher    
        try(Connection con = dbc.getConnection()){
            boolean teacher = false;
            String SQLStmt = "SELECT teacher FROM Users WHERE  email='" + email + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) //While you have something in the results
            {
                int isTeacher =  rs.getInt("teacher");
                if(isTeacher == 1) {
                    teacher=true;
                } else if(isTeacher == 0) {
                    teacher = false;
                }
            }
            return teacher;
        }
    }
        
    
    public String getUserNameFromKey(int studentKey) throws SQLException {
        try(Connection con = dbc.getConnection()){
            String userName = null;
            String SQLStmt = "SELECT userName FROM Users WHERE  userKey='" + studentKey + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) //While you have something in the results
            {
                userName =  rs.getString("userName");
            }
            return userName;
        }
    }
        
    
    public List<User> getAllStudentsInASubject(int subjectKey) throws SQLException {
        List<User> studentsInSubject = new ArrayList<>();
        //List<StudentSubject> allStudentSubjects = studentSubjectDBDao.getAllStudentSubjects();
        String stmt = "Select u.userKey, u.userName, u.password, u.email, u.email,u.phonenr, u.address, u.teacher, u.userIMG, u.postCode, u.city FROM Users u JOIN Student_Subjects s On u.userKey = s.userKey WHERE s.subjectKey = ?";
        try (Connection con = dbc.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(stmt);
            pstmt.setInt(1,subjectKey);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                int userKey = rs.getInt("userKey");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int phoneNr = rs.getInt("phonenr");
                String address = rs.getString("address");
                int postCode = rs.getInt("postCode");
                String city = rs.getString("city");
                int isteacher = rs.getInt("teacher");
                boolean teacher = false;
                if(isteacher == 1)
                    teacher = true;
                String userIMG =  rs.getString("userIMG");
               studentsInSubject.add(new User(userKey, userName, password, email, phoneNr, address, postCode, city, teacher, userIMG)); 
            }
        } catch (SQLException ex) {
            System.out.println("Exception " + ex);
        }
        return studentsInSubject;
    }
    
    
}
