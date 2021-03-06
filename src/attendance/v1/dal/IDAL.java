 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.Absence;
import attendance.v1.be.Attendance;
import attendance.v1.be.StudentSubject;
import attendance.v1.be.Subject;
import attendance.v1.be.SubjectAttendance;
import attendance.v1.be.SubjectsHeld;
import attendance.v1.be.User;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public interface IDAL {




// UsersDBDAO methods
    public List<User> getAllUsers();
    public User getUser(int userKey);
    public User getLoggedInUser(String email);
    public String getUserNameFromKey(int studentKey);
    public User addNewUserToDB(String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher, String userIMG);
    public User editUser (User userToEdit, String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher, String userIMG);
    public void removeUserFromDB(User userToDelete);
    public int checkUserLogin (String email, String password);
    public boolean checkIfTeacher(String email);
    public boolean checkIfUserExist(String email);

    
// AttendanceDBDAO methods
    public List<Attendance> getAllAttendances();
    public List<Attendance> getStudentAttendanceForSubject(int studentKey, int subjectKey);
    public SubjectAttendance addNewAttendanceToDB(int studentKey, SubjectsHeld subjectHeld);
    public List<SubjectAttendance> getSubjectAttendanceListForAllStudentsInThatSubject( int subjectKey);
    public SubjectAttendance getSubjectAttendanceForAStudent(int studentKey, int subjectKey);
    public String getAverageOfAllStudentAttendancesInASubjectAsAString(int subjectKey);
    public String getAverageAttendanceOfAStudentsForAllSubjects (int studentKey);
    public int getAllAttendanceForSubjectByDate(int subjectKey, String date);



// StudentSubjectDBDAO methods
    public List<StudentSubject> getSubjectsOfAStudent(int userKey);


// SubjectsHeldDBDAO methods
    public SubjectsHeld addSubjectsHeld(int skey, String date, String secretCode);
    public SubjectsHeld getSpecificSubjectsHeld(int skey);
   public String getLatestSubjectsHeld(int skey);
    public SubjectsHeld checkCode(int sKey, String code);
      public boolean deleteSubjectsHeld(SubjectsHeld subjectsHeld);
      public List<SubjectsHeld> getAllSubjectsHeldForASubject(int subjectKey);

// SubjectDBDAO methods
    public Subject getSpecificSubjects(int subjectKey);

//AbsenceDBDAO methods
    public void submitAbsence (Absence absence);
    public void deleteExpiredAbsences();
    public List<Absence> getAllAbsencesOnAGivenDate(LocalDate date);
    public List<String> getMonthlyAbsencesForAStudent(int studentKey, int monthInt);
    public int[] getTotalOfAbsencesInAMonthByDay(int monthInt);
}
