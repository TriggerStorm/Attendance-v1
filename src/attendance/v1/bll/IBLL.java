/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.User;
import java.util.List;

/**
 *
 * @author Trigger
 */
public interface IBLL {
    
        User CheckUser(String user);
        List<String> addDayToAttendance(String selectedCourse);


}
