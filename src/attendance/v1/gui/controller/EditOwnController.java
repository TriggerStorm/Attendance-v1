/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

import attendance.v1.be.LoggedInUser;
import attendance.v1.bll.BllManager;
import attendance.v1.bll.InputValidators;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    @FXML
    private JFXTextField TF_Address;
    private LoggedInUser lu;
    private InputValidators iv;
    private BllManager bm;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bm = new BllManager();
        Sc = new StudentController();
        lu = LoggedInUser.getInstance();
        iv = new InputValidators();
    }    

    @FXML
    private void handle_close(ActionEvent event) {
        Stage stage = (Stage) Bn_close.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handle_save(ActionEvent event) {
        String name = TF_name.getText();
        String pass = TF_editPassword.getText();
        String confPass = TF_confirmPassword.getText();
        String email = TF_email.getText();
        String addres = TF_Address.getText();
        String city = TF_City.getText();
        String phoneNr = TF_mobileNr.getText();
        String postCode = TF_PostCode.getText();
        int userkey = lu.getUserKey();
        
        if (iv.isValidEmail(email) && iv.isValidAddress(addres) && iv.isValidCity(city) && iv.isValidPhoneNumber(phoneNr) && iv.isValidPostCode(postCode))
        {
           // bm.editUser(bm.getLoggedInUser(lu.getEmail()), name, pass, email, Integer.parseInt(phoneNr), addres,Integer.parseInt(postCode), city,lu.getTeacher(),lu.getUserIMG());
        Stage stage = (Stage) Bn_save.getScene().getWindow();
        stage.close();
        }
        else
        {
              Alert a = new Alert(Alert.AlertType.INFORMATION); 
         a.setContentText("Error invalid input");
         a.show();
        }
        
        
        
    }
    
}
