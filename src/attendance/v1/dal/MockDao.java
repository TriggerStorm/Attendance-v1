/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trigger
 */
public class MockDao {
    List<String> attendance = new ArrayList<>();
    private User mockuser1;
    
    
    public MockDao() {
 //       attendance.add("SCO", "0", "0", "0", "0", "0", "0", "0");
         mockuser1 = new User(1,"admin", "admin","mock@mail.com", 12345678 ,"1 Mock St" , "False", "data/mockuserIMG.jpg", attendance);
    }
    
    
    public User CheckUser(String user) {
        if(user == mockuser1.getUserName()) {
//          if(password == mockuser1.  getPassword {    
            return mockuser1;
//            {
        }
        return null;
    }
    
    
    
    
    public List<String> addDayToAttendance() {
        LocalDate now = LocalDate.now();
        int dayOfWeek = now.getDayOfWeek().getValue();
        
 //       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
 //       String dateNowString = now.format(formatter);
        return attendance;
    } 
   
    
    

    }
    
