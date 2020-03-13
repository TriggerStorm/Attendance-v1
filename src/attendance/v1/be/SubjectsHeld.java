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
public class SubjectsHeld {
       
    
        private int subjectKey;
        private String dateHeld;
        private String SecretCode;

public SubjectsHeld (int subjectKey, String dateHeld, String SecretCode)
{
    this.subjectKey = subjectKey;
    this.dateHeld = dateHeld;
    this.SecretCode = SecretCode;
}

    public int getSubjectKey() {
        return subjectKey;
    }

    public String getDateHeld() {
        return dateHeld;
    }

    public void setSubjectKey(int subjectKey) {
        this.subjectKey = subjectKey;
    }

    public void setDateHeld(String dateHeld) {
        this.dateHeld = dateHeld;
    }

    public void setSecretCode(String SecretCode) {
        this.SecretCode = SecretCode;
    }

    public String getSecretCode() {
        return SecretCode;
    }
        
        
public SubjectsHeld(String SecretCode){
    this.SecretCode = SecretCode;
}
}