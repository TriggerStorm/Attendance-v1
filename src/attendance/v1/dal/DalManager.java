/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;
import attendance.v1.dal.SecretCodeDBDAO;
import attendance.v1.be.SubjectAttendance;
import attendance.v1.be.User;
import attendance.v1.be.Attendance;
import attendance.v1.be.StudentSubject;
import attendance.v1.bll.BllManager;
import attendance.v1.be.Subject;
import attendance.v1.be.SubjectsHeld;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public class DalManager implements IDAL {
    private AttendanceDBDAO attendanceDBDao;
    private StudentSubjectDBDAO studentSubjectDBDao;
    private SubjectDBDAO subjectDBDao;
    private UserDBDAO userDBDao;
    private SubjectsHeldDBDAO subjectsHeldDBDao;
    private SecretCodeDBDAO secretCodeDBDAO;
    private SubjectDBDAO subjectDBdao;
    
    
    
    public DalManager() {
          attendanceDBDao = new AttendanceDBDAO();
          studentSubjectDBDao = new StudentSubjectDBDAO();
          subjectDBDao = new SubjectDBDAO();
          userDBDao = new UserDBDAO();
          subjectsHeldDBDao = new SubjectsHeldDBDAO();
          secretCodeDBDAO = new SecretCodeDBDAO();
    } 
    
    
    

// AttendanceDBDAO methods
    
    public List<Attendance> getAllAttendances() {
        try {
            return attendanceDBDao.getAllAttendances();
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public SubjectAttendance getSubjectAttendanceForAStudent(int studentKey, int subjectKey){
        try {
            return attendanceDBDao.getSubjectAttendanceForAStudent(studentKey, subjectKey);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public List<Attendance> getStudentAttendanceForSubject(int studentKey, int subjectKey) { /// ????
        try {
            return attendanceDBDao.getAllOfAStudentsAttendanceForASubject(studentKey, subjectKey);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override   // OBSOLETE??
    public List<Attendance> getStudentAttendanceInSubject(int studentKey, int subjectKey) {
        try {
            return attendanceDBDao.getAllOfAStudentsAttendanceForASubject(studentKey, subjectKey);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       
    @Override
    public SubjectAttendance addNewAttendanceToDB(int studentKey, SubjectsHeld subjectHeld) {
        try {
            return attendanceDBDao.addNewAttendanceToDB(studentKey, subjectHeld);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override  // OBSOLETE??
    public SubjectAttendance getStudentDailyAttendance(int studentKey,  int subjectKey) {
        try {
            return attendanceDBDao.getSubjectAttendanceForAStudent(studentKey, subjectKey);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<SubjectAttendance> getSubjectAttendanceListForAllStudentsInThatSubject(int subjectKey) {
        try {
            return attendanceDBDao.getSubjectAttendanceListForAllStudentsInThatSubject(subjectKey);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }

    @Override
    public String getAverageOfAllStudentAttendancesInASubjectAsAString(int subjectKey)
    {
        try {
            return attendanceDBDao.getAverageOfAllStudentAttendancesInASubjectAsAString(subjectKey);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
 
    @Override
    public String getAverageAttendanceOfAStudentsForAllSubjects(int studentKey) {
        try {
            return attendanceDBDao.getAverageAttendanceOfAStudentsForAllSubjects(studentKey);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }
       


// UserDBDAO methods
    
    public int getUserKeyFromName(String userName) throws SQLException{
        userDBDao.getUserNameFromKey(userName);
        return 0;
    }
            
    @Override
    public List<User> getAllUsers() {
        try {
            return userDBDao.getAllUsers();
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public User getLoggedInUser(String email){
        try {
            return userDBDao.getLoggedInUser(email);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public User getUser(int userKey) {
        try {
            return userDBDao.getUser(userKey);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    @Override
    public User addNewUserToDB(String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher, String userIMG) {
        return userDBDao.addNewUserToDB(userName, password, email, phoneNr, address, postCode, city, teacher, userIMG);
    }
    

    @Override
    public User editUser(User userToEdit, String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher, String userIMG) {
        return userDBDao.editUser(userToEdit, userName, password, email, phoneNr, address, postCode, city, teacher, userIMG);
    }

    
    @Override
    public void removeUserFromDB(User userToDelete) {
        userDBDao.removeUserFromDB(userToDelete);
    }

   
    @Override
    public int checkUserLogin (String email, String password) { //checks if our user exsts and the password is correct.
        try {
        return userDBDao.checkUserLogin(email,password);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
    }

    
    @Override
    public boolean checkIfTeacher(String email) {
        try {
            return userDBDao.checkIfTeacher(email);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }



    
    
    
// StudentSubjectDBDAO methods
    
    @Override
    public List<StudentSubject> getSubjectsOfAStudent(int userKey) {
        try {
            return studentSubjectDBDao.getSubjectsOfAStudent(userKey);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }

   
    
    
// SubjectsHeldDBDAO methods
    
    @Override
    public SubjectsHeld addSubjectsHeld(int skey, String date, String secretCode)
    {
        try {
            return subjectsHeldDBDao.addSubjectsHeld(skey, date, secretCode);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    @Override
    public SubjectsHeld getSpecificSubjectsHeld(int skey)
    {
        try {
            return subjectsHeldDBDao.getSpecificSubjectsHeld(skey);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    //SecretCode Methods
    
    @Override
    public SubjectsHeld checkCode(int sKey, String code)
    {
        try {
            return secretCodeDBDAO.checkCode(sKey, code);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }   

    
    
    // SubjectDBDAO methods
    
    public Subject getSpecificSubjects(int subjectKey){
         
             try {
                 return subjectDBdao.getSpecificSubject(subjectKey);
             } catch (SQLException ex) {
                 Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
             }
             return null;
         }

    @Override
   public String getLatestSubjectsHeld(int skey) {
       
        try {
            return subjectsHeldDBDao.getLatestSubjectsHeld(skey);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        } 
        
    
    /*public SubjectAttendance getSubjectAttendanceForAStudent(int studentKey, SubjectsHeld subjectHeld) {
            return attendanceDBDao.getSubjectAttendanceForAStudent(studentKey, subjectHeld);
        }*/

   

}
