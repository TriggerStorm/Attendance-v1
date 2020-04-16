/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.model;

import attendance.v1.be.Absence;
import attendance.v1.be.Attendance;
import attendance.v1.be.SubjectAttendance;
import attendance.v1.bll.BllManager;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import attendance.v1.be.LoggedInUser;
import attendance.v1.be.SubjectsHeld;
import attendance.v1.bll.BLLutilities;
import java.sql.SQLException;

/**
 *
 * @author Trigger
 */
public class AttendanceModel {
    private BllManager bllManager;
    private ObservableList<String> course;

 

    public AttendanceModel() {
        bllManager = new BllManager();
        bllManager.getAllAttendances();
        bllManager.deleteExpiredAbsences();
    }
    
    
    public String getCode() { // need to be move to Teatcher model.
        String password = new Random().ints(10, 33, 122).mapToObj(i -> String.valueOf((char)i)).collect(Collectors.joining());
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 4) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
 
    return saltStr;
    }
   
    
    public void submitAttendance(String code, String selectedSubjectName) {
        bllManager.submitAttendance(code, selectedSubjectName);
    }
  
    
    public void submitAbsence (Absence absence) {
        bllManager.submitAbsence(absence);
    }
    

}
