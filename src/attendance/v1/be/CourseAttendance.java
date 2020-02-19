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
public class CourseAttendance {
    private String courseName;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    private int saturday;
    private int sunday;
    
    
    public CourseAttendance(String courseName, int monday, int tuesday, int wednesday, int thursday, int friday, int saturday, int sunday) {
        this.courseName = courseName;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName() {
        this.courseName = courseName;
    }
    
    public int getMonday() {
        return monday;
    }
    
    public void setMonday() {
        this.monday = monday;
    }
    
    public int getTuesday() {
        return tuesday;
    }
    
    public void setTuesday() {
        this.tuesday = tuesday;
    }
    
    public int getWednesday() {
        return wednesday;
    }
    
    public void setWednesday() {
        this.wednesday = wednesday;
    }
    public int getThursday() {
        return thursday;
    }
    
    public void setThursday() {
        this.thursday = thursday;
    }
    public int getFriday() {
        return friday;
    }
    
    public void setFriday() {
        this.friday = friday;
    }
    public int getSaturday() {
        return saturday;
    }
    
    public void setSaturday() {
        this.saturday = saturday;
    }
    
    public int getSunday() {
        return sunday;
    }
    
    public void setSunday() {
        this.sunday = sunday;
    }
    
    
   
}
