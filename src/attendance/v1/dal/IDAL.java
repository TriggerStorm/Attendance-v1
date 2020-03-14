/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.Attendance;
import attendance.v1.be.ScoMok;
import attendance.v1.be.User;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public interface IDAL {

// Mock methods (to delete later)    
    public String course();
    public String gCode();
    public List<ScoMok> getDBOSattendance();
    public List<ScoMok> getITOattendance();
    public List<ScoMok> getSDEattendance();
    public List<ScoMok> getSCOattendance();
        

    
// UsersDBDAO methods
    public List<User> getAllUsers();
    public User getUser(int userKey);
    public User addNewUserToDB(String userName, String password, String email, int phoneNr, String address, int postCode, String city, String teacher, String userIMG);
    public User editUser (User userToEdit, String userName, String password, String email, int phoneNr, String address, int postCode, String city, String teacher, String userIMG);
    public void removeUserFromDB(User userToDelete);
    public int checkUserLogin (String email, String password);
    public boolean checkIfTeacher(String email);

    
// AttendanceDBDAO methods
    public List<Attendance> getAllAttendances();
    public List<Attendance> getStudentAttendanceInSubject(int studentKey, int subjectKey);
    public int[] getStudentAttendanceForSubjectInDays(int studentKey, int subjectKey);

    

}
