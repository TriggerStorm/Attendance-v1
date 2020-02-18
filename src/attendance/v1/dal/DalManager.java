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
    public User CheckUser (String user) {
        return mockdao.CheckUser(user);
    }
}
