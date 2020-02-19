/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Trigger
 */
public class UserController implements Initializable {

    @FXML
    private TextField TF_email; 
    @FXML
    private Button Bn_ok; // go to edit or new user scean //filp
    @FXML
    private Button Bn_cansel; // done
    @FXML
    private JFXButton bn_edit; // this is a mock butten need to be remove

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle_ok(ActionEvent event) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendance/v1/gui/view/newUser.fxml")); // handle_ok and handle_edit need to be 1 butten if email is new new user if its in system edit user scean. //filp
        
        root1 = (Parent) fxmlLoader.load();
        
        fxmlLoader.<StudentController>getController();

        Stage addStage = new Stage();
        Scene addScene = new Scene(root1);

        
        addStage.setScene(addScene);
        addStage.show();
        
        Stage stage = (Stage) Bn_ok.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handle_edit(ActionEvent event) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendance/v1/gui/view/editUser.fxml")); // if email exsist it need to edit if not have to go to new user scean // filp
        root1 = (Parent) fxmlLoader.load();
        
        fxmlLoader.<StudentController>getController();

        Stage addStage = new Stage();
        Scene addScene = new Scene(root1);

        
        addStage.setScene(addScene);
        addStage.show();
        
        Stage stage = (Stage) bn_edit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void Handle_cansel(ActionEvent event) {
        Stage stage = (Stage) Bn_cansel.getScene().getWindow();
        stage.close();
    }
    
}
