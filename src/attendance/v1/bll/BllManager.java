/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.Attendance;
import attendance.v1.be.SubjectAttendance;
import attendance.v1.be.SubjectsHeld;
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
    public User addNewUserToDB(String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher, String userIMG) {
        return dalManager.addNewUserToDB(userName, password, email, phoneNr, address, postCode, city, teacher, userIMG);
    }
    

    @Override
    public User editUser(User userToEdit, String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher, String userIMG) {
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
    public boolean checkIfTeacher(String email) {
        return dalManager.checkIfTeacher(email);
    }

    
    
    
    
    
// AttendanceDBDAO methods
    
    @Override
    public List<Attendance> getAllAttendances() {
        return dalManager.getAllAttendances();
        }

    
    public List<Attendance> getStudentAttendanceForSubject(int studentKey, int subjectKey) {
        return dalManager.getStudentAttendanceForSubject(studentKey, subjectKey);
    }
   

    @Override
    public SubjectAttendance addNewAttendanceToDB(int studentKey, SubjectsHeld subjectHeld) {
        return dalManager.addNewAttendanceToDB(studentKey, subjectHeld);
    }

    
    @Override
    public SubjectAttendance getStudentDailyAttendance(int studentKey, SubjectsHeld subjectHeld) {
        return dalManager.getStudentDailyAttendance(studentKey, subjectHeld);
    }

}
