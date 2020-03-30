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
public class TeacherModel implements Runnable {
private BllManager bm;
private ObservableList<SubjectAttendance> scoList;
private ObservableList<SubjectAttendance> sdeList;
private ObservableList<SubjectAttendance> itoList;
private ObservableList<SubjectAttendance> dbosList;


    public TeacherModel() {
        bm = new BllManager();
        //Thread t1 = new Thread((Runnable) this.getSco());
        //Thread t2 = new Thread((Runnable) this.getSdeList());
       // Thread t3 = new Thread((Runnable) this.getItoList());
        //Thread t4 = new Thread((Runnable) this.getDBOSList());
       //t1.start();
        //t2.start();
        //t3.start();
        //t4.start();
    }

    public TeacherModel(List sco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getSco(){
        List<SubjectAttendance> sco = bm.getSubjectAttendanceListForAllStudentsInThatSubject(1);
        return sco;
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
    
    public ObservableList<SubjectAttendance> getScoOList(){
        return scoList;
    }
    public ObservableList<SubjectAttendance> getSdeOList(){
        return sdeList;
    }
    public ObservableList<SubjectAttendance> getItoOList(){
        return itoList;
    }
    public ObservableList<SubjectAttendance> getDBOSOList(){
        return dbosList;
    }

    @Override
    public void run() {
        getScoList();
    }
    
}
