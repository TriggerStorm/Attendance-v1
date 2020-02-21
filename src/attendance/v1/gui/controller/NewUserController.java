/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

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
public class NewUserController implements Initializable {

    @FXML
    private TextField TF_mobile;
    @FXML
    private TextField TF_passWord;
    @FXML
    private TextField TF_name;
    @FXML
    private ChoiceBox<String> CB_classes;
    @FXML
    private Button Bn_Save; //need to save new user info from TF as a new mock user // filp
    @FXML
    private Button Bn_cansel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle_save(ActionEvent event) {
        // filp
    }

    @FXML
    private void Handle_cancle(ActionEvent event) {
        Stage stage = (Stage) Bn_cansel.getScene().getWindow();
        stage.close();
    }
    
}
