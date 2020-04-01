/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.LoggedInUser;
import attendance.v1.be.Attendance;
import attendance.v1.be.StudentSubject;
import attendance.v1.be.Subject;
import attendance.v1.be.SubjectAttendance;
import attendance.v1.be.SubjectsHeld;
import attendance.v1.be.User;
import attendance.v1.be.SubjectAttendance;

import java.util.List;

import attendance.v1.dal.DalManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public class BllManager implements IBLL {
    private DalManager dalManager = new DalManager();

  
    
// UserDBDAO methods
    
    @Override
    public List<User> getAllUsers() {
        return dalManager.getAllUsers();
        }
    
    
    public User getLoggedInUser(String email){
        return dalManager.getLoggedInUser(email);
    }
    
    
    @Override
    public User getUser(int userKey) {
            return dalManager.getUser(userKey);
    }

    
    @Override
    public String getUserNameFromKey(int studentKey) {
        return dalManager.getUserNameFromKey(studentKey);
    }

    
    @Override
    public User addNewUserToDB(String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher, String userIMG) {
        return dalManager.addNewUserToDB(userName, password, email, phoneNr, address, postCode, city, teacher, userIMG);
    }
    

    @Override
    public User editUser(User userToEdit, String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher, String userIMG) {
        return dalManager.editUser(userToEdit, userName, password, email, phoneNr, address, postCode, city, teacher, userIMG);
    }

    
    @Override
    public void removeUserFromDB(User userToDelete) {
        dalManager.removeUserFromDB(userToDelete);
    }

    
    @Override
    public int checkUserLogin (String email, String password) {
        return dalManager.checkUserLogin(email,password);
    }

   
    @Override
    public boolean checkIfTeacher(String email) {
        return dalManager.checkIfTeacher(email);
    }

    
    
    
    
    
// AttendanceDBDAO methods
    
    @Override
    public List<Attendance> getAllAttendances() {
        return dalManager.getAllAttendances();
    }
    
    @Override
    public SubjectAttendance getSubjectAttendanceForAStudent(int studentKey, int subjectKey){
        return dalManager.getSubjectAttendanceForAStudent(studentKey, subjectKey);
    }

    @Override
    public List<Attendance> getStudentAttendanceForSubject(int studentKey, int subjectKey) {
        return dalManager.getStudentAttendanceForSubject(studentKey, subjectKey);
    }
   
    @Override
    public SubjectAttendance addNewAttendanceToDB(int studentKey, SubjectsHeld subjectHeld) {
        return dalManager.addNewAttendanceToDB(studentKey, subjectHeld);
    }

    @Override
    public List<SubjectAttendance> getSubjectAttendanceListForAllStudentsInThatSubject(int subjectKey) {
        return dalManager.getSubjectAttendanceListForAllStudentsInThatSubject(subjectKey);
    }
    
    @Override
    public String getAverageOfAllStudentAttendancesInASubjectAsAString(int subjectKey) {
        return dalManager.getAverageOfAllStudentAttendancesInASubjectAsAString(subjectKey);
    }

    @Override
    public String getAverageAttendanceOfAStudentsForAllSubjects(int studentKey) {
        return dalManager.getAverageAttendanceOfAStudentsForAllSubjects(studentKey);
    }


    
// StudentSubjectDBDAO methods
    
    @Override
    public List<StudentSubject> getSubjectsOfAStudent(int userKey) {
        return dalManager.getSubjectsOfAStudent(userKey);
    }

   
    
// SubjectsHeldDBDAO methods
    
    @Override
    public SubjectsHeld addSubjectsHeld(int skey, String date, String secretCode) {
        return dalManager.addSubjectsHeld(skey, date, secretCode);
    }

    public SubjectsHeld newSubjectsHeld(int sKey, String date, String secretCode) {
       return dalManager.addSubjectsHeld(sKey,date,secretCode);
    }
      public boolean deleteSubjectsHeld(SubjectsHeld subjectsHeld) {
          return dalManager.deleteSubjectsHeld(subjectsHeld);
      }

    
    
// SubjectDBDOA methods
    
    public Subject getSpecificSubjects(int subjectKey){
        return dalManager.getSpecificSubjects(subjectKey);
    }
    

    public void submitAttendance(String code, String selectedSubjectName) {
        if(checkCode(code) != null)
        {
            LoggedInUser lUser = LoggedInUser.getInstance();
            SubjectsHeld subjectSelected = checkCode(code);
            SubjectAttendance subjectAttendance = dalManager.addNewAttendanceToDB(lUser.getUserKey() , subjectSelected);
        }
    }
    

    
///SecretCodeDBDAO methods

    public SubjectsHeld checkCode(String code) {
        LoggedInUser lUser = LoggedInUser.getInstance();
        return dalManager.checkCode(lUser.getSelectedSubjectKey(), code);
    }

    @Override
    public String getLatestSubjectsHeldDate(int skey) {
        return dalManager.getLatestSubjectsHeld(skey);
    }

    @Override
    public boolean checkIfUserExist(String email) {
        return dalManager.checkIfUserExist(email);   
    }

    
    
//AbsenceDBDAO methods
    
    @Override
    public void submitAbsence(int studentKey, LocalDate datePicked) {
        dalManager.submitAbsence(studentKey, datePicked);   
    }

    @Override
    public void deleteExpiredAbsences() {
        dalManager.deleteExpiredAbsences();
    }

    
}
