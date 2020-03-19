/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.Attendance;
import attendance.v1.be.StudentSubject;
import attendance.v1.be.SubjectAttendance;
import attendance.v1.be.SubjectsHeld;
import com.microsoft.sqlserver.jdbc.SQLServerException;
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
 * @author Trigger, Filip, Cecillia and Alan
 */


public class StudentSubjectDBDAO {
    private DBConnection dbc;

    
    public StudentSubjectDBDAO() {
        dbc = new DBConnection();
    }
    
    
    public List<StudentSubject> getAllStudentSubjects() throws SQLException {
        List<StudentSubject> allStudentSubjects = new ArrayList(); //get a list to store the values.
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT * FROM STUDENT_SUBJECTS;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) //While you have something in the results
            {
                int subjectKey = rs.getInt("SubjectKey");
                int userKey = rs.getInt("UserKey");
                allStudentSubjects.add(new StudentSubject(subjectKey, userKey)); 
            }    
        }
        return allStudentSubjects;
    }
    
     
    public StudentSubject getStudentSubject(int subjectKey, int userKey) throws SQLException { 
        List<StudentSubject> allStudentSubjects = getAllStudentSubjects();
        StudentSubject testStudentSubject;
        for (int i = 0; i < allStudentSubjects.size(); i++) {
            testStudentSubject = allStudentSubjects.get(i);
            int testSubjectKey = testStudentSubject.getSubjectKey();
            int testUserKey = testStudentSubject.getUserKey();
            if ((testSubjectKey == subjectKey) && (testUserKey == userKey))  {
            return testStudentSubject;
            }
        }
        return null;  // StudentSubject does not exist
    }
    
    
    public List<StudentSubject> getSubjectsOfAStudent(int userKey) throws SQLException {
        List<StudentSubject> studentSubjects= new ArrayList();
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT * FROM  Student_Subjects WHERE userKey = '"+ userKey +"';";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) 
            {
                int subjectKey = rs.getInt("subjectKey");
                int userrKey = rs.getInt("userKey");
                StudentSubject p = new StudentSubject(subjectKey,userrKey);
                studentSubjects.add(p);
            }    
        }
       return studentSubjects;
    }
    
    
     public /*StudentSubject*/ void addNewStudentSubjectToDB(int subjectKey, int userKey) throws SQLException { 
        String sql = "INSERT INTO STUDENT_SUBJECTS(SubjectKey, UserKey) VALUES (?,?)";
        StudentSubject newStudentSubject = new StudentSubject(subjectKey, userKey);
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, subjectKey);
            stmt.setInt(2, userKey);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating attendance failed, no rows affected.");
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(StudentSubjectDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentSubjectDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
   //     return a StudentSubject if needed
    }
 
     
    public void removeStudentSubjectFromDB(int subjectKey, int userKey) throws SQLException {  // may need to change to int subjectKey, int userKey, and then use getStudentSubject method
        String stat = "DELETE FROM Student_Subjects WHERE SubjectKey = ? AND UserKey = ?";
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(stat);
            stmt.setInt(1, subjectKey);
            stmt.setInt(2, userKey);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Exception " + ex);
        }
    }
     
     
}
