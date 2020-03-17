/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.bll.BllManager;
import attendance.v1.bll.IBLL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public class BLLutilities {
    
 
    public static boolean hasFourHoursPass (String dateTimeHeldString) {
         LocalDateTime dateTimeHeld = stringToLocalDateTime(dateTimeHeldString);
        LocalDateTime fourHoursAgo = LocalDateTime.now().minusHours(4);
        boolean fourHoursHavePassed = fourHoursAgo.isAfter(dateTimeHeld);
        return fourHoursHavePassed;
     }
    
    
    
    public static LocalDateTime stringToLocalDateTime(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
        LocalDateTime later = LocalDateTime.parse(dateString, formatter);
        return later;
    }
     
     public static String localDateTimeToString(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
        String dateString = date.format(formatter);
        return dateString;
    } 
     
    
    
    
/*    
      
     public int CheckUser (String email, String password) {//Checks if the user exists, and what kind of user we have.

        boolean usercheck = dalManager.CheckUser(email, password);
        int[] Status  = {1,2,3};//just for easy reference later, might have omitted this and just hardcoded the values.
        if(usercheck) //is a boolean already, so we don't need to use ==. Checks if the user exists.
        {
            boolean teachercheck = dalManager.CheckTeacher(email);
            if(teachercheck)//is a boolean already, so we dont' need to use ==, checks if the user is a teacher.
            {
                return Status[0];
            }
            else
            {
                return Status[1];
            }
        }
        
        else
        {
            return Status[2];
        }
    } */
}
