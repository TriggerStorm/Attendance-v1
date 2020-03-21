/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.Attendance;
import attendance.v1.be.LoggedInUser;
import attendance.v1.be.StudentSubject;
import attendance.v1.be.Subject;
import attendance.v1.be.SubjectsHeld;
import attendance.v1.be.User;
import attendance.v1.bll.BllManager;
import attendance.v1.bll.IBLL;
import attendance.v1.dal.AttendanceDBDAO;
import attendance.v1.dal.StudentSubjectDBDAO;
import attendance.v1.dal.SubjectDBDAO;
import attendance.v1.dal.SubjectsHeldDBDAO;
import attendance.v1.dal.UserDBDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;


/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public class BLLutilities {
    private LoggedInUser lu;   
    private BllManager bm;
    private SubjectDBDAO sdb;
    private SubjectsHeldDBDAO subjectshelddb;
    private AttendanceDBDAO attendancedb;
    private StudentSubjectDBDAO studentsubjectdb;
    private UserDBDAO userdb;

    
    public BLLutilities() {
        lu = LoggedInUser.getInstance();
        bm = new BllManager();
        sdb = new SubjectDBDAO();
        subjectshelddb = new SubjectsHeldDBDAO();
        attendancedb = new AttendanceDBDAO();
        studentsubjectdb = new StudentSubjectDBDAO();
        userdb = new UserDBDAO();
    }
 
    
// Time Converters
    
    public static boolean hasFourHoursPass (String dateTimeHeldString) {
        LocalDateTime dateTimeHeld = stringToLocalDateTime(dateTimeHeldString);
        LocalDateTime fourHoursAgo = LocalDateTime.now().minusHours(4);
        boolean fourHoursHavePassed = fourHoursAgo.isAfter(dateTimeHeld);
        return fourHoursHavePassed;
    }
    
    public static LocalDateTime stringToLocalDateTime(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
        LocalDateTime later = LocalDateTime.parse(dateString, formatter);
        return later;
    }
     
    public static String localDateTimeToString(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
        String dateTimeString = dateTime.format(formatter);
        return dateTimeString;
    } 
    
    public List<Subject> subjectsForGui() throws SQLException {
        List<Subject> list = new ArrayList();
        for(int i = 0; i < bm.getSubjectsOfAStudent(lu.getUserKey()).size();i++)
        {
           list.add(sdb.getSpecificSubject(bm.getSubjectsOfAStudent(lu.getUserKey()).get(i).getSubjectKey()));
        }
        return list;
    }
    
    public String locaDateNowToString() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String dateNowString = now.format(formatter);
        return dateNowString;
    } 
    


// Average calculators
    
    public String getAverageOfAStudentsAttendanceInASubjectAsAString(int subjectKey, int userKey) throws SQLException {
        double averageOfAStudentsAttendanceInASubject = calculateAverageOfAStudentsAttendanceInASubject(subjectKey, userKey);
        String averageOfAStudentsAttendanceInASubjectString = convertDoubleToPercentageString(averageOfAStudentsAttendanceInASubject);
        return averageOfAStudentsAttendanceInASubjectString;
    }
       
    
    public String getAverageOfAllStudentAttendancesInASubjectAsAString(int subjectKey) throws SQLException {
        double totalOfAllStudentAttendancesInASubject = 0;
        List<User> allstudentsInASubject = userdb.getAllStudentsInASubject(subjectKey);
        int numberOfStudentsInASubject = allstudentsInASubject.size();
// maybe need an if (numberOfStudentsInASubject < 1) ...
        for (int i = 0; i < numberOfStudentsInASubject; i++) {
            User testUser = allstudentsInASubject.get(i);
            int userKey = testUser.getUserKey();
            totalOfAllStudentAttendancesInASubject =+ calculateAverageOfAStudentsAttendanceInASubject(subjectKey, userKey);
        }
        double averageOfAllStudentAttendancesInASubject = totalOfAllStudentAttendancesInASubject / numberOfStudentsInASubject;
        String averageOfAllStudentAttendancesInASubjectString = convertDoubleToPercentageString(averageOfAllStudentAttendancesInASubject);
        return averageOfAllStudentAttendancesInASubjectString;
    }
     
    
    public double calculateAverageOfAStudentsAttendanceInASubject(int subjecKey, int userKey) throws SQLException {
        double averageOfAStudentsAttendanceInASubject;
        List<SubjectsHeld> allSubjectsHeldForASubject = subjectshelddb.getAllSubjectsHeldForASubject(subjecKey);
        List<Attendance> allOfAStudentsAttendanceForASubject = attendancedb.getAllOfAStudentsAttendanceForASubject(userKey, subjecKey);
        averageOfAStudentsAttendanceInASubject = allOfAStudentsAttendanceForASubject.size()/allSubjectsHeldForASubject.size();
        return averageOfAStudentsAttendanceInASubject;
    }
        
    
    public String convertDoubleToPercentageString(double decimal) {
        DecimalFormat df = new DecimalFormat("##.##%");
        String percentageString = df.format(decimal);
        return percentageString;
    }
        
        
}
