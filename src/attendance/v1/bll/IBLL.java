/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.ScoMok;
import attendance.v1.be.User;
import java.util.List;

/**
 *
 * @author Trigger
 */
public interface IBLL {
    
    int CheckUser(String email, String Password);
    public String course();
    public String gCode();
    
  
    List<String> addDayToAttendance(String selectedCourse);


}
