/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.ScoMok;
import attendance.v1.be.User;
import java.util.List;

/**
 *
 * @author Trigger
 */
public interface IBLL {
    
    int CheckUser(String email, String Password);
    public String course();
    public String gCode();
    public List<ScoMok> getDBOSattendance();
    public List<ScoMok> getITOattendance();
    public List<ScoMok> getSDEattendance();
    public List<ScoMok> getSCOattendance();
  
    List<String> addDayToAttendance(String selectedCourse);



    
 /*   
    //Mock data methods
    String[] getSCOsttendance();
    String[] getSDEsttendance();
    String[] getDBOSsttendance();
    String[] getITOsttendance();
    */
}
