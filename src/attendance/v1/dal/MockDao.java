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
    private User mockuser2;
    
    
    public MockDao() {
         mockuser1 = new User(1,"admin", "admin","admin@test.com", 12345678 ,"1 Mock St" , true, "data/mockuserIMG.jpg");
         mockuser2 = new User(1,"student", "student","student@test.com", 12345678 ,"2 Mock St" , false, "data/mockuserIMG.jpg");
    }
    
    
    public boolean CheckUser(String email, String password) {
        String name = mockuser1.getEmail();
        String passw = mockuser1.getPassword();
        String name2 = mockuser2.getEmail();
        String passw2 = mockuser2.getPassword();
        if(email.equals(name) || email.equals(name2)) //remember that to compare two strings you need to use equals()
        {
            if(password.equals(passw) || password.equals(passw2)) //remember that to compare two strings you need to use equals()
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
    
    public boolean CheckTeacher(String email)
    {
        if(email.equals(mockuser1.getEmail()))
        {
            return mockuser1.getTeacher();//for now we just return the boolean, later it will probably be easier to have sorted the users into students and teachers beforehand, as the DB can sort this out faster.
        }
        else if(email.equals(mockuser1.getEmail()))
        {
            return mockuser2.getTeacher();
        }
        else
        {
            return false;
        }
    }

}