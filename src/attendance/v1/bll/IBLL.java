/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.Attendance;
import attendance.v1.be.StudentSubject;
import attendance.v1.be.SubjectAttendance;
import attendance.v1.be.SubjectsHeld;
import attendance.v1.be.User;
import java.util.List;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public interface IBLL {
    


   
    

// UsersDBDAO methods
    public List<User> getAllUsers();
    public User getUser(int userKey);
    public User addNewUserToDB(String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher, String userIMG);
    public User editUser (User userToEdit, String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher, String userIMG);
    public void removeUserFromDB(User userToDelete);
    public int checkUserLogin (String email, String password);
    public boolean checkIfTeacher(String email);



 // AttendanceDBDAO methods
    public List<Attendance> getAllAttendances();
    public List<Attendance> getStudentAttendanceForSubject(int studentKey, int subjectKey);
    public SubjectAttendance addNewAttendanceToDB(int studentKey, SubjectsHeld subjectHeld);
    public SubjectAttendance getStudentDailyAttendance(int studentKey, SubjectsHeld subjectHeld);

    

// StudentSubjectDBDAO methods
    public List<StudentSubject> getSubjectsOfAStudent(int userKey);



// SubjectsHeldDBDAO methods
    public SubjectsHeld addSubjectsHeld(int skey, String date, String secretCode);
    public SubjectsHeld newSubjectsHeld(int sKey, String date, String secretCode);


}

