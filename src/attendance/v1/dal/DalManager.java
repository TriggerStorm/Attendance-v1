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
import attendance.v1.be.Classes;
import java.util.List;

/**
 *
 * @author Trigger
 */
public class DalManager implements IDAL {
    private MockDao mockdao;
    private AttendanceDBDAO attendanceDBDao;

    
    public DalManager() {
          mockdao = new MockDao();
          attendanceDBDao = new AttendanceDBDAO();

    } 
    
    
    @Override
    public boolean CheckUser (String email, String password) { //checks if our user exsts and the password is correct.
        return mockdao.CheckUser(email,password);
    }
    
    @Override
    public boolean CheckTeacher(String email) {//checks to see if our user is a teacher, doesn't need the password for that.
        return mockdao.CheckTeacher(email);
    }
    
    
    @Override
    public List<String> addDayToAttendance(String selectedCourse) {
        return mockdao.addDayToAttendance(selectedCourse);
    }
   
           
    @Override 
    public String gCode() {
        return mockdao.gCode();
    }
    
    
    @Override
    public String course() {
        return mockdao.course();
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
