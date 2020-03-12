/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.ScoMok;
import attendance.v1.be.SubjectAttendance;
import attendance.v1.be.User;
import attendance.v1.be.Attendance;
import attendance.v1.bll.BllManager;
import attendance.v1.be.Subject;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public class DalManager implements IDAL {
    private AttendanceDBDAO attendanceDBDao;
    private Student_SubjectDBDAO student_SubjectDBDao;
    private SubjectDBDAO subjectDBDao;
    private UserDBDAO userDBDao;
    
    
    
    public DalManager() {
          attendanceDBDao = new AttendanceDBDAO();
          student_SubjectDBDao = new Student_SubjectDBDAO();
          subjectDBDao = new SubjectDBDAO();
          userDBDao = new UserDBDAO();
    } 
    
    
    
// AttendanceDBDAO methods
    
    @Override
    public int CheckUser (String email, String password) { //checks if our user exsts and the password is correct.
        return attendanceDBDao.CheckUser(email,password);
    }
    
    
    @Override
    public boolean CheckTeacher(String email) {//checks to see if our user is a teacher, doesn't need the password for that.
        return attendanceDBDao.CheckTeacher(email);
    }
    
    
    @Override
    public List<String> addDayToAttendance(String selectedCourse) {
        return attendanceDBDao.addDayToAttendance(selectedCourse);
    }
   
           
    @Override 
    public String gCode() {
        return attendanceDBDao.gCode();
    }
    
    
    @Override
    public String course() {
        return attendanceDBDao.course();
    } 
    
    
    @Override
    public List<ScoMok> getSCOattendance(){
        return attendanceDBDao.getSCOattendance();
    }
        
    @Override
    public List<ScoMok> getSDEattendance(){
        return attendanceDBDao.getSDEattendance();
    }
        
    @Override
    public List<ScoMok> getITOattendance(){
        return attendanceDBDao.getITOattendance();
    }
           
    @Override
    public List<ScoMok> getDBOSattendance(){
        return attendanceDBDao.getDBOSattendance();
    }

    
    
// UserDBDAO methods
    
    @Override
    public List<User> getAllUsers() {
        try {
            return userDBDao.getAllUsers();
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    @Override
    public User getUser(int userKey) {
        try {
            return userDBDao.getUser(userKey);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    @Override
    public User addNewUserToDB(String userName, String password, String email, int phoneNr, String address, int postCode, String city, String teacher, String userIMG) {
        return userDBDao.addNewUserToDB(userName, password, email, phoneNr, address, postCode, city, teacher, userIMG);
    }
    

    @Override
    public User editUser(User userToEdit, String userName, String password, String email, int phoneNr, String address, int postCode, String city, String teacher, String userIMG) {
        return userDBDao.editUser(userToEdit, userName, password, email, phoneNr, address, postCode, city, teacher, userIMG);
    }

    
    @Override
    public void removeUserFromDB(User userToDelete) {
        userDBDao.removeUserFromDB(userToDelete);
    }

   
    
    
}
