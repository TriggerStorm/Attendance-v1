/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.model;

import attendance.v1.be.ScoMok;
import attendance.v1.gui.model.AttendanceModel;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author macos
 */
public class DataModel {
    private static DataModel instance;
    private ObservableList<ScoMok> autoupdatingSCOlist;
    private List<ScoMok> autoupdatingSDElist;
    private List<ScoMok> autoupdatingITOlist;
    private List<ScoMok> autoupdatingDBOSlist;
    private AttendanceModel am;
    private DataModel()
    {
         am = new AttendanceModel();
        autoupdatingSCOlist = FXCollections.observableArrayList(am.getScoAttendance());
        autoupdatingSDElist = FXCollections.observableArrayList(am.getSdeAttendance());
        autoupdatingITOlist = FXCollections.observableArrayList(am.getItoAttandance());
        autoupdatingDBOSlist= FXCollections.observableArrayList(am.getDBOSAttandance());
       
    }
    
    public static DataModel GetInstance() 
    {
        if(instance == null)
        {
            instance = new DataModel();
        }
        return instance;
    }
    public ObservableList<ScoMok> getScoList()
    {
        return autoupdatingSCOlist;
    }
    public void addStudentToList(ScoMok sm)
            {
                autoupdatingSCOlist.add(sm);
            }
}
