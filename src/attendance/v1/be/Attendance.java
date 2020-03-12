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
    
        private String studentKey;
        private String classKey;
        private String dateHeld;
        private int SecretCode;
        
        
public Attendance(String studentKey, String classKey, String dateHeld){
    this.studentKey = studentKey;
    this.classKey = classKey;
    this.dateHeld = dateHeld;
}
public Attendance(String classKey, String dateHeld, int SecretCode)
{
    this.classKey = classKey;
    this.dateHeld = dateHeld;
    this.SecretCode = SecretCode;
}

    public void setSecretCode(int SecretCode) {
        this.SecretCode = SecretCode;
    }

    public int getSecretCode() {
        return SecretCode;
    }

    public String getStudentKey() {
        return studentKey;
    }

    public String getClassKey() {
        return classKey;
    }

    public String getDateHeld() {
        return dateHeld;
    }

    public void setStudentKey(String studentKey) {
        this.studentKey = studentKey;
    }

    public void setClassKey(String classKey) {
        this.classKey = classKey;
    }

    public void setDateHeld(String dateHeld) {
        this.dateHeld = dateHeld;
    }
        
        
}


