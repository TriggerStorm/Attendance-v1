/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.be;

import java.util.List;

/**
 *
 * @author Trigger
 */
public class User {
    private int userKey;
    private String userName;
    private String password;
    private String email;
    private int phoneNr;
    private String address;
    private String teacher;
    private String userIMG;
    private List<SubjectAttendance> attendance;
    
    
 public User (int userKey, String userName,String password,String email,int phoneNr,String address,String teacher,String userIMG, List<SubjectAttendance> attendance){
 
     this.userKey = userKey;
     this.userName = userName;
     this.password = password;
     this.email = email;
     this.phoneNr = phoneNr;
     this.address = address;
     this.teacher = teacher;
     this.userIMG = userIMG;
     this.attendance = attendance;
     
 }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getUserIMG() {
        return userIMG;
    }

    public void setUserIMG(String userIMG) {
        this.userIMG = userIMG;
    }
    
    public List<SubjectAttendance> getAttendance () {
        return attendance;
    }

    public void setUserIMG(List<SubjectAttendance> attendance) {
        this.attendance = attendance;
    }
 
}
