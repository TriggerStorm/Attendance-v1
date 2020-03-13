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
import attendance.v1.be.ScoMok;
import attendance.v1.be.SubjectAttendance;
import attendance.v1.be.User;
import attendance.v1.be.Attendance;
import attendance.v1.bll.BllManager;
import attendance.v1.be.Subject;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public class AttendanceDBDAO {
 
/**
 *
 * @author Alan
 */
    
    private DBConnection dbc;
    public List<Attendance> attendance;
    public List<SubjectAttendance> studentAttendance;
    
    
    
    public AttendanceDBDAO() {
 
    }
    
    
     public List<Attendance> getAllAttendances() throws SQLException{
        List<Attendance> allAttendance = new ArrayList(); //get a list to store the values.
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT * FROM ATTENDANCE;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) //While you have something in the results
            {
                int userKey = rs.getInt("UserKey");
                int subjectKey = rs.getInt("SubjectKey");
                String dateHeld =  rs.getString("DateHeld");
               allAttendance.add(new Attendance(userKey, subjectKey, dateHeld)); 
            }    
        }
        return allAttendance;
    }
     
      
    public List<Attendance> getStudentAttendanceInSubject(int studentKey, int subjectKey) throws SQLException {
        List<Attendance> allAttendances = getAllAttendances();
        List<Attendance> studentAttendanceInSubject = new ArrayList<>();
        Attendance testAttendance;
        for (int i = 0; i < allAttendances.size(); i++) {
            testAttendance = allAttendances.get(i);
            if (testAttendance.getStudentKey() == studentKey) {
                if (testAttendance.getSubjectKey() == subjectKey) {
                studentAttendanceInSubject.add(testAttendance);
                }
            }
        }
        return studentAttendanceInSubject;
    }


     
    
    
     
     
     
     
     
     
     
     
     
     
     
     
  /*  public int mockPrintOut() {
         int count = mockStudentAttendance.size();
        return count;
    }
    
   */ 
   
    


        // mockuser1 = new User(1,"admin", "admin","admin@test.com", 12345678 ,"1 Mock St" , true, "data/mockuserIMG.jpg"); // add list
        // mockuser2 = new User(2,"student", "student","student@test.com", 12345678 ,"2 Mock St" , false, "data/mockuserIMG.jpg");//

   

    
    
    
    
   
    
    
    
    
    public List<String> addDayToAttendance(String selectedCourse) { // bit rough. Work in progress. Needs a lot of work
 /*       selectedCourse = "SCO";  // will come from gui later
        LocalDate now = LocalDate.now();
        int dayOfWeek = now.getDayOfWeek().getValue();
        int noOfCourses = attendance.size();
        if (noOfCourses > 0) {
            System.out.println("No of courses =" + noOfCourses);
            for (int i = 0; i < noOfCourses; i++) {
            
            String testCourse = attendance.get(i);
                System.out.println("Course number:" + (i+1));
                System.out.println(testCourse);
        }
        return attendance;
    } */
       return null; 
    }
    

   
        
    
   
    
    public String[] getSubjectAttendance(String subject) {
 /*       SubjectAttendance subjectCheck;
        String[] subjectString;
        int weekdayAttendance = 0;
        if (mockStudentAttendance.size()>0) {
            for(int i = 0; i > mockStudentAttendance.size(); i++) {
                subjectCheck = null; 
                // need to finish this method later
            }
        } */
        return null;
    }

    
    public String gCode() {
        String gCode = "9W6A";
        return gCode;
    }
        
     public String course() {
        String course = "Computer Science";
        return course;
    } 

    public List<ScoMok> getSCOattendance(){
        List<ScoMok> allSCO = new ArrayList<>();
        String Name = ("student");
        allSCO.add(new ScoMok(Name,5,8,5,6,8,56));
        return allSCO;
    }
    
    public List<ScoMok> getSDEattendance(){
        List<ScoMok> allSDE = new ArrayList<>();
        String Name = ("student");
        allSDE.add(new ScoMok(Name,9,9,9,9,9,99));
        return allSDE;
    }
    
    public List<ScoMok> getITOattendance(){
        List<ScoMok> allITO = new ArrayList<>();
        String Name = ("student");
        allITO.add(new ScoMok(Name,5,4,2,7,5,69));
        return allITO;
    }
    
    public List<ScoMok> getDBOSattendance(){
        List<ScoMok> allDBOS = new ArrayList<>();
        String Name = ("student");
        allDBOS.add(new ScoMok(Name,12,0,6,4,7,54));
        return allDBOS;
    }
    
}

