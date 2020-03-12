/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Trigger
 */
public class DateUtil {
    private int[] attendance = new int[5];
    
    public int[] addDayToAttendance() {
        LocalDate now = LocalDate.now();
        int dayOfWeek = now.getDayOfWeek().getValue();
        
 //       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
 //       String dateNowString = now.format(formatter);
        return attendance;
    } 
   
    
    public LocalDate stringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        LocalDate dateNow = LocalDate.parse(dateString, formatter);
        return dateNow;
    }

}
