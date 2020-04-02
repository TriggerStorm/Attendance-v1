/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.Absence;
import attendance.v1.be.Attendance;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */

public class AbsenceDBDAO {
    private DBConnection dbc;

    
    public AbsenceDBDAO () {
            dbc = new DBConnection();
    }
    
    
    public List<Absence> getAllAbsencesOnAGivenDate(LocalDate date) throws SQLException {
    //  Gets a list of all attendances on a given date
        List<Absence> allAbsencesForADate = new ArrayList(); //get a list to store the values.
        java.sql.Date sqlDate = java.sql.Date.valueOf(date); // converts LocalDate date to sqlDate
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT * FROM ABSENCE WHERE DATE = '" + sqlDate + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) //While you have something in the results
            {
                int userKey = rs.getInt("studentKey");
                allAbsencesForADate.add(new Absence(userKey, date)); 
//System.out.println("");
//System.out.println("Found entry");
            }    
        }
// TEST   
/*System.out.println("");
System.out.println("List of Absences on " + date);
        for (int i = 0; i < allAbsencesForADate.size(); i++) {
        Absence absence = allAbsencesForADate.get(i);
System.out.println("");
System.out.println(i + ": Studentkey= "+ absence.getStudentKey() + "  Date: " + absence.getDate()); 
        } */
        return allAbsencesForADate;
    }
        
    
    
     public boolean checkForAbsenceInDB(Absence absence) throws SQLException {
    //  Checks if student has already submitted absence on picked date, to prevent sql duplication error
        int studentKey = absence.getStudentKey();
        java.sql.Date sqlDate = java.sql.Date.valueOf(absence.getDate()); // converts LocalDate date to sqlDate
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT * FROM ABSENCE WHERE StudentKey = '" + studentKey + "' AND DATE = '" + sqlDate+"';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQLStmt);
            while(rs.next())
            {
System.out.println("");
System.out.println("ERROR - Absence already submitted");             
                return true;
            }
        }
System.out.println("");
System.out.println( "New Absence submitted");  
        return false;
    }
        
     
    public List<String> getMonthlyAbsencesForAStudent(int studentKey, int monthInt) throws SQLException {
    // Returns a list of strings representingthe days absent in a given month (as an int)
        Calendar calendar = Calendar.getInstance();
        List<String> studentsAbsencePerMonth = new ArrayList<>();
        String dayString;
        java.sql.Date startDate = convertMonthIntToSQLDate(monthInt);
        java.sql.Date endDate = convertMonthIntToSQLDate(monthInt + 1);       
        try(Connection con = dbc.getConnection()) {
            String SQLStmt = "SELECT * FROM ABSENCE WHERE StudentKey = '" + studentKey + "' AND Date >= '" + startDate + "' AND Date < '" + endDate + "';";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) //While you have something in the results
            {
                java.sql.Date sqlDate = rs.getDate("date");
                calendar.setTime(sqlDate);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                dayString = String.valueOf(day);
                studentsAbsencePerMonth.add(dayString);
            }
        return studentsAbsencePerMonth;
        }
    }
     
     
    public void submitAbsence (Absence absence) throws SQLException {  // just a test for now
    //  Adds an absence to the DB (from DatePicker) 
System.out.println("");
System.out.println("DBDAO student = " + absence.getStudentKey()); 
System.out.println("");
System.out.println("DBDAO date picked = " + absence.getDate());
        if (!checkForAbsenceInDB(absence)) {
        String sql = "INSERT INTO ABSENCE(studentKey, date) VALUES (?,?)";
        java.sql.Date sqlDate = java.sql.Date.valueOf(absence.getDate()); // converts LocalDate date to sqlDate
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, absence.getStudentKey());
            stmt.setDate(2, sqlDate);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating absence failed, no rows affected.");
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(AttendanceDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
  //      return BE entity (studentKey, datePicked)??
        }
 //       getAllAbsencesOnAGivenDate(absence.getDate());  // TEST 
        deleteExpiredAbsences();  //TEST
 //       getMonthlyAbsencesForAStudent(594, 4);  //TEST
    }
    

    public void deleteExpiredAbsences() throws SQLException {
    //  Deletes all absences odd than today
        java.sql.Date sqlExpiryDate = java.sql.Date.valueOf(LocalDate.now());
        String SQLStmt = "DELETE FROM ABSENCE WHERE DATE < '" + sqlExpiryDate + "';";
        try (Connection con = dbc.getConnection()) {
            Statement statement = con.createStatement();
            statement.executeUpdate(SQLStmt);      
        }
    }
    
        
    private java.sql.Date convertMonthIntToSQLDate (int monthInt) {
    // Converts an int month to the first day of that month in sql date form
        Calendar calendar = Calendar.getInstance();
        String yearString = String.valueOf(calendar.getInstance().get(Calendar.YEAR));
        String MonthString = String.valueOf(monthInt);
        if (monthInt < 10) {
            MonthString = "0" + MonthString;
        }
        String firstDayOfMonthString = yearString + "-" + MonthString + "-01"; 
       LocalDate date = LocalDate.parse(firstDayOfMonthString);
       java.sql.Date sqlDate = java.sql.Date.valueOf(date);
       return sqlDate;
    }
     
         
}
