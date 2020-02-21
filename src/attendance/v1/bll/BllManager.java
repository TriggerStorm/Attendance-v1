/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.ScoMok;
import attendance.v1.be.User;
import attendance.v1.dal.DalManager;
import java.util.List;

/**
 *
 * @author Trigger
 */
public class BllManager implements IBLL {
    private DalManager dalManager = new DalManager();

    
     @Override
    public int CheckUser (String email, String password) {//Checks if the user exists, and what kind of user we have.

        boolean usercheck = dalManager.CheckUser(email, password);
        int[] Status  = {1,2,3};//just for easy reference later, might have omitted this and just hardcoded the values.
        if(usercheck) //is a boolean already, so we don't need to use ==. Checks if the user exists.
        {
            boolean teachercheck = dalManager.CheckTeacher(email);
            if(teachercheck)//is a boolean already, so we dont' need to use ==, checks if the user is a teacher.
            {
                return Status[0];
            }
            else
            {
                return Status[1];
            }
        }
        
        else
        {
            return Status[2];
        }
    }
    
    public List<ScoMok> getScoAttandance(){
        return dalManager.getScoAttandance();
    }
    public List<ScoMok> getSdeAttandance(){
        return dalManager.getSdeAttandance();
    }
    public List<ScoMok> getItoAttandance(){
        return dalManager.getItoAttandance();
    }
    public List<ScoMok> getDBOSAttandance(){
        return dalManager.getDBOSAttandance();
    }
    public String gCode(){
     return dalManager.gCode();
    }
    public String course(){
     return dalManager.course();
    }
    
    
    
}
