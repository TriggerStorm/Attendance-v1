/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.StudentSubjects;
import attendance.v1.be.Student_Classes;
import attendance.v1.be.Subject;
import attendance.v1.be.SubjectsHeld;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author admin
 */
public class Student_SubjectDBDAO {
    private DBConnection db;
    public List<StudentSubjects> getSubjectsOfGivenStudent(int uKey) throws SQLException 
    {
        db = new DBConnection();
      List<StudentSubjects> studentSubjects= new ArrayList();
           
        try(Connection con = db.getConnection()){
            String SQLStmt = "SELECT * FROM STUDENT_SUBJECTS WHERE userKey = '"+uKey+"';";
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
           
             
          
                 while(rs.next()) 
            {
                int subjectKey = rs.getInt("subjectKey");
                StudentSubjects p = new StudentSubjects(subjectKey,uKey);
                studentSubjects.add(p);
            }    
        }
       return studentSubjects;
    }
          
    
    
    
            }    
        
      
    

