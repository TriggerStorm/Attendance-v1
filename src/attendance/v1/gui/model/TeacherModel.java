/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.model;

import attendance.v1.be.SubjectAttendance;
import attendance.v1.bll.BllManager;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Trigger
 */
public class TeacherModel {
private BllManager bm;
private ObservableList<SubjectAttendance> scoList;
private ObservableList<SubjectAttendance> sdeList;
private ObservableList<SubjectAttendance> itoList;
private ObservableList<SubjectAttendance> dbosList;


    public TeacherModel() {
        bm = new BllManager();
        getScoList();
        getSdeList();
        getItoList();
        getDBOSList();
    }
    
    public ObservableList<SubjectAttendance> getScoList(){
    List<SubjectAttendance> sco = bm.getSubjectAttendanceListForAllStudentsInThatSubject(1);
      scoList = FXCollections.observableArrayList(sco);
      return scoList;
    }
    
    public ObservableList<SubjectAttendance> getSdeList(){
    List<SubjectAttendance> sde = bm.getSubjectAttendanceListForAllStudentsInThatSubject(5);
      sdeList = FXCollections.observableArrayList(sde);
      return sdeList;
    }
    
    public ObservableList<SubjectAttendance> getItoList(){
    List<SubjectAttendance> ito = bm.getSubjectAttendanceListForAllStudentsInThatSubject(9);
      itoList = FXCollections.observableArrayList(ito);
      return itoList;
    }
    
    public ObservableList<SubjectAttendance> getDBOSList(){
    List<SubjectAttendance> dbos = bm.getSubjectAttendanceListForAllStudentsInThatSubject(13);
      dbosList = FXCollections.observableArrayList(dbos);
      return dbosList;
    }
    
}
