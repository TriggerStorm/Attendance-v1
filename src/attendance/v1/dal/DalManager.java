/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.ScoMok;
import attendance.v1.be.User;
import java.util.List;

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
    public boolean CheckUser (String email, String password) { //checks if our user exsts and the password is correct.
        return mockdao.CheckUser(email,password);
    }
    
    @Override
    public boolean CheckTeacher(String email) {//checks to see if our user is a teacher, doesn't need the password for that.
        return mockdao.CheckTeacher(email);
    }
    
    public List<ScoMok> getScoAttandance(){
        return mockdao.getScoAttandance();
        
    }
    public List<ScoMok> getSdeAttandance(){
        return mockdao.getSdeAttandance();
    }
    public List<ScoMok> getItoAttandance(){
        return mockdao.getItoAttandance();
    }
    public List<ScoMok> getDBOSAttandance(){
        return mockdao.getDBOSAttandance();
    }
    
    
    
}
