/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.Subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author macos
 */
public class TeacherDBDAO {
     private DBConnection db;

    
     public Subject assignTeacherClass(Subject subject, String teacher) throws SQLException 

    {
        db = new DBConnection();
        
           
        try(Connection con = db.getConnection()){
            String SQLStmt = "UPDATE SUBJECTS SET AssociatedTeacher = ? WHERE subjectKey = ?;";
            
            PreparedStatement pstmt = con.prepareStatement(SQLStmt);

             pstmt.setString(1,teacher);
            pstmt.setInt(2,subject.getSubjectKey());
        }
        return new Subject(subject.getSubjectKey(),subject.getSubjectName(),subject.getSubjectIMG(),subject.getAssociatedCourse(),teacher);

}
}
