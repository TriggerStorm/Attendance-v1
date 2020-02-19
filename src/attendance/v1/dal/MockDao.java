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
         mockuser1 = new User(1,"admin", "admin","mock@mail.com", 12345678 ,"1 Mock St" , true, "data/mockuserIMG.jpg");
    }
    
    
    public boolean CheckUser(String user, String password) {
        String name = mockuser1.getUserName();
        String passw = mockuser1.getPassword();
        if(user.equals(name)) //remember that to compare two strings you need to use equals()
        {
            if(password.equals(passw)) //remember that to compare two strings you need to use equals()
            {    
            return true; //user and password match.
            }
            else
            {
            return false; // fail log in
            }
        }
        else
        {
        return false;// fail log in
        }
    }
    
    public boolean CheckTeacher(String user)
    {
        return mockuser1.getTeacher();//for now we just return the boolean, later it will probably be easier to have sorted the users into students and teachers beforehand, as the DB can sort this out faster.
    }

}