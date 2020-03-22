/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.be;

/**
 *
 * @author cille
 */
public class LoggedInUser{
    
    private static LoggedInUser instance = null;
    
    private int userKey;
    private String userName;
    private String password;
    private String email;
    private int phoneNr;
    private String address;
    private int postCode;
    private String city;
    private boolean teacher;
    private String userIMG;
    private SubjectsHeld sbh;
    private int selectedSubjectKey;

    private LoggedInUser(){
     SubjectsHeld sbh = new SubjectsHeld(0,"","");
    }
   
    public static LoggedInUser getInstance()
    {
        if(instance == null)
        {
            instance = new LoggedInUser();
        }
        
        return instance;
    }


    public int getSelectedSubjectKey()
    {
        return selectedSubjectKey;
    }
    
    public void setSelectedSubjectKey(int subjectKey)
    {
        selectedSubjectKey = subjectKey;
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

    public int getPostCode() {
        return postCode;
    }
    
    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
     
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public boolean getTeacher() {
        return teacher;
    }

    public void setTeacher(boolean teacher) {
        this.teacher = teacher;
    }

    public String getUserIMG() {
        return userIMG;
    }

    public void setUserIMG(String userIMG) {
        this.userIMG = userIMG;
    }
    public void setSelectedSubjectsHeld(SubjectsHeld subjectsHeld)
    {
        this.sbh = subjectsHeld;
    }
    public SubjectsHeld getSelectedSubjectsHeld()
    {
        return sbh;
    }
}
