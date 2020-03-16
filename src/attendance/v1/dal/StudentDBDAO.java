/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;
import attendance.v1.dal.DBConnection;
import attendance.v1.be.Subject;
import attendance.v1.be.StudentSubject;
import attendance.v1.be.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author macos
 */
public class StudentDBDAO {
   private DBConnection db;
     public List<Subject> getSubjects() throws SQLException 
    {
        db = new DBConnection();
        List<Subject> allclasses = new ArrayList();
           
        try(Connection con = db.getConnection()){
            String SQLStmt = "SELECT * FROM SUBJECTS;";
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            
            while(rs.next()) 
            {
               
                
                int subjectKey = rs.getInt("SubjectKey");
                String subjectName = rs.getString("SubjectName");
                String subjectIMG = rs.getString("SubjectIMG");
                String associatedCourse = rs.getString("AssociatedCourse");
                String associatedTeacher = rs.getString("AssociatedTeacher");
                Subject p = new Subject(subjectKey,subjectName,subjectIMG,associatedCourse,associatedTeacher);
                allclasses.add(p);
            }    
        }
       return allclasses;
    }
     
     public StudentSubject assignStudentCourse(Subject subject, User user) throws SQLException 
    {
        db = new DBConnection();
        
           int ukey = user.getUserKey();
           int ckey = subject.getSubjectKey();
        try(Connection con = db.getConnection()){
            String SQLStmt = "UPDATE STUDENT_SUBJECTS SET SUBJECTKEY = ?,USERKEY = ? WHERE id = ?;";
            
            PreparedStatement pstmt = con.prepareStatement(SQLStmt);
            
             pstmt.setInt(1,ukey);
             pstmt.setInt(2,ckey);
            pstmt.setInt(3,ckey);
        }
        return new StudentSubject(ukey,ckey);
}
}

