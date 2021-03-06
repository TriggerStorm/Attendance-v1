/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.format.DateTimeFormatter;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.ResultSet;
import java.sql.Statement;


import attendance.v1.be.User;
import attendance.v1.be.Attendance;
import attendance.v1.be.LoggedInUser;
import attendance.v1.be.SubjectsHeld;
import attendance.v1.be.StudentSubject;
import attendance.v1.be.SubjectAttendance;
import java.text.DecimalFormat;


/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public class AttendanceDBDAO {
 
    private DBConnection dbc;
    public List<Attendance> attendance;
    public List<SubjectAttendance> studentAttendance;
    public UserDBDAO newUserDBDao;
    public LoggedInUser lu;
    public UserDBDAO tempUserDBDao;
    public SubjectsHeldDBDAO tempSubjectsHeldDBDao;
    public StudentSubjectDBDAO tempStudentSubjectDBDao;
    
    public AttendanceDBDAO() {
        tempUserDBDao = new UserDBDAO();
        tempSubjectsHeldDBDao = new SubjectsHeldDBDAO();
        tempStudentSubjectDBDao = new StudentSubjectDBDAO();
        dbc = new DBConnection();
        lu = LoggedInUser.getInstance();
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public List<Attendance> getAllAttendances() throws SQLException{
    //  Gets a list of all attendances from the DB
        List<Attendance> allAttendance = new ArrayList(); //get a list to store the values.
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT * FROM ATTENDANCE;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) //While you have something in the results
            {
                int userKey = rs.getInt("studentKey");
                int subjectKey = rs.getInt("SubjectKey");
                String dateHeld =  rs.getString("DateHeld");
               allAttendance.add(new Attendance(userKey, subjectKey, dateHeld)); 
            }    
        }
        return allAttendance;
    }
     


    public SubjectAttendance addNewAttendanceToDB(int studentKey, SubjectsHeld subjectHeld) throws SQLException { 
    //  Adds a new attendance to the DB, and returns the users updated attendance information to the GUI as a SubjectAttendance data object
        int subjectKey = subjectHeld.getSubjectKey();
        String dateHeld = subjectHeld.getDateHeld();
        String sql = "INSERT INTO ATTENDANCE(studentKey, SubjectKey, DateHeld) VALUES (?,?,?)";
        Attendance newAttendance = new Attendance(studentKey, subjectKey, dateHeld);
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, studentKey);
            stmt.setInt(2, subjectKey);
            stmt.setString(3, dateHeld);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating attendance failed, no rows affected.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    newAttendance.setStudentKey((int) generatedKeys.getLong(1));// CHECK THIS LINE
                    lu.setAttendanceSubmitted();
                } else {
                    throw new SQLException("Creating attendance failed, no ID obtained.");
                } 
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(AttendanceDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return getSubjectAttendanceForAStudent(studentKey, subjectKey);
    }
   
        
    public List<SubjectAttendance> getSubjectAttendanceListForAllStudentsInThatSubject(int subjectKey) throws SQLException {
    //  Returns a list of SubjectAttendance of all students in a given subject. Used to calculate the total subject attendance average for all students in a subject
        List<SubjectAttendance> allStudentDailyAttendance = new ArrayList<>();
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT userKey FROM Student_Subjects WHERE subjectKey = ?;"; ///To get all the users in that subject.
            PreparedStatement statement = con.prepareStatement(SQLStmt);
            statement.setInt(1,subjectKey);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) //While you have something in the results
            {
                int userKey = rs.getInt("userKey");
                SubjectAttendance tempSubjectA = getSubjectAttendanceForAStudent(userKey, subjectKey); //Fetch the attendance for each of those students.
                allStudentDailyAttendance.add(tempSubjectA); 
            }    
        }catch (SQLServerException ex) {
            Logger.getLogger(AttendanceDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allStudentDailyAttendance;
   }
   
   
    public  SubjectAttendance getSubjectAttendanceForAStudent(int studentKey, int subjectKey) throws SQLException {
    //  Returns a SubjectAttendance of a student in a subject
        int[] dailyAttendanceIntArray = new int[7];
        List<Attendance> studentAttendanceInSubject = getAllOfAStudentsAttendanceForASubject(studentKey, subjectKey);
        dailyAttendanceIntArray = listOfAttendanceToIntArrayOfDays(studentAttendanceInSubject);
        String name = tempUserDBDao.getUserNameFromKey(studentKey);
        int monday = dailyAttendanceIntArray[0];
        int tuesday = dailyAttendanceIntArray[1];
        int wednesday = dailyAttendanceIntArray[2];
        int thursday = dailyAttendanceIntArray[3];
        int friday = dailyAttendanceIntArray[4];
        String percent = getAverageOfAStudentsAttendanceInASubjectAsAString(subjectKey, studentKey);
        SubjectAttendance sda = new SubjectAttendance(studentKey, name, monday, tuesday, wednesday, thursday, friday, percent);
        return sda;
    }
    


    public List<Attendance> getAllOfAStudentsAttendanceForASubject(int studentKey, int subjectKey) throws SQLException {
    //  Returns all attendances for all students in a subject   
        List<Attendance> studentAttendanceInSubject = new ArrayList<>();
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT DateHeld FROM ATTENDANCE WHERE studentKey = '" + studentKey + "' AND subjectKey='" + subjectKey + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) //While you have something in the results
            {
                String dateHeld =  rs.getString("DateHeld");
                studentAttendanceInSubject.add(new Attendance(studentKey, subjectKey, dateHeld)); 
            }    
        }
        return studentAttendanceInSubject;
    }


 
    public List<Attendance> getAllAttendanceForSubject(int subjectKey) throws SQLException {
    //  Returns all attendances for a student in a subject   
        List<Attendance> allAttendanceInSubject = new ArrayList<>();
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT studentKey, DateHeld FROM ATTENDANCE WHERE subjectKey ='" + subjectKey + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) //While you have something in the results
            {
                int studentKey = rs.getInt("studentKey");
                String dateHeld =  rs.getString("DateHeld");
               allAttendanceInSubject.add(new Attendance(studentKey, subjectKey, dateHeld)); 
            }    
        }
        return allAttendanceInSubject;
    }
    
    public int getAllAttendanceForSubjectByDate(int subjectKey, String date) throws SQLException {
    //  Returns an int value of the number of students who attended a given subject on a give day 
        String theDateTime ="";
        SubjectsHeld theSubject = tempSubjectsHeldDBDao.getSubjectHeldFromDate(subjectKey, date); //get the subjectHeld that we need
        if(theSubject != null)
        theDateTime = theSubject.getDateHeld(); //fetch that one's full date and time.
        int attendees = 0; //initialize the total amount of attnedees to 0.
        try(Connection con = dbc.getConnection())
        {
            String sqlStmt = "Select studentKey from Attendance where dateHeld= '" + theDateTime + "';"; //the sql Query.
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStmt);
            while(rs.next())
            {
                attendees++;//add one to the attendees.
            }
        }
        return attendees; //return the total number.
    }
    
       
    public String getAverageAttendanceOfAStudentsForAllSubjects (int studentKey) throws SQLException {
    //  Returns the String of the total average of a students attendance for all subjects
        double totalAverageAttendanceOfAStudentsForAllSubjects = 0;
        int numberOfSubjectsOfAStudent;
        List<StudentSubject> allOfAStudentsSubjects;
        allOfAStudentsSubjects = tempStudentSubjectDBDao.getSubjectsOfAStudent(studentKey);
        numberOfSubjectsOfAStudent = allOfAStudentsSubjects.size();
        for (int i = 0; i < numberOfSubjectsOfAStudent; i++) {
            int testSubjectKey = allOfAStudentsSubjects.get(i).getSubjectKey();
            totalAverageAttendanceOfAStudentsForAllSubjects += calculateAverageOfAStudentsAttendanceInASubject(testSubjectKey, studentKey);
        }
        double averageAttendanceOfAStudentsForAllSubjects = totalAverageAttendanceOfAStudentsForAllSubjects / numberOfSubjectsOfAStudent;
        String averageAttendanceOfAStudentsForAllSubjectsString = convertDoubleToPercentageString(averageAttendanceOfAStudentsForAllSubjects);
        return averageAttendanceOfAStudentsForAllSubjectsString;
    }
    
    
    private int[] listOfAttendanceToIntArrayOfDays(List<Attendance> attendanceList) {
    //  Converts list of attendances into a int[] and gives daily attendance totals where monday is [0]...  
        int[] dailyAttendanceIntArray = new int[7];
        int attendanceTotal = attendanceList.size();
            if(attendanceTotal > 0)
            {
                for (int i = 0; i+1 < attendanceTotal; i++) {
                    Attendance attendance = attendanceList.get(i);
                    String dateHeldString = attendance.getDateHeld();
                    LocalDateTime dateHeld = stringToLocalDate(dateHeldString);
                    int dayOfWeek = (dateHeld.getDayOfWeek().getValue()) - 1; 
                    dailyAttendanceIntArray[dayOfWeek] ++;
                }
            }
        return dailyAttendanceIntArray;
    }
    
   
    
    
    
