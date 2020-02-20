/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.User;
import java.util.List;

/**
 *
 * @author Trigger
 */
public interface IDAL {

    
   
    List<String> addDayToAttendance(String selectedCourse);


    boolean CheckUser(String email, String password);
    
    boolean CheckTeacher(String email);

    //Mock data methods
    String[] getSCOattendance();
    String[] getSDEattendance();
    String[] getDBOSattendance();
    String[] getITOattendance();

}
