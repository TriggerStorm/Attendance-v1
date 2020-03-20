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
    

        private int studentKey;
        private int subjectKey;
        private String dateHeld;
        
        
public Attendance(int studentKey, int subjectKey, String dateHeld){

    this.studentKey = studentKey;
    this.subjectKey = subjectKey;
    this.dateHeld = dateHeld;
}


    public int getStudentKey() {
        return studentKey;

    }
    


    public void setStudentKey(int studentKey) {
        this.studentKey = studentKey;

    }
    
    
    public int getSubjectKey() {
        return subjectKey;
    }


    
    public void setSubjectKey(int subjectKey) {
        this.subjectKey = subjectKey;
    }

    public String getDateHeld() {
        return dateHeld.split("T")[0];

    }

    
    public void setDateHeld(String dateHeld) {
        this.dateHeld = dateHeld;
    }
        
    @Override
    public String toString()
    {
        this.dateHeld = dateHeld.split("T")[0];
        return this.dateHeld+"LOL";
    }
        
}


