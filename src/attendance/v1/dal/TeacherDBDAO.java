/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.Subject;
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
public class TeacherDBDAO {
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
     public Subject assignTeacherClass(Subject classes, String teacher) throws SQLException 
    {
        db = new DBConnection();
        
           
        try(Connection con = db.getConnection()){
            String SQLStmt = "UPDATE SUBJECTS SET AssociatedTeacher = ? WHERE id = ?;";
            
            PreparedStatement pstmt = con.prepareStatement(SQLStmt);
             pstmt.setString(1,teacher);
            pstmt.setInt(2,classes.getClasskey());
        }
        return new Subject(classes.getClasskey(),classes.getClassName(),classes.getClassIMG(),classes.getAssociatedCourse(),teacher);
}
}