// Average calculators
    
    public String getAverageOfAStudentsAttendanceInASubjectAsAString(int subjectKey, int userKey) throws SQLException {
    //  Returns the String of the average of a students attendance in a subject
        double averageOfAStudentsAttendanceInASubject = calculateAverageOfAStudentsAttendanceInASubject(subjectKey, userKey);
        String averageOfAStudentsAttendanceInASubjectString = convertDoubleToPercentageString(averageOfAStudentsAttendanceInASubject);
        return averageOfAStudentsAttendanceInASubjectString;
    }
       
    
    public String getAverageOfAllStudentAttendancesInASubjectAsAString(int subjectKey) throws SQLException {
    //  Returns the String of the total average of all students in a subject   
        double totalOfAllStudentAttendancesInASubject = 0;
        List<User> allstudentsInASubject = tempUserDBDao.getAllStudentsInASubject(subjectKey);
        int numberOfStudentsInASubject = allstudentsInASubject.size();
        for (int i = 0; i < numberOfStudentsInASubject; i++) {
            User testUser = allstudentsInASubject.get(i);
            int userKey = testUser.getUserKey();
            totalOfAllStudentAttendancesInASubject += calculateAverageOfAStudentsAttendanceInASubject(subjectKey, userKey);
        }
        double averageOfAllStudentAttendancesInASubject = totalOfAllStudentAttendancesInASubject / numberOfStudentsInASubject;
        String averageOfAllStudentAttendancesInASubjectString = convertDoubleToPercentageString(averageOfAllStudentAttendancesInASubject);
        return averageOfAllStudentAttendancesInASubjectString;
    }
     
    
    private double calculateAverageOfAStudentsAttendanceInASubject(int subjectKey, int userKey) throws SQLException {
    //  Returns the int value of the average attendance of a student in a subject
        double averageOfAStudentsAttendanceInASubject;
        List<SubjectsHeld> allSubjectsHeldForASubject = tempSubjectsHeldDBDao.getAllSubjectsHeldForASubject(subjectKey);
        List<Attendance> allOfAStudentsAttendanceForASubject = getAllOfAStudentsAttendanceForASubject(userKey, subjectKey);
        double allOfStudentAttendanceInSubject = allOfAStudentsAttendanceForASubject.size();
        double totalAttendanceForSubject = allSubjectsHeldForASubject.size();
        averageOfAStudentsAttendanceInASubject = allOfStudentAttendanceInSubject/totalAttendanceForSubject;
        return averageOfAStudentsAttendanceInASubject;
    }
        
    
    private String convertDoubleToPercentageString(double decimal) {
        //  Converts double to String percent
        DecimalFormat df = new DecimalFormat("##.##%");
        String percentageString = df.format(decimal);
        return percentageString;
    }
        
    
    
    
    
// Time Converters

    public String dateNowToString() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
        String dateNowString = now.format(formatter);
        return dateNowString;
    } 
    
    
    public String localDateToString(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
        String dateString = date.format(formatter);
        return dateString;
    } 
    
    
     public LocalDateTime stringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
        LocalDateTime date = LocalDateTime.parse(dateString, formatter);
        return date;
    }
    
     
    public List<Attendance> getStudentAttendanceForSubject(int studentKey, int subjectKey) throws SQLException {
    //  Returns a list of Attendances of a given student for a give subject
         List<Attendance> allAttendances = getAllAttendances();
        List<Attendance> studentAttendanceInSubject = new ArrayList<>();
        Attendance testAttendance;
        for (int i = 0; i < allAttendances.size(); i++) {
            testAttendance = allAttendances.get(i);
            if (testAttendance.getStudentKey() == studentKey) {
                if (testAttendance.getSubjectKey() == subjectKey) {
                studentAttendanceInSubject.add(testAttendance);
                }
            }
        }
        return studentAttendanceInSubject;
    }

}

