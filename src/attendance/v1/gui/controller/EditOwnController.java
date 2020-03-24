/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Trigger
 */
public class EditOwnController implements Initializable {

    @FXML
    private TextField TF_name;
    @FXML
    private TextField TF_editPassword;
    @FXML
    private TextField TF_confirmPassword;
    @FXML
    private TextField TF_email;
    @FXML
    private TextField TF_mobileNr;
    @FXML
    private Button Bn_close;
    @FXML
    private Button Bn_save;
    @FXML
    private ImageView Lb_profilepic;
    
    private StudentController Sc;
    @FXML
    private JFXTextField TF_PostCode;
    @FXML
    private JFXTextField TF_City;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Sc = new StudentController();
    }    

    @FXML
    private void handle_close(ActionEvent event) {
        Stage stage = (Stage) Bn_close.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handle_save(ActionEvent event) {
        TF_name.getText();
        
        Stage stage = (Stage) Bn_save.getScene().getWindow();
        stage.close();
    }
    
}
