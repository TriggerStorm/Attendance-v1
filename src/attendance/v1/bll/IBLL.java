/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.User;

/**
 *
 * @author Trigger
 */
public interface IBLL {
        int CheckUser(String email, String Password);

}
