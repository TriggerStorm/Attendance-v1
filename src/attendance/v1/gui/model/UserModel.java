/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.model;

import attendance.v1.be.User;
import attendance.v1.bll.BllManager;

/**
 *
 * @author Trigger
 */
public class UserModel {
    private BllManager bllManager;

    public UserModel() {
        bllManager = new BllManager();
        bllManager.getAllUsers();
    }
    

    public int CheckUser(String email, String password ){  // Changed form int - Alan 12-03
        int loginstate = bllManager.checkUserLogin(email, password); //This method gets the int.

        return loginstate;
        
    }

}
