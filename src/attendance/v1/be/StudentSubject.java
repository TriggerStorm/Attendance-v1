/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.be;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public class StudentSubject {
    private int subjectKey;
    private int userKey;

    
    public StudentSubject (int subjectKey, int userKey) {
        this.subjectKey = subjectKey;
        this.userKey = userKey;
        }

    
    public int getClassKey() {
        return subjectKey;
    }
    
      
    public void setClassKey(int subjectKey) {
        this.subjectKey = subjectKey;
    }
 
       
    public int getUserKey() {
        return userKey;
    }

    
    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

}