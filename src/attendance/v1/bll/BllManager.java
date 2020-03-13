/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.ScoMok;
import attendance.v1.be.User;

import java.util.List;

import attendance.v1.dal.DalManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public class BllManager implements IBLL {
    private DalManager dalManager = new DalManager();

    
   @Override
    public int CheckUser (String email, String password) { //checks if our user exsts and the password is correct.
        return dalManager.CheckUser(email,password);
    }
    
    
    @Override
    public List<String> addDayToAttendance(String selectedCourse) {
        return dalManager.addDayToAttendance(selectedCourse);
    }
 
    
// UserDBDAO methods
    @Override
    public List<User> getAllUsers() {
        return dalManager.getAllUsers();
        }

    
    @Override
    public User getUser(int userKey) {
            return dalManager.getUser(userKey);
    }

    
    @Override
    public User addNewUserToDB(String userName, String password, String email, int phoneNr, String address, int postCode, String city, String teacher, String userIMG) {
        return dalManager.addNewUserToDB(userName, password, email, phoneNr, address, postCode, city, teacher, userIMG);
    }
    

    @Override
    public User editUser(User userToEdit, String userName, String password, String email, int phoneNr, String address, int postCode, String city, String teacher, String userIMG) {
        return dalManager.editUser(userToEdit, userName, password, email, phoneNr, address, postCode, city, teacher, userIMG);
    }

    
    @Override
    public void removeUserFromDB(User userToDelete) {
        dalManager.removeUserFromDB(userToDelete);
    }

    @Override
    public boolean CheckTeacher(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    

}
