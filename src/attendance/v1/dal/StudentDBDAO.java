/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;
import attendance.v1.dal.DBConnection;
import attendance.v1.be.Classes;
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
     public List<Classes> getSubjects() throws SQLException 
    {
        db = new DBConnection();
        List<Classes> allclasses = new ArrayList();
           
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
                Classes p = new Classes(SubjectKey,SubjectName,SubjectIMG,AssociatedCourse,AssociatedTeacher);
                allclasses.add(p);
            }    
        }
       return allclasses;
    }
     
     public Classes assignStudentCourse(Classes classes, String student) throws SQLException 
    {
        db = new DBConnection();
        
           
        try(Connection con = db.getConnection()){
            String SQLStmt = "UPDATE SUBJECTS SET AssociatedStudents = ? WHERE id = ?;";
            
            PreparedStatement pstmt = con.prepareStatement(SQLStmt);
             pstmt.setString(1,student);
            pstmt.setInt(2,classes.getClasskey());
        }
        return new Classes(classes.getClasskey(),classes.getClassName(),classes.getClassIMG(),student,classes.getAssociatedTeacher());
}
}

