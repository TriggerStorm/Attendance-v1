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
        public List<ScoMok> getDBOSAttandance();
        public List<ScoMok> getItoAttandance();
        public List<ScoMok> getSdeAttandance();
        public List<ScoMok> getScoAttandance();
        

    
        
    List<String> addDayToAttendance(String selectedCourse);


    int CheckUser(String email, String Password);

    
    
    //Mock data methods
    String[] getSCOsttendance();
    String[] getSDEsttendance();
    String[] getDBOSsttendance();
    String[] getITOsttendance();
}
