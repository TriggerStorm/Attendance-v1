/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;


import attendance.v1.be.SubjectAttendance;
import attendance.v1.be.User;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import attendance.v1.be.ScoMok;
import attendance.v1.be.User;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;

import attendance.v1.be.ScoMok;

import attendance.v1.be.ScoMok;

import java.util.List;


import attendance.v1.be.ScoMok;

import attendance.v1.be.ScoMok;

import attendance.v1.be.ScoMok;

/**
 *
 * @author Trigger
 */
public class MockDao {
    public List<String> attendance = new ArrayList<>();
    public User mockuser1;
    public User mockuser2;

    public SubjectAttendance mockSCO;
    public SubjectAttendance mockSDE;
    public SubjectAttendance mockDBOS;
    public SubjectAttendance mockITO;

    public List<SubjectAttendance> mockStudentAttendance;
    
    public MockDao() {
        
/*        mockStudentAttendance = new ArrayList<SubjectAttendance>();
        SubjectAttendance mockSCO = new SubjectAttendance("SCO", 1, 0, 2, 0, 3);
        SubjectAttendance mockSDE = new SubjectAttendance("SDE", 4, 5, 0, 0, 0);
        SubjectAttendance mockDBOS = new SubjectAttendance("DBOS", 0, 0, 0, 6, 0);
        SubjectAttendance mockITO = new SubjectAttendance("ITO", 0, 0, 0, 7, 0);

        mockStudentAttendance.add(mockSCO);
        mockStudentAttendance.add(mockSDE);
        mockStudentAttendance.add(mockDBOS);
        mockStudentAttendance.add(mockITO);


        mockuser1 = new User(1,"admin", "admin","mock@mail.com", 12345678 ,"1 Mock St" , "Y", "data/mockuserIMG.jpg");
   
    

    }
    
    
    
    public int mockPrintOut() {
         int count = mockStudentAttendance.size();
        return count;
    }
    
    
    public static void main(String[] args) {
        MockDao mockdao = new MockDao();
        mockdao.addDayToAttendance("SCO");
        //        launch(args);


        // mockuser1 = new User(1,"admin", "admin","admin@test.com", 12345678 ,"1 Mock St" , true, "data/mockuserIMG.jpg"); // add list
        // mockuser2 = new User(2,"student", "student","student@test.com", 12345678 ,"2 Mock St" , false, "data/mockuserIMG.jpg");//

    }
   

    
    
    
    
    public boolean CheckUser(String email, String password) {
        String name = mockuser1.getEmail();
        String passw = mockuser1.getPassword();
        String name2 = mockuser2.getEmail();
        String passw2 = mockuser2.getPassword();
        if(email.equals(name) || email.equals(name2)) //remember that to compare two strings you need to use equals()
        {
            if(password.equals(passw) || password.equals(passw2)) //remember that to compare two strings you need to use equals()
            {    
            return true; //user and password match.
            }
            else
            {
            return false; // fail log in
            }
        }
        else
        {
        return false;// fail log in
        }
    }
    
    
    
    
    public List<String> addDayToAttendance(String selectedCourse) { // bit rough. Work in progress. Needs a lot of work
 /*       selectedCourse = "SCO";  // will come from gui later
        LocalDate now = LocalDate.now();
        int dayOfWeek = now.getDayOfWeek().getValue();
        int noOfCourses = attendance.size();
        if (noOfCourses > 0) {
            System.out.println("No of courses =" + noOfCourses);
            for (int i = 0; i < noOfCourses; i++) {
            
            String testCourse = attendance.get(i);
                System.out.println("Course number:" + (i+1));
                System.out.println(testCourse);
        }
        return attendance;
    } 
       return null; 
    }
    

    public boolean CheckTeacher(String email) {
/*        if(email.equals(mockuser1.getEmail()))
        {
            return mockuser1.getTeacher();//for now we just return the boolean, later it will probably be easier to have sorted the users into students and teachers beforehand, as the DB can sort this out faster.
        }
        else if(email.equals(mockuser1.getEmail()))
        {
            return mockuser2.getTeacher();
        }
        else
        { 
            return false;
        
    }
        
    
   
    
    public String[] getSubjectAttendance(String subject) {
 /*       SubjectAttendance subjectCheck;
        String[] subjectString;
        int weekdayAttendance = 0;
        if (mockStudentAttendance.size()>0) {
            for(int i = 0; i > mockStudentAttendance.size(); i++) {
                subjectCheck = null; 
                // need to finish this method later
            }
        } 
        return null;
    }

    
    public String gCode() {
        String gCode = "9W6A";
        return gCode;
    }
        
     public String course() {
        String course = "Computer Science";
        return course;
    } 

    public List<ScoMok> getSCOattendance(){
        List<ScoMok> allSco = new ArrayList<>();
        String Name = ("student");
        allSco.add(new ScoMok(Name,5,8,5,6,8,56));
        return allSco;
    }
    public List<ScoMok> getSDEattendance(){
        List<ScoMok> allSco = new ArrayList<>();
        String Name = ("student");
        allSco.add(new ScoMok(Name,9,9,9,9,9,99));
        return allSco;
    }
    public List<ScoMok> getITOattendance(){
        List<ScoMok> allSco = new ArrayList<>();
        String Name = ("student");
        allSco.add(new ScoMok(Name,5,4,2,7,5,69));
        return allSco;
    }
    public List<ScoMok> getDBOSattendance(){
        List<ScoMok> allSco = new ArrayList<>();
        String Name = ("student");
        allSco.add(new ScoMok(Name,12,0,6,4,7,54));
        return allSco;
    }
    */
    }
}