/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Trigger
 */
public class EditUserController implements Initializable {

    @FXML
    private TextField TF_name;
    @FXML
    private TextField TF_showPassWord;
    @FXML
    private ChoiceBox<?> CB_classes;
    @FXML
    private Button Bn_resetPassWord;
    @FXML
    private Button Bn_add;
    @FXML
    private Button bn_cansel;
    @FXML
    private Button Bn_save;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
