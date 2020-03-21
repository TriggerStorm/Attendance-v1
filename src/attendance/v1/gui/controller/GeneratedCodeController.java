/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

import attendance.v1.be.LoggedInUser;
import attendance.v1.bll.BllManager;
import attendance.v1.gui.model.AttendanceModel;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Trigger
 */
public class GeneratedCodeController implements Initializable {

    @FXML
    private Label TF_code;
    private AttendanceModel Am;
    private BllManager bm;
    private LoggedInUser lu;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lu = LoggedInUser.getInstance();
        bm = new BllManager();
        setcode();
    }    
    public void setcode (){
        Am = new AttendanceModel();
       LocalDateTime date = LocalDateTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
        String dateString = date.format(formatter);
         String secretCode = Am.getCode();
       TF_code.setText(secretCode);
       bm.newSubjectsHeld(lu.getSelectedSubjectKey(),secretCode,dateString); 
       
    }
}
