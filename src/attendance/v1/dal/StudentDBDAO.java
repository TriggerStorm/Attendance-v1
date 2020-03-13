/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;
import attendance.v1.dal.DBConnection;
import attendance.v1.be.Subject;
import attendance.v1.be.StudentSubjects;
import attendance.v1.be.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author macos
 */
public class StudentDBDAO {
   private DBConnection db;
    
     
     public StudentSubjects assignStudentCourse(User user ,int course) throws SQLException 
    {
        for(int i = 0; i < getSubjectsSPECIFIC(course).size();i++)
            
        {db = new DBConnection();
        
           int ukey = user.getUserKey();
           int skey = getSubjectsSPECIFIC(course).get(i).getClasskey();
           try(Connection con = db.getConnection()){
            String SQLStmt = "INSERT INTO  STUDENT_SUBJECTS(subjectKey,userKey) VALUES (?,?); ";
            
            PreparedStatement pstmt = con.prepareStatement(SQLStmt);
            
             pstmt.setInt(1,ukey);
             pstmt.setInt(2, skey);
             pstmt.execute();
        }
       return new StudentSubjects(ukey,skey);
        } 
      return null;
}
      public List<Subject> getSubjectsSPECIFIC(int course) throws SQLException 
    {
        db = new DBConnection();
        List<Subject> allclasses = new ArrayList();
           
        try(Connection con = db.getConnection()){
            String SQLStmt = "SELECT * FROM SUBJECTS WHERE AssociatedCourse = ?;";
             PreparedStatement pstmt = con.prepareStatement(SQLStmt);   
             pstmt.setInt(1,course);
             pstmt.execute();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            
            while(rs.next()) 
            {
               
                
                int SubjectKey = rs.getInt("SubjectKey");
                String SubjectName = rs.getString("SubjectName");
                String SubjectIMG = rs.getString("SubjectIMG");
                String AssociatedCourse = rs.getString("AssociatedCourse");
                String AssociatedTeacher = rs.getString("AssociatedTeacher");
                Subject p = new Subject(SubjectKey,SubjectName,SubjectIMG,AssociatedCourse,AssociatedTeacher);
                allclasses.add(p);
            }    
        }
       return allclasses;
    }
}

