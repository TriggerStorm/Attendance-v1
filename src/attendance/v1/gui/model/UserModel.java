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
    }
    
   /* public User CheckUser(String userName, String password ){
        User user = bllManager.CheckUser(userName, password); // its hire it dont work.   it need to send 2 string form gui to the mok dall to varify user log in.
        return user;
    }*/
}
