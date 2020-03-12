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
import java.util.List;

/**
 *
 * @author Trigger
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
    
    
    @Override
    public boolean CheckUser (String email, String password) { //checks if our user exsts and the password is correct.
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
    
    
    // Mock data methods
        
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

   
    
    
}
