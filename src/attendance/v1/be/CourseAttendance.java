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
   
    
    
    public CourseAttendance(String courseName, int monday, int tuesday, int wednesday, int thursday, int friday) {
        this.courseName = courseName;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
    }

    
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public int getMonday() {
        return monday;
    }
    
    public void setMonday(int monday) {
        this.monday = monday;
    }
    
    public int getTuesday() {
        return tuesday;
    }
    
    public void setTuesday(int tuesday) {
        this.tuesday = tuesday;
    }
    
    public int getWednesday() {
        return wednesday;
    }
    
    public void setWednesday(int wednesday) {
        this.wednesday = wednesday;
    }
    public int getThursday() {
        return thursday;
    }
    
    public void setThursday(int thursday) {
        this.thursday = thursday;
    }
    public int getFriday() {
        return friday;
    }
    
    public void setFriday(int friday) {
        this.friday = friday;
    }
    
    
   
}
