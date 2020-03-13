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
        private String studentKey;
        private String subjectKey;
        private String dateHeld;
        
        
        
public Attendance(String studentKey, String classKey, String dateHeld){

    this.userKey = studentKey;
    this.studentKey = studentKey;
    this.subjectKey = classKey;
    this.dateHeld = dateHeld;
}
    public String getUserKey() {
        return userKey;
    }


    public String getClassKey() {

        return subjectKey;
    }

    public String getDateHeld() {
        return dateHeld;
    }

    public void setUserKey(String studentKey) {
        this.userKey = studentKey;
    }


    public void setClassKey(String classKey) {

        this.subjectKey = classKey;
    }

    public void setDateHeld(String dateHeld) {
        this.dateHeld = dateHeld;
    }
        
        
}


