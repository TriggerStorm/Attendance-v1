/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.ScoMok;
import attendance.v1.be.User;
import java.util.List;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public interface IBLL {
    
    List<String> addDayToAttendance(String selectedCourse);
    int CheckUser(String email, String password);
    boolean CheckTeacher(String email);


        
// UsersDBDAO methods
    public List<User> getAllUsers();
    public User getUser(int userKey);
    public User addNewUserToDB(String userName, String password, String email, int phoneNr, String address, int postCode, String city, String teacher, String userIMG);
    public User editUser (User userToEdit, String userName, String password, String email, int phoneNr, String address, int postCode, String city, String teacher, String userIMG);
    public void removeUserFromDB(User userToDelete);

}

