/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.be;

import java.time.LocalDate;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */

public class Absence {
    private int studentKey;
    private LocalDate date;
    
    
    public  Absence(int studentKey, LocalDate date) {
        this.studentKey = studentKey;
        this.date = date;
    }

    
    public int getStudentKey() {
        return studentKey;
    }
    
    
    public void setStudentKey(int studentKey) {
        this.studentKey = studentKey;
    }
    
    
    public LocalDate getDate() {
        return date;
    }
    
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}
