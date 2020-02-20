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

/**
 *
 * @author Trigger
 */
public class MockDao {
    public List<String> attendance = new ArrayList<>();
    public User mockuser1;
    public User mockuser2;

    public static SubjectAttendance mockSA;
    public List<SubjectAttendance> mockStudentAttendance;
    
    public MockDao() {
        mockStudentAttendance = new ArrayList<SubjectAttendance>();
        
        mockSA.setSubjectName("SCO");
        mockSA.setMonday(1);
        mockSA.setTuesday(0);
        mockSA.setWednesday(2);
        mockSA.setThursday(0);
        mockSA.setFriday(3);
        mockStudentAttendance.add(mockSA);
        
        mockSA.setSubjectName("SDE");
        mockSA.setMonday(4);
        mockSA.setTuesday(5);
        mockSA.setWednesday(0);
        mockSA.setThursday(0);
        mockSA.setFriday(0);
        mockStudentAttendance.add(mockSA);
        
        mockSA.setSubjectName("DBOS");
        mockSA.setMonday(0);
        mockSA.setTuesday(0);
        mockSA.setWednesday(0);
        mockSA.setThursday(6);
        mockSA.setFriday(0);
        mockStudentAttendance.add(mockSA);
        
        mockSA.setSubjectName("ITO");
        mockSA.setMonday(0);
        mockSA.setTuesday(0);
        mockSA.setWednesday(0);
        mockSA.setThursday(7);
        mockSA.setFriday(0);
        mockStudentAttendance.add(mockSA);
     
        mockuser1 = new User(1,"admin", "admin","mock@mail.com", 12345678 ,"1 Mock St" , false, "data/mockuserIMG.jpg", mockStudentAttendance);
   
    

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
    
    
    
    
    public List<String> addDayToAttendance(String selectedCourse) { // bit rough. Work in progress
        selectedCourse = "SCO";  // will come from gui later
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
    

    public boolean CheckTeacher(String email)
    {
        if(email.equals(mockuser1.getEmail()))
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
    }


}