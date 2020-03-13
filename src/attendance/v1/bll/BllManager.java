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
    public List<String> addDayToAttendance(String selectedCourse) {
        return dalManager.addDayToAttendance(selectedCourse);
    }
    
       
    @Override
    public String gCode() {
        return dalManager.gCode();
    }
    
        
    @Override
    public String course() {
        return dalManager.course();
    } 
    
         // Mock data methods    
    @Override
    public List<ScoMok> getSCOattendance(){
        return dalManager.getSCOattendance();
    }
    
        
    @Override
    public List<ScoMok> getSDEattendance(){
        return dalManager.getSDEattendance();
    }
    
        
    @Override
    public List<ScoMok> getITOattendance(){
        return dalManager.getITOattendance();
    }
    
        
    @Override
    public List<ScoMok> getDBOSattendance(){
        return dalManager.getDBOSattendance();
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
    public int checkUserLogin (String email, String password) {
        return dalManager.checkUserLogin(email,password);
    }

    @Override
    public boolean CheckTeacher(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}
