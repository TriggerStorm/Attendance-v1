/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import attendance.v1.be.SubjectAttendance;
import attendance.v1.be.User;
import attendance.v1.be.Attendance;
import java.sql.ResultSet;
import java.sql.Statement;
import attendance.v1.bll.BllManager;
import attendance.v1.be.Subject;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.time.format.DateTimeFormatter;



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


        dbc = new DBConnection();


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
     
   public int[] addNewAttendanceToDB(int studentKey, int subjectKey) { 
        LocalDate now = LocalDate.now();
        String dateHeld = dateNowToString();
        String sql = "INSERT INTO ATTENDANCE(UserKey, SubjectKey, DateHeld) VALUES (?,?,?)";
        
        
        Attendance newAttendance = new Attendance(studentKey, subjectKey, dateHeld);
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, studentKey);
            stmt.setInt(2, subjectKey);
            stmt.setString(3, dateHeld);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating attendance failed, no rows affected.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    newAttendance.setStudentKey((int) generatedKeys.getLong(1));   // CHECK THIS LINE
                } else {
                    throw new SQLException("Creating attendance failed, no ID obtained.");
                } 
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(AttendanceDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   // FOR NOW
    }
   
        

    public int[] getStudentAttendanceForSubjectInDays(int studentKey, int subjectKey ) throws SQLException { // bit rough. Work in progress. Needs a lot of work
        int[] dailyAttendanceIntArray = new int[5];
        List<Attendance> studentAttendanceInSubject = getStudentAttendanceInSubject(studentKey, subjectKey);
        dailyAttendanceIntArray = listOfAttendanceToIntArrayOfDays(studentAttendanceInSubject);
        return dailyAttendanceIntArray;
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


        
    public int[] listOfAttendanceToIntArrayOfDays(List<Attendance> attendanceList) {
        int[] dailyAttendanceIntArray = new int[5];
        int attendanceTotal = attendanceList.size();
// System.out.println("No of courses =" + noOfCourses);
            for (int i = 0; i < attendanceTotal; i++) {
                Attendance attendance = attendanceList.get(i);
                String dateHeldString = attendance.getDateHeld();
                LocalDate dateHeld = stringToLocalDate(dateHeldString);
                int dayOfWeek = (dateHeld.getDayOfWeek().getValue()) - 1; 
                dailyAttendanceIntArray[dayOfWeek] ++;
            }
  //      int dayInt = Integer.parseInt(myString);
        return dailyAttendanceIntArray;
    }
    
   
    public String dateNowToString() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String dateNowString = now.format(formatter);
        return dateNowString;
    } 
    
    
    public String localDateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String dateString = date.format(formatter);
        return dateString;
    } 
    
    
     public LocalDate stringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return date;
    }
    
     
    
    
    
     public String gCode() {
        String gCode = "9W6A";
        return gCode;
    }
        
     public String course() {
        String course = "Computer Science";
        return course;
    } 


    
   
}

