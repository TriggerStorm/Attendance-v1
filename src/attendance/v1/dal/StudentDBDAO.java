/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;
import attendance.v1.dal.DBConnection;
import attendance.v1.be.Classes;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author macos
 */
public class StudentDBDAO {
   private DBConnection db;
     public List<Classes> getSubjects() 
    {
        db = new DBConnection();
        List<Classes> allclasses = new ArrayList();
     return  allclasses;
}
}
