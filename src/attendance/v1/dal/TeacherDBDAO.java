/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.Classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
     public Classes assignTeacherClass(Classes classes, String teacher) throws SQLException 
    {
        db = new DBConnection();
        
           
        try(Connection con = db.getConnection()){
            String SQLStmt = "UPDATE SUBJECTS SET AssociatedTeacher = ? WHERE id = ?;";
            
            PreparedStatement pstmt = con.prepareStatement(SQLStmt);
             pstmt.setString(1,teacher);
            pstmt.setInt(2,classes.getClasskey());
        }
        return new Classes(classes.getClasskey(),classes.getClassName(),classes.getClassIMG(),classes.getAssociatedCourse(),teacher);
}
}
