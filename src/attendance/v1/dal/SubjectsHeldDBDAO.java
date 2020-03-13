/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.Attendance;
import attendance.v1.be.SubjectsHeld;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Trigger
 */


public class SubjectsHeldDBDAO {
    
    private DBConnection dbc;
        
    public SubjectsHeldDBDAO() {
        dbc = new DBConnection();
    }
    
    public SubjectsHeld setSecretCode (String SubjectKey, String Date, String SecretCode) throws SQLException
    {
        String sql = "INSERT INTO SubjectsHeld(SubjectKey, Date, SecretCode,) VALUES (?,?,?)";
        SubjectsHeld a = new SubjectsHeld(SubjectKey,Date,SecretCode);
        try(Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, SubjectKey);
            stmt.setString(2, Date);
            stmt.setString(3, SecretCode); 
            
            }    catch (SQLException ex) {
            Logger.getLogger(AttendanceDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return a;
    }
    
    public List<SubjectsHeld> getSecretCode () throws SQLException
    {
        List<SubjectsHeld> SecretCode = new ArrayList<>();
        
        try ( Connection con = dbc.getConnection()) {
            String sql = "SELECT * FROM SubjectsHeld";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String Code = rs.getString("Code"); // string
                
                SecretCode.add(new SubjectsHeld(Code));
            }
            return SecretCode;
        }
        
    }
}
