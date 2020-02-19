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
public class MockDao {
    
    private User mockuser1;
    
    
    public MockDao() {
         mockuser1 = new User(1,"admin", "admin","mock@mail.com", 12345678 ,"1 Mock St" , "False", "data/mockuserIMG.jpg");
    }
    
    
    public User CheckUser(String user, String password) {
        if(user == mockuser1.getUserName()) {
          if(password == mockuser1.getPassword()) {    
            return mockuser1;
//            {
        }
        return null; // fail log in ?
    }
        return null;
    
    
 }
}