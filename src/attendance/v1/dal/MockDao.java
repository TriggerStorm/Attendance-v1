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
    public static SubjectAttendance mockSA;
    public List<SubjectAttendance> mockStudentAttendance;
    
    public MockDao() {
        mockStudentAttendance = new ArrayList<SubjectAttendance>();
        
        mockSA.setCourseName("SCO");
        mockSA.setMonday(1);
        mockSA.setTuesday(0);
        mockSA.setWednesday(2);
        mockSA.setThursday(0);
        mockSA.setFriday(3);
        mockStudentAttendance.add(mockSA);
        
        mockSA.setCourseName("SDE");
        mockSA.setMonday(4);
        mockSA.setTuesday(5);
        mockSA.setWednesday(0);
        mockSA.setThursday(0);
        mockSA.setFriday(0);
        mockStudentAttendance.add(mockSA);
        
        mockSA.setCourseName("DBOS");
        mockSA.setMonday(0);
        mockSA.setTuesday(0);
        mockSA.setWednesday(0);
        mockSA.setThursday(6);
        mockSA.setFriday(0);
        mockStudentAttendance.add(mockSA);
        
        mockSA.setCourseName("ITO");
        mockSA.setMonday(0);
        mockSA.setTuesday(0);
        mockSA.setWednesday(0);
        mockSA.setThursday(7);
        mockSA.setFriday(0);
        mockStudentAttendance.add(mockSA);
     
        mockuser1 = new User(1,"admin", "admin","mock@mail.com", 12345678 ,"1 Mock St" , "False", "data/mockuserIMG.jpg", mockStudentAttendance);
   
    
    }
    
    
    
    public int mockPrintOut() {
         int count = mockStudentAttendance.size();
        return count;
    }
   

    
    
    
    
    public User CheckUser(String user) {
        if(user == mockuser1.getUserName()) {
//          if(password == mockuser1.  getPassword {    
            return mockuser1;
//            {
        }
        return null;
    }
    
    
    
    
    public List<String> addDayToAttendance(String selectedCourse) {
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
    
    
}