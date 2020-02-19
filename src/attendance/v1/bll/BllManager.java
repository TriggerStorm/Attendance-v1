/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.User;
import attendance.v1.dal.IDAL;

/**
 *
 * @author Trigger
 */
public class BllManager implements IBLL {
    private IDAL dalManager;

    
     @Override
    public int CheckUser (String user, String password) {


        int[] Status  = {1,2,3};
        if(dalManager.CheckUser(user, password) == true)
        {
            if(dalManager.CheckTeacher(user, password) == true)
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
}
