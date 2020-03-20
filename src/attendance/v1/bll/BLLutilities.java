/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.Attendance;
import attendance.v1.be.LoggedInUser;
import attendance.v1.be.Subject;
import attendance.v1.be.SubjectsHeld;
import attendance.v1.bll.BllManager;
import attendance.v1.bll.IBLL;
import attendance.v1.dal.AttendanceDBDAO;
import java.time.LocalDate;
import attendance.v1.dal.SubjectDBDAO;
import attendance.v1.dal.SubjectsHeldDBDAO;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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


    public BLLutilities() {
        lu = LoggedInUser.getInstance();
        bm = new BllManager();
        sdb = new SubjectDBDAO();
        subjectshelddb = new SubjectsHeldDBDAO();
        attendancedb = new AttendanceDBDAO();
    }
 
    
    
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
     
    
     public List<Subject> subjectsForGui() throws SQLException   
     {
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
    
    
    public String calculateAverageOfAStudentsAttendanceInASubject(int subjecKey, int userKey) throws SQLException {
        int averageOfAStudentsAttendanceInASubject;
        List<SubjectsHeld> allSubjectsHeldForASubject = subjectshelddb.getAllSubjectsHeldForASubject(subjecKey);
        List<Attendance> allOfAStudentsAttendanceForASubject = attendancedb.getAllOfAStudentsAttendanceForASubject(userKey, subjecKey);
        averageOfAStudentsAttendanceInASubject = allOfAStudentsAttendanceForASubject.size()/allSubjectsHeldForASubject.size();
        DecimalFormat df = new DecimalFormat("##.##%");
        double percent = (averageOfAStudentsAttendanceInASubject);
        String averageOfAStudentsAttendanceInASubjectString = df.format(percent);
        return averageOfAStudentsAttendanceInASubjectString;
    }
    
    
    
}
