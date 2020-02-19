/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.User;
import attendance.v1.dal.IDAL;
import java.util.List;

/**
 *
 * @author Trigger
 */
public class BllManager implements IBLL {
    private IDAL dalManager;

    
    @Override
    public User CheckUser (String user) {
        return dalManager.CheckUser(user);
    }
    
    
    @Override
    public List<String> addDayToAttendance(String selectedCourse) {
        return dalManager.addDayToAttendance(selectedCourse);
    }
}
