/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

import attendance.v1.gui.model.AttendanceModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Trigger
 */
public class EditUserController implements Initializable {

    @FXML
    private TextField TF_name; // need to get name of user and show in TF. // filp
    @FXML
    private TextField TF_showPassWord;
    @FXML
    private ChoiceBox<String> CB_classes; // need to make mok date for course computersi and make it pickeble in choice box. // filp
    @FXML
    private Button Bn_resetPassWord; // need to reset and random gen new pass and show it in TF_showPassWord // filp
    @FXML
    private Button bn_cansel; // done
    @FXML
    private Button Bn_save; // need to add edit stuff to user. // filp
    
    private AttendanceModel Am;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setCB();
    }    
    public void setCB(){
        Am = new AttendanceModel();
        //CB_classes.setItems(Am.course());
        
    }
    @FXML
    private void handle_save(ActionEvent event) {
        Stage stage = (Stage) Bn_save.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handle_resetpassword(ActionEvent event) {
    }

    @FXML
    private void bn_cansel(ActionEvent event) {
        Stage stage = (Stage) bn_cansel.getScene().getWindow();
        stage.close();
        
    }
    
}
