/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.be;

/**
 *
 * @author Trigger
 */
public class Attendance {
    
        private String userKey;
        private String subjectKey;
        private String dateHeld;
        private int SecretCode;
        
        
public Attendance(String studentKey, String classKey, String dateHeld){
    this.userKey = studentKey;
    this.subjectKey = classKey;
    this.dateHeld = dateHeld;
}
public Attendance(String classKey, String dateHeld, int SecretCode)
{
    this.subjectKey = classKey;
    this.dateHeld = dateHeld;
    this.SecretCode = SecretCode;
}

    public void setSecretCode(int SecretCode) {
        this.SecretCode = SecretCode;
    }

    public int getSecretCode() {
        return SecretCode;
    }

    public String getUserKey() {
        return userKey;
    }

    public String getSubjectKey() {
        return subjectKey;
    }

    public String getDateHeld() {
        return dateHeld;
    }

    public void setUserKey(String studentKey) {
        this.userKey = studentKey;
    }

    public void setSubjectKey(String classKey) {
        this.subjectKey = classKey;
    }

    public void setDateHeld(String dateHeld) {
        this.dateHeld = dateHeld;
    }
        
        
}


