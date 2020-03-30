/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import java.time.LocalDate;

/**
 *
 * @author admin
 */
public class CalendarDBDAO {
    
    public void submitAbsence (int studentKey, LocalDate datePicked ) {  // just a test for now

System.out.println("");
System.out.println("DBDAO student = " + studentKey); 
System.out.println("");
System.out.println("DBDAO date picked = " + datePicked);
     
    }
    
    
}
