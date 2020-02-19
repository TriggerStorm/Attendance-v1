/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.CourseAttendance;
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
    List<String> attendance = new ArrayList<>();
    private User mockuser1;
    private CourseAttendance mockCA;
    private List<CourseAttendance> mockStudentAttendance;
    
    public MockDao() {
        mockStudentAttendance = new ArrayList<CourseAttendance>();
                
        
        mockCA.setCourseName("SCO");
        mockCA.setMonday(1);
        mockCA.setTuesday(0);
        mockCA.setWednesday(2);
        mockCA.setThursday(0);
        mockCA.setFriday(3);
        mockStudentAttendance.add(mockCA);
        
         mockCA.setCourseName("SDE");
        mockCA.setMonday(4);
        mockCA.setTuesday(5);
        mockCA.setWednesday(0);
        mockCA.setThursday(0);
        mockCA.setFriday(0);
        mockStudentAttendance.add(mockCA);
        
         mockCA.setCourseName("DBOS");
        mockCA.setMonday(0);
        mockCA.setTuesday(0);
        mockCA.setWednesday(0);
        mockCA.setThursday(6);
        mockCA.setFriday(0);
        mockStudentAttendance.add(mockCA);
        
         mockCA.setCourseName("ITO");
        mockCA.setMonday(0);
        mockCA.setTuesday(0);
        mockCA.setWednesday(0);
        mockCA.setThursday(7);
        mockCA.setFriday(0);
        mockStudentAttendance.add(mockCA);
     
      

         mockuser1 = new User(1,"admin", "admin","mock@mail.com", 12345678 ,"1 Mock St" , "False", "data/mockuserIMG.jpg", mockStudentAttendance);
    }
    
    
    
    public static void main(String[] args) {
        MockDao mockdao = new MockDao();
        mockdao.addDayToAttendance("SCO");
        //        launch(args);

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