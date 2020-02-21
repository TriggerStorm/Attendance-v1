/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.ScoMok;
import attendance.v1.be.User;
import java.util.List;

/**
 *
 * @author Trigger
 */
public interface IDAL {
    boolean CheckUser(String email, String password);
    
    boolean CheckTeacher(String email);
    public String course();
    public String gCode();
    public List<ScoMok> getDBOSAttandance();
    public List<ScoMok> getItoAttandance();
    public List<ScoMok> getSdeAttandance();
    public List<ScoMok> getScoAttandance();
}
