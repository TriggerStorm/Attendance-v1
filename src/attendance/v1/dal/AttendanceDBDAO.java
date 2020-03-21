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
import java.time.LocalDateTime;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.format.DateTimeFormatter;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.ResultSet;
import java.sql.Statement;

import attendance.v1.be.SubjectAttendance;
import attendance.v1.be.User;
import attendance.v1.be.Attendance;
import attendance.v1.bll.BllManager;
import attendance.v1.be.Subject;
import attendance.v1.be.SubjectsHeld;
import attendance.v1.be.StudentSubject;
import attendance.v1.be.SubjectAttendance;
import java.text.DecimalFormat;


/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public class AttendanceDBDAO {
 
    private DBConnection dbc;
    public List<Attendance> attendance;
    public List<SubjectAttendance> studentAttendance;
    public UserDBDAO tempUserDBDao;
    public SubjectsHeldDBDAO tempSubjectsHeldDBDao;
    
    
    public AttendanceDBDAO() {
        tempUserDBDao = new UserDBDAO();
        tempSubjectsHeldDBDao = new SubjectsHeldDBDAO();
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
                int userKey = rs.getInt("studentKey");
                int subjectKey = rs.getInt("SubjectKey");
                String dateHeld =  rs.getString("DateHeld");
               allAttendance.add(new Attendance(userKey, subjectKey, dateHeld)); 
            }    
        }
        return allAttendance;
    }
     
     
   public SubjectAttendance addNewAttendanceToDB(int studentKey, SubjectsHeld subjectHeld) throws SQLException { 
 // can this method be passed a subjectheld????       
       int subjectKey = subjectHeld.getSubjectKey();
        String dateHeld = subjectHeld.getDateHeld();
        String sql = "INSERT INTO ATTENDANCE(studentKey, SubjectKey, DateHeld) VALUES (?,?,?)";
        
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
        return getSubjectAttendanceForAStudent(studentKey, subjectKey);
    }
   
        
   public List<SubjectAttendance> getSubjectAttendanceListForAllStudentsInThatSubject( int subjectKey) throws SQLException {
       List<SubjectAttendance> allStudentDailyAttendance = new ArrayList<>();
       List<User> allStudentsInASubject = tempUserDBDao.getAllStudentsInASubject(subjectKey);
       for (int i = 0; i < allStudentsInASubject.size(); i++) {
           int userKey = allStudentsInASubject.get(i).getUserKey();
           SubjectAttendance studentsDailyAttendance = getSubjectAttendanceForAStudent(userKey, subjectKey);
           allStudentDailyAttendance.add(studentsDailyAttendance);
       }
       return allStudentDailyAttendance;
   }
   
   
    public  SubjectAttendance getSubjectAttendanceForAStudent(int studentKey, int subjectKey) throws SQLException {
        int[] dailyAttendanceIntArray = new int[5];
        List<Attendance> studentAttendanceInSubject = getAllOfAStudentsAttendanceForASubject(studentKey, subjectKey);
        dailyAttendanceIntArray = listOfAttendanceToIntArrayOfDays(studentAttendanceInSubject);
        String name = tempUserDBDao.getUserNameFromKey(studentKey);
        int monday = dailyAttendanceIntArray[0];
        int tuesday = dailyAttendanceIntArray[1];
        int wednesday = dailyAttendanceIntArray[2];
        int thursday = dailyAttendanceIntArray[3];
        int friday = dailyAttendanceIntArray[4];
        String percent = getAverageOfAStudentsAttendanceInASubjectAsAString(subjectKey, studentKey);
        SubjectAttendance sda = new SubjectAttendance(name, monday, tuesday, wednesday, thursday, friday, percent);
        return sda;
    }
    

    public List<Attendance> getAllOfAStudentsAttendanceForASubject(int studentKey, int subjectKey) throws SQLException {
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

 
    public List<Attendance> getAllAttendanceForSubject(int subjectKey) throws SQLException {
        List<Attendance> allAttendances = getAllAttendances();
        List<Attendance> allAttendanceInSubject = new ArrayList<>();
        Attendance testAttendance;
        for (int i = 0; i < allAttendances.size(); i++) {
            testAttendance = allAttendances.get(i);
            if (testAttendance.getSubjectKey() == subjectKey) {
                allAttendanceInSubject.add(testAttendance);
            }
        }
        return allAttendanceInSubject;
    }

        
    public int[] listOfAttendanceToIntArrayOfDays(List<Attendance> attendanceList) {
        int[] dailyAttendanceIntArray = new int[5];
        int attendanceTotal = attendanceList.size();
            for (int i = 0; i < attendanceTotal; i++) {
                Attendance attendance = attendanceList.get(i);
                String dateHeldString = attendance.getDateHeld();
                LocalDateTime dateHeld = stringToLocalDate(dateHeldString);
                int dayOfWeek = (dateHeld.getDayOfWeek().getValue()) - 1; 
                dailyAttendanceIntArray[dayOfWeek] ++;
            }
        return dailyAttendanceIntArray;
    }
    
   
    
    
    
// Average calculators
    
    public String getAverageOfAStudentsAttendanceInASubjectAsAString(int subjectKey, int userKey) throws SQLException {
        double averageOfAStudentsAttendanceInASubject = calculateAverageOfAStudentsAttendanceInASubject(subjectKey, userKey);
        String averageOfAStudentsAttendanceInASubjectString = convertDoubleToPercentageString(averageOfAStudentsAttendanceInASubject);
        return averageOfAStudentsAttendanceInASubjectString;
    }
       
    
    public String getAverageOfAllStudentAttendancesInASubjectAsAString(int subjectKey) throws SQLException {
        double totalOfAllStudentAttendancesInASubject = 0;
        List<User> allstudentsInASubject = tempUserDBDao.getAllStudentsInASubject(subjectKey);
        int numberOfStudentsInASubject = allstudentsInASubject.size();
// maybe need an if (numberOfStudentsInASubject < 1) ...
        for (int i = 0; i < numberOfStudentsInASubject; i++) {
            User testUser = allstudentsInASubject.get(i);
            int userKey = testUser.getUserKey();
            totalOfAllStudentAttendancesInASubject =+ calculateAverageOfAStudentsAttendanceInASubject(subjectKey, userKey);
        }
        double averageOfAllStudentAttendancesInASubject = totalOfAllStudentAttendancesInASubject / numberOfStudentsInASubject;
        String averageOfAllStudentAttendancesInASubjectString = convertDoubleToPercentageString(averageOfAllStudentAttendancesInASubject);
        return averageOfAllStudentAttendancesInASubjectString;
    }
     
    
    public double calculateAverageOfAStudentsAttendanceInASubject(int subjecKey, int userKey) throws SQLException {
        double averageOfAStudentsAttendanceInASubject;
        List<SubjectsHeld> allSubjectsHeldForASubject = tempSubjectsHeldDBDao.getAllSubjectsHeldForASubject(subjecKey);
        List<Attendance> allOfAStudentsAttendanceForASubject = getAllOfAStudentsAttendanceForASubject(userKey, subjecKey);
        averageOfAStudentsAttendanceInASubject = allOfAStudentsAttendanceForASubject.size()/allSubjectsHeldForASubject.size();
        return averageOfAStudentsAttendanceInASubject;
    }
        
    
    public String convertDoubleToPercentageString(double decimal) {
        DecimalFormat df = new DecimalFormat("##.##%");
        String percentageString = df.format(decimal);
        return percentageString;
    }
        
    
    
    
    
// Time Converters

    public String dateNowToString() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
        String dateNowString = now.format(formatter);
        return dateNowString;
    } 
    
    
    public String localDateToString(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
        String dateString = date.format(formatter);
        return dateString;
    } 
    
    
     public LocalDateTime stringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
        LocalDateTime date = LocalDateTime.parse(dateString, formatter);
        return date;
    }
    
     
    
    
}

