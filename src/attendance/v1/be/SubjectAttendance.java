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


public class SubjectAttendance {
    private String name;
    private int userKey;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    private String percent;

    public SubjectAttendance(int userKey, String name,int monday,int tuesday,int wednesday,int thursday,int friday, String percent) {
        this.userKey = userKey;
        this.name = name;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.percent= percent;
    }
    
     public SubjectAttendance(int monday,int tuesday,int wednesday,int thursday,int friday) {
        
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        
    }
      
    public int getUserKey(){
        return userKey;
    }
    
    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
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
     
    public void setThursdag(int thursdag) {
        this.thursday = thursdag;
    }

    
    public int getFriday() {
        return friday;
    }
    
    public void setFriday(int friday) {
        this.friday = friday;
    }

    
    public String getPercent() {
        return percent;
    }
    
    public void setPercent(String percent) {
        this.percent = percent;
    }

    

}
