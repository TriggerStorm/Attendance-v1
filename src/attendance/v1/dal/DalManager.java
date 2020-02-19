/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.User;

/**
 *
 * @author Trigger
 */
public class DalManager implements IDAL {
    private MockDao mockdao;
    
    public DalManager() {
          mockdao = new MockDao();
    } 
    
    
    @Override
    public boolean CheckUser (String user, String password) { //checks if our user exsts and the password is correct.
        return mockdao.CheckUser(user,password);
    }
    
    @Override
    public boolean CheckTeacher(String user) {//checks to see if our user is a teacher, doesn't need the password for that.
        return mockdao.CheckTeacher(user);
    }
}
