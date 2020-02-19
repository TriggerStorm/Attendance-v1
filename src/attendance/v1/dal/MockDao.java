/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

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
    List<String> attendance = new ArrayList<>(8);
    private User mockuser1;
    
    
    public MockDao() {
        String[] arr1 = {"SCO", "0", "0", "0", "0", "0", "0", "0"};
        String[] arr2 = {"SDE", "0", "0", "0", "0", "0", "0", "0"};
        String[] arr3 = {"DBOS", "0", "0", "0", "0", "0", "0", "0"};
        String[] arr4 = {"ITO", "0", "0", "0", "0", "0", "0", "0"};
        attendance.addAll(Arrays.asList(arr1));
        attendance.addAll(Arrays.asList(arr2));
        attendance.addAll(Arrays.asList(arr3));
        attendance.addAll(Arrays.asList(arr4));

         mockuser1 = new User(1,"admin", "admin","mock@mail.com", 12345678 ,"1 Mock St" , "False", "data/mockuserIMG.jpg", attendance);
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
            for (int i = 0; i < noOfCourses; i++) {
            
            String testCourse = attendance.get(i);
                System.out.println(testCourse);
        }
 //       attendance(dayOfWeek+1) =+;
        return attendance;
    } 
       return null;
    }
    
    
}