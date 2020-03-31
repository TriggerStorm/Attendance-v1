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
import javafx.concurrent.Task;

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

        Task<ObservableList<SubjectAttendance>> getScoList = new Task<ObservableList<SubjectAttendance>>() {
            @Override protected ObservableList<SubjectAttendance> call() throws Exception {
            updateMessage("message");
            System.out.print("Working on it");
            List<SubjectAttendance> sco = bm.getSubjectAttendanceListForAllStudentsInThatSubject(1);
            scoList = FXCollections.observableArrayList(sco);
            return scoList;
            //updateProgress(i, 100);
            }
        };
        
        Task<ObservableList<SubjectAttendance>> getSdeList = new Task<ObservableList<SubjectAttendance>>() {
            @Override protected ObservableList<SubjectAttendance> call() throws Exception {
            updateMessage("message");
            List<SubjectAttendance> sde = bm.getSubjectAttendanceListForAllStudentsInThatSubject(5);
            sdeList = FXCollections.observableArrayList(sde);
            return sdeList;
            //updateProgress(i, 100);
            }
        };

        Task<ObservableList<SubjectAttendance>> getItoList = new Task<ObservableList<SubjectAttendance>>() {
            @Override protected ObservableList<SubjectAttendance> call() throws Exception {
            updateMessage("message");
            List<SubjectAttendance> ito = bm.getSubjectAttendanceListForAllStudentsInThatSubject(9);
            itoList = FXCollections.observableArrayList(ito);
            return itoList;
            //updateProgress(i, 100);
            }
        };

        Task<ObservableList<SubjectAttendance>> getDbosList = new Task<ObservableList<SubjectAttendance>>() {
            @Override protected ObservableList<SubjectAttendance> call() throws Exception {
            updateMessage("message");
            List<SubjectAttendance> dbos = bm.getSubjectAttendanceListForAllStudentsInThatSubject(69);
            dbosList = FXCollections.observableArrayList(dbos);
            return dbosList;
            //updateProgress(i, 100);
            }            
      };

    getScoList.run();
    getSdeList.run();
    getItoList.run();
    getDbosList.run();
    
    this.scoList = getScoList.getValue();
    this.sdeList = getSdeList.getValue();
    this.itoList = getItoList.getValue();
    this.dbosList = getDbosList.getValue();
    

//System.out.println(task.getMessage());
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
    
  /*  public ObservableList<SubjectAttendance> getScoList(){
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
    }*/
    
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
        //getScoList();
    }
    
}