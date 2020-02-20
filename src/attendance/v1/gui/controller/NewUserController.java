/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

import attendance.v1.be.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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
    private Button Bn_add;
    @FXML
    private Button Bn_Save;
    @FXML
    private Button Bn_cancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      CB_classes.setItems(FXCollections.observableArrayList(
        "SCO","ITO","SDE","DB/OS"));
    }    

    @FXML
    private void handle_save(ActionEvent event) {
        User user1 = new User(1,"","","",1,"","","");
    }

    @FXML
    private void Handle_cancel(ActionEvent event) {
    }
    
}
