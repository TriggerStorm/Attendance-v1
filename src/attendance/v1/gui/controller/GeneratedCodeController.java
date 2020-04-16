/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

import attendance.v1.be.LoggedInUser;
import attendance.v1.bll.Action1;
import attendance.v1.bll.BllManager;
import attendance.v1.bll.CommandManager;
import attendance.v1.gui.model.AttendanceModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Trigger
 */
public class GeneratedCodeController implements Initializable {

    @FXML
    private Label TF_code;
    private LoggedInUser lu;
    private CommandManager cm;
    private AttendanceModel am;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        am = new AttendanceModel();
        cm = CommandManager.getInstance();
        lu = LoggedInUser.getInstance();
        if(lu.getLastCode().length() < 3)
        setcode();
        else
        TF_code.setText(lu.getLastCode());
    }    
    public void setcode (){
        String code = "";
            code = am.getCode();
        TF_code.setText(code);
        lu.setLastCode(code);
      cm.execute(new Action1(code),code);
       
    }
}
