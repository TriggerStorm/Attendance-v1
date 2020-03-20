/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import attendance.v1.be.Attendance;
import attendance.v1.be.StudentSubject;
import attendance.v1.dal.StudentSubjectDBDAO;
import java.sql.SQLException;
import java.util.List;
import attendance.v1.bll.BLLutilities;
import attendance.v1.dal.AttendanceDBDAO;
/**
 *
 * @author admin
 *//**
 *
 * @author admin
 */
public class test {
        private StudentSubjectDBDAO studentSubjectDBDao = new StudentSubjectDBDAO();
        private BLLutilities bllUtil = new BLLutilities();
        private AttendanceDBDAO attdb = new AttendanceDBDAO();
        
   
        
    public void main(String[] args) throws SQLException {
        System.out.println("start");
        List<Attendance> allattend = attdb.getAllAttendances();
        for (int i = 0; i < allattend.size(); i++) {
            Attendance attend = allattend.get(i);
            System.out.println(i + " subject: " + attend.getSubjectKey() + "  student:" + attend.getStudentKey());
        }
        System.out.println("");
//System.out.println("allSubjectsHeldForASubject = " + allSubjectsHeldForASubject.size());
System.out.println("");
//System.out.println("allOfAStudentsAttendanceForASubject" + allOfAStudentsAttendanceForASubject.size());
System.out.println("");

System.out.println("averageOfAStudentsAttendanceInASubject");

    //    int average = bllUtil.calculateAverageOfAStudentsAttendanceInASubject(0, 0);
            System.out.println("finish");

    }
    
}
