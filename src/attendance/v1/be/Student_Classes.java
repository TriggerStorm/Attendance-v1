/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.be;

/**
 *
 * @author admin
 */
public class Student_Classes {
    private int classKey;
    private int userKey;

    
    public Student_Classes (int classKey, int userKey) {
        this.classKey = classKey;
        this.userKey = userKey;
        }

    
    public int getClassKey() {
        return classKey;
    }
    
      
    public void setClassKey(int classKey) {
        this.classKey = classKey;
    }
 
       
    public int getUserKey() {
        return userKey;
    }

    
    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

}