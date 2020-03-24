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
import java.util.logging.Level;
import java.util.logging.Logger;


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
            pstmt.setInt(1,subjectsHeld.getSubjectKey());
            pstmt.setString(2,date);
            pstmt.setString(3,secretCode);
            pstmt.setInt(4,subjectsHeld.getSubjectKey());
            pstmt.execute();
        }
        return new SubjectsHeld(subjectsHeld.getSubjectKey(),date,secretCode);
    }


     public SubjectsHeld getSpecificSubjectsHeld(int skey) throws SQLException {
        db = new DBConnection();
        try(Connection con = db.getConnection()) {
            String SQLStmt = "SELECT * FROM SUBJECTSHELD WHERE subjectKey = '"+skey+"';";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
                int subjectKey = rs.getInt("subjectKey");
                String date = rs.getString("date");
                String secretCode = rs.getString("secretCode");
                return new SubjectsHeld(subjectKey,date,secretCode);
        }
    }


    public List<SubjectsHeld> getAllSubjectsHeldForASubject(int subjectKey) throws SQLException {
        //List<SubjectsHeld> allSubjectsHeld = getALLSubjectsHeld();
        List<SubjectsHeld> allSubjectsHeldForASubject = new ArrayList<>();
                db = new DBConnection();
        try(Connection con = db.getConnection()) {
            String SQLStmt = "SELECT * FROM SUBJECTSHELD WHERE subjectKey = '"+subjectKey+"';";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next())
            {
                int subtKey = rs.getInt("subjectKey");
                String date = rs.getString("date");
                String secretCode = rs.getString("secretCode");
                allSubjectsHeldForASubject.add( new SubjectsHeld(subtKey,date,secretCode));
            }
        }


        /*for (int i = 0; i < allSubjectsHeld.size(); i++) {
            SubjectsHeld testSubjectsHeld = allSubjectsHeld.get(i);
            if (testSubjectsHeld.getSubjectKey() == subjectKey) {
                allSubjectsHeldForASubject.add(testSubjectsHeld);
            }
        }*/
        return allSubjectsHeldForASubject;
    }


    public SubjectsHeld addSubjectsHeld(int skey, String date, String secretCode) throws SQLException {
        db = new DBConnection();
        try(Connection con = db.getConnection()){

            String sqlIf = "INSERT INTO SUBJECTSHELD (subjectKey, date, secretCode) VALUES (?, ?, ?);";
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
            pstmt.setInt(4,subjectsHeld.getSubjectKey());
            pstmt.execute();

            return new SubjectsHeld(skey,date,secretCode);
        }
     }
     public boolean deleteSubjectsHeld(SubjectsHeld subjectsHeld) throws SQLException
     {
          db = new DBConnection();
        try(Connection con = db.getConnection()){

            String sqlStatement = "DELETE FROM SUBJECTSHELD WHERE subjectKey = ? and dateHeld = ?";
            PreparedStatement pstmt = con.prepareStatement(sqlStatement);
            pstmt.setInt(1,subjectsHeld.getSubjectKey());
            pstmt.setString(2, subjectsHeld.getDateHeld());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                return false;

            }
            else
                return true;
        }
     }






    public SubjectsHeld setSecretCode (int SubjectKey, String Date, String SecretCode) throws SQLException
    {
        String sql = "INSERT INTO SubjectsHeld(SubjectKey, Date, SecretCode,) VALUES (?,?,?)";
        SubjectsHeld a = new SubjectsHeld(SubjectKey,Date,SecretCode);
        try(Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, SubjectKey);
            stmt.setString(2, Date);
            stmt.setString(3, SecretCode);

            }    catch (SQLException ex) {
            Logger.getLogger(AttendanceDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return a;
    }
     // add more getters.....-------------------------------------------------------------------------------------------------------------------
    public List<SubjectsHeld> getSecretCode () throws SQLException
    {
        List<SubjectsHeld> SecretCode = new ArrayList<>();

        try ( Connection con = db.getConnection()) {
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
    public String getLatestSubjectsHeld(int skey) throws SQLException
    {
        String date ="";
          db = new DBConnection();
        try(Connection con = db.getConnection()) {
            String SQLStmt = "SELECT TOP 1 * FROM SUBJECTSHELD WHERE subjectKey = '"+skey+"'ORDER BY date DESC;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
           while(rs.next())
           {
             date = rs.getString("date");
           }

        }
        return date;
}

}
