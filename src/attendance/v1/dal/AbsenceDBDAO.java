/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.Attendance;
import attendance.v1.be.SubjectAttendance;
import attendance.v1.be.SubjectsHeld;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class AbsenceDBDAO {
    private DBConnection dbc;

    
    public AbsenceDBDAO () {
            dbc = new DBConnection();
    }
    
    
    public void submitAbsence (int studentKey, LocalDate datePicked ) {  // just a test for now
     
System.out.println("");
System.out.println("DBDAO student = " + studentKey); 
System.out.println("");
System.out.println("DBDAO date picked = " + datePicked);

        String sql = "INSERT INTO ABSENCE(studentKey, date) VALUES (?,?)";
        java.sql.Date sqlDate = java.sql.Date.valueOf( datePicked );
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, studentKey);
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
    
    private void deleteExpiredAbsences() {
        
    }
    
    
}
