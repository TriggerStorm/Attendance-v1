/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.SubjectsHeld;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macos
 */
public class SubjectsHeldDBDAO {
     private DBConnection db;
     public List<SubjectsHeld> getALLSubjectsHeld() throws SQLException 
    {
        db = new DBConnection();
        List<SubjectsHeld> allsubjectsHeld = new ArrayList();
           
        try(Connection con = db.getConnection()){
            String SQLStmt = "SELECT * FROM SUBJECTSHELD;";
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            
            while(rs.next()) 
            {
                int subjectKey = rs.getInt("subjectKey");
                String date = rs.getString("date");
                String secretCode = rs.getString("secretCode");
                SubjectsHeld p = new SubjectsHeld(subjectKey,date,secretCode);
                allsubjectsHeld.add(p);
            }    
        }
       return allsubjectsHeld;
    }
    
     public SubjectsHeld editSubjectsHeld(SubjectsHeld subjectsHeld, String date, String secretCode) throws SQLException 
    {
        db = new DBConnection();
        
           
        try(Connection con = db.getConnection()){
            String SQLStmt = "UPDATE SUBJECTSHELD SET subjectKey = ?,date = ?, secretCode = ?  WHERE subjectKey = ?;";
            
            PreparedStatement pstmt = con.prepareStatement(SQLStmt);
             pstmt.setInt(1,subjectsHeld.getSkey());
            pstmt.setString(2,date);
            pstmt.setString(3,secretCode);
            pstmt.setInt(4,subjectsHeld.getSkey());
            pstmt.execute();
        }
        return new SubjectsHeld(subjectsHeld.getSkey(),date,secretCode);
}
     
     public SubjectsHeld getSpecificSubjectsHeld(int skey) throws SQLException 
    {
        db = new DBConnection(); 
        try(Connection con = db.getConnection()){
            String SQLStmt = "SELECT * FROM SUBJECTSHELD WHERE subjectKey = '"+skey+"';";
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
                int subjectKey = rs.getInt("subjectKey");
                String date = rs.getString("date");
                String secretCode = rs.getString("secretCode");
                return new SubjectsHeld(subjectKey,date,secretCode);
            }    
       
       
    }
 public SubjectsHeld addSubjectsHeld(int skey, String date, String secretCode) throws SQLException {
   db = new DBConnection();
        try(Connection con = db.getConnection()){
            
            String sqlIf = "INSERT INTO SUBJECTSHELD (subjectKey, secretCode, date) VALUES (?, ?, ?);"; 
            PreparedStatement pstmt = con.prepareStatement(sqlIf);
            pstmt.setInt(1,skey);
            pstmt.setString(2,date);
            pstmt.setString(3,secretCode);
            pstmt.execute(); 
            return new SubjectsHeld(skey,date,secretCode);
        } 
    }
     public SubjectsHeld editSubjectsHeld(SubjectsHeld subjectsHeld,int skey, String date, String secretCode) throws SQLException
     {
         db = new DBConnection();
        try(Connection con = db.getConnection()){
        
            String sqlIf = "UPDATE SUBJECTSHELD SET subjectKey = ?, secretCode = ?, date = ? WHERE subjectKey = ?;";
             PreparedStatement pstmt = con.prepareStatement(sqlIf);
            pstmt.setInt(1,skey);
            pstmt.setString(2,date);
            pstmt.setString(3,secretCode);
            pstmt.setInt(4,subjectsHeld.getSkey());
            pstmt.execute();
            
            return new SubjectsHeld(skey,date,secretCode);
        }
     }
     public void deleteSubjectsHeld(SubjectsHeld subjectsHeld) throws SQLException
     {
          db = new DBConnection();
        try(Connection con = db.getConnection()){
            String sqlStatement = "DELETE FROM SUBJECTSHELD WHERE subjectKey = ? ;";
            PreparedStatement pstmt = con.prepareStatement(sqlStatement);
            pstmt.setInt(1,subjectsHeld.getSkey());
            pstmt.execute();
        }
     }
}
