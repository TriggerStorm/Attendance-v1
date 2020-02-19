/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.model;

import attendance.v1.bll.BllManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Trigger
 */
public class AttendanceModel {
    private BllManager bllManager;
   // private ObservableList<AttSco> ScoList;
    

    public AttendanceModel() {
        bllManager = new BllManager();
      //  getScoAttendance();
    }
    
   /* public ObservableList<AttSco> getScoAttendance(){
    
      List<Sco> allSco = bllManager.fetchAllSco();
      ScoList = FXCollections.observableArrayList(allSco);
      return ScoList;
        
    }
    */
        
    
    
}
