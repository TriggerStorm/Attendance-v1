/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.model;

import attendance.v1.be.ScoMok;
import attendance.v1.bll.BllManager;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Trigger
 */
public class AttendanceModel {
    private BllManager bllManager;
    private ObservableList<String> course;
    

    public AttendanceModel() {
        bllManager = new BllManager();
        
    }
    public String gCode(){
      
      return bllManager.gCode();
      
    }
    
    public ObservableList<String> course(){
      
      String allcourse = bllManager.course();
      course = FXCollections.observableArrayList(allcourse);
      return course;
    }
    

}
